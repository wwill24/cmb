package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import qj.f;
import qj.q;
import qj.u;
import tj.b;

public final class ObservableMergeWithCompletable<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final f f30353b;

    static final class MergeWithObserver<T> extends AtomicInteger implements u<T>, b {
        private static final long serialVersionUID = -4592979584110982903L;
        final u<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final AtomicReference<b> mainDisposable = new AtomicReference<>();
        volatile boolean mainDone;
        volatile boolean otherDone;
        final OtherObserver otherObserver = new OtherObserver(this);

        static final class OtherObserver extends AtomicReference<b> implements d {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<?> parent;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            public void a(b bVar) {
                DisposableHelper.i(this, bVar);
            }

            public void onComplete() {
                this.parent.b();
            }

            public void onError(Throwable th2) {
                this.parent.e(th2);
            }
        }

        MergeWithObserver(u<? super T> uVar) {
            this.downstream = uVar;
        }

        public void a(b bVar) {
            DisposableHelper.i(this.mainDisposable, bVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.otherDone = true;
            if (this.mainDone) {
                e.a(this.downstream, this, this.error);
            }
        }

        public boolean c() {
            return DisposableHelper.b(this.mainDisposable.get());
        }

        public void d(T t10) {
            e.e(this.downstream, t10, this, this.error);
        }

        public void dispose() {
            DisposableHelper.a(this.mainDisposable);
            DisposableHelper.a(this.otherObserver);
        }

        /* access modifiers changed from: package-private */
        public void e(Throwable th2) {
            DisposableHelper.a(this.mainDisposable);
            e.c(this.downstream, th2, this, this.error);
        }

        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                e.a(this.downstream, this, this.error);
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.a(this.otherObserver);
            e.c(this.downstream, th2, this, this.error);
        }
    }

    public ObservableMergeWithCompletable(q<T> qVar, f fVar) {
        super(qVar);
        this.f30353b = fVar;
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(uVar);
        uVar.a(mergeWithObserver);
        this.f30395a.e(mergeWithObserver);
        this.f30353b.e(mergeWithObserver.otherObserver);
    }
}
