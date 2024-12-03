package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.os.i;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Handler f2686a;

    private n() {
    }

    @NonNull
    public static Handler a() {
        if (f2686a != null) {
            return f2686a;
        }
        synchronized (n.class) {
            if (f2686a == null) {
                f2686a = i.a(Looper.getMainLooper());
            }
        }
        return f2686a;
    }
}
