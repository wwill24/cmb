package com.google.zxing.datamatrix.encoder;

import com.google.android.gms.common.api.a;
import gh.a;
import java.util.Arrays;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public final class g {
    public static int a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = i10;
        while (i11 < length && f(charSequence.charAt(i11))) {
            i11++;
        }
        return i11 - i10;
    }

    public static String b(String str, SymbolShapeHint symbolShapeHint, a aVar, a aVar2, boolean z10) {
        c cVar = new c();
        int i10 = 0;
        e[] eVarArr = {new a(), cVar, new h(), new i(), new d(), new b()};
        f fVar = new f(str);
        fVar.n(symbolShapeHint);
        fVar.l(aVar, aVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            fVar.r(236);
            fVar.m(2);
            fVar.f22076f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            fVar.r(237);
            fVar.m(2);
            fVar.f22076f += 7;
        }
        if (z10) {
            cVar.d(fVar);
            i10 = fVar.e();
            fVar.j();
        }
        while (fVar.i()) {
            eVarArr[i10].a(fVar);
            if (fVar.e() >= 0) {
                i10 = fVar.e();
                fVar.j();
            }
        }
        int a10 = fVar.a();
        fVar.p();
        int a11 = fVar.g().a();
        if (!(a10 >= a11 || i10 == 0 || i10 == 5 || i10 == 4)) {
            fVar.r(254);
        }
        StringBuilder b10 = fVar.b();
        if (b10.length() < a11) {
            b10.append(129);
        }
        while (b10.length() < a11) {
            b10.append(r(b10.length() + 1));
        }
        return fVar.b().toString();
    }

    private static int c(float[] fArr, int[] iArr, int i10, byte[] bArr) {
        for (int i11 = 0; i11 < 6; i11++) {
            int ceil = (int) Math.ceil((double) fArr[i11]);
            iArr[i11] = ceil;
            if (i10 > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i10 = ceil;
            }
            if (i10 == ceil) {
                bArr[i11] = (byte) (bArr[i11] + 1);
            }
        }
        return i10;
    }

    private static int d(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 += bArr[i11];
        }
        return i10;
    }

    static void e(char c10) {
        String hexString = Integer.toHexString(c10);
        throw new IllegalArgumentException("Illegal character: " + c10 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + PropertyUtils.MAPPED_DELIM2);
    }

    static boolean f(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    static boolean g(char c10) {
        return c10 >= 128 && c10 <= 255;
    }

    static boolean h(char c10) {
        return c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'Z');
    }

    static boolean i(char c10) {
        return c10 >= ' ' && c10 <= '^';
    }

    static boolean j(char c10) {
        return c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'a' && c10 <= 'z');
    }

    static boolean k(char c10) {
        return m(c10) || c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'Z');
    }

    private static boolean l(char c10) {
        return false;
    }

    private static boolean m(char c10) {
        return c10 == 13 || c10 == '*' || c10 == '>';
    }

    static int n(CharSequence charSequence, int i10, int i11) {
        int o10 = o(charSequence, i10, i11);
        if (i11 == 3 && o10 == 3) {
            int min = Math.min(i10 + 3, charSequence.length());
            while (i10 < min) {
                if (!k(charSequence.charAt(i10))) {
                    return 0;
                }
                i10++;
            }
        } else if (i11 == 4 && o10 == 4) {
            int min2 = Math.min(i10 + 4, charSequence.length());
            while (i10 < min2) {
                if (!i(charSequence.charAt(i10))) {
                    return 0;
                }
                i10++;
            }
        }
        return o10;
    }

    static int o(CharSequence charSequence, int i10, int i11) {
        float[] fArr;
        char c10;
        CharSequence charSequence2 = charSequence;
        int i12 = i10;
        if (i12 >= charSequence.length()) {
            return i11;
        }
        if (i11 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i11] = 0.0f;
        }
        byte[] bArr = new byte[6];
        int[] iArr = new int[6];
        int i13 = 0;
        while (true) {
            int i14 = i12 + i13;
            if (i14 == charSequence.length()) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                int c11 = c(fArr, iArr, a.e.API_PRIORITY_OTHER, bArr);
                int d10 = d(bArr);
                if (iArr[0] == c11) {
                    return 0;
                }
                if (d10 == 1) {
                    if (bArr[5] > 0) {
                        return 5;
                    }
                    if (bArr[4] > 0) {
                        return 4;
                    }
                    if (bArr[2] > 0) {
                        return 2;
                    }
                    if (bArr[3] > 0) {
                        return 3;
                    }
                }
                return 1;
            }
            char charAt = charSequence2.charAt(i14);
            i13++;
            if (f(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (g(charAt)) {
                float ceil = (float) Math.ceil((double) fArr[0]);
                fArr[0] = ceil;
                fArr[0] = ceil + 2.0f;
            } else {
                float ceil2 = (float) Math.ceil((double) fArr[0]);
                fArr[0] = ceil2;
                fArr[0] = ceil2 + 1.0f;
            }
            if (h(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (j(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (k(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (i(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (g(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (l(charAt)) {
                c10 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c10 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i13 >= 4) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                c(fArr, iArr, a.e.API_PRIORITY_OTHER, bArr);
                if (iArr[0] < q(iArr[c10], iArr[1], iArr[2], iArr[3], iArr[4])) {
                    return 0;
                }
                int i15 = iArr[c10];
                if (i15 < iArr[0] || i15 + 1 < p(iArr[1], iArr[2], iArr[3], iArr[4])) {
                    return 5;
                }
                if (iArr[4] + 1 < q(iArr[5], iArr[1], iArr[2], iArr[3], iArr[0])) {
                    return 4;
                }
                if (iArr[2] + 1 < q(iArr[5], iArr[1], iArr[4], iArr[3], iArr[0])) {
                    return 2;
                }
                if (iArr[3] + 1 < q(iArr[5], iArr[1], iArr[4], iArr[2], iArr[0])) {
                    return 3;
                }
                if (iArr[1] + 1 >= p(iArr[0], iArr[5], iArr[4], iArr[2])) {
                    continue;
                } else {
                    int i16 = iArr[1];
                    int i17 = iArr[3];
                    if (i16 < i17) {
                        return 1;
                    }
                    if (i16 == i17) {
                        for (int i18 = i12 + i13 + 1; i18 < charSequence.length(); i18++) {
                            char charAt2 = charSequence2.charAt(i18);
                            if (m(charAt2)) {
                                return 3;
                            }
                            if (!k(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static int p(int i10, int i11, int i12, int i13) {
        return Math.min(i10, Math.min(i11, Math.min(i12, i13)));
    }

    private static int q(int i10, int i11, int i12, int i13, int i14) {
        return Math.min(p(i10, i11, i12, i13), i14);
    }

    private static char r(int i10) {
        int i11 = ((i10 * Opcodes.FCMPL) % 253) + 1 + 129;
        if (i11 > 254) {
            i11 -= 254;
        }
        return (char) i11;
    }
}
