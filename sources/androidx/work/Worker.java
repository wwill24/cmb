package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.c;

public abstract class Worker extends c {

    /* renamed from: e  reason: collision with root package name */
    androidx.work.impl.utils.futures.a<c.a> f7351e;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                Worker.this.f7351e.o(Worker.this.o());
            } catch (Throwable th2) {
                Worker.this.f7351e.p(th2);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.a f7353a;

        b(androidx.work.impl.utils.futures.a aVar) {
            this.f7353a = aVar;
        }

        public void run() {
            try {
                this.f7353a.o(Worker.this.p());
            } catch (Throwable th2) {
                this.f7353a.p(th2);
            }
        }
    }

    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    public zf.a<b2.b> d() {
        androidx.work.impl.utils.futures.a s10 = androidx.work.impl.utils.futures.a.s();
        c().execute(new b(s10));
        return s10;
    }

    @NonNull
    public final zf.a<c.a> m() {
        this.f7351e = androidx.work.impl.utils.futures.a.s();
        c().execute(new a());
        return this.f7351e;
    }

    @NonNull
    public abstract c.a o();

    @NonNull
    public b2.b p() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }
}
