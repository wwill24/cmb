package me;

import android.os.SystemClock;
import androidx.annotation.NonNull;

public class i implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final i f41262a = new i();

    private i() {
    }

    @NonNull
    public static f c() {
        return f41262a;
    }

    public final long a() {
        return System.nanoTime();
    }

    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
