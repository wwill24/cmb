package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import qj.h;
import qj.l;
import rn.a;
import rn.b;
import rn.c;

public final class FlowableConcatArray<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    final a<? extends T>[] f30152b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f30153c;

    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements l<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final boolean delayError;
        final b<? super T> downstream;
        List<Throwable> errors;
        int index;
        long produced;
        final a<? extends T>[] sources;
        final AtomicInteger wip = new AtomicInteger();

        ConcatArraySubscriber(a<? extends T>[] aVarArr, boolean z10, b<? super T> bVar) {
            super(false);
            this.downstream = bVar;
            this.sources = aVarArr;
            this.delayError = z10;
        }

        public void d(T t10) {
            this.produced++;
            this.downstream.d(t10);
        }

        public void e(c cVar) {
            g(cVar);
        }

        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                a<? extends T>[] aVarArr = this.sources;
                int length = aVarArr.length;
                int i10 = this.index;
                while (i10 != length) {
                    a<? extends T> aVar = aVarArr[i10];
                    if (aVar == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.delayError) {
                            List list = this.errors;
                            if (list == null) {
                                list = new ArrayList((length - i10) + 1);
                                this.errors = list;
                            }
                            list.add(nullPointerException);
                            i10++;
                        } else {
                            this.downstream.onError(nullPointerException);
                            return;
                        }
                    } else {
                        long j10 = this.produced;
                        if (j10 != 0) {
                            this.produced = 0;
                            c(j10);
                        }
                        aVar.a(this);
                        i10++;
                        this.index = i10;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.errors;
                if (list2 == null) {
                    this.downstream.onComplete();
                } else if (list2.size() == 1) {
                    this.downstream.onError(list2.get(0));
                } else {
                    this.downstream.onError(new CompositeException((Iterable<? extends Throwable>) list2));
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.delayError) {
                List list = this.errors;
                if (list == null) {
                    list = new ArrayList((this.sources.length - this.index) + 1);
                    this.errors = list;
                }
                list.add(th2);
                onComplete();
                return;
            }
            this.downstream.onError(th2);
        }
    }

    public FlowableConcatArray(a<? extends T>[] aVarArr, boolean z10) {
        this.f30152b = aVarArr;
        this.f30153c = z10;
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.f30152b, this.f30153c, bVar);
        bVar.e(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
