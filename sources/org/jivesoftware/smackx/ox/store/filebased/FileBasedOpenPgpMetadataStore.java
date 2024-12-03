package org.jivesoftware.smackx.ox.store.filebased;

import en.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpMetadataStore;
import org.jivesoftware.smackx.ox.util.Util;
import org.jxmpp.jid.BareJid;
import org.jxmpp.util.XmppDateTime;

public class FileBasedOpenPgpMetadataStore extends AbstractOpenPgpMetadataStore {
    public static final String ANNOUNCED = "announced.list";
    private static final Logger LOGGER = Logger.getLogger(FileBasedOpenPgpMetadataStore.class.getName());
    private final File basePath;

    public FileBasedOpenPgpMetadataStore(File file) {
        this.basePath = file;
    }

    private File getAnnouncedFingerprintsPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), ANNOUNCED);
    }

    static Map<a, Date> readFingerprintsAndDates(File file) throws IOException {
        int i10;
        if (!file.exists() || file.isDirectory()) {
            return new HashMap();
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(FileUtils.prepareFileInputStream(file), Util.UTF8));
            try {
                HashMap hashMap = new HashMap();
                i10 = 0;
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        i10++;
                        String[] split = readLine.trim().split(" ");
                        if (split.length != 2) {
                            LOGGER.log(Level.FINE, "Skipping invalid line " + i10 + " in file " + file.getAbsolutePath());
                        } else {
                            hashMap.put(new a(split[0]), XmppDateTime.m(split[1]));
                        }
                    } else {
                        CloseableUtil.maybeClose(bufferedReader2, LOGGER);
                        return hashMap;
                    }
                }
            } catch (IllegalArgumentException | ParseException e10) {
                LOGGER.log(Level.WARNING, "Error parsing fingerprint/date touple in line " + i10 + " of file " + file.getAbsolutePath(), e10);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (Throwable th3) {
            th = th3;
            CloseableUtil.maybeClose(bufferedReader, LOGGER);
            throw th;
        }
    }

    static void writeFingerprintsAndDates(Map<a, Date> map, File file) throws IOException {
        String str;
        if (map == null || map.isEmpty()) {
            FileUtils.maybeDeleteFileOrThrow(file);
            return;
        }
        FileUtils.maybeCreateFileWithParentDirectories(file);
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(FileUtils.prepareFileOutputStream(file), Util.UTF8));
            try {
                for (a next : map.keySet()) {
                    Date date = map.get(next);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(next.toString());
                    sb2.append(" ");
                    if (date != null) {
                        str = XmppDateTime.i(date);
                    } else {
                        str = XmppDateTime.i(new Date());
                    }
                    sb2.append(str);
                    bufferedWriter2.write(sb2.toString());
                    bufferedWriter2.newLine();
                }
                CloseableUtil.maybeClose(bufferedWriter2, LOGGER);
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CloseableUtil.maybeClose(bufferedWriter, LOGGER);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CloseableUtil.maybeClose(bufferedWriter, LOGGER);
            throw th;
        }
    }

    public Map<a, Date> readAnnouncedFingerprintsOf(BareJid bareJid) throws IOException {
        return readFingerprintsAndDates(getAnnouncedFingerprintsPath(bareJid));
    }

    public void writeAnnouncedFingerprintsOf(BareJid bareJid, Map<a, Date> map) throws IOException {
        writeFingerprintsAndDates(map, getAnnouncedFingerprintsPath(bareJid));
    }
}
