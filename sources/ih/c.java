package ih;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import jh.a;
import jh.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f23558a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(a aVar, int i10, int i11) {
        int i12;
        int[] iArr = new int[i11];
        int i13 = aVar.i() / i10;
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                if (aVar.h((i14 * i10) + i16)) {
                    i12 = 1 << ((i10 - i16) - 1);
                } else {
                    i12 = 0;
                }
                i15 |= i12;
            }
            iArr[i14] = i15;
        }
        return iArr;
    }

    private static void b(b bVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 > i15) {
                    break;
                }
                bVar.i(i14, i13);
                bVar.i(i14, i15);
                bVar.i(i13, i14);
                bVar.i(i15, i14);
                i14++;
            }
        }
        int i16 = i10 - i11;
        bVar.i(i16, i16);
        int i17 = i16 + 1;
        bVar.i(i17, i16);
        bVar.i(i16, i17);
        int i18 = i10 + i11;
        bVar.i(i18, i16);
        bVar.i(i18, i17);
        bVar.i(i18, i18 - 1);
    }

    private static void c(b bVar, boolean z10, int i10, a aVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (aVar.h(i12)) {
                    bVar.i(i13, i11 - 5);
                }
                if (aVar.h(i12 + 7)) {
                    bVar.i(i11 + 5, i13);
                }
                if (aVar.h(20 - i12)) {
                    bVar.i(i13, i11 + 5);
                }
                if (aVar.h(27 - i12)) {
                    bVar.i(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (aVar.h(i12)) {
                bVar.i(i14, i11 - 7);
            }
            if (aVar.h(i12 + 10)) {
                bVar.i(i11 + 7, i14);
            }
            if (aVar.h(29 - i12)) {
                bVar.i(i14, i11 + 7);
            }
            if (aVar.h(39 - i12)) {
                bVar.i(i11 - 7, i14);
            }
            i12++;
        }
    }

    public static a d(String str, int i10, int i11, Charset charset) {
        Charset charset2;
        if (charset != null) {
            charset2 = charset;
        } else {
            charset2 = StandardCharsets.ISO_8859_1;
        }
        return e(str.getBytes(charset2), i10, i11, charset);
    }

    public static a e(byte[] bArr, int i10, int i11, Charset charset) {
        int i12;
        int i13;
        int i14;
        boolean z10;
        a aVar;
        int i15;
        a a10 = new d(bArr, charset).a();
        int i16 = ((a10.i() * i10) / 100) + 11;
        int i17 = a10.i() + i16;
        int i18 = 32;
        int i19 = 4;
        boolean z11 = 0;
        boolean z12 = true;
        if (i11 != 0) {
            z10 = i11 < 0;
            i13 = Math.abs(i11);
            if (z10) {
                i18 = 4;
            }
            if (i13 <= i18) {
                i14 = j(i13, z10);
                i12 = f23558a[i13];
                int i20 = i14 - (i14 % i12);
                aVar = i(a10, i12);
                if (aVar.i() + i16 > i20) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z10 && aVar.i() > i12 * 64) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i11)}));
            }
        } else {
            a aVar2 = null;
            int i21 = 0;
            int i22 = 0;
            while (i21 <= 32) {
                boolean z13 = i21 <= 3 ? z12 : z11;
                int i23 = z13 ? i21 + 1 : i21;
                int j10 = j(i23, z13);
                if (i17 <= j10) {
                    if (aVar2 == null || i22 != f23558a[i23]) {
                        int i24 = f23558a[i23];
                        i22 = i24;
                        aVar2 = i(a10, i24);
                    }
                    int i25 = j10 - (j10 % i22);
                    if ((!z13 || aVar2.i() <= i22 * 64) && aVar2.i() + i16 <= i25) {
                        aVar = aVar2;
                        i12 = i22;
                        z10 = z13;
                        i13 = i23;
                        i14 = j10;
                    }
                }
                i21++;
                z12 = z12;
                i19 = 4;
                z11 = 0;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        a f10 = f(aVar, i14, i12);
        int i26 = aVar.i() / i12;
        a g10 = g(z10, i13, i26);
        int i27 = (z10 ? 11 : 14) + (i13 * 4);
        int[] iArr = new int[i27];
        int i28 = 2;
        if (z10) {
            for (int i29 = z11; i29 < i27; i29++) {
                iArr[i29] = i29;
            }
            i15 = i27;
        } else {
            int i30 = i27 / 2;
            i15 = i27 + 1 + (((i30 - 1) / 15) * 2);
            int i31 = i15 / 2;
            for (int i32 = z11; i32 < i30; i32++) {
                int i33 = (i32 / 15) + i32;
                iArr[(i30 - i32) - 1] = (i31 - i33) - 1;
                iArr[i30 + i32] = i33 + i31 + (z12 ? 1 : 0);
            }
        }
        b bVar = new b(i15);
        int i34 = z11;
        int i35 = i34;
        while (i34 < i13) {
            int i36 = ((i13 - i34) * i19) + (z10 ? 9 : 12);
            int i37 = z11;
            while (i37 < i36) {
                int i38 = i37 * 2;
                while (z11 < i28) {
                    if (f10.h(i35 + i38 + z11)) {
                        int i39 = i34 * 2;
                        bVar.i(iArr[i39 + z11], iArr[i39 + i37]);
                    }
                    if (f10.h((i36 * 2) + i35 + i38 + z11)) {
                        int i40 = i34 * 2;
                        bVar.i(iArr[i40 + i37], iArr[((i27 - 1) - i40) - z11]);
                    }
                    if (f10.h((i36 * 4) + i35 + i38 + z11)) {
                        int i41 = (i27 - 1) - (i34 * 2);
                        bVar.i(iArr[i41 - z11], iArr[i41 - i37]);
                    }
                    if (f10.h((i36 * 6) + i35 + i38 + z11)) {
                        int i42 = i34 * 2;
                        bVar.i(iArr[((i27 - 1) - i42) - i37], iArr[i42 + z11]);
                    }
                    z11++;
                    i28 = 2;
                }
                i37++;
                z11 = 0;
                i28 = 2;
            }
            i35 += i36 * 8;
            i34++;
            i19 = 4;
            z11 = 0;
            i28 = 2;
        }
        c(bVar, z10, i15, g10);
        if (z10) {
            b(bVar, i15 / 2, 5);
        } else {
            int i43 = i15 / 2;
            b(bVar, i43, 7);
            int i44 = 0;
            int i45 = 0;
            while (i45 < (i27 / 2) - 1) {
                for (int i46 = i43 & 1; i46 < i15; i46 += 2) {
                    int i47 = i43 - i44;
                    bVar.i(i47, i46);
                    int i48 = i43 + i44;
                    bVar.i(i48, i46);
                    bVar.i(i46, i47);
                    bVar.i(i46, i48);
                }
                i45 += 15;
                i44 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.c(z10);
        aVar3.f(i15);
        aVar3.d(i13);
        aVar3.b(i26);
        aVar3.e(bVar);
        return aVar3;
    }

    private static a f(a aVar, int i10, int i11) {
        kh.c cVar = new kh.c(h(i11));
        int i12 = i10 / i11;
        int[] a10 = a(aVar, i11, i12);
        cVar.b(a10, i12 - (aVar.i() / i11));
        a aVar2 = new a();
        aVar2.c(0, i10 % i11);
        for (int c10 : a10) {
            aVar2.c(c10, i11);
        }
        return aVar2;
    }

    static a g(boolean z10, int i10, int i11) {
        a aVar = new a();
        if (z10) {
            aVar.c(i10 - 1, 2);
            aVar.c(i11 - 1, 6);
            return f(aVar, 28, 4);
        }
        aVar.c(i10 - 1, 5);
        aVar.c(i11 - 1, 11);
        return f(aVar, 40, 4);
    }

    private static kh.a h(int i10) {
        if (i10 == 4) {
            return kh.a.f23611k;
        }
        if (i10 == 6) {
            return kh.a.f23610j;
        }
        if (i10 == 8) {
            return kh.a.f23614n;
        }
        if (i10 == 10) {
            return kh.a.f23609i;
        }
        if (i10 == 12) {
            return kh.a.f23608h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i10);
    }

    static a i(a aVar, int i10) {
        a aVar2 = new a();
        int i11 = aVar.i();
        int i12 = (1 << i10) - 2;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = 0;
            for (int i15 = 0; i15 < i10; i15++) {
                int i16 = i13 + i15;
                if (i16 >= i11 || aVar.h(i16)) {
                    i14 |= 1 << ((i10 - 1) - i15);
                }
            }
            int i17 = i14 & i12;
            if (i17 == i12) {
                aVar2.c(i17, i10);
            } else if (i17 == 0) {
                aVar2.c(i14 | 1, i10);
            } else {
                aVar2.c(i14, i10);
                i13 += i10;
            }
            i13--;
            i13 += i10;
        }
        return aVar2;
    }

    private static int j(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }
}
