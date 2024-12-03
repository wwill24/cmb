package androidx.camera.core.impl.utils;

import android.os.Looper;
import androidx.core.util.h;

public final class p {
    public static void a() {
        h.j(b(), "Not in application's main thread");
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
