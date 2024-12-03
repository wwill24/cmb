package com.google.zxing.qrcode.encoder;

import com.google.android.gms.common.api.a;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import jh.f;
import kh.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f22150a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final Charset f22151b = StandardCharsets.ISO_8859_1;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22152a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.zxing.qrcode.decoder.Mode[] r0 = com.google.zxing.qrcode.decoder.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22152a = r0
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22152a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22152a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22152a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.b.a.<clinit>():void");
        }
    }

    static void a(String str, jh.a aVar, Charset charset) {
        for (byte c10 : str.getBytes(charset)) {
            aVar.c(c10, 8);
        }
    }

    static void b(CharSequence charSequence, jh.a aVar) throws WriterException {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int p10 = p(charSequence.charAt(i10));
            if (p10 != -1) {
                int i11 = i10 + 1;
                if (i11 < length) {
                    int p11 = p(charSequence.charAt(i11));
                    if (p11 != -1) {
                        aVar.c((p10 * 45) + p11, 11);
                        i10 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    aVar.c(p10, 6);
                    i10 = i11;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void c(String str, Mode mode, jh.a aVar, Charset charset) throws WriterException {
        int i10 = a.f22152a[mode.ordinal()];
        if (i10 == 1) {
            h(str, aVar);
        } else if (i10 == 2) {
            b(str, aVar);
        } else if (i10 == 3) {
            a(str, aVar, charset);
        } else if (i10 == 4) {
            e(str, aVar);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void d(CharacterSetECI characterSetECI, jh.a aVar) {
        aVar.c(Mode.ECI.a(), 4);
        aVar.c(characterSetECI.c(), 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c A[LOOP:0: B:3:0x000f->B:16:0x003c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void e(java.lang.String r6, jh.a r7) throws com.google.zxing.WriterException {
        /*
            java.nio.charset.Charset r0 = jh.f.f23593b
            byte[] r6 = r6.getBytes(r0)
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0054
            int r0 = r6.length
            int r0 = r0 + -1
            r1 = 0
        L_0x000f:
            if (r1 >= r0) goto L_0x0053
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x002b
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x002b
        L_0x0029:
            int r2 = r2 - r3
            goto L_0x003a
        L_0x002b:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0039
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0039
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0029
        L_0x0039:
            r2 = r4
        L_0x003a:
            if (r2 == r4) goto L_0x004b
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto L_0x000f
        L_0x004b:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L_0x0053:
            return
        L_0x0054:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Kanji byte size not even"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.b.e(java.lang.String, jh.a):void");
    }

    static void f(int i10, rh.a aVar, Mode mode, jh.a aVar2) throws WriterException {
        int b10 = mode.b(aVar);
        int i11 = 1 << b10;
        if (i10 < i11) {
            aVar2.c(i10, b10);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    static void g(Mode mode, jh.a aVar) {
        aVar.c(mode.a(), 4);
    }

    static void h(CharSequence charSequence, jh.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int charAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(Mode mode, jh.a aVar, jh.a aVar2, rh.a aVar3) {
        return aVar.i() + mode.b(aVar3) + aVar2.i();
    }

    private static int j(sh.a aVar) {
        return c.a(aVar) + c.c(aVar) + c.d(aVar) + c.e(aVar);
    }

    private static int k(jh.a aVar, ErrorCorrectionLevel errorCorrectionLevel, rh.a aVar2, sh.a aVar3) throws WriterException {
        int i10 = a.e.API_PRIORITY_OTHER;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            d.a(aVar, errorCorrectionLevel, aVar2, i12, aVar3);
            int j10 = j(aVar3);
            if (j10 < i10) {
                i11 = i12;
                i10 = j10;
            }
        }
        return i11;
    }

    private static Mode l(String str, Charset charset) {
        if (f.f23593b.equals(charset) && s(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else if (p(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z10 = true;
            }
        }
        if (z10) {
            return Mode.ALPHANUMERIC;
        }
        if (z11) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static rh.a m(int i10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i11 = 1; i11 <= 40; i11++) {
            rh.a e10 = rh.a.e(i11);
            if (v(i10, e10, errorCorrectionLevel)) {
                return e10;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013b, code lost:
        if (sh.b.b(r8) != false) goto L_0x013f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static sh.b n(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map<com.google.zxing.EncodeHintType, ?> r8) throws com.google.zxing.WriterException {
        /*
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L_0x001c
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.GS1_FORMAT
            boolean r3 = r8.containsKey(r2)
            if (r3 == 0) goto L_0x001c
            java.lang.Object r2 = r8.get(r2)
            java.lang.String r2 = r2.toString()
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            if (r2 == 0) goto L_0x001c
            r2 = r0
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            if (r8 == 0) goto L_0x0037
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.QR_COMPACT
            boolean r4 = r8.containsKey(r3)
            if (r4 == 0) goto L_0x0037
            java.lang.Object r3 = r8.get(r3)
            java.lang.String r3 = r3.toString()
            boolean r3 = java.lang.Boolean.parseBoolean(r3)
            if (r3 == 0) goto L_0x0037
            r3 = r0
            goto L_0x0038
        L_0x0037:
            r3 = r1
        L_0x0038:
            java.nio.charset.Charset r4 = f22151b
            if (r8 == 0) goto L_0x0045
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r5 = r8.containsKey(r5)
            if (r5 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r0 = r1
        L_0x0046:
            if (r0 == 0) goto L_0x0057
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L_0x0058
        L_0x0057:
            r1 = r4
        L_0x0058:
            if (r3 == 0) goto L_0x0076
            com.google.zxing.qrcode.decoder.Mode r0 = com.google.zxing.qrcode.decoder.Mode.BYTE
            boolean r3 = r1.equals(r4)
            r4 = 0
            if (r3 == 0) goto L_0x0064
            r1 = r4
        L_0x0064:
            com.google.zxing.qrcode.encoder.MinimalEncoder$c r6 = com.google.zxing.qrcode.encoder.MinimalEncoder.h(r6, r4, r1, r2, r7)
            jh.a r1 = new jh.a
            r1.<init>()
            r6.b(r1)
            rh.a r6 = r6.e()
            goto L_0x00ed
        L_0x0076:
            com.google.zxing.qrcode.decoder.Mode r3 = l(r6, r1)
            jh.a r4 = new jh.a
            r4.<init>()
            com.google.zxing.qrcode.decoder.Mode r5 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r3 != r5) goto L_0x008e
            if (r0 == 0) goto L_0x008e
            com.google.zxing.common.CharacterSetECI r0 = com.google.zxing.common.CharacterSetECI.a(r1)
            if (r0 == 0) goto L_0x008e
            d(r0, r4)
        L_0x008e:
            if (r2 == 0) goto L_0x0095
            com.google.zxing.qrcode.decoder.Mode r0 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION
            g(r0, r4)
        L_0x0095:
            g(r3, r4)
            jh.a r0 = new jh.a
            r0.<init>()
            c(r6, r3, r0, r1)
            if (r8 == 0) goto L_0x00cd
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x00cd
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            rh.a r1 = rh.a.e(r1)
            int r2 = i(r3, r4, r0, r1)
            boolean r2 = v(r2, r1, r7)
            if (r2 == 0) goto L_0x00c5
            goto L_0x00d1
        L_0x00c5:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L_0x00cd:
            rh.a r1 = t(r7, r3, r4, r0)
        L_0x00d1:
            jh.a r2 = new jh.a
            r2.<init>()
            r2.b(r4)
            if (r3 != r5) goto L_0x00e0
            int r6 = r0.j()
            goto L_0x00e4
        L_0x00e0:
            int r6 = r6.length()
        L_0x00e4:
            f(r6, r1, r3, r2)
            r2.b(r0)
            r6 = r1
            r1 = r2
            r0 = r3
        L_0x00ed:
            rh.a$b r2 = r6.c(r7)
            int r3 = r6.d()
            int r4 = r2.d()
            int r3 = r3 - r4
            u(r3, r1)
            int r4 = r6.d()
            int r2 = r2.c()
            jh.a r1 = r(r1, r4, r3, r2)
            sh.b r2 = new sh.b
            r2.<init>()
            r2.c(r7)
            r2.f(r0)
            r2.g(r6)
            int r0 = r6.b()
            sh.a r3 = new sh.a
            r3.<init>(r0, r0)
            r0 = -1
            if (r8 == 0) goto L_0x013e
            com.google.zxing.EncodeHintType r4 = com.google.zxing.EncodeHintType.QR_MASK_PATTERN
            boolean r5 = r8.containsKey(r4)
            if (r5 == 0) goto L_0x013e
            java.lang.Object r8 = r8.get(r4)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            boolean r4 = sh.b.b(r8)
            if (r4 == 0) goto L_0x013e
            goto L_0x013f
        L_0x013e:
            r8 = r0
        L_0x013f:
            if (r8 != r0) goto L_0x0145
            int r8 = k(r1, r7, r6, r3)
        L_0x0145:
            r2.d(r8)
            com.google.zxing.qrcode.encoder.d.a(r1, r7, r6, r8, r3)
            r2.e(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.b.n(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):sh.b");
    }

    static byte[] o(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[(length + i10)];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new c(kh.a.f23612l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    static int p(int i10) {
        int[] iArr = f22150a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    static void q(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws WriterException {
        if (i13 < i12) {
            int i14 = i10 % i12;
            int i15 = i12 - i14;
            int i16 = i10 / i12;
            int i17 = i16 + 1;
            int i18 = i11 / i12;
            int i19 = i18 + 1;
            int i20 = i16 - i18;
            int i21 = i17 - i19;
            if (i20 != i21) {
                throw new WriterException("EC bytes mismatch");
            } else if (i12 != i15 + i14) {
                throw new WriterException("RS blocks mismatch");
            } else if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i13 < i15) {
                iArr[0] = i18;
                iArr2[0] = i20;
            } else {
                iArr[0] = i19;
                iArr2[0] = i21;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    static jh.a r(jh.a aVar, int i10, int i11, int i12) throws WriterException {
        int i13 = i10;
        int i14 = i11;
        int i15 = i12;
        if (aVar.j() == i14) {
            ArrayList<a> arrayList = new ArrayList<>(i15);
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                q(i10, i11, i12, i19, iArr, iArr2);
                int i20 = iArr[0];
                byte[] bArr = new byte[i20];
                aVar.l(i16 * 8, bArr, 0, i20);
                byte[] o10 = o(bArr, iArr2[0]);
                arrayList.add(new a(bArr, o10));
                i17 = Math.max(i17, i20);
                i18 = Math.max(i18, o10.length);
                i16 += iArr[0];
            }
            if (i14 == i16) {
                jh.a aVar2 = new jh.a();
                for (int i21 = 0; i21 < i17; i21++) {
                    for (a a10 : arrayList) {
                        byte[] a11 = a10.a();
                        if (i21 < a11.length) {
                            aVar2.c(a11[i21], 8);
                        }
                    }
                }
                for (int i22 = 0; i22 < i18; i22++) {
                    for (a b10 : arrayList) {
                        byte[] b11 = b10.b();
                        if (i22 < b11.length) {
                            aVar2.c(b11[i22], 8);
                        }
                    }
                }
                if (i13 == aVar2.j()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i13 + " and " + aVar2.j() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static boolean s(String str) {
        byte[] bytes = str.getBytes(f.f23593b);
        int length = bytes.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10 += 2) {
            byte b10 = bytes[i10] & 255;
            if ((b10 < 129 || b10 > 159) && (b10 < 224 || b10 > 235)) {
                return false;
            }
        }
        return true;
    }

    private static rh.a t(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, jh.a aVar, jh.a aVar2) throws WriterException {
        return m(i(mode, aVar, aVar2, m(i(mode, aVar, aVar2, rh.a.e(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    static void u(int i10, jh.a aVar) throws WriterException {
        int i11;
        int i12 = i10 * 8;
        if (aVar.i() <= i12) {
            for (int i13 = 0; i13 < 4 && aVar.i() < i12; i13++) {
                aVar.a(false);
            }
            int i14 = aVar.i() & 7;
            if (i14 > 0) {
                while (i14 < 8) {
                    aVar.a(false);
                    i14++;
                }
            }
            int j10 = i10 - aVar.j();
            for (int i15 = 0; i15 < j10; i15++) {
                if ((i15 & 1) == 0) {
                    i11 = 236;
                } else {
                    i11 = 17;
                }
                aVar.c(i11, 8);
            }
            if (aVar.i() != i12) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.i() + " > " + i12);
    }

    static boolean v(int i10, rh.a aVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (aVar.d() - aVar.c(errorCorrectionLevel).d() >= (i10 + 7) / 8) {
            return true;
        }
        return false;
    }
}
