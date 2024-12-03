package org.jivesoftware.smackx.ox.store.filebased;

import en.a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpTrustStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jivesoftware.smackx.ox.util.Util;
import org.jxmpp.jid.BareJid;

public class FileBasedOpenPgpTrustStore extends AbstractOpenPgpTrustStore {
    private static final Logger LOGGER = Logger.getLogger(FileBasedOpenPgpTrustStore.class.getName());
    private final File basePath;

    public FileBasedOpenPgpTrustStore(File file) {
        this.basePath = file;
    }

    public static String TRUST_RECORD(a aVar) {
        return aVar.toString() + ".trust";
    }

    private File getTrustPath(BareJid bareJid, a aVar) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), TRUST_RECORD(aVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r9v9, types: [org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0023 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[Catch:{ all -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A[SYNTHETIC, Splitter:B:29:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore.Trust readTrust(org.jxmpp.jid.BareJid r8, en.a r9) throws java.io.IOException {
        /*
            r7 = this;
            java.io.File r8 = r7.getTrustPath(r8, r9)
            r9 = 0
            java.io.FileInputStream r0 = org.jivesoftware.smack.util.FileUtils.prepareFileInputStream(r8)     // Catch:{ IOException -> 0x0063 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0063 }
            java.nio.charset.Charset r2 = org.jivesoftware.smackx.ox.util.Util.UTF8     // Catch:{ IOException -> 0x0063 }
            r1.<init>(r0, r2)     // Catch:{ IOException -> 0x0063 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0063 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0063 }
            r1 = 0
        L_0x0016:
            java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            if (r2 == 0) goto L_0x0050
            int r1 = r1 + 1
            org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust r9 = org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore.Trust.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0023 }
            goto L_0x0050
        L_0x0023:
            java.util.logging.Logger r3 = LOGGER     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.util.logging.Level r4 = java.util.logging.Level.WARNING     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r5.<init>()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r6 = "Skipping invalid trust record in line "
            r5.append(r6)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r5.append(r1)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r6 = " \""
            r5.append(r6)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r5.append(r2)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r2 = "\" of file "
            r5.append(r2)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r2 = r8.getAbsolutePath()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r5.append(r2)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r2 = r5.toString()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r3.log(r4, r2)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            goto L_0x0016
        L_0x0050:
            if (r9 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust r9 = org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore.Trust.undecided     // Catch:{ IOException -> 0x005e, all -> 0x005b }
        L_0x0055:
            java.util.logging.Logger r8 = LOGGER
            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r0, r8)
            return r9
        L_0x005b:
            r8 = move-exception
            r9 = r0
            goto L_0x0071
        L_0x005e:
            r8 = move-exception
            r9 = r0
            goto L_0x0064
        L_0x0061:
            r8 = move-exception
            goto L_0x0071
        L_0x0063:
            r8 = move-exception
        L_0x0064:
            boolean r0 = r8 instanceof java.io.FileNotFoundException     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x0070
            org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust r8 = org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore.Trust.undecided     // Catch:{ all -> 0x0061 }
            java.util.logging.Logger r0 = LOGGER
            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r9, r0)
            return r8
        L_0x0070:
            throw r8     // Catch:{ all -> 0x0061 }
        L_0x0071:
            java.util.logging.Logger r0 = LOGGER
            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r9, r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.ox.store.filebased.FileBasedOpenPgpTrustStore.readTrust(org.jxmpp.jid.BareJid, en.a):org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore$Trust");
    }

    /* access modifiers changed from: protected */
    public void writeTrust(BareJid bareJid, a aVar, OpenPgpTrustStore.Trust trust) throws IOException {
        Throwable th2;
        BufferedWriter bufferedWriter;
        File trustPath = getTrustPath(bareJid, aVar);
        if (trust == null || trust == OpenPgpTrustStore.Trust.undecided) {
            FileUtils.maybeDeleteFileOrThrow(trustPath);
        }
        FileUtils.maybeCreateFileWithParentDirectories(trustPath);
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(FileUtils.prepareFileOutputStream(trustPath), Util.UTF8));
            try {
                bufferedWriter.write(trust.toString());
                CloseableUtil.maybeClose(bufferedWriter, LOGGER);
            } catch (Throwable th3) {
                th2 = th3;
                CloseableUtil.maybeClose(bufferedWriter, LOGGER);
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            bufferedWriter = null;
            CloseableUtil.maybeClose(bufferedWriter, LOGGER);
            throw th2;
        }
    }
}
