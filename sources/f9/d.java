package f9;

import java.util.concurrent.TimeUnit;

public class d {
    public static long a(int i10) {
        if (i10 >= 0) {
            return TimeUnit.MILLISECONDS.convert((long) Math.pow(2.0d, (double) i10), TimeUnit.SECONDS);
        }
        throw new IllegalArgumentException("numTimesRetriedSoFar must be >= 0");
    }

    public static long b(long j10, int i10) {
        if (i10 >= 0) {
            return j10 + TimeUnit.MILLISECONDS.convert((long) Math.pow(4.0d, (double) i10), TimeUnit.MINUTES);
        }
        throw new IllegalArgumentException("numTimesRetriedSoFar must be >= 0");
    }

    public static boolean c(int i10) {
        return (i10 == 400 || i10 == 401 || i10 == 404) ? false : true;
    }
}
