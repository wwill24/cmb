package io.reactivex.subjects;

import androidx.camera.view.h;
import bk.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.u;
import tj.b;

public final class PublishSubject<T> extends c<T> {

    /* renamed from: c  reason: collision with root package name */
    static final PublishDisposable[] f30745c = new PublishDisposable[0];

    /* renamed from: d  reason: collision with root package name */
    static final PublishDisposable[] f30746d = new PublishDisposable[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<PublishDisposable<T>[]> f30747a = new AtomicReference<>(f30746d);

    /* renamed from: b  reason: collision with root package name */
    Throwable f30748b;

    static final class PublishDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 3562861878281475070L;
        final u<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(u<? super T> uVar, PublishSubject<T> publishSubject) {
            this.downstream = uVar;
            this.parent = publishSubject;
        }

        public void a() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (get()) {
                a.s(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        public boolean c() {
            return get();
        }

        public void d(T t10) {
            if (!get()) {
                this.downstream.d(t10);
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.D0(this);
            }
        }
    }

    PublishSubject() {
    }

    public static <T> PublishSubject<T> C0() {
        return new PublishSubject<>();
    }

    /* access modifiers changed from: package-private */
    public boolean B0(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f30747a.get();
            if (publishDisposableArr == f30745c) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!h.a(this.f30747a, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void D0(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f30747a.get();
            if (publishDisposableArr != f30745c && publishDisposableArr != f30746d) {
                int length = publishDisposableArr.length;
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (publishDisposableArr[i11] == publishDisposable) {
                        i10 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = f30746d;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i10);
                        System.arraycopy(publishDisposableArr, i10 + 1, publishDisposableArr3, i10, (length - i10) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!h.a(this.f30747a, publishDisposableArr, publishDisposableArr2));
    }

    public void a(b bVar) {
        if (this.f30747a.get() == f30745c) {
            bVar.dispose();
        }
    }

    public void d(T t10) {
        xj.b.e(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable d10 : (PublishDisposable[]) this.f30747a.get()) {
            d10.d(t10);
        }
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        PublishDisposable publishDisposable = new PublishDisposable(uVar, this);
        uVar.a(publishDisposable);
        if (!B0(publishDisposable)) {
            Throwable th2 = this.f30748b;
            if (th2 != null) {
                uVar.onError(th2);
            } else {
                uVar.onComplete();
            }
        } else if (publishDisposable.c()) {
            D0(publishDisposable);
        }
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f30747a.get();
        PublishDisposable<T>[] publishDisposableArr2 = f30745c;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable a10 : (PublishDisposable[]) this.f30747a.getAndSet(publishDisposableArr2)) {
                a10.a();
            }
        }
    }

    public void onError(Throwable th2) {
        xj.b.e(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f30747a.get();
        PublishDisposable<T>[] publishDisposableArr2 = f30745c;
        if (publishDisposableArr == publishDisposableArr2) {
            a.s(th2);
            return;
        }
        this.f30748b = th2;
        for (PublishDisposable b10 : (PublishDisposable[]) this.f30747a.getAndSet(publishDisposableArr2)) {
            b10.b(th2);
        }
    }
}
