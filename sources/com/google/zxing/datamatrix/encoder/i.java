package com.google.zxing.datamatrix.encoder;

final class i extends c {
    i() {
    }

    public void a(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!fVar.i()) {
                break;
            }
            char c10 = fVar.c();
            fVar.f22076f++;
            c(c10, sb2);
            if (sb2.length() % 3 == 0) {
                c.h(fVar, sb2);
                if (g.n(fVar.d(), fVar.f22076f, f()) != f()) {
                    fVar.o(0);
                    break;
                }
            }
        }
        g(fVar, sb2);
    }

    /* access modifiers changed from: package-private */
    public int c(char c10, StringBuilder sb2) {
        if (c10 == 13) {
            sb2.append(0);
        } else if (c10 == ' ') {
            sb2.append(3);
        } else if (c10 == '*') {
            sb2.append(1);
        } else if (c10 == '>') {
            sb2.append(2);
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
        } else if (c10 < 'A' || c10 > 'Z') {
            g.e(c10);
        } else {
            sb2.append((char) ((c10 - 'A') + 14));
        }
        return 1;
    }

    public int f() {
        return 3;
    }

    /* access modifiers changed from: package-private */
    public void g(f fVar, StringBuilder sb2) {
        fVar.p();
        int a10 = fVar.g().a() - fVar.a();
        fVar.f22076f -= sb2.length();
        if (fVar.f() > 1 || a10 > 1 || fVar.f() != a10) {
            fVar.r(254);
        }
        if (fVar.e() < 0) {
            fVar.o(0);
        }
    }
}
