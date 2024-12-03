package org.jivesoftware.smack.roster.rosterstore;

import gm.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.provider.RosterPacketProvider;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.stringencoder.Base32;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.Jid;

public final class DirectoryRosterStore implements RosterStore {
    private static final String ENTRY_PREFIX = "entry-";
    private static final Logger LOGGER = Logger.getLogger(DirectoryRosterStore.class.getName());
    private static final String STORE_ID = "DEFAULT_ROSTER_STORE";
    private static final String VERSION_FILE_NAME = "__version__";
    private final File fileDir;

    private DirectoryRosterStore(File file) {
        this.fileDir = file;
    }

    private boolean addEntryRaw(RosterPacket.Item item) {
        return FileUtils.writeFile(getBareJidFile(item.getJid()), item.toXML());
    }

    private File getBareJidFile(Jid jid) {
        String encode = Base32.encode(jid.toString());
        File file = this.fileDir;
        return new File(file, ENTRY_PREFIX + encode);
    }

    private File getVersionFile() {
        return new File(this.fileDir, VERSION_FILE_NAME);
    }

    public static DirectoryRosterStore init(File file) {
        DirectoryRosterStore directoryRosterStore = new DirectoryRosterStore(file);
        if (directoryRosterStore.setRosterVersion("")) {
            return directoryRosterStore;
        }
        return null;
    }

    public static DirectoryRosterStore open(File file) {
        DirectoryRosterStore directoryRosterStore = new DirectoryRosterStore(file);
        String readFile = FileUtils.readFile(directoryRosterStore.getVersionFile());
        if (readFile == null || !readFile.startsWith("DEFAULT_ROSTER_STORE\n")) {
            return null;
        }
        return directoryRosterStore;
    }

    private static RosterPacket.Item readEntry(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            try {
                RosterPacket.Item parseItem = RosterPacketProvider.parseItem(PacketParserUtils.getParserFor((Reader) fileReader));
                fileReader.close();
                return parseItem;
            } catch (IOException | IllegalArgumentException | XmlPullParserException e10) {
                String str = "Exception while parsing roster entry.";
                if (file.delete()) {
                    str = str + " File was deleted.";
                }
                LOGGER.log(Level.SEVERE, str, e10);
                return null;
            }
        } catch (FileNotFoundException e11) {
            LOGGER.log(Level.FINE, "Roster entry file not found", e11);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean rosterDirFilter(File file) {
        return file.getName().startsWith(ENTRY_PREFIX);
    }

    private boolean setRosterVersion(String str) {
        File versionFile = getVersionFile();
        return FileUtils.writeFile(versionFile, "DEFAULT_ROSTER_STORE\n" + str);
    }

    public boolean addEntry(RosterPacket.Item item, String str) {
        return addEntryRaw(item) && setRosterVersion(str);
    }

    public List<RosterPacket.Item> getEntries() {
        ArrayList arrayList = new ArrayList();
        for (File readEntry : this.fileDir.listFiles(new a())) {
            RosterPacket.Item readEntry2 = readEntry(readEntry);
            if (readEntry2 == null) {
                return null;
            }
            arrayList.add(readEntry2);
        }
        return arrayList;
    }

    public RosterPacket.Item getEntry(Jid jid) {
        return readEntry(getBareJidFile(jid));
    }

    public String getRosterVersion() {
        String readFile = FileUtils.readFile(getVersionFile());
        if (readFile == null) {
            return null;
        }
        String[] split = readFile.split("\n", 2);
        if (split.length < 2) {
            return null;
        }
        return split[1];
    }

    public boolean removeEntry(Jid jid, String str) {
        return getBareJidFile(jid).delete() && setRosterVersion(str);
    }

    public boolean resetEntries(Collection<RosterPacket.Item> collection, String str) {
        for (File delete : this.fileDir.listFiles(new a())) {
            delete.delete();
        }
        for (RosterPacket.Item addEntryRaw : collection) {
            if (!addEntryRaw(addEntryRaw)) {
                return false;
            }
        }
        return setRosterVersion(str);
    }

    public void resetStore() {
        resetEntries(Collections.emptyList(), "");
    }
}
