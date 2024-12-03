package com.google.zxing.datamatrix.encoder;

final class d implements e {
    d() {
    }

    private static void b(char c10, StringBuilder sb2) {
        if (c10 >= ' ' && c10 <= '?') {
            sb2.append(c10);
        } else if (c10 < '@' || c10 > '^') {
            g.e(c10);
        } else {
            sb2.append((char) (c10 - '@'));
        }
    }

    private static String c(CharSequence charSequence) {
        char c10;
        char c11;
        int length = charSequence.length();
        if (length != 0) {
            char c12 = 0;
            char charAt = charSequence.charAt(0);
            if (length >= 2) {
                c10 = charSequence.charAt(1);
            } else {
                c10 = 0;
            }
            if (length >= 3) {
                c11 = charSequence.charAt(2);
            } else {
                c11 = 0;
            }
            if (length >= 4) {
                c12 = charSequence.charAt(3);
            }
            int i10 = (charAt << 18) + (c10 << 12) + (c11 << 6) + c12;
            char c13 = (char) ((i10 >> 8) & 255);
            char c14 = (char) (i10 & 255);
            StringBuilder sb2 = new StringBuilder(3);
            sb2.append((char) ((i10 >> 16) & 255));
            if (length >= 2) {
                sb2.append(c13);
            }
            if (length >= 3) {
                sb2.append(c14);
            }
            return sb2.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void e(f fVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z10 = true;
                if (length == 1) {
                    fVar.p();
                    int a10 = fVar.g().a() - fVar.a();
                    int f10 = fVar.f();
                    if (f10 > a10) {
                        fVar.q(fVar.a() + 1);
                        a10 = fVar.g().a() - fVar.a();
                    }
                    if (f10 <= a10 && a10 <= 2) {
                        fVar.o(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i10 = length - 1;
                    String c10 = c(charSequence);
                    if (!(!fVar.i()) || i10 > 2) {
                        z10 = false;
                    }
                    if (i10 <= 2) {
                        fVar.q(fVar.a() + i10);
                        if (fVar.g().a() - fVar.a() >= 3) {
                            fVar.q(fVar.a() + c10.length());
                            z10 = false;
                        }
                    }
                    if (z10) {
                        fVar.k();
                        fVar.f22076f -= i10;
                    } else {
                        fVar.s(c10);
                    }
                    fVar.o(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            fVar.o(0);
        }
    }

    public void a(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!fVar.i()) {
                break;
            }
            b(fVar.c(), sb2);
            fVar.f22076f++;
            if (sb2.length() >= 4) {
                fVar.s(c(sb2));
                sb2.delete(0, 4);
                if (g.n(fVar.d(), fVar.f22076f, d()) != d()) {
                    fVar.o(0);
                    break;
                }
            }
        }
        sb2.append(31);
        e(fVar, sb2);
    }

    public int d() {
        return 4;
    }
}
