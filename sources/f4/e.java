package f4;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f14715a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f14716b = new b();

    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f14717a = new Handler(Looper.getMainLooper());

        a() {
        }

        public void execute(@NonNull Runnable runnable) {
            this.f14717a.post(runnable);
        }
    }

    class b implements Executor {
        b() {
        }

        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f14716b;
    }

    public static Executor b() {
        return f14715a;
    }
}
