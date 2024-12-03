package com.leanplum.internal;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.leanplum.Leanplum;
import com.leanplum.Var;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileManager {
    public static Map<String, String> filenameToURLs = null;
    private static boolean initializing = false;
    static final Object initializingLock = new Object();
    private static boolean isInitialized = false;
    public static Var<HashMap<String, Object>> resources;
    private static ResourceUpdateCallback updateCallback;

    public enum DownloadFileResult {
        NONE,
        EXISTS_IN_ASSETS,
        DOWNLOADING
    }

    static class HashResults {
        final String hash;
        final int size;

        public HashResults(String str, int i10) {
            this.hash = str;
            this.size = i10;
        }
    }

    interface ResourceUpdateCallback {
        void onResourceSyncFinish();
    }

    private static String appBundlePath() {
        return "";
    }

    private static String bundlePath() {
        return Leanplum.getContext().getDir("Leanplum_Bundle", 0).getAbsolutePath();
    }

    private static List<Pattern> compilePatterns(List<String> list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String next : list) {
            try {
                arrayList.add(Pattern.compile(next));
            } catch (PatternSyntaxException unused) {
                Log.e("Ignoring malformed resource syncing pattern: \"" + next + "\". Patterns must be regular expressions.", new Object[0]);
            }
        }
        return arrayList;
    }

    private static String documentsPath() {
        Context context = Leanplum.getContext();
        if (context != null) {
            return context.getDir("Leanplum_Documents", 0).getAbsolutePath();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static void enableResourceSyncing(java.util.List<java.util.regex.Pattern> r13, java.util.List<java.util.regex.Pattern> r14) {
        /*
            java.lang.String r0 = "__Android Resources"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            com.leanplum.Var r0 = com.leanplum.Var.define(r0, r1)
            resources = r0
            java.lang.String r0 = "res/drawable"
            java.lang.String r1 = "res/layout"
            android.content.Context r2 = com.leanplum.Leanplum.getContext()
            r3 = 1
            r4 = 0
            r5 = 0
            java.util.zip.ZipInputStream r6 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x0106 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0106 }
            java.lang.String r2 = r2.getPackageResourcePath()     // Catch:{ IOException -> 0x0106 }
            r7.<init>(r2)     // Catch:{ IOException -> 0x0106 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0106 }
        L_0x0026:
            java.util.zip.ZipEntry r2 = r6.getNextEntry()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r2 == 0) goto L_0x00eb
            java.lang.String r5 = r2.getName()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            boolean r7 = r5.startsWith(r0)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r7 != 0) goto L_0x003c
            boolean r7 = r5.startsWith(r1)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r7 == 0) goto L_0x0026
        L_0x003c:
            r7 = 4
            java.lang.String r7 = r5.substring(r7)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r13 == 0) goto L_0x0069
            int r8 = r13.size()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r8 <= 0) goto L_0x0069
            java.util.Iterator r8 = r13.iterator()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
        L_0x004d:
            boolean r9 = r8.hasNext()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r9 == 0) goto L_0x0065
            java.lang.Object r9 = r8.next()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.util.regex.Pattern r9 = (java.util.regex.Pattern) r9     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.util.regex.Matcher r9 = r9.matcher(r7)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            boolean r9 = r9.matches()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r9 == 0) goto L_0x004d
            r8 = r3
            goto L_0x0066
        L_0x0065:
            r8 = r4
        L_0x0066:
            if (r8 != 0) goto L_0x0069
            goto L_0x0026
        L_0x0069:
            if (r14 == 0) goto L_0x008b
            java.util.Iterator r8 = r14.iterator()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
        L_0x006f:
            boolean r9 = r8.hasNext()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r9 == 0) goto L_0x0087
            java.lang.Object r9 = r8.next()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.util.regex.Pattern r9 = (java.util.regex.Pattern) r9     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.util.regex.Matcher r9 = r9.matcher(r7)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            boolean r9 = r9.matches()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            if (r9 == 0) goto L_0x006f
            r8 = r3
            goto L_0x0088
        L_0x0087:
            r8 = r4
        L_0x0088:
            if (r8 == 0) goto L_0x008b
            goto L_0x0026
        L_0x008b:
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r8.<init>()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r9 = 8192(0x2000, float:1.14794E-41)
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r10 = r4
        L_0x0095:
            int r11 = r6.read(r9)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r12 = -1
            if (r11 == r12) goto L_0x00a1
            r8.write(r9, r4, r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            int r10 = r10 + r11
            goto L_0x0095
        L_0x00a1:
            r6.closeEntry()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r9.<init>()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.String r11 = ""
            r9.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            long r11 = r2.getTime()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r9.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.String r2 = ""
            r9.append(r2)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r9.append(r10)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.String r2 = r9.toString()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r9.<init>()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.String r11 = "__Android Resources."
            r9.append(r11)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.String r11 = "."
            java.lang.String r12 = "\\."
            java.lang.String r7 = r7.replace(r11, r12)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r11 = 47
            r12 = 46
            java.lang.String r7 = r7.replace(r11, r12)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            r9.append(r7)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            java.lang.String r7 = r9.toString()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            byte[] r8 = r8.toByteArray()     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            com.leanplum.Var.defineResource(r7, r5, r10, r2, r8)     // Catch:{ IOException -> 0x0101, all -> 0x00fe }
            goto L_0x0026
        L_0x00eb:
            r6.close()     // Catch:{ IOException -> 0x00ef }
            goto L_0x0135
        L_0x00ef:
            r13 = move-exception
            java.lang.String r14 = "Failed to close ZipInputStream."
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r13 = r13.getMessage()
            r0[r4] = r13
            com.leanplum.internal.Log.d(r14, r0)
            goto L_0x0135
        L_0x00fe:
            r13 = move-exception
            r5 = r6
            goto L_0x0148
        L_0x0101:
            r13 = move-exception
            r5 = r6
            goto L_0x0107
        L_0x0104:
            r13 = move-exception
            goto L_0x0148
        L_0x0106:
            r13 = move-exception
        L_0x0107:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r14.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r0 = "Error occurred when trying to enable resource syncing."
            r14.append(r0)     // Catch:{ all -> 0x0104 }
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x0104 }
            r14.append(r13)     // Catch:{ all -> 0x0104 }
            java.lang.String r13 = r14.toString()     // Catch:{ all -> 0x0104 }
            java.lang.Object[] r14 = new java.lang.Object[r4]     // Catch:{ all -> 0x0104 }
            com.leanplum.internal.Log.d(r13, r14)     // Catch:{ all -> 0x0104 }
            if (r5 == 0) goto L_0x0135
            r5.close()     // Catch:{ IOException -> 0x0127 }
            goto L_0x0135
        L_0x0127:
            r13 = move-exception
            java.lang.String r14 = "Failed to close ZipInputStream."
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r13 = r13.getMessage()
            r0[r4] = r13
            com.leanplum.internal.Log.d(r14, r0)
        L_0x0135:
            isInitialized = r3
            java.lang.Object r13 = initializingLock
            monitor-enter(r13)
            initializing = r4     // Catch:{ all -> 0x0145 }
            com.leanplum.internal.FileManager$ResourceUpdateCallback r14 = updateCallback     // Catch:{ all -> 0x0145 }
            if (r14 == 0) goto L_0x0143
            r14.onResourceSyncFinish()     // Catch:{ all -> 0x0145 }
        L_0x0143:
            monitor-exit(r13)     // Catch:{ all -> 0x0145 }
            return
        L_0x0145:
            r14 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0145 }
            throw r14
        L_0x0148:
            if (r5 == 0) goto L_0x015c
            r5.close()     // Catch:{ IOException -> 0x014e }
            goto L_0x015c
        L_0x014e:
            r14 = move-exception
            java.lang.String r0 = "Failed to close ZipInputStream."
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r14 = r14.getMessage()
            r1[r4] = r14
            com.leanplum.internal.Log.d(r0, r1)
        L_0x015c:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.FileManager.enableResourceSyncing(java.util.List, java.util.List):void");
    }

    public static boolean fileExistsAtPath(String str) {
        return str != null && new File(str).exists();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.leanplum.internal.Log.d("Failed to close InputStream.", r9.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0075, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0076, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007b, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007e, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[SYNTHETIC, Splitter:B:30:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007a A[ExcHandler: NoSuchAlgorithmException (r9v1 'e' java.security.NoSuchAlgorithmException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.leanplum.internal.FileManager.HashResults fileMD5HashCreateWithPath(java.io.InputStream r9) {
        /*
            java.lang.String r0 = "Failed to close InputStream."
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            r3 = 1
            r4 = 0
            java.security.DigestInputStream r5 = new java.security.DigestInputStream     // Catch:{ all -> 0x005f }
            r5.<init>(r9, r2)     // Catch:{ all -> 0x005f }
            r9 = 8192(0x2000, float:1.14794E-41)
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x005d }
            r6 = r4
        L_0x0015:
            int r7 = r5.read(r9)     // Catch:{ all -> 0x005d }
            r8 = -1
            if (r7 == r8) goto L_0x001e
            int r6 = r6 + r7
            goto L_0x0015
        L_0x001e:
            r5.close()     // Catch:{ IOException -> 0x0022, NoSuchAlgorithmException -> 0x007a }
            goto L_0x002e
        L_0x0022:
            r9 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            r5[r4] = r9     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            com.leanplum.internal.Log.d(r0, r5)     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
        L_0x002e:
            byte[] r9 = r2.digest()     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            r0.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            int r2 = r9.length     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
        L_0x0038:
            if (r4 >= r2) goto L_0x0053
            byte r5 = r9[r4]     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            int r7 = r5.length()     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            if (r7 != r3) goto L_0x004d
            r7 = 48
            r0.append(r7)     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
        L_0x004d:
            r0.append(r5)     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            int r4 = r4 + 1
            goto L_0x0038
        L_0x0053:
            com.leanplum.internal.FileManager$HashResults r9 = new com.leanplum.internal.FileManager$HashResults     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            java.lang.String r0 = r0.toString()     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            r9.<init>(r0, r6)     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            return r9
        L_0x005d:
            r9 = move-exception
            goto L_0x0062
        L_0x005f:
            r2 = move-exception
            r5 = r9
            r9 = r2
        L_0x0062:
            if (r5 == 0) goto L_0x0074
            r5.close()     // Catch:{ IOException -> 0x0068, NoSuchAlgorithmException -> 0x007a }
            goto L_0x0074
        L_0x0068:
            r2 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            r3[r4] = r2     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
            com.leanplum.internal.Log.d(r0, r3)     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
        L_0x0074:
            throw r9     // Catch:{ NoSuchAlgorithmException -> 0x007a, IOException -> 0x0075 }
        L_0x0075:
            r9 = move-exception
            r9.printStackTrace()
            return r1
        L_0x007a:
            r9 = move-exception
            r9.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.FileManager.fileMD5HashCreateWithPath(java.io.InputStream):com.leanplum.internal.FileManager$HashResults");
    }

    private static String fileRelativeTo(String str, String str2) {
        return str + RemoteSettings.FORWARD_SLASH_STRING + str2;
    }

    static String fileRelativeToAppBundle(String str) {
        if (str == null) {
            return null;
        }
        return fileRelativeTo(appBundlePath(), str);
    }

    public static String fileRelativeToDocuments(String str) {
        if (str == null) {
            return null;
        }
        return fileRelativeTo(documentsPath(), str);
    }

    static String fileRelativeToLPBundle(String str) {
        if (str == null) {
            return null;
        }
        return fileRelativeTo(bundlePath(), str);
    }

    public static String fileValue(String str) {
        return fileValue(str, str, (Boolean) null);
    }

    static int getFileSize(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    static boolean initializing() {
        return initializing;
    }

    static boolean isNewerLocally(Map<String, Object> map, Map<String, Object> map2) {
        if (map2 == null) {
            return true;
        }
        String str = (String) map.get("hash");
        String str2 = (String) map2.get("hash");
        Integer num = (Integer) map.get("size");
        Integer num2 = (Integer) map2.get("size");
        if (num2 == null) {
            return true;
        }
        if (num != null && !num.equals(num2)) {
            return true;
        }
        if (str == null || (str2 != null && str.equals(str2))) {
            return false;
        }
        return true;
    }

    public static boolean isResourceSyncingEnabled() {
        return initializing || isInitialized;
    }

    public static DownloadFileResult maybeDownloadFile(boolean z10, String str, String str2, String str3, Runnable runnable) {
        if (str != null && !str.equals(str2) && (!z10 || VarCache.getResIdFromPath(str) == 0)) {
            InputStream inputStream = null;
            try {
                InputStream open = Leanplum.getContext().getResources().getAssets().open(str);
                if (open != null) {
                    DownloadFileResult downloadFileResult = DownloadFileResult.EXISTS_IN_ASSETS;
                    try {
                        open.close();
                    } catch (IOException e10) {
                        Log.d("Failed to close InputStream.", e10.getMessage());
                    }
                    return downloadFileResult;
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e11) {
                        Log.d("Failed to close InputStream.", e11.getMessage());
                    }
                }
                if (!fileExistsAtPath(fileRelativeToAppBundle(str)) && !fileExistsAtPath(fileRelativeToDocuments(str))) {
                    Map<String, String> map = filenameToURLs;
                    if (map != null && map.containsKey(str) && str3 == null) {
                        str3 = filenameToURLs.get(str);
                    }
                    FileTransferManager.getInstance().downloadFile(str, str3, runnable, runnable);
                    return DownloadFileResult.DOWNLOADING;
                }
            } catch (IOException unused) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        Log.d("Failed to close InputStream.", e12.getMessage());
                    }
                }
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e13) {
                        Log.d("Failed to close InputStream.", e13.getMessage());
                    }
                }
                throw th2;
            }
        }
        return DownloadFileResult.NONE;
    }

    public static void setFilenameToURLs(Map<String, String> map) {
        filenameToURLs = map;
    }

    static void setResourceSyncFinishBlock(ResourceUpdateCallback resourceUpdateCallback) {
        updateCallback = resourceUpdateCallback;
    }

    public static InputStream stream(boolean z10, Boolean bool, Boolean bool2, String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Context context = Leanplum.getContext();
            if (z10 && str.equals(str2) && bArr != null) {
                return new ByteArrayInputStream(bArr);
            }
            if (z10 && str.equals(str2) && bArr == null) {
                int generateIdFromResourceName = Util.generateIdFromResourceName(str);
                if (generateIdFromResourceName == 0) {
                    return null;
                }
                Resources resources2 = context.getResources();
                return context.getContentResolver().openInputStream(Uri.parse("android.resource://" + resources2.getResourcePackageName(generateIdFromResourceName) + '/' + resources2.getResourceTypeName(generateIdFromResourceName) + '/' + resources2.getResourceEntryName(generateIdFromResourceName)));
            } else if (bool2 == null) {
                try {
                    return context.getAssets().open(str);
                } catch (IOException unused) {
                }
            } else {
                if (!bool2.booleanValue()) {
                    if (bool.booleanValue() && str.equals(str2)) {
                    }
                    return new FileInputStream(new File(str));
                }
                return context.getAssets().open(str);
            }
        } catch (IOException e10) {
            Log.d("Failed to load a stream." + e10.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String fileValue(java.lang.String r2, java.lang.String r3, java.lang.Boolean r4) {
        /*
            if (r2 != 0) goto L_0x0004
            r2 = 0
            return r2
        L_0x0004:
            boolean r0 = r2.equals(r3)
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = fileRelativeToAppBundle(r3)
            boolean r1 = fileExistsAtPath(r0)
            if (r1 == 0) goto L_0x0015
            return r0
        L_0x0015:
            if (r4 != 0) goto L_0x0044
            android.content.Context r4 = com.leanplum.Leanplum.getContext()     // Catch:{ Exception -> 0x004b, all -> 0x0042 }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x004b, all -> 0x0042 }
            java.io.InputStream r3 = r4.open(r2)     // Catch:{ Exception -> 0x004b, all -> 0x0042 }
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ Exception -> 0x0029 }
            goto L_0x0041
        L_0x0029:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Failed to close InputStream: "
            r4.append(r0)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.leanplum.internal.Log.d(r3, r4)
        L_0x0041:
            return r2
        L_0x0042:
            r2 = move-exception
            throw r2
        L_0x0044:
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x004b
            return r2
        L_0x004b:
            java.lang.String r4 = fileRelativeToLPBundle(r2)
            boolean r0 = fileExistsAtPath(r4)
            if (r0 != 0) goto L_0x007e
            java.lang.String r4 = fileRelativeToDocuments(r2)
            boolean r0 = fileExistsAtPath(r4)
            if (r0 != 0) goto L_0x007e
            java.lang.String r4 = fileRelativeToAppBundle(r2)
            boolean r2 = fileExistsAtPath(r4)
            if (r2 != 0) goto L_0x007e
            java.lang.String r4 = fileRelativeToLPBundle(r3)
            boolean r2 = fileExistsAtPath(r4)
            if (r2 != 0) goto L_0x007e
            java.lang.String r4 = fileRelativeToAppBundle(r3)
            boolean r2 = fileExistsAtPath(r4)
            if (r2 != 0) goto L_0x007e
            return r3
        L_0x007e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.FileManager.fileValue(java.lang.String, java.lang.String, java.lang.Boolean):java.lang.String");
    }

    public static void enableResourceSyncing(List<String> list, List<String> list2, boolean z10) {
        initializing = true;
        if (!isInitialized) {
            try {
                final List<Pattern> compilePatterns = compilePatterns(list);
                final List<Pattern> compilePatterns2 = compilePatterns(list2);
                if (z10) {
                    OperationQueue.sharedInstance().addParallelOperation(new Runnable() {
                        public void run() {
                            try {
                                FileManager.enableResourceSyncing(compilePatterns, compilePatterns2);
                            } catch (Throwable th2) {
                                Log.exception(th2);
                            }
                        }
                    });
                } else {
                    enableResourceSyncing(compilePatterns, compilePatterns2);
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }
}
