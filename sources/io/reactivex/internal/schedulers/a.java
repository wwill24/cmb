package io.reactivex.internal.schedulers;

import androidx.camera.view.h;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import qj.v;

public final class a extends v {

    /* renamed from: e  reason: collision with root package name */
    static final b f30622e;

    /* renamed from: f  reason: collision with root package name */
    static final RxThreadFactory f30623f;

    /* renamed from: g  reason: collision with root package name */
    static final int f30624g = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: h  reason: collision with root package name */
    static final c f30625h;

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f30626c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<b> f30627d;

    /* renamed from: io.reactivex.internal.schedulers.a$a  reason: collision with other inner class name */
    static final class C0357a extends v.c {

        /* renamed from: a  reason: collision with root package name */
        private final wj.b f30628a;

        /* renamed from: b  reason: collision with root package name */
        private final tj.a f30629b;

        /* renamed from: c  reason: collision with root package name */
        private final wj.b f30630c;

        /* renamed from: d  reason: collision with root package name */
        private final c f30631d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f30632e;

        C0357a(c cVar) {
            this.f30631d = cVar;
            wj.b bVar = new wj.b();
            this.f30628a = bVar;
            tj.a aVar = new tj.a();
            this.f30629b = aVar;
            wj.b bVar2 = new wj.b();
            this.f30630c = bVar2;
            bVar2.a(bVar);
            bVar2.a(aVar);
        }

        public tj.b b(Runnable runnable) {
            if (this.f30632e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f30631d.f(runnable, 0, TimeUnit.MILLISECONDS, this.f30628a);
        }

        public boolean c() {
            return this.f30632e;
        }

        public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f30632e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f30631d.f(runnable, j10, timeUnit, this.f30629b);
        }

        public void dispose() {
            if (!this.f30632e) {
                this.f30632e = true;
                this.f30630c.dispose();
            }
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f30633a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f30634b;

        /* renamed from: c  reason: collision with root package name */
        long f30635c;

        b(int i10, ThreadFactory threadFactory) {
            this.f30633a = i10;
            this.f30634b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f30634b[i11] = new c(threadFactory);
            }
        }

        public c a() {
            int i10 = this.f30633a;
            if (i10 == 0) {
                return a.f30625h;
            }
            c[] cVarArr = this.f30634b;
            long j10 = this.f30635c;
            this.f30635c = 1 + j10;
            return cVarArr[(int) (j10 % ((long) i10))];
        }

        public void b() {
            for (c dispose : this.f30634b) {
                dispose.dispose();
            }
        }
    }

    static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f30625h = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f30623f = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f30622e = bVar;
        bVar.b();
    }

    public a() {
        this(f30623f);
    }

    static int f(int i10, int i11) {
        return (i11 <= 0 || i11 > i10) ? i10 : i11;
    }

    public v.c b() {
        return new C0357a(this.f30627d.get().a());
    }

    public tj.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f30627d.get().a().g(runnable, j10, timeUnit);
    }

    public tj.b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f30627d.get().a().h(runnable, j10, j11, timeUnit);
    }

    public void g() {
        b bVar = new b(f30624g, this.f30626c);
        if (!h.a(this.f30627d, f30622e, bVar)) {
            bVar.b();
        }
    }

    public a(ThreadFactory threadFactory) {
        this.f30626c = threadFactory;
        this.f30627d = new AtomicReference<>(f30622e);
        g();
    }
}
