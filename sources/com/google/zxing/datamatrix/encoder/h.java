package com.google.zxing.datamatrix.encoder;

final class h extends c {
    h() {
    }

    /* access modifiers changed from: package-private */
    public int c(char c10, StringBuilder sb2) {
        if (c10 == ' ') {
            sb2.append(3);
            return 1;
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) ((c10 - '0') + 4));
            return 1;
        } else if (c10 >= 'a' && c10 <= 'z') {
            sb2.append((char) ((c10 - 'a') + 14));
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
        } else if (c10 >= '[' && c10 <= '_') {
            sb2.append(1);
            sb2.append((char) ((c10 - '[') + 22));
            return 2;
        } else if (c10 == '`') {
            sb2.append(2);
            sb2.append(0);
            return 2;
        } else if (c10 <= 'Z') {
            sb2.append(2);
            sb2.append((char) ((c10 - 'A') + 1));
            return 2;
        } else if (c10 <= 127) {
            sb2.append(2);
            sb2.append((char) ((c10 - '{') + 27));
            return 2;
        } else {
            sb2.append("\u0001\u001e");
            return c((char) (c10 - 128), sb2) + 2;
        }
    }

    public int f() {
        return 2;
    }
}
