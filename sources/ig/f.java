package ig;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jivesoftware.smack.util.StringUtils;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f23501a = Charset.forName("UTF-8");

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f23502a;

        /* renamed from: b  reason: collision with root package name */
        public int f23503b;

        a() {
        }
    }

    static class b extends a {

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f23504f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g  reason: collision with root package name */
        private static final int[] f23505g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c  reason: collision with root package name */
        private int f23506c;

        /* renamed from: d  reason: collision with root package name */
        private int f23507d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f23508e;

        public b(int i10, byte[] bArr) {
            int[] iArr;
            this.f23502a = bArr;
            if ((i10 & 8) == 0) {
                iArr = f23504f;
            } else {
                iArr = f23505g;
            }
            this.f23508e = iArr;
            this.f23506c = 0;
            this.f23507d = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x00f1 A[EDGE_INSN: B:70:0x00f1->B:53:0x00f1 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(byte[] r17, int r18, int r19, boolean r20) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.f23506c
                r2 = 0
                r3 = 6
                if (r1 != r3) goto L_0x0009
                return r2
            L_0x0009:
                int r4 = r19 + r18
                int r5 = r0.f23507d
                byte[] r6 = r0.f23502a
                int[] r7 = r0.f23508e
                r9 = r2
                r8 = r5
                r5 = r1
                r1 = r18
            L_0x0016:
                r10 = 3
                r11 = 4
                r12 = 2
                r13 = 1
                if (r1 >= r4) goto L_0x00f1
                if (r5 != 0) goto L_0x0063
            L_0x001e:
                int r14 = r1 + 4
                if (r14 > r4) goto L_0x005f
                byte r8 = r17[r1]
                r8 = r8 & 255(0xff, float:3.57E-43)
                r8 = r7[r8]
                int r8 = r8 << 18
                int r15 = r1 + 1
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << 12
                r8 = r8 | r15
                int r15 = r1 + 2
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << r3
                r8 = r8 | r15
                int r15 = r1 + 3
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                r8 = r8 | r15
                if (r8 < 0) goto L_0x005f
                int r1 = r9 + 2
                byte r15 = (byte) r8
                r6[r1] = r15
                int r1 = r9 + 1
                int r15 = r8 >> 8
                byte r15 = (byte) r15
                r6[r1] = r15
                int r1 = r8 >> 16
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 3
                r1 = r14
                goto L_0x001e
            L_0x005f:
                if (r1 < r4) goto L_0x0063
                goto L_0x00f1
            L_0x0063:
                int r14 = r1 + 1
                byte r1 = r17[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                r1 = r7[r1]
                r15 = 5
                r2 = -1
                if (r5 == 0) goto L_0x00e1
                if (r5 == r13) goto L_0x00d5
                r13 = -2
                if (r5 == r12) goto L_0x00c1
                if (r5 == r10) goto L_0x008e
                if (r5 == r11) goto L_0x0082
                if (r5 == r15) goto L_0x007c
                goto L_0x00ed
            L_0x007c:
                if (r1 == r2) goto L_0x00ed
                r0.f23506c = r3
            L_0x0080:
                r10 = 0
                return r10
            L_0x0082:
                r10 = 0
                if (r1 != r13) goto L_0x0089
                int r5 = r5 + 1
                goto L_0x00ed
            L_0x0089:
                if (r1 == r2) goto L_0x00ed
                r0.f23506c = r3
                return r10
            L_0x008e:
                if (r1 < 0) goto L_0x00a9
                int r2 = r8 << 6
                r1 = r1 | r2
                int r2 = r9 + 2
                byte r5 = (byte) r1
                r6[r2] = r5
                int r2 = r9 + 1
                int r5 = r1 >> 8
                byte r5 = (byte) r5
                r6[r2] = r5
                int r2 = r1 >> 16
                byte r2 = (byte) r2
                r6[r9] = r2
                int r9 = r9 + 3
                r8 = r1
                r5 = 0
                goto L_0x00ed
            L_0x00a9:
                if (r1 != r13) goto L_0x00bb
                int r1 = r9 + 1
                int r2 = r8 >> 2
                byte r2 = (byte) r2
                r6[r1] = r2
                int r1 = r8 >> 10
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 2
                r5 = r15
                goto L_0x00ed
            L_0x00bb:
                if (r1 == r2) goto L_0x00ed
                r0.f23506c = r3
            L_0x00bf:
                r1 = 0
                return r1
            L_0x00c1:
                if (r1 < 0) goto L_0x00c4
                goto L_0x00d8
            L_0x00c4:
                if (r1 != r13) goto L_0x00d0
                int r1 = r9 + 1
                int r2 = r8 >> 4
                byte r2 = (byte) r2
                r6[r9] = r2
                r9 = r1
                r5 = r11
                goto L_0x00ed
            L_0x00d0:
                if (r1 == r2) goto L_0x00ed
                r0.f23506c = r3
                goto L_0x0080
            L_0x00d5:
                r10 = 0
                if (r1 < 0) goto L_0x00dc
            L_0x00d8:
                int r2 = r8 << 6
                r1 = r1 | r2
                goto L_0x00e4
            L_0x00dc:
                if (r1 == r2) goto L_0x00ed
                r0.f23506c = r3
                return r10
            L_0x00e1:
                r10 = 0
                if (r1 < 0) goto L_0x00e8
            L_0x00e4:
                int r5 = r5 + 1
                r8 = r1
                goto L_0x00ed
            L_0x00e8:
                if (r1 == r2) goto L_0x00ed
                r0.f23506c = r3
                return r10
            L_0x00ed:
                r1 = r14
                r2 = 0
                goto L_0x0016
            L_0x00f1:
                if (r20 != 0) goto L_0x00fa
                r0.f23506c = r5
                r0.f23507d = r8
                r0.f23503b = r9
                return r13
            L_0x00fa:
                if (r5 == r13) goto L_0x0122
                if (r5 == r12) goto L_0x0115
                if (r5 == r10) goto L_0x0106
                if (r5 == r11) goto L_0x0103
                goto L_0x011d
            L_0x0103:
                r0.f23506c = r3
                goto L_0x00bf
            L_0x0106:
                int r1 = r9 + 1
                int r2 = r8 >> 10
                byte r2 = (byte) r2
                r6[r9] = r2
                int r9 = r1 + 1
                int r2 = r8 >> 2
                byte r2 = (byte) r2
                r6[r1] = r2
                goto L_0x011d
            L_0x0115:
                int r1 = r9 + 1
                int r2 = r8 >> 4
                byte r2 = (byte) r2
                r6[r9] = r2
                r9 = r1
            L_0x011d:
                r0.f23506c = r5
                r0.f23503b = r9
                return r13
            L_0x0122:
                r0.f23506c = r3
                goto L_0x00bf
            */
            throw new UnsupportedOperationException("Method not decompiled: ig.f.b.a(byte[], int, int, boolean):boolean");
        }
    }

    static class c extends a {

        /* renamed from: j  reason: collision with root package name */
        private static final byte[] f23509j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k  reason: collision with root package name */
        private static final byte[] f23510k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX};

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f23511c;

        /* renamed from: d  reason: collision with root package name */
        int f23512d;

        /* renamed from: e  reason: collision with root package name */
        private int f23513e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f23514f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f23515g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f23516h;

        /* renamed from: i  reason: collision with root package name */
        private final byte[] f23517i;

        public c(int i10, byte[] bArr) {
            boolean z10;
            boolean z11;
            byte[] bArr2;
            int i11;
            this.f23502a = bArr;
            boolean z12 = true;
            if ((i10 & 1) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f23514f = z10;
            if ((i10 & 2) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f23515g = z11;
            this.f23516h = (i10 & 4) == 0 ? false : z12;
            if ((i10 & 8) == 0) {
                bArr2 = f23509j;
            } else {
                bArr2 = f23510k;
            }
            this.f23517i = bArr2;
            this.f23511c = new byte[2];
            this.f23512d = 0;
            if (z11) {
                i11 = 19;
            } else {
                i11 = -1;
            }
            this.f23513e = i11;
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
                byte[] r1 = r0.f23517i
                byte[] r2 = r0.f23502a
                int r3 = r0.f23513e
                int r4 = r20 + r19
                int r5 = r0.f23512d
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
                byte[] r10 = r0.f23511c
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
                r0.f23512d = r7
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r19 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.f23511c
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
                r0.f23512d = r7
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
                boolean r3 = r0.f23516h
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
                boolean r3 = r0.f23516h
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
                int r5 = r0.f23512d
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0134
                if (r5 <= 0) goto L_0x00fa
                byte[] r4 = r0.f23511c
                byte r4 = r4[r7]
                r7 = r9
                goto L_0x00fc
            L_0x00fa:
                byte r4 = r18[r11]
            L_0x00fc:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r12
                int r5 = r5 - r7
                r0.f23512d = r5
                int r5 = r6 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r5] = r1
                boolean r1 = r0.f23514f
                if (r1 == 0) goto L_0x0120
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L_0x0120:
                boolean r1 = r0.f23515g
                if (r1 == 0) goto L_0x01d6
                boolean r1 = r0.f23516h
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
                byte[] r4 = r0.f23511c
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
                byte[] r10 = r0.f23511c
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
                r0.f23512d = r5
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
                boolean r1 = r0.f23514f
                if (r1 == 0) goto L_0x0183
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L_0x0183:
                boolean r1 = r0.f23515g
                if (r1 == 0) goto L_0x0195
                boolean r1 = r0.f23516h
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
                boolean r1 = r0.f23515g
                if (r1 == 0) goto L_0x01d6
                if (r6 <= 0) goto L_0x01d6
                r1 = 19
                if (r3 == r1) goto L_0x01d6
                boolean r1 = r0.f23516h
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
                byte[] r1 = r0.f23511c
                int r2 = r0.f23512d
                int r4 = r2 + 1
                r0.f23512d = r4
                byte r4 = r18[r11]
                r1[r2] = r4
                goto L_0x01d6
            L_0x01c0:
                int r4 = r4 - r8
                if (r11 != r4) goto L_0x01d6
                byte[] r1 = r0.f23511c
                int r2 = r0.f23512d
                int r4 = r2 + 1
                byte r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.f23512d = r2
                int r11 = r11 + r9
                byte r2 = r18[r11]
                r1[r4] = r2
            L_0x01d6:
                r0.f23503b = r6
                r0.f23513e = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ig.f.c.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(String str, int i10) {
        return b(str.getBytes(f23501a), i10);
    }

    public static byte[] b(byte[] bArr, int i10) {
        return c(bArr, 0, bArr.length, i10);
    }

    public static byte[] c(byte[] bArr, int i10, int i11, int i12) {
        b bVar = new b(i12, new byte[((i11 * 3) / 4)]);
        if (bVar.a(bArr, i10, i11, true)) {
            int i13 = bVar.f23503b;
            byte[] bArr2 = bVar.f23502a;
            if (i13 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr2, 0, bArr3, 0, i13);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String d(byte[] bArr) {
        return g(bArr, 2);
    }

    public static byte[] e(byte[] bArr, int i10) {
        return f(bArr, 0, bArr.length, i10);
    }

    public static byte[] f(byte[] bArr, int i10, int i11, int i12) {
        c cVar = new c(i12, (byte[]) null);
        int i13 = (i11 / 3) * 4;
        int i14 = 2;
        if (!cVar.f23514f) {
            int i15 = i11 % 3;
            if (i15 == 1) {
                i13 += 2;
            } else if (i15 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (cVar.f23515g && i11 > 0) {
            int i16 = ((i11 - 1) / 57) + 1;
            if (!cVar.f23516h) {
                i14 = 1;
            }
            i13 += i16 * i14;
        }
        cVar.f23502a = new byte[i13];
        cVar.a(bArr, i10, i11, true);
        return cVar.f23502a;
    }

    public static String g(byte[] bArr, int i10) {
        try {
            return new String(e(bArr, i10), StringUtils.USASCII);
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}
