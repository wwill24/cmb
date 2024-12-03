package i2;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import h2.q;
import java.util.concurrent.Executor;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final q f15454a;

    /* renamed from: b  reason: collision with root package name */
    final Handler f15455b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Executor f15456c = new a();

    class a implements Executor {
        a() {
        }

        public void execute(@NonNull Runnable runnable) {
            c.this.f15455b.post(runnable);
        }
    }

    public c(@NonNull Executor executor) {
        this.f15454a = new q(executor);
    }

    @NonNull
    public Executor a() {
        return this.f15456c;
    }

    @NonNull
    /* renamed from: d */
    public q b() {
        return this.f15454a;
    }
}
