package em;

import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static double[][] f23401a = {new double[]{3.240969941904521d, -1.537383177570093d, -0.498610760293d}, new double[]{-0.96924363628087d, 1.87596750150772d, 0.041555057407175d}, new double[]{0.055630079696993d, -0.20397695888897d, 1.056971514242878d}};

    /* renamed from: b  reason: collision with root package name */
    private static double[][] f23402b = {new double[]{0.41239079926595d, 0.35758433938387d, 0.18048078840183d}, new double[]{0.21263900587151d, 0.71516867876775d, 0.072192315360733d}, new double[]{0.019330818715591d, 0.11919477979462d, 0.95053215224966d}};

    /* renamed from: c  reason: collision with root package name */
    private static double f23403c = 1.0d;

    /* renamed from: d  reason: collision with root package name */
    private static double f23404d = 0.19783000664283d;

    /* renamed from: e  reason: collision with root package name */
    private static double f23405e = 0.46831999493879d;

    /* renamed from: f  reason: collision with root package name */
    private static double f23406f = 903.2962962d;

    /* renamed from: g  reason: collision with root package name */
    private static double f23407g = 0.0088564516d;

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final boolean f23408a;

        /* renamed from: b  reason: collision with root package name */
        final double f23409b;

        private b(double d10) {
            this.f23408a = d10 >= 0.0d;
            this.f23409b = d10;
        }
    }

    private static double a(double[] dArr, double[] dArr2) {
        double d10 = 0.0d;
        for (int i10 = 0; i10 < dArr.length; i10++) {
            d10 += dArr[i10] * dArr2[i10];
        }
        return d10;
    }

    private static double b(double d10) {
        return d10 <= 0.0031308d ? d10 * 12.92d : (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d;
    }

    private static List<double[]> c(double d10) {
        ArrayList arrayList = new ArrayList();
        double pow = Math.pow(d10 + 16.0d, 3.0d) / 1560896.0d;
        if (pow <= f23407g) {
            pow = d10 / f23406f;
        }
        int i10 = 0;
        int i11 = 0;
        while (i11 < 3) {
            double[] dArr = f23401a[i11];
            double d11 = dArr[i10];
            double d12 = dArr[1];
            double d13 = dArr[2];
            int i12 = i10;
            while (i12 < 2) {
                double d14 = (((632260.0d * d13) - (126452.0d * d12)) * pow) + ((double) (126452 * i12));
                arrayList.add(new double[]{(((284517.0d * d11) - (94839.0d * d13)) * pow) / d14, ((((((838422.0d * d13) + (769860.0d * d12)) + (731718.0d * d11)) * d10) * pow) - (((double) (i12 * 769860)) * d10)) / d14});
                i12++;
                i11 = i11;
                i10 = 0;
                pow = pow;
            }
            int i13 = i10;
            i11++;
            pow = pow;
        }
        return arrayList;
    }

    public static double[] d(double[] dArr) {
        double d10 = dArr[0];
        double d11 = dArr[1];
        double d12 = dArr[2];
        if (d12 > 99.9999999d) {
            return new double[]{100.0d, 0.0d, d10};
        } else if (d12 < 1.0E-8d) {
            return new double[]{0.0d, 0.0d, d10};
        } else {
            return new double[]{d12, (k(d12, d10) / 100.0d) * d11, d10};
        }
    }

    public static double[] e(double[] dArr) {
        return h(d(dArr));
    }

    private static double f(double d10) {
        if (d10 <= 8.0d) {
            return (f23403c * d10) / f23406f;
        }
        return f23403c * Math.pow((d10 + 16.0d) / 116.0d, 3.0d);
    }

    public static double[] g(double[] dArr) {
        double d10 = dArr[0];
        double d11 = dArr[1];
        double d12 = (dArr[2] / 360.0d) * 2.0d * 3.141592653589793d;
        return new double[]{d10, Math.cos(d12) * d11, Math.sin(d12) * d11};
    }

    public static double[] h(double[] dArr) {
        return l(j(g(dArr)));
    }

    private static b i(double d10, double[] dArr) {
        return new b(dArr[1] / (Math.sin(d10) - (dArr[0] * Math.cos(d10))));
    }

    public static double[] j(double[] dArr) {
        double d10 = dArr[0];
        double d11 = dArr[1];
        double d12 = dArr[2];
        if (d10 == 0.0d) {
            return new double[]{0.0d, 0.0d, 0.0d};
        }
        double d13 = 13.0d * d10;
        double d14 = (d11 / d13) + f23404d;
        double d15 = (d12 / d13) + f23405e;
        double f10 = f(d10);
        double d16 = 9.0d * f10;
        double d17 = 0.0d - ((d16 * d14) / (((d14 - 4.0d) * d15) - (d14 * d15)));
        return new double[]{d17, f10, ((d16 - ((15.0d * d15) * f10)) - (d15 * d17)) / (d15 * 3.0d)};
    }

    private static double k(double d10, double d11) {
        double d12 = (d11 / 360.0d) * 3.141592653589793d * 2.0d;
        double d13 = Double.MAX_VALUE;
        for (double[] i10 : c(d10)) {
            b i11 = i(d12, i10);
            if (i11.f23408a) {
                d13 = Math.min(d13, i11.f23409b);
            }
        }
        return d13;
    }

    public static double[] l(double[] dArr) {
        return new double[]{b(a(f23401a[0], dArr)), b(a(f23401a[1], dArr)), b(a(f23401a[2], dArr))};
    }
}
