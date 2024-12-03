package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.os.i;
import b2.k;

public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f7485a = i.a(Looper.getMainLooper());

    public void a(@NonNull Runnable runnable) {
        this.f7485a.removeCallbacks(runnable);
    }

    public void b(long j10, @NonNull Runnable runnable) {
        this.f7485a.postDelayed(runnable, j10);
    }
}
