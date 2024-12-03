package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import qj.f;
import tj.b;

public final class CompletableAndThenCompletable extends qj.a {

    /* renamed from: a  reason: collision with root package name */
    final f f30099a;

    /* renamed from: b  reason: collision with root package name */
    final f f30100b;

    static final class SourceObserver extends AtomicReference<b> implements d, b {
        private static final long serialVersionUID = -4101678820158072998L;
        final d actualObserver;
        final f next;

        SourceObserver(d dVar, f fVar) {
            this.actualObserver = dVar;
            this.next = fVar;
        }

        public void a(b bVar) {
            if (DisposableHelper.i(this, bVar)) {
                this.actualObserver.a(this);
            }
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.next.e(new a(this, this.actualObserver));
        }

        public void onError(Throwable th2) {
            this.actualObserver.onError(th2);
        }
    }

    static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<b> f30101a;

        /* renamed from: b  reason: collision with root package name */
        final d f30102b;

        a(AtomicReference<b> atomicReference, d dVar) {
            this.f30101a = atomicReference;
            this.f30102b = dVar;
        }

        public void a(b bVar) {
            DisposableHelper.d(this.f30101a, bVar);
        }

        public void onComplete() {
            this.f30102b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f30102b.onError(th2);
        }
    }

    public CompletableAndThenCompletable(f fVar, f fVar2) {
        this.f30099a = fVar;
        this.f30100b = fVar2;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        this.f30099a.e(new SourceObserver(dVar, this.f30100b));
    }
}
