package io.sentry.vendor;

import java.io.UnsupportedEncodingException;
import org.jivesoftware.smack.util.StringUtils;

public class a {

    /* renamed from: io.sentry.vendor.a$a  reason: collision with other inner class name */
    static abstract class C0362a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f31734a;

        /* renamed from: b  reason: collision with root package name */
        public int f31735b;

        C0362a() {
        }
    }

    static class b extends C0362a {

        /* renamed from: j  reason: collision with root package name */
        private static final byte[] f31736j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k  reason: collision with root package name */
        private static final byte[] f31737k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f31738c;

        /* renamed from: d  reason: collision with root package name */
        int f31739d;

        /* renamed from: e  reason: collision with root package name */
        private int f31740e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f31741f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f31742g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f31743h;

        /* renamed from: i  reason: collision with root package name */
        private final byte[] f31744i;

        public b(int i10, byte[] bArr) {
            boolean z10;
            boolean z11;
            byte[] bArr2;
            int i11;
            this.f31734a = bArr;
            boolean z12 = true;
            if ((i10 & 1) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f31741f = z10;
            if ((i10 & 2) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f31742g = z11;
            this.f31743h = (i10 & 4) == 0 ? false : z12;
            if ((i10 & 8) == 0) {
                bArr2 = f31736j;
            } else {
                bArr2 = f31737k;
            }
            this.f31744i = bArr2;
            this.f31738c = new byte[2];
            this.f31739d = 0;
            if (z11) {
                i11 = 19;
            } else {
                i11 = -1;
            }
            this.f31740e = i11;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01af  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x00e6 A[SYNTHETIC] */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.f31744i
                byte[] r2 = r0.f31734a
                int r3 = r0.f31740e
                int r4 = r20 + r19
                int r5 = r0.f31739d
                r6 = -1
                r7 = 0
                r8 = 2
                r9 = 1
                if (r5 == r9) goto L_0x0031
                if (r5 == r8) goto L_0x0015
                goto L_0x0050
            L_0x0015:
                int r5 = r19 + 1
                if (r5 > r4) goto L_0x0050
                byte[] r10 = r0.f31738c
                byte r11 = r10[r7]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.f31739d = r7
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.f31738c
                byte r5 = r5[r7]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                byte r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.f31739d = r7
                goto L_0x0053
            L_0x0050:
                r11 = r19
                r10 = r6
            L_0x0053:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r6) goto L_0x008f
                int r6 = r10 >> 18
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r7] = r6
                int r6 = r10 >> 12
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r10 >> 6
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r8] = r6
                r6 = r10 & 63
                byte r6 = r1[r6]
                r10 = 3
                r2[r10] = r6
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x008d
                boolean r3 = r0.f31743h
                if (r3 == 0) goto L_0x0085
                r3 = 5
                r2[r12] = r13
                goto L_0x0086
            L_0x0085:
                r3 = r12
            L_0x0086:
                int r6 = r3 + 1
                r2[r3] = r14
            L_0x008a:
                r3 = 19
                goto L_0x0090
            L_0x008d:
                r6 = r12
                goto L_0x0090
            L_0x008f:
                r6 = r7
            L_0x0090:
                int r10 = r11 + 3
                if (r10 > r4) goto L_0x00e6
                byte r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                byte r5 = r18[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                byte r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r5 = r5 & 63
                byte r5 = r1[r5]
                r2[r11] = r5
                int r6 = r6 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e4
                boolean r3 = r0.f31743h
                if (r3 == 0) goto L_0x00dd
                int r3 = r6 + 1
                r2[r6] = r13
                r6 = r3
            L_0x00dd:
                int r3 = r6 + 1
                r2[r6] = r14
                r6 = r3
                r11 = r10
                goto L_0x008a
            L_0x00e4:
                r11 = r10
                goto L_0x0090
            L_0x00e6:
                if (r21 == 0) goto L_0x01af
                int r5 = r0.f31739d
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0134
                if (r5 <= 0) goto L_0x00fa
                byte[] r4 = r0.f31738c
                byte r4 = r4[r7]
                r7 = r9
                goto L_0x00fc
            L_0x00fa:
                byte r4 = r18[r11]
            L_0x00fc:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r12
                int r5 = r5 - r7
                r0.f31739d = r5
                int r5 = r6 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r5] = r1
                boolean r1 = r0.f31741f
                if (r1 == 0) goto L_0x0120
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L_0x0120:
                boolean r1 = r0.f31742g
                if (r1 == 0) goto L_0x01d6
                boolean r1 = r0.f31743h
                if (r1 == 0) goto L_0x012d
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x012d:
                int r1 = r6 + 1
                r2[r6] = r14
            L_0x0131:
                r6 = r1
                goto L_0x01d6
            L_0x0134:
                int r10 = r11 - r5
                int r4 = r4 - r8
                if (r10 != r4) goto L_0x0197
                if (r5 <= r9) goto L_0x0141
                byte[] r4 = r0.f31738c
                byte r4 = r4[r7]
                r7 = r9
                goto L_0x0147
            L_0x0141:
                int r4 = r11 + 1
                byte r10 = r18[r11]
                r11 = r4
                r4 = r10
            L_0x0147:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r14
                if (r5 <= 0) goto L_0x0153
                byte[] r10 = r0.f31738c
                int r11 = r7 + 1
                byte r7 = r10[r7]
                goto L_0x0157
            L_0x0153:
                byte r10 = r18[r11]
                r11 = r7
                r7 = r10
            L_0x0157:
                r7 = r7 & 255(0xff, float:3.57E-43)
                int r7 = r7 << r8
                r4 = r4 | r7
                int r5 = r5 - r11
                r0.f31739d = r5
                int r5 = r6 + 1
                int r7 = r4 >> 12
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r5] = r7
                int r5 = r6 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r6] = r1
                boolean r1 = r0.f31741f
                if (r1 == 0) goto L_0x0183
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L_0x0183:
                boolean r1 = r0.f31742g
                if (r1 == 0) goto L_0x0195
                boolean r1 = r0.f31743h
                if (r1 == 0) goto L_0x0190
                int r1 = r5 + 1
                r2[r5] = r13
                r5 = r1
            L_0x0190:
                int r1 = r5 + 1
                r2[r5] = r14
                r5 = r1
            L_0x0195:
                r6 = r5
                goto L_0x01d6
            L_0x0197:
                boolean r1 = r0.f31742g
                if (r1 == 0) goto L_0x01d6
                if (r6 <= 0) goto L_0x01d6
                r1 = 19
                if (r3 == r1) goto L_0x01d6
                boolean r1 = r0.f31743h
                if (r1 == 0) goto L_0x01aa
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x01aa:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L_0x0131
            L_0x01af:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01c0
                byte[] r1 = r0.f31738c
                int r2 = r0.f31739d
                int r4 = r2 + 1
                r0.f31739d = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x01d6
            L_0x01c0:
                int r4 = r4 - r8
                if (r11 != r4) goto L_0x01d6
                byte[] r1 = r0.f31738c
                int r2 = r0.f31739d
                int r4 = r2 + 1
                byte r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.f31739d = r2
                int r11 = r11 + r9
                byte r2 = r18[r11]
                r1[r4] = r2
            L_0x01d6:
                r0.f31735b = r6
                r0.f31740e = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i10) {
        return b(bArr, 0, bArr.length, i10);
    }

    public static byte[] b(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, (byte[]) null);
        int i13 = (i11 / 3) * 4;
        int i14 = 2;
        if (!bVar.f31741f) {
            int i15 = i11 % 3;
            if (i15 == 1) {
                i13 += 2;
            } else if (i15 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (bVar.f31742g && i11 > 0) {
            int i16 = ((i11 - 1) / 57) + 1;
            if (!bVar.f31743h) {
                i14 = 1;
            }
            i13 += i16 * i14;
        }
        bVar.f31734a = new byte[i13];
        bVar.a(bArr, i10, i11, true);
        return bVar.f31734a;
    }

    public static String c(byte[] bArr, int i10) {
        try {
            return new String(a(bArr, i10), StringUtils.USASCII);
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
