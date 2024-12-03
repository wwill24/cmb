package j$.time.format;

import j$.time.temporal.a;
import org.apache.commons.cli.HelpFormatter;

final class j implements C0529g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f42635a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f42636b;

    public /* synthetic */ j(Object obj, int i10) {
        this.f42635a = i10;
        this.f42636b = obj;
    }

    private static void a(StringBuilder sb2, int i10) {
        sb2.append((char) ((i10 / 10) + 48));
        sb2.append((char) ((i10 % 10) + 48));
    }

    static int c(CharSequence charSequence, int i10) {
        char charAt = charSequence.charAt(i10);
        if (charAt < '0' || charAt > '9') {
            return -1;
        }
        return charAt - '0';
    }

    public final boolean b(A a10, StringBuilder sb2) {
        switch (this.f42635a) {
            case 0:
                Long e10 = a10.e(a.OFFSET_SECONDS);
                if (e10 == null) {
                    return false;
                }
                sb2.append("GMT");
                int intExact = Math.toIntExact(e10.longValue());
                if (intExact == 0) {
                    return true;
                }
                int abs = Math.abs((intExact / 3600) % 100);
                int abs2 = Math.abs((intExact / 60) % 60);
                int abs3 = Math.abs(intExact % 60);
                sb2.append(intExact < 0 ? HelpFormatter.DEFAULT_OPT_PREFIX : "+");
                if (((H) this.f42636b) == H.FULL) {
                    a(sb2, abs);
                    sb2.append(':');
                    a(sb2, abs2);
                    if (abs3 == 0) {
                        return true;
                    }
                } else {
                    if (abs >= 10) {
                        sb2.append((char) ((abs / 10) + 48));
                    }
                    sb2.append((char) ((abs % 10) + 48));
                    if (abs2 == 0 && abs3 == 0) {
                        return true;
                    }
                    sb2.append(':');
                    a(sb2, abs2);
                    if (abs3 == 0) {
                        return true;
                    }
                }
                sb2.append(':');
                a(sb2, abs3);
                return true;
            default:
                sb2.append((String) this.f42636b);
                return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        if (r13 >= 0) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d9, code lost:
        if (r13 >= 0) goto L_0x00db;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(j$.time.format.x r12, java.lang.CharSequence r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.f42635a
            switch(r0) {
                case 0: goto L_0x0007;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0109
        L_0x0007:
            int r0 = r13.length()
            int r0 = r0 + r14
            r5 = 0
            r6 = 3
            java.lang.String r4 = "GMT"
            r1 = r12
            r2 = r13
            r3 = r14
            boolean r1 = r1.s(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x001b
            goto L_0x008e
        L_0x001b:
            int r7 = r14 + 3
            if (r7 != r0) goto L_0x0021
            goto L_0x00fe
        L_0x0021:
            char r1 = r13.charAt(r7)
            r2 = 43
            r3 = 1
            if (r1 != r2) goto L_0x002c
            r1 = r3
            goto L_0x0031
        L_0x002c:
            r2 = 45
            if (r1 != r2) goto L_0x00fe
            r1 = -1
        L_0x0031:
            int r7 = r7 + r3
            java.lang.Object r2 = r11.f42636b
            j$.time.format.H r2 = (j$.time.format.H) r2
            j$.time.format.H r3 = j$.time.format.H.FULL
            r4 = 0
            r5 = 58
            if (r2 != r3) goto L_0x0086
            int r2 = r7 + 1
            int r3 = c(r13, r7)
            int r6 = r2 + 1
            int r2 = c(r13, r2)
            if (r3 < 0) goto L_0x008e
            if (r2 < 0) goto L_0x008e
            int r7 = r6 + 1
            char r6 = r13.charAt(r6)
            if (r6 == r5) goto L_0x0056
            goto L_0x008e
        L_0x0056:
            int r3 = r3 * 10
            int r3 = r3 + r2
            int r2 = r7 + 1
            int r6 = c(r13, r7)
            int r7 = r2 + 1
            int r2 = c(r13, r2)
            if (r6 < 0) goto L_0x008e
            if (r2 >= 0) goto L_0x006a
            goto L_0x008e
        L_0x006a:
            int r6 = r6 * 10
            int r6 = r6 + r2
            int r2 = r7 + 2
            if (r2 >= r0) goto L_0x00e1
            char r0 = r13.charAt(r7)
            if (r0 != r5) goto L_0x00e1
            int r0 = r7 + 1
            int r0 = c(r13, r0)
            int r13 = c(r13, r2)
            if (r0 < 0) goto L_0x00e1
            if (r13 < 0) goto L_0x00e1
            goto L_0x00db
        L_0x0086:
            int r2 = r7 + 1
            int r3 = c(r13, r7)
            if (r3 >= 0) goto L_0x0091
        L_0x008e:
            int r12 = ~r14
            goto L_0x0108
        L_0x0091:
            if (r2 >= r0) goto L_0x00e5
            int r6 = c(r13, r2)
            if (r6 < 0) goto L_0x009e
            int r3 = r3 * 10
            int r3 = r3 + r6
            int r2 = r2 + 1
        L_0x009e:
            int r6 = r2 + 2
            if (r6 >= r0) goto L_0x00e5
            char r7 = r13.charAt(r2)
            if (r7 != r5) goto L_0x00e5
            if (r6 >= r0) goto L_0x00e5
            char r7 = r13.charAt(r2)
            if (r7 != r5) goto L_0x00e5
            int r7 = r2 + 1
            int r7 = c(r13, r7)
            int r6 = c(r13, r6)
            if (r7 < 0) goto L_0x00e5
            if (r6 < 0) goto L_0x00e5
            int r7 = r7 * 10
            int r6 = r6 + r7
            int r7 = r2 + 3
            int r2 = r7 + 2
            if (r2 >= r0) goto L_0x00e1
            char r0 = r13.charAt(r7)
            if (r0 != r5) goto L_0x00e1
            int r0 = r7 + 1
            int r0 = c(r13, r0)
            int r13 = c(r13, r2)
            if (r0 < 0) goto L_0x00e1
            if (r13 < 0) goto L_0x00e1
        L_0x00db:
            int r0 = r0 * 10
            int r0 = r0 + r13
            int r7 = r7 + 3
            r4 = r0
        L_0x00e1:
            r13 = r4
            r4 = r6
            r10 = r7
            goto L_0x00e7
        L_0x00e5:
            r10 = r2
            r13 = r4
        L_0x00e7:
            long r0 = (long) r1
            long r2 = (long) r3
            r5 = 3600(0xe10, double:1.7786E-320)
            long r2 = r2 * r5
            long r4 = (long) r4
            r6 = 60
            long r4 = r4 * r6
            long r4 = r4 + r2
            long r2 = (long) r13
            long r4 = r4 + r2
            long r7 = r4 * r0
            j$.time.temporal.a r6 = j$.time.temporal.a.OFFSET_SECONDS
            r5 = r12
            r9 = r14
            int r12 = r5.o(r6, r7, r9, r10)
            goto L_0x0108
        L_0x00fe:
            j$.time.temporal.a r3 = j$.time.temporal.a.OFFSET_SECONDS
            r4 = 0
            r2 = r12
            r6 = r14
            int r12 = r2.o(r3, r4, r6, r7)
        L_0x0108:
            return r12
        L_0x0109:
            int r0 = r13.length()
            if (r14 > r0) goto L_0x0130
            if (r14 < 0) goto L_0x0130
            java.lang.Object r0 = r11.f42636b
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            r5 = 0
            int r6 = r4.length()
            r1 = r12
            r2 = r13
            r3 = r14
            boolean r12 = r1.s(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0126
            int r12 = ~r14
            goto L_0x012f
        L_0x0126:
            java.lang.Object r12 = r11.f42636b
            java.lang.String r12 = (java.lang.String) r12
            int r12 = r12.length()
            int r12 = r12 + r14
        L_0x012f:
            return r12
        L_0x0130:
            java.lang.IndexOutOfBoundsException r12 = new java.lang.IndexOutOfBoundsException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.j.d(j$.time.format.x, java.lang.CharSequence, int):int");
    }

    public final String toString() {
        switch (this.f42635a) {
            case 0:
                StringBuilder a10 = j$.time.a.a("LocalizedOffset(");
                a10.append((H) this.f42636b);
                a10.append(")");
                return a10.toString();
            default:
                String replace = ((String) this.f42636b).replace("'", "''");
                return "'" + replace + "'";
        }
    }
}
