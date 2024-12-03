package h2;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class q implements i2.a {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<a> f15292a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f15293b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f15294c;

    /* renamed from: d  reason: collision with root package name */
    final Object f15295d = new Object();

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final q f15296a;

        /* renamed from: b  reason: collision with root package name */
        final Runnable f15297b;

        a(@NonNull q qVar, @NonNull Runnable runnable) {
            this.f15296a = qVar;
            this.f15297b = runnable;
        }

        public void run() {
            try {
                this.f15297b.run();
                synchronized (this.f15296a.f15295d) {
                    this.f15296a.a();
                }
            } catch (Throwable th2) {
                synchronized (this.f15296a.f15295d) {
                    this.f15296a.a();
                    throw th2;
                }
            }
        }
    }

    public q(@NonNull Executor executor) {
        this.f15293b = executor;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Runnable poll = this.f15292a.poll();
        this.f15294c = poll;
        if (poll != null) {
            this.f15293b.execute(poll);
        }
    }

    public void execute(@NonNull Runnable runnable) {
        synchronized (this.f15295d) {
            this.f15292a.add(new a(this, runnable));
            if (this.f15294c == null) {
                a();
            }
        }
    }

    public boolean s0() {
        boolean z10;
        synchronized (this.f15295d) {
            if (!this.f15292a.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }
}
