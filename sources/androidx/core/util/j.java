package androidx.core.util;

import java.io.PrintWriter;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.cli.HelpFormatter;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4740a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static char[] f4741b = new char[24];

    private static int a(int i10, int i11, boolean z10, int i12) {
        if (i10 > 99 || (z10 && i12 >= 3)) {
            return i11 + 3;
        }
        if (i10 > 9 || (z10 && i12 >= 2)) {
            return i11 + 2;
        }
        if (z10 || i10 > 0) {
            return i11 + 1;
        }
        return 0;
    }

    public static void b(long j10, long j11, PrintWriter printWriter) {
        if (j10 == 0) {
            printWriter.print(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        } else {
            d(j10 - j11, printWriter, 0);
        }
    }

    public static void c(long j10, PrintWriter printWriter) {
        d(j10, printWriter, 0);
    }

    public static void d(long j10, PrintWriter printWriter, int i10) {
        synchronized (f4740a) {
            printWriter.print(new String(f4741b, 0, e(j10, i10)));
        }
    }

    private static int e(long j10, int i10) {
        char c10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z10;
        boolean z11;
        int i16;
        boolean z12;
        int i17;
        boolean z13;
        int i18;
        int i19;
        boolean z14;
        boolean z15;
        boolean z16;
        int i20;
        long j11 = j10;
        int i21 = i10;
        if (f4741b.length < i21) {
            f4741b = new char[i21];
        }
        char[] cArr = f4741b;
        int i22 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i22 == 0) {
            int i23 = i21 - 1;
            while (i23 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i22 > 0) {
            c10 = SignatureVisitor.EXTENDS;
        } else {
            c10 = SignatureVisitor.SUPER;
            j11 = -j11;
        }
        int i24 = (int) (j11 % 1000);
        int floor = (int) Math.floor((double) (j11 / 1000));
        if (floor > 86400) {
            i11 = floor / 86400;
            floor -= 86400 * i11;
        } else {
            i11 = 0;
        }
        if (floor > 3600) {
            i12 = floor / 3600;
            floor -= i12 * 3600;
        } else {
            i12 = 0;
        }
        if (floor > 60) {
            int i25 = floor / 60;
            i13 = floor - (i25 * 60);
            i14 = i25;
        } else {
            i13 = floor;
            i14 = 0;
        }
        if (i21 != 0) {
            int a10 = a(i11, 1, false, 0);
            if (a10 > 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            int a11 = a10 + a(i12, 1, z14, 2);
            if (a11 > 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            int a12 = a11 + a(i14, 1, z15, 2);
            if (a12 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int a13 = a12 + a(i13, 1, z16, 2);
            if (a13 > 0) {
                i20 = 3;
            } else {
                i20 = 0;
            }
            i15 = 0;
            for (int a14 = a13 + a(i24, 2, true, i20) + 1; a14 < i21; a14++) {
                cArr[i15] = ' ';
                i15++;
            }
        } else {
            i15 = 0;
        }
        cArr[i15] = c10;
        int i26 = i15 + 1;
        if (i21 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i27 = i26;
        int f10 = f(cArr, i11, Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, i26, false, 0);
        if (f10 != i27) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        int f11 = f(cArr, i12, 'h', f10, z11, i16);
        if (f11 != i27) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z10) {
            i17 = 2;
        } else {
            i17 = 0;
        }
        int f12 = f(cArr, i14, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, f11, z12, i17);
        if (f12 != i27) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z10) {
            i18 = 2;
        } else {
            i18 = 0;
        }
        int f13 = f(cArr, i13, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, f12, z13, i18);
        if (!z10 || f13 == i27) {
            i19 = 0;
        } else {
            i19 = 3;
        }
        int f14 = f(cArr, i24, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, f13, true, i19);
        cArr[f14] = Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
        return f14 + 1;
    }

    private static int f(char[] cArr, int i10, char c10, int i11, boolean z10, int i12) {
        int i13;
        if (!z10 && i10 <= 0) {
            return i11;
        }
        if ((!z10 || i12 < 3) && i10 <= 99) {
            i13 = i11;
        } else {
            int i14 = i10 / 100;
            cArr[i11] = (char) (i14 + 48);
            i13 = i11 + 1;
            i10 -= i14 * 100;
        }
        if ((z10 && i12 >= 2) || i10 > 9 || i11 != i13) {
            int i15 = i10 / 10;
            cArr[i13] = (char) (i15 + 48);
            i13++;
            i10 -= i15 * 10;
        }
        cArr[i13] = (char) (i10 + 48);
        int i16 = i13 + 1;
        cArr[i16] = c10;
        return i16 + 1;
    }
}
