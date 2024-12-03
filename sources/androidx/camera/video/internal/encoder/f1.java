package androidx.camera.video.internal.encoder;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

public class f1 implements g1 {
    public long a() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }

    public long b() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime());
    }
}
