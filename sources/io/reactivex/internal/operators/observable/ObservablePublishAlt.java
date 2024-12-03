package io.reactivex.internal.operators.observable;

import androidx.camera.view.h;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.s;
import qj.u;
import tj.b;
import wj.c;
import zj.a;

public final class ObservablePublishAlt<T> extends a<T> implements c {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f30357a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<PublishConnection<T>> f30358b = new AtomicReference<>();

    static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements b {
        private static final long serialVersionUID = 7463222674719692880L;
        final u<? super T> downstream;

        InnerDisposable(u<? super T> uVar, PublishConnection<T> publishConnection) {
            this.downstream = uVar;
            lazySet(publishConnection);
        }

        public boolean c() {
            return get() == null;
        }

        public void dispose() {
            PublishConnection publishConnection = (PublishConnection) getAndSet((Object) null);
            if (publishConnection != null) {
                publishConnection.e(this);
            }
        }
    }

    static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements u<T>, b {

        /* renamed from: a  reason: collision with root package name */
        static final InnerDisposable[] f30359a = new InnerDisposable[0];

        /* renamed from: b  reason: collision with root package name */
        static final InnerDisposable[] f30360b = new InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<PublishConnection<T>> current;
        Throwable error;
        final AtomicReference<b> upstream;

        PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.current = atomicReference;
            this.upstream = new AtomicReference<>();
            lazySet(f30359a);
        }

        public void a(b bVar) {
            DisposableHelper.i(this.upstream, bVar);
        }

        public boolean b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                if (innerDisposableArr == f30360b) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public boolean c() {
            return get() == f30360b;
        }

        public void d(T t10) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) get()) {
                innerDisposable.downstream.d(t10);
            }
        }

        public void dispose() {
            getAndSet(f30360b);
            h.a(this.current, this, (Object) null);
            DisposableHelper.a(this.upstream);
        }

        public void e(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (innerDisposableArr[i11] == innerDisposable) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        innerDisposableArr2 = f30359a;
                        if (length != 1) {
                            innerDisposableArr2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i10);
                            System.arraycopy(innerDisposableArr, i10 + 1, innerDisposableArr2, i10, (length - i10) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        public void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(f30360b)) {
                innerDisposable.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(f30360b)) {
                innerDisposable.downstream.onError(th2);
            }
        }
    }

    public ObservablePublishAlt(s<T> sVar) {
        this.f30357a = sVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A0(vj.f<? super tj.b> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection<T>> r0 = r4.f30358b
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection r0 = (io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.c()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection r1 = new io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection<T>> r2 = r4.f30358b
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection<T>> r2 = r4.f30358b
            boolean r0 = androidx.camera.view.h.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.connect
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            r5.accept(r0)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            qj.s<T> r5 = r4.f30357a
            r5.e(r0)
        L_0x003f:
            return
        L_0x0040:
            r5 = move-exception
            uj.a.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.e(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublishAlt.A0(vj.f):void");
    }

    public void f(b bVar) {
        h.a(this.f30358b, (PublishConnection) bVar, (Object) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l0(qj.u<? super T> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection<T>> r0 = r3.f30358b
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection r0 = (io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection) r0
            if (r0 != 0) goto L_0x001b
            io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection r1 = new io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection<T>> r2 = r3.f30358b
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt$PublishConnection<T>> r2 = r3.f30358b
            boolean r0 = androidx.camera.view.h.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001a
            goto L_0x0000
        L_0x001a:
            r0 = r1
        L_0x001b:
            io.reactivex.internal.operators.observable.ObservablePublishAlt$InnerDisposable r1 = new io.reactivex.internal.operators.observable.ObservablePublishAlt$InnerDisposable
            r1.<init>(r4, r0)
            r4.a(r1)
            boolean r2 = r0.b(r1)
            if (r2 == 0) goto L_0x0033
            boolean r4 = r1.c()
            if (r4 == 0) goto L_0x0032
            r0.e(r1)
        L_0x0032:
            return
        L_0x0033:
            java.lang.Throwable r0 = r0.error
            if (r0 == 0) goto L_0x003b
            r4.onError(r0)
            goto L_0x003e
        L_0x003b:
            r4.onComplete()
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublishAlt.l0(qj.u):void");
    }
}
