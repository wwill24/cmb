package androidx.core.os;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class g {

    private static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f4635a;

        a(@NonNull Handler handler) {
            this.f4635a = (Handler) h.g(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (!this.f4635a.post((Runnable) h.g(runnable))) {
                throw new RejectedExecutionException(this.f4635a + " is shutting down");
            }
        }
    }

    @NonNull
    public static Executor a(@NonNull Handler handler) {
        return new a(handler);
    }
}
