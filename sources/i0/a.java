package i0;

import android.util.Pair;
import androidx.annotation.NonNull;
import f0.e;
import f0.m;

public final class a {
    @NonNull
    public static Pair<Double, Double> a(double d10, double d11) {
        if (e.a(m.class) != null) {
            d10 = b(d10);
            d11 = b(d11);
        }
        return Pair.create(Double.valueOf(d10), Double.valueOf(d11));
    }

    private static double b(double d10) {
        return d10 >= 0.0d ? d10 : ((d10 * 10000.0d) - 1.0d) / 10000.0d;
    }
}
