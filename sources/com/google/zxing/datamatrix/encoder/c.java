package com.google.zxing.datamatrix.encoder;

import org.apache.commons.beanutils.PropertyUtils;

class c implements e {
    c() {
    }

    private int b(f fVar, StringBuilder sb2, StringBuilder sb3, int i10) {
        int length = sb2.length();
        sb2.delete(length - i10, length);
        fVar.f22076f--;
        int c10 = c(fVar.c(), sb3);
        fVar.k();
        return c10;
    }

    private static String e(CharSequence charSequence) {
        int charAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * PropertyUtils.MAPPED_DELIM) + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    static void h(f fVar, StringBuilder sb2) {
        fVar.s(e(sb2));
        sb2.delete(0, 3);
    }

    public void a(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!fVar.i()) {
                break;
            }
            char c10 = fVar.c();
            fVar.f22076f++;
            int c11 = c(c10, sb2);
            int a10 = fVar.a() + ((sb2.length() / 3) * 2);
            fVar.q(a10);
            int a11 = fVar.g().a() - a10;
            if (fVar.i()) {
                if (sb2.length() % 3 == 0 && g.n(fVar.d(), fVar.f22076f, f()) != f()) {
                    fVar.o(0);
                    break;
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && a11 != 2) {
                    c11 = b(fVar, sb2, sb3, c11);
                }
                while (sb2.length() % 3 == 1 && (c11 > 3 || a11 != 1)) {
                    c11 = b(fVar, sb2, sb3, c11);
                }
            }
        }
        g(fVar, sb2);
    }

    /* access modifiers changed from: package-private */
    public int c(char c10, StringBuilder sb2) {
        if (c10 == ' ') {
            sb2.append(3);
            return 1;
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
            return 1;
        } else if (c10 >= 'A' && c10 <= 'Z') {
            sb2.append((char) ((c10 - 'A') + 14));
            return 1;
        } else if (c10 < ' ') {
            sb2.append(0);
            sb2.append(c10);
            return 2;
        } else if (c10 <= '/') {
            sb2.append(1);
            sb2.append((char) (c10 - '!'));
            return 2;
        } else if (c10 <= '@') {
            sb2.append(1);
            sb2.append((char) ((c10 - ':') + 15));
            return 2;
        } else if (c10 <= '_') {
            sb2.append(1);
            sb2.append((char) ((c10 - '[') + 22));
            return 2;
        } else if (c10 <= 127) {
            sb2.append(2);
            sb2.append((char) (c10 - '`'));
            return 2;
        } else {
            sb2.append("\u0001\u001e");
            return c((char) (c10 - 128), sb2) + 2;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = fVar.f22076f;
        int i11 = 0;
        int i12 = 0;
        while (fVar.i()) {
            char c10 = fVar.c();
            fVar.f22076f++;
            i12 = c(c10, sb2);
            if (sb2.length() % 3 == 0) {
                i10 = fVar.f22076f;
                i11 = sb2.length();
            }
        }
        if (i11 != sb2.length()) {
            int a10 = fVar.a() + ((sb2.length() / 3) * 2) + 1;
            fVar.q(a10);
            int a11 = fVar.g().a() - a10;
            int length = sb2.length() % 3;
            if ((length == 2 && a11 != 2) || (length == 1 && (i12 > 3 || a11 != 1))) {
                sb2.setLength(i11);
                fVar.f22076f = i10;
            }
        }
        if (sb2.length() > 0) {
            fVar.r(230);
        }
        g(fVar, sb2);
    }

    public int f() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void g(f fVar, StringBuilder sb2) {
        int length = sb2.length() % 3;
        int a10 = fVar.a() + ((sb2.length() / 3) * 2);
        fVar.q(a10);
        int a11 = fVar.g().a() - a10;
        if (length == 2) {
            sb2.append(0);
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (fVar.i()) {
                fVar.r(254);
            }
        } else if (a11 == 1 && length == 1) {
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (fVar.i()) {
                fVar.r(254);
            }
            fVar.f22076f--;
        } else if (length == 0) {
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (a11 > 0 || fVar.i()) {
                fVar.r(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        fVar.o(0);
    }
}
