package org.jivesoftware.smackx.caps.cache;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.stringencoder.Base32;
import org.jivesoftware.smack.util.stringencoder.StringEncoder;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

public class SimpleDirectoryPersistentCache implements EntityCapsPersistentCache {
    private static final Logger LOGGER = Logger.getLogger(SimpleDirectoryPersistentCache.class.getName());
    private final File cacheDir;
    private final StringEncoder<String> filenameEncoder;

    public SimpleDirectoryPersistentCache(File file) {
        this(file, Base32.getStringEncoder());
    }

    private File getFileFor(String str) {
        return new File(this.cacheDir, this.filenameEncoder.encode(str));
    }

    private static DiscoverInfo restoreInfoFromFile(File file) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            String readUTF = dataInputStream.readUTF();
            dataInputStream.close();
            if (readUTF == null) {
                return null;
            }
            return (DiscoverInfo) PacketParserUtils.parseStanza(readUTF);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static void writeInfoToFile(File file, DiscoverInfo discoverInfo) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeUTF(discoverInfo.toXML().toString());
            dataOutputStream.close();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public void addDiscoverInfoByNodePersistent(String str, DiscoverInfo discoverInfo) {
        File fileFor = getFileFor(str);
        try {
            if (fileFor.createNewFile()) {
                writeInfoToFile(fileFor, discoverInfo);
            }
        } catch (IOException e10) {
            LOGGER.log(Level.SEVERE, "Failed to write disco info to file", e10);
        }
    }

    public void emptyCache() {
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    public DiscoverInfo lookup(String str) {
        File fileFor = getFileFor(str);
        if (!fileFor.isFile()) {
            return null;
        }
        try {
            return restoreInfoFromFile(fileFor);
        } catch (Exception e10) {
            LOGGER.log(Level.WARNING, "Coud not restore info from file", e10);
            return null;
        }
    }

    public SimpleDirectoryPersistentCache(File file, StringEncoder<String> stringEncoder) {
        if (!file.exists()) {
            throw new IllegalStateException("Cache directory \"" + file + "\" does not exist");
        } else if (file.isDirectory()) {
            this.cacheDir = file;
            this.filenameEncoder = stringEncoder;
        } else {
            throw new IllegalStateException("Cache directory \"" + file + "\" is not a directory");
        }
    }
}
