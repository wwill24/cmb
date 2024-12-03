package io.reactivex.internal.operators.completable;

import qj.a;
import tj.b;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    final vj.a f30115a;

    public d(vj.a aVar) {
        this.f30115a = aVar;
    }

    /* access modifiers changed from: protected */
    public void E(qj.d dVar) {
        b b10 = io.reactivex.disposables.a.b();
        dVar.a(b10);
        try {
            this.f30115a.run();
            if (!b10.c()) {
                dVar.onComplete();
            }
        } catch (Throwable th2) {
            uj.a.b(th2);
            if (!b10.c()) {
                dVar.onError(th2);
            } else {
                bk.a.s(th2);
            }
        }
    }
}
