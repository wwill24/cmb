package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jh.a;
import net.bytebuddy.jar.asm.Opcodes;
import sh.b;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f22153a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f22154b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f22155c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, Opcodes.IXOR, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, Opcodes.L2D, -1}, new int[]{6, 30, 58, 86, 114, Opcodes.D2I, -1}, new int[]{6, 34, 62, 90, 118, Opcodes.I2C, -1}, new int[]{6, 30, 54, 78, 102, 126, Opcodes.FCMPG}, new int[]{6, 24, 50, 76, 102, 128, Opcodes.IFNE}, new int[]{6, 28, 54, 80, 106, Opcodes.IINC, Opcodes.IFLE}, new int[]{6, 32, 58, 84, 110, 136, Opcodes.IF_ICMPGE}, new int[]{6, 26, 54, 82, 110, Opcodes.L2D, Opcodes.IF_ACMPNE}, new int[]{6, 30, 58, 86, 114, Opcodes.D2I, Opcodes.TABLESWITCH}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f22156d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(a aVar, ErrorCorrectionLevel errorCorrectionLevel, rh.a aVar2, int i10, sh.a aVar3) throws WriterException {
        c(aVar3);
        d(aVar2, aVar3);
        l(errorCorrectionLevel, i10, aVar3);
        s(aVar2, aVar3);
        f(aVar, i10, aVar3);
    }

    static int b(int i10, int i11) {
        if (i11 != 0) {
            int n10 = n(i11);
            int i12 = i10 << (n10 - 1);
            while (n(i12) >= n10) {
                i12 ^= i11 << (n(i12) - n10);
            }
            return i12;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void c(sh.a aVar) {
        aVar.a((byte) -1);
    }

    static void d(rh.a aVar, sh.a aVar2) throws WriterException {
        j(aVar2);
        e(aVar2);
        r(aVar, aVar2);
        k(aVar2);
    }

    private static void e(sh.a aVar) throws WriterException {
        if (aVar.b(8, aVar.d() - 8) != 0) {
            aVar.f(8, aVar.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    static void f(a aVar, int i10, sh.a aVar2) throws WriterException {
        boolean z10;
        int e10 = aVar2.e() - 1;
        int d10 = aVar2.d() - 1;
        int i11 = -1;
        int i12 = 0;
        while (e10 > 0) {
            if (e10 == 6) {
                e10--;
            }
            while (d10 >= 0 && d10 < aVar2.d()) {
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = e10 - i13;
                    if (o(aVar2.b(i14, d10))) {
                        if (i12 < aVar.i()) {
                            z10 = aVar.h(i12);
                            i12++;
                        } else {
                            z10 = false;
                        }
                        if (i10 != -1 && c.f(i10, i14, d10)) {
                            z10 = !z10;
                        }
                        aVar2.g(i14, d10, z10);
                    }
                }
                d10 += i11;
            }
            i11 = -i11;
            d10 += i11;
            e10 -= 2;
        }
        if (i12 != aVar.i()) {
            throw new WriterException("Not all bits consumed: " + i12 + '/' + aVar.i());
        }
    }

    private static void g(int i10, int i11, sh.a aVar) throws WriterException {
        int i12 = 0;
        while (i12 < 8) {
            int i13 = i10 + i12;
            if (o(aVar.b(i13, i11))) {
                aVar.f(i13, i11, 0);
                i12++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void h(int i10, int i11, sh.a aVar) {
        for (int i12 = 0; i12 < 5; i12++) {
            int[] iArr = f22154b[i12];
            for (int i13 = 0; i13 < 5; i13++) {
                aVar.f(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    private static void i(int i10, int i11, sh.a aVar) {
        for (int i12 = 0; i12 < 7; i12++) {
            int[] iArr = f22153a[i12];
            for (int i13 = 0; i13 < 7; i13++) {
                aVar.f(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    private static void j(sh.a aVar) throws WriterException {
        int length = f22153a[0].length;
        i(0, 0, aVar);
        i(aVar.e() - length, 0, aVar);
        i(0, aVar.e() - length, aVar);
        g(0, 7, aVar);
        g(aVar.e() - 8, 7, aVar);
        g(0, aVar.e() - 8, aVar);
        m(7, 0, aVar);
        m((aVar.d() - 7) - 1, 0, aVar);
        m(7, aVar.d() - 7, aVar);
    }

    private static void k(sh.a aVar) {
        int i10 = 8;
        while (i10 < aVar.e() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (o(aVar.b(i10, 6))) {
                aVar.f(i10, 6, i12);
            }
            if (o(aVar.b(6, i10))) {
                aVar.f(6, i10, i12);
            }
            i10 = i11;
        }
    }

    static void l(ErrorCorrectionLevel errorCorrectionLevel, int i10, sh.a aVar) throws WriterException {
        int i11;
        a aVar2 = new a();
        p(errorCorrectionLevel, i10, aVar2);
        for (int i12 = 0; i12 < aVar2.i(); i12++) {
            boolean h10 = aVar2.h((aVar2.i() - 1) - i12);
            int[] iArr = f22156d[i12];
            aVar.g(iArr[0], iArr[1], h10);
            int i13 = 8;
            if (i12 < 8) {
                i11 = 8;
                i13 = (aVar.e() - i12) - 1;
            } else {
                i11 = (aVar.d() - 7) + (i12 - 8);
            }
            aVar.g(i13, i11, h10);
        }
    }

    private static void m(int i10, int i11, sh.a aVar) throws WriterException {
        int i12 = 0;
        while (i12 < 7) {
            int i13 = i11 + i12;
            if (o(aVar.b(i10, i13))) {
                aVar.f(i10, i13, 0);
                i12++;
            } else {
                throw new WriterException();
            }
        }
    }

    static int n(int i10) {
        return 32 - Integer.numberOfLeadingZeros(i10);
    }

    private static boolean o(int i10) {
        return i10 == -1;
    }

    static void p(ErrorCorrectionLevel errorCorrectionLevel, int i10, a aVar) throws WriterException {
        if (b.b(i10)) {
            int a10 = (errorCorrectionLevel.a() << 3) | i10;
            aVar.c(a10, 5);
            aVar.c(b(a10, 1335), 10);
            a aVar2 = new a();
            aVar2.c(21522, 15);
            aVar.o(aVar2);
            if (aVar.i() != 15) {
                throw new WriterException("should not happen but we got: " + aVar.i());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void q(rh.a aVar, a aVar2) throws WriterException {
        aVar2.c(aVar.f(), 6);
        aVar2.c(b(aVar.f(), 7973), 12);
        if (aVar2.i() != 18) {
            throw new WriterException("should not happen but we got: " + aVar2.i());
        }
    }

    private static void r(rh.a aVar, sh.a aVar2) {
        if (aVar.f() >= 2) {
            int[] iArr = f22155c[aVar.f() - 1];
            for (int i10 : iArr) {
                if (i10 >= 0) {
                    for (int i11 : iArr) {
                        if (i11 >= 0 && o(aVar2.b(i11, i10))) {
                            h(i11 - 2, i10 - 2, aVar2);
                        }
                    }
                }
            }
        }
    }

    static void s(rh.a aVar, sh.a aVar2) throws WriterException {
        if (aVar.f() >= 7) {
            a aVar3 = new a();
            q(aVar, aVar3);
            int i10 = 17;
            for (int i11 = 0; i11 < 6; i11++) {
                for (int i12 = 0; i12 < 3; i12++) {
                    boolean h10 = aVar3.h(i10);
                    i10--;
                    aVar2.g(i11, (aVar2.d() - 11) + i12, h10);
                    aVar2.g((aVar2.d() - 11) + i12, i11, h10);
                }
            }
        }
    }
}
