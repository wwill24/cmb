package io.reactivex.subjects;

import androidx.camera.view.h;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import qj.a;
import qj.d;
import tj.b;

public final class CompletableSubject extends a implements d {

    /* renamed from: d  reason: collision with root package name */
    static final CompletableDisposable[] f30740d = new CompletableDisposable[0];

    /* renamed from: e  reason: collision with root package name */
    static final CompletableDisposable[] f30741e = new CompletableDisposable[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<CompletableDisposable[]> f30742a = new AtomicReference<>(f30740d);

    /* renamed from: b  reason: collision with root package name */
    final AtomicBoolean f30743b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    Throwable f30744c;

    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements b {
        private static final long serialVersionUID = -7650903191002190468L;
        final d downstream;

        CompletableDisposable(d dVar, CompletableSubject completableSubject) {
            this.downstream = dVar;
            lazySet(completableSubject);
        }

        public boolean c() {
            return get() == null;
        }

        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet((Object) null);
            if (completableSubject != null) {
                completableSubject.M(this);
            }
        }
    }

    CompletableSubject() {
    }

    public static CompletableSubject L() {
        return new CompletableSubject();
    }

    /* access modifiers changed from: protected */
    public void E(d dVar) {
        CompletableDisposable completableDisposable = new CompletableDisposable(dVar, this);
        dVar.a(completableDisposable);
        if (!K(completableDisposable)) {
            Throwable th2 = this.f30744c;
            if (th2 != null) {
                dVar.onError(th2);
            } else {
                dVar.onComplete();
            }
        } else if (completableDisposable.c()) {
            M(completableDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean K(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f30742a.get();
            if (completableDisposableArr == f30741e) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!h.a(this.f30742a, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void M(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f30742a.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (completableDisposableArr[i11] == completableDisposable) {
                        i10 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = f30740d;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i10);
                        System.arraycopy(completableDisposableArr, i10 + 1, completableDisposableArr3, i10, (length - i10) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!h.a(this.f30742a, completableDisposableArr, completableDisposableArr2));
    }

    public void a(b bVar) {
        if (this.f30742a.get() == f30741e) {
            bVar.dispose();
        }
    }

    public void onComplete() {
        if (this.f30743b.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f30742a.getAndSet(f30741e)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        xj.b.e(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f30743b.compareAndSet(false, true)) {
            this.f30744c = th2;
            for (CompletableDisposable completableDisposable : this.f30742a.getAndSet(f30741e)) {
                completableDisposable.downstream.onError(th2);
            }
            return;
        }
        bk.a.s(th2);
    }
}
