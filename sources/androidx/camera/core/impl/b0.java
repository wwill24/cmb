package androidx.camera.core.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public abstract class b0 {
    @NonNull
    public static b0 a(@NonNull Executor executor, @NonNull Handler handler) {
        return new d(executor, handler);
    }

    @NonNull
    public abstract Executor b();

    @NonNull
    public abstract Handler c();
}
