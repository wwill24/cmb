package io.reactivex.subjects;

import androidx.camera.view.h;
import bk.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.w;
import qj.z;
import tj.b;

public final class SingleSubject<T> extends w<T> implements z<T> {

    /* renamed from: e  reason: collision with root package name */
    static final SingleDisposable[] f30749e = new SingleDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    static final SingleDisposable[] f30750f = new SingleDisposable[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<SingleDisposable<T>[]> f30751a = new AtomicReference<>(f30749e);

    /* renamed from: b  reason: collision with root package name */
    final AtomicBoolean f30752b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    T f30753c;

    /* renamed from: d  reason: collision with root package name */
    Throwable f30754d;

    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements b {
        private static final long serialVersionUID = -7650903191002190468L;
        final z<? super T> downstream;

        SingleDisposable(z<? super T> zVar, SingleSubject<T> singleSubject) {
            this.downstream = zVar;
            lazySet(singleSubject);
        }

        public boolean c() {
            return get() == null;
        }

        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet((Object) null);
            if (singleSubject != null) {
                singleSubject.a0(this);
            }
        }
    }

    SingleSubject() {
    }

    public static <T> SingleSubject<T> W() {
        return new SingleSubject<>();
    }

    /* access modifiers changed from: protected */
    public void J(z<? super T> zVar) {
        SingleDisposable singleDisposable = new SingleDisposable(zVar, this);
        zVar.a(singleDisposable);
        if (!V(singleDisposable)) {
            Throwable th2 = this.f30754d;
            if (th2 != null) {
                zVar.onError(th2);
            } else {
                zVar.onSuccess(this.f30753c);
            }
        } else if (singleDisposable.c()) {
            a0(singleDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean V(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f30751a.get();
            if (singleDisposableArr == f30750f) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!h.a(this.f30751a, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    public T X() {
        if (this.f30751a.get() == f30750f) {
            return this.f30753c;
        }
        return null;
    }

    public boolean Y() {
        return this.f30751a.get() == f30750f && this.f30754d != null;
    }

    public boolean Z() {
        return this.f30751a.get() == f30750f && this.f30753c != null;
    }

    public void a(b bVar) {
        if (this.f30751a.get() == f30750f) {
            bVar.dispose();
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f30751a.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (singleDisposableArr[i11] == singleDisposable) {
                        i10 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = f30749e;
                    } else {
                        SingleDisposable[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i10);
                        System.arraycopy(singleDisposableArr, i10 + 1, singleDisposableArr3, i10, (length - i10) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!h.a(this.f30751a, singleDisposableArr, singleDisposableArr2));
    }

    public void onError(Throwable th2) {
        xj.b.e(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f30752b.compareAndSet(false, true)) {
            this.f30754d = th2;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f30751a.getAndSet(f30750f)) {
                singleDisposable.downstream.onError(th2);
            }
            return;
        }
        a.s(th2);
    }

    public void onSuccess(T t10) {
        xj.b.e(t10, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f30752b.compareAndSet(false, true)) {
            this.f30753c = t10;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f30751a.getAndSet(f30750f)) {
                singleDisposable.downstream.onSuccess(t10);
            }
        }
    }
}
