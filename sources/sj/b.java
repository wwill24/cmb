package sj;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import qj.v;

final class b extends v {

    /* renamed from: c  reason: collision with root package name */
    private final Handler f33842c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f33843d;

    private static final class a extends v.c {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f33844a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f33845b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f33846c;

        a(Handler handler, boolean z10) {
            this.f33844a = handler;
            this.f33845b = z10;
        }

        public boolean c() {
            return this.f33846c;
        }

        @SuppressLint({"NewApi"})
        public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f33846c) {
                return io.reactivex.disposables.a.a();
            } else {
                C0397b bVar = new C0397b(this.f33844a, bk.a.u(runnable));
                Message obtain = Message.obtain(this.f33844a, bVar);
                obtain.obj = this;
                if (this.f33845b) {
                    obtain.setAsynchronous(true);
                }
                this.f33844a.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
                if (!this.f33846c) {
                    return bVar;
                }
                this.f33844a.removeCallbacks(bVar);
                return io.reactivex.disposables.a.a();
            }
        }

        public void dispose() {
            this.f33846c = true;
            this.f33844a.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: sj.b$b  reason: collision with other inner class name */
    private static final class C0397b implements Runnable, tj.b {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f33847a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f33848b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f33849c;

        C0397b(Handler handler, Runnable runnable) {
            this.f33847a = handler;
            this.f33848b = runnable;
        }

        public boolean c() {
            return this.f33849c;
        }

        public void dispose() {
            this.f33847a.removeCallbacks(this);
            this.f33849c = true;
        }

        public void run() {
            try {
                this.f33848b.run();
            } catch (Throwable th2) {
                bk.a.s(th2);
            }
        }
    }

    b(Handler handler, boolean z10) {
        this.f33842c = handler;
        this.f33843d = z10;
    }

    public v.c b() {
        return new a(this.f33842c, this.f33843d);
    }

    @SuppressLint({"NewApi"})
    public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C0397b bVar = new C0397b(this.f33842c, bk.a.u(runnable));
            Message obtain = Message.obtain(this.f33842c, bVar);
            if (this.f33843d) {
                obtain.setAsynchronous(true);
            }
            this.f33842c.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
