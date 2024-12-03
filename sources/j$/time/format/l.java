package j$.time.format;

import com.facebook.internal.security.CertificateUtil;
import j$.time.temporal.a;
import java.util.Objects;
import org.apache.commons.cli.HelpFormatter;

final class l implements C0529g {

    /* renamed from: c  reason: collision with root package name */
    static final String[] f42643c = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

    /* renamed from: d  reason: collision with root package name */
    static final l f42644d = new l("+HH:MM:ss", "Z");

    /* renamed from: e  reason: collision with root package name */
    static final l f42645e = new l("+HH:MM:ss", "0");

    /* renamed from: a  reason: collision with root package name */
    private final String f42646a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42647b;

    l(String str, String str2) {
        Objects.requireNonNull(str, "pattern");
        int i10 = 0;
        while (true) {
            String[] strArr = f42643c;
            if (i10 >= 9) {
                throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
            } else if (strArr[i10].equals(str)) {
                this.f42647b = i10;
                this.f42646a = str2;
                return;
            } else {
                i10++;
            }
        }
    }

    private boolean a(int[] iArr, int i10, CharSequence charSequence, boolean z10) {
        int i11;
        int i12 = this.f42647b;
        if ((i12 + 3) / 2 < i10) {
            return false;
        }
        int i13 = iArr[0];
        if (i12 % 2 == 0 && i10 > 1) {
            int i14 = i13 + 1;
            if (i14 > charSequence.length() || charSequence.charAt(i13) != ':') {
                return z10;
            }
            i13 = i14;
        }
        if (i13 + 2 > charSequence.length()) {
            return z10;
        }
        int i15 = i13 + 1;
        char charAt = charSequence.charAt(i13);
        int i16 = i15 + 1;
        char charAt2 = charSequence.charAt(i15);
        if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i11 = (charAt2 - '0') + ((charAt - '0') * 10)) < 0 || i11 > 59) {
            return z10;
        }
        iArr[i10] = i11;
        iArr[0] = i16;
        return false;
    }

    public final boolean b(A a10, StringBuilder sb2) {
        Long e10 = a10.e(a.OFFSET_SECONDS);
        if (e10 == null) {
            return false;
        }
        int intExact = Math.toIntExact(e10.longValue());
        if (intExact != 0) {
            int abs = Math.abs((intExact / 3600) % 100);
            int abs2 = Math.abs((intExact / 60) % 60);
            int abs3 = Math.abs(intExact % 60);
            int length = sb2.length();
            sb2.append(intExact < 0 ? HelpFormatter.DEFAULT_OPT_PREFIX : "+");
            sb2.append((char) ((abs / 10) + 48));
            sb2.append((char) ((abs % 10) + 48));
            int i10 = this.f42647b;
            if (i10 >= 3 || (i10 >= 1 && abs2 > 0)) {
                int i11 = i10 % 2;
                String str = CertificateUtil.DELIMITER;
                sb2.append(i11 == 0 ? str : "");
                sb2.append((char) ((abs2 / 10) + 48));
                sb2.append((char) ((abs2 % 10) + 48));
                abs += abs2;
                int i12 = this.f42647b;
                if (i12 >= 7 || (i12 >= 5 && abs3 > 0)) {
                    if (i12 % 2 != 0) {
                        str = "";
                    }
                    sb2.append(str);
                    sb2.append((char) ((abs3 / 10) + 48));
                    sb2.append((char) ((abs3 % 10) + 48));
                    abs += abs3;
                }
            }
            if (abs == 0) {
                sb2.setLength(length);
            }
            return true;
        }
        sb2.append(this.f42646a);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r16.s(r17, r18, r0.f42646a, 0, r9) != false) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(j$.time.format.x r16, java.lang.CharSequence r17, int r18) {
        /*
            r15 = this;
            r0 = r15
            r7 = r17
            r8 = r18
            int r1 = r17.length()
            java.lang.String r2 = r0.f42646a
            int r9 = r2.length()
            r10 = 0
            if (r9 != 0) goto L_0x001c
            if (r8 != r1) goto L_0x0031
            j$.time.temporal.a r1 = j$.time.temporal.a.OFFSET_SECONDS
            r2 = r1
            r6 = r8
            r3 = r10
            goto L_0x008f
        L_0x001c:
            if (r8 != r1) goto L_0x0020
            int r1 = ~r8
            return r1
        L_0x0020:
            java.lang.String r4 = r0.f42646a
            r5 = 0
            r1 = r16
            r2 = r17
            r3 = r18
            r6 = r9
            boolean r1 = r1.s(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x0031
            goto L_0x0088
        L_0x0031:
            char r1 = r17.charAt(r18)
            r2 = 43
            r3 = 45
            if (r1 == r2) goto L_0x003d
            if (r1 != r3) goto L_0x0086
        L_0x003d:
            r2 = 1
            if (r1 != r3) goto L_0x0042
            r1 = -1
            goto L_0x0043
        L_0x0042:
            r1 = r2
        L_0x0043:
            r3 = 4
            int[] r3 = new int[r3]
            int r4 = r8 + 1
            r5 = 0
            r3[r5] = r4
            boolean r4 = r15.a(r3, r2, r7, r2)
            r6 = 2
            r12 = 3
            if (r4 != 0) goto L_0x0069
            int r4 = r0.f42647b
            if (r4 < r12) goto L_0x0059
            r4 = r2
            goto L_0x005a
        L_0x0059:
            r4 = r5
        L_0x005a:
            boolean r4 = r15.a(r3, r6, r7, r4)
            if (r4 != 0) goto L_0x0069
            boolean r4 = r15.a(r3, r12, r7, r5)
            if (r4 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r4 = r5
            goto L_0x006a
        L_0x0069:
            r4 = r2
        L_0x006a:
            if (r4 != 0) goto L_0x0086
            long r9 = (long) r1
            r1 = r3[r2]
            long r1 = (long) r1
            r13 = 3600(0xe10, double:1.7786E-320)
            long r1 = r1 * r13
            r4 = r3[r6]
            long r6 = (long) r4
            r13 = 60
            long r6 = r6 * r13
            long r6 = r6 + r1
            r1 = r3[r12]
            long r1 = (long) r1
            long r6 = r6 + r1
            long r6 = r6 * r9
            j$.time.temporal.a r1 = j$.time.temporal.a.OFFSET_SECONDS
            r2 = r3[r5]
            r3 = r6
            r6 = r2
            goto L_0x008e
        L_0x0086:
            if (r9 != 0) goto L_0x0098
        L_0x0088:
            j$.time.temporal.a r1 = j$.time.temporal.a.OFFSET_SECONDS
            int r2 = r8 + r9
            r6 = r2
            r3 = r10
        L_0x008e:
            r2 = r1
        L_0x008f:
            r1 = r16
            r5 = r18
            int r1 = r1.o(r2, r3, r5, r6)
            return r1
        L_0x0098:
            int r1 = ~r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.l.d(j$.time.format.x, java.lang.CharSequence, int):int");
    }

    public final String toString() {
        String replace = this.f42646a.replace("'", "''");
        StringBuilder a10 = j$.time.a.a("Offset(");
        a10.append(f42643c[this.f42647b]);
        a10.append(",'");
        a10.append(replace);
        a10.append("')");
        return a10.toString();
    }
}
