package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.d;
import qj.f;
import tj.b;
import vj.j;

public final class CompletableResumeNext extends a {

    /* renamed from: a  reason: collision with root package name */
    final f f30108a;

    /* renamed from: b  reason: collision with root package name */
    final j<? super Throwable, ? extends f> f30109b;

    static final class ResumeNextObserver extends AtomicReference<b> implements d, b {
        private static final long serialVersionUID = 5018523762564524046L;
        final d downstream;
        final j<? super Throwable, ? extends f> errorMapper;
        boolean once;

        ResumeNextObserver(d dVar, j<? super Throwable, ? extends f> jVar) {
            this.downstream = dVar;
            this.errorMapper = jVar;
        }

        public void a(b bVar) {
            DisposableHelper.d(this, bVar);
        }

        public boolean c() {
            return DisposableHelper.b((b) get());
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            if (this.once) {
                this.downstream.onError(th2);
                return;
            }
            this.once = true;
            try {
                ((f) xj.b.e(this.errorMapper.apply(th2), "The errorMapper returned a null CompletableSource")).e(this);
            } catch (Throwable th3) {
                uj.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }
    }

    public CompletableResumeNext(f fVar, j<? super Throwable, ? extends f> jVar) {
        this.f30108a = fVar;
        this.f30109b = jVar;
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(dVar, this.f30109b);
        dVar.a(resumeNextObserver);
        this.f30108a.e(resumeNextObserver);
    }
}
