package io.sentry.android.core;

import android.os.Debug;
import io.sentry.d0;
import io.sentry.f1;
import io.sentry.x1;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class t implements d0 {
    public void a() {
    }

    public void b(x1 x1Var) {
        x1Var.b(new f1(System.currentTimeMillis(), Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(), Debug.getNativeHeapSize() - Debug.getNativeHeapFreeSize()));
    }
}
