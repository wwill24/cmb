package zl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f24826a = b();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f24827b = Pattern.compile("^&#[Xx]?");

    public static String a(String str) {
        int i10;
        Matcher matcher = f24827b.matcher(str);
        if (matcher.find()) {
            if (matcher.end() == 2) {
                i10 = 10;
            } else {
                i10 = 16;
            }
            try {
                int parseInt = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), i10);
                if (parseInt == 0) {
                    return "�";
                }
                return new String(Character.toChars(parseInt));
            } catch (IllegalArgumentException unused) {
                return "�";
            }
        } else {
            String str2 = f24826a.get(str.substring(1, str.length() - 1));
            if (str2 != null) {
                return str2;
            }
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, java.lang.String> b() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Class<zl.b> r1 = zl.b.class
            java.lang.String r2 = "/org/commonmark/internal/util/entities.properties"
            java.io.InputStream r1 = r1.getResourceAsStream(r2)
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0056 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0056 }
            r4.<init>(r1, r2)     // Catch:{ IOException -> 0x0056 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0056 }
        L_0x001d:
            java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x003f
            int r2 = r1.length()     // Catch:{ all -> 0x004a }
            if (r2 != 0) goto L_0x002a
            goto L_0x001d
        L_0x002a:
            java.lang.String r2 = "="
            int r2 = r1.indexOf(r2)     // Catch:{ all -> 0x004a }
            r4 = 0
            java.lang.String r4 = r1.substring(r4, r2)     // Catch:{ all -> 0x004a }
            int r2 = r2 + 1
            java.lang.String r1 = r1.substring(r2)     // Catch:{ all -> 0x004a }
            r0.put(r4, r1)     // Catch:{ all -> 0x004a }
            goto L_0x001d
        L_0x003f:
            r3.close()     // Catch:{ IOException -> 0x0056 }
            java.lang.String r1 = "NewLine"
            java.lang.String r2 = "\n"
            r0.put(r1, r2)
            return r0
        L_0x004a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r1 = move-exception
            r3.close()     // Catch:{ all -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch:{ IOException -> 0x0056 }
        L_0x0055:
            throw r1     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Failed reading data for HTML named character references"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zl.b.b():java.util.Map");
    }
}
