package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import nh.l;

public final class Code128Writer extends l {

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static final class MinimalEncoder {

        /* renamed from: a  reason: collision with root package name */
        private int[][] f22085a;

        /* renamed from: b  reason: collision with root package name */
        private Latch[][] f22086b;

        private enum Charset {
            A,
            B,
            C,
            NONE
        }

        private enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        private MinimalEncoder() {
        }

        /* synthetic */ MinimalEncoder(a aVar) {
            this();
        }

        private static void b(Collection<int[]> collection, int i10, int[] iArr, int[] iArr2, int i11) {
            collection.add(a.f22100a[i10]);
            if (i11 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i10 * iArr2[0]);
        }

        private boolean c(CharSequence charSequence, Charset charset, int i10) {
            int i11;
            char charAt = charSequence.charAt(i10);
            int i12 = a.f22099b[charset.ordinal()];
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        return false;
                    }
                    if (charAt == 241 || ((i11 = i10 + 1) < charSequence.length() && f(charAt) && f(charSequence.charAt(i11)))) {
                        return true;
                    }
                    return false;
                } else if (charAt == 241 || charAt == 242 || charAt == 243 || charAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ÿ".indexOf(charAt) >= 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (charAt == 241 || charAt == 242 || charAt == 243 || charAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ".indexOf(charAt) >= 0) {
                return true;
            } else {
                return false;
            }
        }

        private int d(CharSequence charSequence, Charset charset, int i10) {
            boolean z10;
            int i11;
            int i12;
            int i13;
            int i14 = this.f22085a[charset.ordinal()][i10];
            if (i14 > 0) {
                return i14;
            }
            Latch latch = Latch.NONE;
            int i15 = i10 + 1;
            int i16 = 1;
            if (i15 >= charSequence.length()) {
                z10 = true;
            } else {
                z10 = false;
            }
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i17 = Integer.MAX_VALUE;
            for (int i18 = 0; i18 <= 1; i18++) {
                if (c(charSequence, charsetArr[i18], i10)) {
                    Latch latch2 = Latch.NONE;
                    Charset charset2 = charsetArr[i18];
                    if (charset != charset2) {
                        latch2 = Latch.valueOf(charset2.toString());
                        i12 = 2;
                    } else {
                        i12 = 1;
                    }
                    if (!z10) {
                        i12 += d(charSequence, charsetArr[i18], i15);
                    }
                    if (i12 < i17) {
                        latch = latch2;
                        i17 = i12;
                    }
                    if (charset == charsetArr[(i18 + 1) % 2]) {
                        Latch latch3 = Latch.SHIFT;
                        if (!z10) {
                            i13 = d(charSequence, charset, i15) + 2;
                        } else {
                            i13 = 2;
                        }
                        if (i13 < i17) {
                            latch = latch3;
                            i17 = i13;
                        }
                    }
                }
            }
            Charset charset3 = Charset.C;
            if (c(charSequence, charset3, i10)) {
                Latch latch4 = Latch.NONE;
                if (charset != charset3) {
                    latch4 = Latch.C;
                    i11 = 2;
                } else {
                    i11 = 1;
                }
                if (charSequence.charAt(i10) != 241) {
                    i16 = 2;
                }
                int i19 = i16 + i10;
                if (i19 < charSequence.length()) {
                    i11 += d(charSequence, charset3, i19);
                }
                if (i11 < i17) {
                    latch = latch4;
                    i17 = i11;
                }
            }
            if (i17 != Integer.MAX_VALUE) {
                this.f22085a[charset.ordinal()][i10] = i17;
                this.f22086b[charset.ordinal()][i10] = latch;
                return i17;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + charSequence.charAt(i10));
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean[] e(java.lang.String r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                int r2 = r17.length()
                r3 = 2
                int[] r4 = new int[r3]
                r5 = 1
                r4[r5] = r2
                r2 = 0
                r6 = 4
                r4[r2] = r6
                java.lang.Class r7 = java.lang.Integer.TYPE
                java.lang.Object r4 = java.lang.reflect.Array.newInstance(r7, r4)
                int[][] r4 = (int[][]) r4
                r0.f22085a = r4
                int r4 = r17.length()
                int[] r7 = new int[r3]
                r7[r5] = r4
                r7[r2] = r6
                java.lang.Class<com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch> r4 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.class
                java.lang.Object r4 = java.lang.reflect.Array.newInstance(r4, r7)
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch[][] r4 = (com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch[][]) r4
                r0.f22086b = r4
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r4 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.NONE
                r0.d(r1, r4, r2)
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                int[] r8 = new int[r5]
                r8[r2] = r2
                int[] r9 = new int[r5]
                r9[r2] = r5
                int r10 = r17.length()
                r11 = r2
            L_0x0047:
                if (r11 >= r10) goto L_0x00fb
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch[][] r12 = r0.f22086b
                int r13 = r4.ordinal()
                r12 = r12[r13]
                r12 = r12[r11]
                int[] r13 = com.google.zxing.oned.Code128Writer.a.f22098a
                int r14 = r12.ordinal()
                r13 = r13[r14]
                r14 = 100
                r15 = 101(0x65, float:1.42E-43)
                if (r13 == r5) goto L_0x0088
                if (r13 == r3) goto L_0x007c
                r3 = 3
                if (r13 == r3) goto L_0x006f
                if (r13 == r6) goto L_0x0069
                goto L_0x0094
            L_0x0069:
                r3 = 98
                b(r7, r3, r8, r9, r11)
                goto L_0x0094
            L_0x006f:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.C
                if (r11 != 0) goto L_0x0076
                r4 = 105(0x69, float:1.47E-43)
                goto L_0x0078
            L_0x0076:
                r4 = 99
            L_0x0078:
                b(r7, r4, r8, r9, r11)
                goto L_0x0093
            L_0x007c:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.B
                if (r11 != 0) goto L_0x0083
                r4 = 104(0x68, float:1.46E-43)
                goto L_0x0084
            L_0x0083:
                r4 = r14
            L_0x0084:
                b(r7, r4, r8, r9, r11)
                goto L_0x0093
            L_0x0088:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.A
                if (r11 != 0) goto L_0x008f
                r4 = 103(0x67, float:1.44E-43)
                goto L_0x0090
            L_0x008f:
                r4 = r15
            L_0x0090:
                b(r7, r4, r8, r9, r11)
            L_0x0093:
                r4 = r3
            L_0x0094:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.C
                r13 = 102(0x66, float:1.43E-43)
                if (r4 != r3) goto L_0x00b9
                char r3 = r1.charAt(r11)
                r12 = 241(0xf1, float:3.38E-43)
                if (r3 != r12) goto L_0x00a6
                b(r7, r13, r8, r9, r11)
                goto L_0x00f7
            L_0x00a6:
                int r3 = r11 + 2
                java.lang.String r3 = r1.substring(r11, r3)
                int r3 = java.lang.Integer.parseInt(r3)
                b(r7, r3, r8, r9, r11)
                int r3 = r11 + 1
                if (r3 >= r10) goto L_0x00f7
                r11 = r3
                goto L_0x00f7
            L_0x00b9:
                char r3 = r1.charAt(r11)
                switch(r3) {
                    case 241: goto L_0x00df;
                    case 242: goto L_0x00dc;
                    case 243: goto L_0x00d9;
                    case 244: goto L_0x00c7;
                    default: goto L_0x00c0;
                }
            L_0x00c0:
                char r3 = r1.charAt(r11)
                int r14 = r3 + -32
                goto L_0x00e0
            L_0x00c7:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.A
                if (r4 != r3) goto L_0x00cf
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.SHIFT
                if (r12 != r3) goto L_0x00d7
            L_0x00cf:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.B
                if (r4 != r3) goto L_0x00e0
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.SHIFT
                if (r12 != r3) goto L_0x00e0
            L_0x00d7:
                r14 = r15
                goto L_0x00e0
            L_0x00d9:
                r14 = 96
                goto L_0x00e0
            L_0x00dc:
                r14 = 97
                goto L_0x00e0
            L_0x00df:
                r14 = r13
            L_0x00e0:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.A
                if (r4 != r3) goto L_0x00e8
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.SHIFT
                if (r12 != r3) goto L_0x00f0
            L_0x00e8:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.B
                if (r4 != r3) goto L_0x00f4
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.SHIFT
                if (r12 != r3) goto L_0x00f4
            L_0x00f0:
                if (r14 >= 0) goto L_0x00f4
                int r14 = r14 + 96
            L_0x00f4:
                b(r7, r14, r8, r9, r11)
            L_0x00f7:
                int r11 = r11 + r5
                r3 = 2
                goto L_0x0047
            L_0x00fb:
                r1 = 0
                r0.f22085a = r1
                r0.f22086b = r1
                r1 = r8[r2]
                boolean[] r1 = com.google.zxing.oned.Code128Writer.m(r7, r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.MinimalEncoder.e(java.lang.String):boolean[]");
        }

        private static boolean f(char c10) {
            return c10 >= '0' && c10 <= '9';
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22098a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f22099b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset[] r0 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22099b = r0
                r1 = 1
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r2 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22099b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.B     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f22099b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Charset r4 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Charset.C     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch[] r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f22098a = r3
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r4 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.A     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f22098a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r3 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.B     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f22098a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r1 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.C     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f22098a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.google.zxing.oned.Code128Writer$MinimalEncoder$Latch r1 = com.google.zxing.oned.Code128Writer.MinimalEncoder.Latch.SHIFT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.a.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        if (r7.equals("B") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int i(java.lang.String r6, java.util.Map<com.google.zxing.EncodeHintType, ?> r7) {
        /*
            int r0 = r6.length()
            r1 = 1
            if (r0 < r1) goto L_0x00ff
            r2 = 80
            if (r0 > r2) goto L_0x00ff
            r2 = 0
            r3 = -1
            if (r7 == 0) goto L_0x006b
            com.google.zxing.EncodeHintType r4 = com.google.zxing.EncodeHintType.FORCE_CODE_SET
            boolean r5 = r7.containsKey(r4)
            if (r5 == 0) goto L_0x006b
            java.lang.Object r7 = r7.get(r4)
            java.lang.String r7 = r7.toString()
            r7.hashCode()
            int r4 = r7.hashCode()
            switch(r4) {
                case 65: goto L_0x003f;
                case 66: goto L_0x0036;
                case 67: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r1 = r3
            goto L_0x0049
        L_0x002b:
            java.lang.String r1 = "C"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r1 = 2
            goto L_0x0049
        L_0x0036:
            java.lang.String r4 = "B"
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x0049
            goto L_0x0029
        L_0x003f:
            java.lang.String r1 = "A"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0048
            goto L_0x0029
        L_0x0048:
            r1 = r2
        L_0x0049:
            switch(r1) {
                case 0: goto L_0x0069;
                case 1: goto L_0x0066;
                case 2: goto L_0x0063;
                default: goto L_0x004c;
            }
        L_0x004c:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unsupported code set hint: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L_0x0063:
            r3 = 99
            goto L_0x006b
        L_0x0066:
            r3 = 100
            goto L_0x006b
        L_0x0069:
            r3 = 101(0x65, float:1.42E-43)
        L_0x006b:
            if (r2 >= r0) goto L_0x00fe
            char r7 = r6.charAt(r2)
            r1 = 127(0x7f, float:1.78E-43)
            switch(r7) {
                case 241: goto L_0x0078;
                case 242: goto L_0x0078;
                case 243: goto L_0x0078;
                case 244: goto L_0x0078;
                default: goto L_0x0076;
            }
        L_0x0076:
            if (r7 > r1) goto L_0x00e7
        L_0x0078:
            switch(r3) {
                case 99: goto L_0x00b6;
                case 100: goto L_0x009a;
                case 101: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x00e4
        L_0x007c:
            r4 = 95
            if (r7 <= r4) goto L_0x00e4
            if (r7 <= r1) goto L_0x0083
            goto L_0x00e4
        L_0x0083:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Bad character in input for forced code set A: ASCII value="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L_0x009a:
            r1 = 32
            if (r7 <= r1) goto L_0x009f
            goto L_0x00e4
        L_0x009f:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Bad character in input for forced code set B: ASCII value="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L_0x00b6:
            r4 = 48
            if (r7 < r4) goto L_0x00cd
            r4 = 57
            if (r7 <= r4) goto L_0x00c0
            if (r7 <= r1) goto L_0x00cd
        L_0x00c0:
            r1 = 242(0xf2, float:3.39E-43)
            if (r7 == r1) goto L_0x00cd
            r1 = 243(0xf3, float:3.4E-43)
            if (r7 == r1) goto L_0x00cd
            r1 = 244(0xf4, float:3.42E-43)
            if (r7 == r1) goto L_0x00cd
            goto L_0x00e4
        L_0x00cd:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Bad character in input for forced code set C: ASCII value="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L_0x00e4:
            int r2 = r2 + 1
            goto L_0x006b
        L_0x00e7:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Bad character in input: ASCII value="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L_0x00fe:
            return r3
        L_0x00ff:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "Contents length should be between 1 and 80 characters, but got "
            r7.append(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.i(java.lang.String, java.util.Map):int");
    }

    private static int j(CharSequence charSequence, int i10, int i11) {
        CType l10;
        CType l11;
        char charAt;
        CType l12 = l(charSequence, i10);
        CType cType = CType.ONE_DIGIT;
        if (l12 != cType) {
            CType cType2 = CType.UNCODABLE;
            if (l12 == cType2) {
                if (i10 >= charSequence.length() || ((charAt = charSequence.charAt(i10)) >= ' ' && (i11 != 101 || (charAt >= '`' && (charAt < 241 || charAt > 244))))) {
                    return 100;
                }
                return 101;
            } else if (i11 == 101 && l12 == CType.FNC_1) {
                return 101;
            } else {
                if (i11 == 99) {
                    return 99;
                }
                if (i11 == 100) {
                    CType cType3 = CType.FNC_1;
                    if (l12 == cType3 || (l10 = l(charSequence, i10 + 2)) == cType2 || l10 == cType) {
                        return 100;
                    }
                    if (l10 != cType3) {
                        int i12 = i10 + 4;
                        while (true) {
                            l11 = l(charSequence, i12);
                            if (l11 != CType.TWO_DIGITS) {
                                break;
                            }
                            i12 += 2;
                        }
                        if (l11 == CType.ONE_DIGIT) {
                            return 100;
                        }
                        return 99;
                    } else if (l(charSequence, i10 + 3) == CType.TWO_DIGITS) {
                        return 99;
                    } else {
                        return 100;
                    }
                } else {
                    if (l12 == CType.FNC_1) {
                        l12 = l(charSequence, i10 + 1);
                    }
                    if (l12 == CType.TWO_DIGITS) {
                        return 99;
                    }
                    return 100;
                }
            }
        } else if (i11 == 101) {
            return 101;
        } else {
            return 100;
        }
    }

    private static boolean[] k(String str, int i10) {
        int i11;
        int i12;
        int i13;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i14 < length) {
            if (i10 == -1) {
                i11 = j(str, i14, i16);
            } else {
                i11 = i10;
            }
            int i18 = 100;
            if (i11 == i16) {
                switch (str.charAt(i14)) {
                    case 241:
                        i18 = 102;
                        break;
                    case 242:
                        i18 = 97;
                        break;
                    case 243:
                        i18 = 96;
                        break;
                    case 244:
                        if (i16 == 101) {
                            i18 = 101;
                            break;
                        }
                        break;
                    default:
                        if (i16 != 100) {
                            if (i16 == 101) {
                                i18 = str.charAt(i14) - ' ';
                                if (i18 < 0) {
                                    i18 += 96;
                                    break;
                                }
                            } else {
                                int i19 = i14 + 1;
                                if (i19 != length) {
                                    i18 = Integer.parseInt(str.substring(i14, i14 + 2));
                                    i14 = i19;
                                    break;
                                } else {
                                    throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                                }
                            }
                        } else {
                            i18 = str.charAt(i14) - ' ';
                            break;
                        }
                        break;
                }
                i14++;
            } else {
                if (i16 == 0) {
                    if (i11 == 100) {
                        i13 = 104;
                    } else if (i11 != 101) {
                        i13 = 105;
                    } else {
                        i13 = 103;
                    }
                    i12 = i13;
                } else {
                    i12 = i11;
                }
                i16 = i11;
            }
            arrayList.add(a.f22100a[i12]);
            i15 += i12 * i17;
            if (i14 != 0) {
                i17++;
            }
        }
        return m(arrayList, i15);
    }

    private static CType l(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i11);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    static boolean[] m(Collection<int[]> collection, int i10) {
        int[][] iArr = a.f22100a;
        collection.add(iArr[i10 % 103]);
        collection.add(iArr[106]);
        int i11 = 0;
        int i12 = 0;
        for (int[] next : collection) {
            for (int i13 : r7.next()) {
                i12 += i13;
            }
        }
        boolean[] zArr = new boolean[i12];
        for (int[] b10 : collection) {
            i11 += l.b(zArr, i11, b10, true);
        }
        return zArr;
    }

    public boolean[] d(String str) {
        return e(str, (Map<EncodeHintType, ?>) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] e(java.lang.String r4, java.util.Map<com.google.zxing.EncodeHintType, ?> r5) {
        /*
            r3 = this;
            int r0 = i(r4, r5)
            if (r5 == 0) goto L_0x001e
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.CODE128_COMPACT
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L_0x001e
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = r5.toString()
            boolean r5 = java.lang.Boolean.parseBoolean(r5)
            if (r5 == 0) goto L_0x001e
            r5 = 1
            goto L_0x001f
        L_0x001e:
            r5 = 0
        L_0x001f:
            if (r5 == 0) goto L_0x002c
            com.google.zxing.oned.Code128Writer$MinimalEncoder r5 = new com.google.zxing.oned.Code128Writer$MinimalEncoder
            r0 = 0
            r5.<init>(r0)
            boolean[] r4 = r5.e(r4)
            goto L_0x0030
        L_0x002c:
            boolean[] r4 = k(r4, r0)
        L_0x0030:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.e(java.lang.String, java.util.Map):boolean[]");
    }

    /* access modifiers changed from: protected */
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
