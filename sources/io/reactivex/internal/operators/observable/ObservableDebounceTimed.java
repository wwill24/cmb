package io.reactivex.internal.operators.observable;

import ak.c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.s;
import qj.u;
import qj.v;
import tj.b;

public final class ObservableDebounceTimed<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f30324b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f30325c;

    /* renamed from: d  reason: collision with root package name */
    final v f30326d;

    static final class DebounceEmitter<T> extends AtomicReference<b> implements Runnable, b {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final a<T> parent;
        final T value;

        DebounceEmitter(T t10, long j10, a<T> aVar) {
            this.value = t10;
            this.idx = j10;
            this.parent = aVar;
        }

        public void a(b bVar) {
            DisposableHelper.d(this, bVar);
        }

        public boolean c() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.b(this.idx, this.value, this);
            }
        }
    }

    static final class a<T> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f30327a;

        /* renamed from: b  reason: collision with root package name */
        final long f30328b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f30329c;

        /* renamed from: d  reason: collision with root package name */
        final v.c f30330d;

        /* renamed from: e  reason: collision with root package name */
        b f30331e;

        /* renamed from: f  reason: collision with root package name */
        b f30332f;

        /* renamed from: g  reason: collision with root package name */
        volatile long f30333g;

        /* renamed from: h  reason: collision with root package name */
        boolean f30334h;

        a(u<? super T> uVar, long j10, TimeUnit timeUnit, v.c cVar) {
            this.f30327a = uVar;
            this.f30328b = j10;
            this.f30329c = timeUnit;
            this.f30330d = cVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.k(this.f30331e, bVar)) {
                this.f30331e = bVar;
                this.f30327a.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j10, T t10, DebounceEmitter<T> debounceEmitter) {
            if (j10 == this.f30333g) {
                this.f30327a.d(t10);
                debounceEmitter.dispose();
            }
        }

        public boolean c() {
            return this.f30330d.c();
        }

        public void d(T t10) {
            if (!this.f30334h) {
                long j10 = this.f30333g + 1;
                this.f30333g = j10;
                b bVar = this.f30332f;
                if (bVar != null) {
                    bVar.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t10, j10, this);
                this.f30332f = debounceEmitter;
                debounceEmitter.a(this.f30330d.d(debounceEmitter, this.f30328b, this.f30329c));
            }
        }

        public void dispose() {
            this.f30331e.dispose();
            this.f30330d.dispose();
        }

        public void onComplete() {
            if (!this.f30334h) {
                this.f30334h = true;
                b bVar = this.f30332f;
                if (bVar != null) {
                    bVar.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.f30327a.onComplete();
                this.f30330d.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f30334h) {
                bk.a.s(th2);
                return;
            }
            b bVar = this.f30332f;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f30334h = true;
            this.f30327a.onError(th2);
            this.f30330d.dispose();
        }
    }

    public ObservableDebounceTimed(s<T> sVar, long j10, TimeUnit timeUnit, v vVar) {
        super(sVar);
        this.f30324b = j10;
        this.f30325c = timeUnit;
        this.f30326d = vVar;
    }

    public void l0(u<? super T> uVar) {
        this.f30395a.e(new a(new c(uVar), this.f30324b, this.f30325c, this.f30326d.b()));
    }
}
