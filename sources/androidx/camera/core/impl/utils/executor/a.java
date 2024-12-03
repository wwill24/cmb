package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class a {
    @NonNull
    public static Executor a() {
        return b.a();
    }

    @NonNull
    public static Executor b() {
        return d.a();
    }

    @NonNull
    public static Executor c() {
        return e.a();
    }

    @NonNull
    public static ScheduledExecutorService d() {
        return f.a();
    }

    @NonNull
    public static ScheduledExecutorService e(@NonNull Handler handler) {
        return new c(handler);
    }

    @NonNull
    public static Executor f(@NonNull Executor executor) {
        return new SequentialExecutor(executor);
    }
}
