package tm;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import zm.f;

public final class e extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final d f33880d = new e();

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f33881e = Logger.getLogger(e.class.getName());

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f33882f = Pattern.compile("^nameserver\\s+(.*)$");

    /* renamed from: g  reason: collision with root package name */
    private static List<String> f33883g;

    /* renamed from: h  reason: collision with root package name */
    private static long f33884h;

    private e() {
        super(e.class.getSimpleName(), 2000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A[SYNTHETIC, Splitter:B:34:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096 A[SYNTHETIC, Splitter:B:42:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> L() {
        /*
            r9 = this;
            java.lang.String r0 = "Could not close reader"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/etc/resolv.conf"
            r1.<init>(r2)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 != 0) goto L_0x0011
            return r3
        L_0x0011:
            long r4 = r1.lastModified()
            long r6 = f33884h
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0020
            java.util.List<java.lang.String> r2 = f33883g
            if (r2 == 0) goto L_0x0020
            return r2
        L_0x0020:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            r8.<init>(r1)     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            r7.<init>(r8, r1)     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0078, all -> 0x0076 }
        L_0x0036:
            java.lang.String r1 = r6.readLine()     // Catch:{ IOException -> 0x0074 }
            if (r1 == 0) goto L_0x0055
            java.util.regex.Pattern r7 = f33882f     // Catch:{ IOException -> 0x0074 }
            java.util.regex.Matcher r1 = r7.matcher(r1)     // Catch:{ IOException -> 0x0074 }
            boolean r7 = r1.matches()     // Catch:{ IOException -> 0x0074 }
            if (r7 == 0) goto L_0x0036
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch:{ IOException -> 0x0074 }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException -> 0x0074 }
            r2.add(r1)     // Catch:{ IOException -> 0x0074 }
            goto L_0x0036
        L_0x0055:
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x0061
        L_0x0059:
            r1 = move-exception
            java.util.logging.Logger r6 = f33881e
            java.util.logging.Level r7 = java.util.logging.Level.WARNING
            r6.log(r7, r0, r1)
        L_0x0061:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x006f
            java.util.logging.Logger r0 = f33881e
            java.lang.String r1 = "Could not find any nameservers in /etc/resolv.conf"
            r0.fine(r1)
            return r3
        L_0x006f:
            f33883g = r2
            f33884h = r4
            return r2
        L_0x0074:
            r1 = move-exception
            goto L_0x007a
        L_0x0076:
            r1 = move-exception
            goto L_0x0094
        L_0x0078:
            r1 = move-exception
            r6 = r3
        L_0x007a:
            java.util.logging.Logger r2 = f33881e     // Catch:{ all -> 0x0092 }
            java.util.logging.Level r4 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0092 }
            java.lang.String r5 = "Could not read from /etc/resolv.conf"
            r2.log(r4, r5, r1)     // Catch:{ all -> 0x0092 }
            if (r6 == 0) goto L_0x0091
            r6.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0091
        L_0x0089:
            r1 = move-exception
            java.util.logging.Logger r2 = f33881e
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r2.log(r4, r0, r1)
        L_0x0091:
            return r3
        L_0x0092:
            r1 = move-exception
            r3 = r6
        L_0x0094:
            if (r3 == 0) goto L_0x00a2
            r3.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r2 = move-exception
            java.util.logging.Logger r3 = f33881e
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r3.log(r4, r0, r2)
        L_0x00a2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tm.e.L():java.util.List");
    }

    public boolean isAvailable() {
        if (f.a()) {
            return false;
        }
        try {
            return new File("/etc/resolv.conf").exists();
        } catch (SecurityException e10) {
            f33881e.log(Level.FINE, "Access to /etc/resolv.conf not possible", e10);
            return false;
        }
    }
}
