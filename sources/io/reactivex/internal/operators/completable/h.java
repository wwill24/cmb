package io.reactivex.internal.operators.completable;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import qj.a;
import qj.d;
import qj.f;
import xj.b;

public final class h extends a {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends f> f30125a;

    public h(Iterable<? extends f> iterable) {
        this.f30125a = iterable;
    }

    public void E(d dVar) {
        tj.a aVar = new tj.a();
        dVar.a(aVar);
        try {
            Iterator it = (Iterator) b.e(this.f30125a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            while (!aVar.c()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            Throwable b10 = atomicThrowable.b();
                            if (b10 == null) {
                                dVar.onComplete();
                                return;
                            } else {
                                dVar.onError(b10);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!aVar.c()) {
                        try {
                            f fVar = (f) b.e(it.next(), "The iterator returned a null CompletableSource");
                            if (!aVar.c()) {
                                atomicInteger.getAndIncrement();
                                fVar.e(new g(dVar, aVar, atomicThrowable, atomicInteger));
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            uj.a.b(th2);
                            atomicThrowable.a(th2);
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    atomicThrowable.a(th3);
                }
            }
        } catch (Throwable th4) {
            uj.a.b(th4);
            dVar.onError(th4);
        }
    }
}
