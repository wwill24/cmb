package com.jakewharton.rxrelay2;

import androidx.camera.view.h;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.u;
import tj.b;

public final class PublishRelay<T> extends c<T> {

    /* renamed from: b  reason: collision with root package name */
    static final PublishDisposable[] f22157b = new PublishDisposable[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<PublishDisposable<T>[]> f22158a = new AtomicReference<>(f22157b);

    static final class PublishDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 3562861878281475070L;
        final u<? super T> downstream;
        final PublishRelay<T> parent;

        PublishDisposable(u<? super T> uVar, PublishRelay<T> publishRelay) {
            this.downstream = uVar;
            this.parent = publishRelay;
        }

        public void a(T t10) {
            if (!get()) {
                this.downstream.d(t10);
            }
        }

        public boolean c() {
            return get();
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.E0(this);
            }
        }
    }

    PublishRelay() {
    }

    public static <T> PublishRelay<T> C0() {
        return new PublishRelay<>();
    }

    /* access modifiers changed from: package-private */
    public void B0(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f22158a.get();
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!h.a(this.f22158a, publishDisposableArr, publishDisposableArr2));
    }

    public boolean D0() {
        return ((PublishDisposable[]) this.f22158a.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public void E0(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f22158a.get();
            if (publishDisposableArr != f22157b) {
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
                        publishDisposableArr2 = f22157b;
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
        } while (!h.a(this.f22158a, publishDisposableArr, publishDisposableArr2));
    }

    public void accept(T t10) {
        if (t10 != null) {
            for (PublishDisposable a10 : (PublishDisposable[]) this.f22158a.get()) {
                a10.a(t10);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super T> uVar) {
        PublishDisposable publishDisposable = new PublishDisposable(uVar, this);
        uVar.a(publishDisposable);
        B0(publishDisposable);
        if (publishDisposable.c()) {
            E0(publishDisposable);
        }
    }
}
