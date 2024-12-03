package f4;

import android.annotation.TargetApi;
import android.os.SystemClock;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final double f14718a = (1.0d / Math.pow(10.0d, 6.0d));

    public static double a(long j10) {
        return ((double) (b() - j10)) * f14718a;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
