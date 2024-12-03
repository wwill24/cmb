package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.NonNull;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f4586a = new ThreadLocal<>();

    public static void a(int i10, int i11, int i12, @NonNull double[] dArr) {
        double d10;
        double d11;
        double d12;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d13 = ((double) i10) / 255.0d;
            if (d13 < 0.04045d) {
                d10 = d13 / 12.92d;
            } else {
                d10 = Math.pow((d13 + 0.055d) / 1.055d, 2.4d);
            }
            double d14 = ((double) i11) / 255.0d;
            if (d14 < 0.04045d) {
                d11 = d14 / 12.92d;
            } else {
                d11 = Math.pow((d14 + 0.055d) / 1.055d, 2.4d);
            }
            double d15 = ((double) i12) / 255.0d;
            if (d15 < 0.04045d) {
                d12 = d15 / 12.92d;
            } else {
                d12 = Math.pow((d15 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * d10) + (0.3576d * d11) + (0.1805d * d12)) * 100.0d;
            dArr2[1] = ((0.2126d * d10) + (0.7152d * d11) + (0.0722d * d12)) * 100.0d;
            dArr2[2] = ((d10 * 0.0193d) + (d11 * 0.1192d) + (d12 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int b(double d10, double d11, double d12) {
        double d13;
        double d14;
        double d15;
        double d16 = (((3.2406d * d10) + (-1.5372d * d11)) + (-0.4986d * d12)) / 100.0d;
        double d17 = (((-0.9689d * d10) + (1.8758d * d11)) + (0.0415d * d12)) / 100.0d;
        double d18 = (((0.0557d * d10) + (-0.204d * d11)) + (1.057d * d12)) / 100.0d;
        if (d16 > 0.0031308d) {
            d13 = (Math.pow(d16, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d13 = d16 * 12.92d;
        }
        if (d17 > 0.0031308d) {
            d14 = (Math.pow(d17, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d14 = d17 * 12.92d;
        }
        if (d18 > 0.0031308d) {
            d15 = (Math.pow(d18, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d15 = d18 * 12.92d;
        }
        return Color.rgb(j((int) Math.round(d13 * 255.0d), 0, 255), j((int) Math.round(d14 * 255.0d), 0, 255), j((int) Math.round(d15 * 255.0d), 0, 255));
    }

    public static int c(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb((int) ((((float) Color.alpha(i10)) * f11) + (((float) Color.alpha(i11)) * f10)), (int) ((((float) Color.red(i10)) * f11) + (((float) Color.red(i11)) * f10)), (int) ((((float) Color.green(i10)) * f11) + (((float) Color.green(i11)) * f10)), (int) ((((float) Color.blue(i10)) * f11) + (((float) Color.blue(i11)) * f10)));
    }

    public static double d(int i10, int i11) {
        if (Color.alpha(i11) == 255) {
            if (Color.alpha(i10) < 255) {
                i10 = h(i10, i11);
            }
            double e10 = e(i10) + 0.05d;
            double e11 = e(i11) + 0.05d;
            return Math.max(e10, e11) / Math.min(e10, e11);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i11));
    }

    public static double e(int i10) {
        double[] k10 = k();
        f(i10, k10);
        return k10[1] / 100.0d;
    }

    public static void f(int i10, @NonNull double[] dArr) {
        a(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    private static int g(int i10, int i11) {
        return 255 - (((255 - i11) * (255 - i10)) / 255);
    }

    public static int h(int i10, int i11) {
        int alpha = Color.alpha(i11);
        int alpha2 = Color.alpha(i10);
        int g10 = g(alpha2, alpha);
        return Color.argb(g10, i(Color.red(i10), alpha2, Color.red(i11), alpha, g10), i(Color.green(i10), alpha2, Color.green(i11), alpha, g10), i(Color.blue(i10), alpha2, Color.blue(i11), alpha, g10));
    }

    private static int i(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            return 0;
        }
        return (((i10 * 255) * i11) + ((i12 * i13) * (255 - i11))) / (i14 * 255);
    }

    private static int j(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : Math.min(i10, i12);
    }

    private static double[] k() {
        ThreadLocal<double[]> threadLocal = f4586a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int l(int i10, int i11) {
        if (i11 >= 0 && i11 <= 255) {
            return (i10 & 16777215) | (i11 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
