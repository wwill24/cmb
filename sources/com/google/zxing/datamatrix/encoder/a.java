package com.google.zxing.datamatrix.encoder;

import net.bytebuddy.jar.asm.Opcodes;

final class a implements e {
    a() {
    }

    private static char b(char c10, char c11) {
        if (g.f(c10) && g.f(c11)) {
            return (char) (((c10 - '0') * 10) + (c11 - '0') + Opcodes.IXOR);
        }
        throw new IllegalArgumentException("not digits: " + c10 + c11);
    }

    public void a(f fVar) {
        if (g.a(fVar.d(), fVar.f22076f) >= 2) {
            fVar.r(b(fVar.d().charAt(fVar.f22076f), fVar.d().charAt(fVar.f22076f + 1)));
            fVar.f22076f += 2;
            return;
        }
        char c10 = fVar.c();
        int n10 = g.n(fVar.d(), fVar.f22076f, c());
        if (n10 != c()) {
            if (n10 == 1) {
                fVar.r(230);
                fVar.o(1);
            } else if (n10 == 2) {
                fVar.r(239);
                fVar.o(2);
            } else if (n10 == 3) {
                fVar.r(238);
                fVar.o(3);
            } else if (n10 == 4) {
                fVar.r(240);
                fVar.o(4);
            } else if (n10 == 5) {
                fVar.r(231);
                fVar.o(5);
            } else {
                throw new IllegalStateException("Illegal mode: " + n10);
            }
        } else if (g.g(c10)) {
            fVar.r(235);
            fVar.r((char) ((c10 - 128) + 1));
            fVar.f22076f++;
        } else {
            fVar.r((char) (c10 + 1));
            fVar.f22076f++;
        }
    }

    public int c() {
        return 0;
    }
}
