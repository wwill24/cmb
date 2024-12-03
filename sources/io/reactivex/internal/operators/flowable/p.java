package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
import qj.h;
import rn.b;
import vj.j;

public final class p {

    static final class a<T, R> extends h<R> {

        /* renamed from: b  reason: collision with root package name */
        final T f30287b;

        /* renamed from: c  reason: collision with root package name */
        final j<? super T, ? extends rn.a<? extends R>> f30288c;

        a(T t10, j<? super T, ? extends rn.a<? extends R>> jVar) {
            this.f30287b = t10;
            this.f30288c = jVar;
        }

        public void n0(b<? super R> bVar) {
            try {
                rn.a aVar = (rn.a) xj.b.e(this.f30288c.apply(this.f30287b), "The mapper returned a null Publisher");
                if (aVar instanceof Callable) {
                    try {
                        Object call = ((Callable) aVar).call();
                        if (call == null) {
                            EmptySubscription.a(bVar);
                        } else {
                            bVar.e(new ScalarSubscription(bVar, call));
                        }
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        EmptySubscription.c(th2, bVar);
                    }
                } else {
                    aVar.a(bVar);
                }
            } catch (Throwable th3) {
                EmptySubscription.c(th3, bVar);
            }
        }
    }

    public static <T, U> h<U> a(T t10, j<? super T, ? extends rn.a<? extends U>> jVar) {
        return bk.a.l(new a(t10, jVar));
    }

    public static <T, R> boolean b(rn.a<T> aVar, b<? super R> bVar, j<? super T, ? extends rn.a<? extends R>> jVar) {
        if (!(aVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) aVar).call();
            if (call == null) {
                EmptySubscription.a(bVar);
                return true;
            }
            try {
                rn.a aVar2 = (rn.a) xj.b.e(jVar.apply(call), "The mapper returned a null Publisher");
                if (aVar2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) aVar2).call();
                        if (call2 == null) {
                            EmptySubscription.a(bVar);
                            return true;
                        }
                        bVar.e(new ScalarSubscription(bVar, call2));
                    } catch (Throwable th2) {
                        uj.a.b(th2);
                        EmptySubscription.c(th2, bVar);
                        return true;
                    }
                } else {
                    aVar2.a(bVar);
                }
                return true;
            } catch (Throwable th3) {
                uj.a.b(th3);
                EmptySubscription.c(th3, bVar);
                return true;
            }
        } catch (Throwable th4) {
            uj.a.b(th4);
            EmptySubscription.c(th4, bVar);
            return true;
        }
    }
}
