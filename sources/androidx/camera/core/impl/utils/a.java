package androidx.camera.core.impl.utils;

import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.Comparator;
import z.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Rational f2612a = new Rational(4, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final Rational f2613b = new Rational(3, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final Rational f2614c = new Rational(16, 9);

    /* renamed from: d  reason: collision with root package name */
    public static final Rational f2615d = new Rational(9, 16);

    /* renamed from: androidx.camera.core.impl.utils.a$a  reason: collision with other inner class name */
    public static final class C0018a implements Comparator<Rational> {

        /* renamed from: a  reason: collision with root package name */
        private Rational f2616a;

        public C0018a(@NonNull Rational rational) {
            this.f2616a = rational;
        }

        /* renamed from: a */
        public int compare(Rational rational, Rational rational2) {
            if (rational.equals(rational2)) {
                return 0;
            }
            return (int) Math.signum(Float.valueOf(Math.abs(rational.floatValue() - this.f2616a.floatValue())).floatValue() - Float.valueOf(Math.abs(rational2.floatValue() - this.f2616a.floatValue())).floatValue());
        }
    }

    public static boolean a(@NonNull Size size, Rational rational) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        if (c.a(size) >= c.a(c.f18784b)) {
            return b(size, rational);
        }
        return false;
    }

    private static boolean b(@NonNull Size size, @NonNull Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i10 = width % 16;
        if (i10 == 0 && height % 16 == 0) {
            if (c(Math.max(0, height - 16), width, rational) || c(Math.max(0, width - 16), height, rational2)) {
                return true;
            }
            return false;
        } else if (i10 == 0) {
            return c(height, width, rational);
        } else {
            if (height % 16 == 0) {
                return c(width, height, rational2);
            }
            return false;
        }
    }

    private static boolean c(int i10, int i11, Rational rational) {
        boolean z10;
        if (i11 % 16 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.a(z10);
        double numerator = ((double) (i10 * rational.getNumerator())) / ((double) rational.getDenominator());
        if (numerator <= ((double) Math.max(0, i11 - 16)) || numerator >= ((double) (i11 + 16))) {
            return false;
        }
        return true;
    }
}
