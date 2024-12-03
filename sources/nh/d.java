package nh;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class d extends l {
    private static void i(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) != 0) {
                i12 = 2;
            }
            iArr[i11] = i12;
        }
    }

    private static String j(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        sb2.append("%V");
                    } else if (charAt == '`') {
                        sb2.append("%W");
                    } else if (!(charAt == '-' || charAt == '.')) {
                        if (charAt <= 26) {
                            sb2.append('$');
                            sb2.append((char) ((charAt - 1) + 65));
                        } else if (charAt < ' ') {
                            sb2.append('%');
                            sb2.append((char) ((charAt - 27) + 65));
                        } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                            sb2.append('/');
                            sb2.append((char) ((charAt - '!') + 65));
                        } else if (charAt <= '9') {
                            sb2.append((char) ((charAt - '0') + 48));
                        } else if (charAt <= '?') {
                            sb2.append('%');
                            sb2.append((char) ((charAt - ';') + 70));
                        } else if (charAt <= 'Z') {
                            sb2.append((char) ((charAt - 'A') + 65));
                        } else if (charAt <= '_') {
                            sb2.append('%');
                            sb2.append((char) ((charAt - '[') + 75));
                        } else if (charAt <= 'z') {
                            sb2.append(SignatureVisitor.EXTENDS);
                            sb2.append((char) ((charAt - 'a') + 65));
                        } else if (charAt <= 127) {
                            sb2.append('%');
                            sb2.append((char) ((charAt - '{') + 80));
                        } else {
                            throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i10) + "'");
                        }
                    }
                }
                sb2.append(charAt);
            } else {
                sb2.append("%U");
            }
        }
        return sb2.toString();
    }

    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 80) {
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i10)) < 0) {
                    str = j(str);
                    length = str.length();
                    if (length > 80) {
                        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                    }
                } else {
                    i10++;
                }
            }
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[((length * 13) + 25)];
            i(Opcodes.LCMP, iArr);
            int b10 = l.b(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int b11 = b10 + l.b(zArr, b10, iArr2, false);
            for (int i11 = 0; i11 < length; i11++) {
                i(c.f23810a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i11))], iArr);
                int b12 = b11 + l.b(zArr, b11, iArr, true);
                b11 = b12 + l.b(zArr, b12, iArr2, false);
            }
            i(Opcodes.LCMP, iArr);
            l.b(zArr, b11, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    /* access modifiers changed from: protected */
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.CODE_39);
    }
}
