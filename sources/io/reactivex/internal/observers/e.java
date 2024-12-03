package io.reactivex.internal.observers;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.c;
import java.util.concurrent.CountDownLatch;
import qj.d;
import qj.n;
import qj.z;
import tj.b;

public final class e<T> extends CountDownLatch implements z<T>, d, n<T> {

    /* renamed from: a  reason: collision with root package name */
    T f30091a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f30092b;

    /* renamed from: c  reason: collision with root package name */
    b f30093c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f30094d;

    public e() {
        super(1);
    }

    public void a(b bVar) {
        this.f30093c = bVar;
        if (this.f30094d) {
            bVar.dispose();
        }
    }

    public T b() {
        if (getCount() != 0) {
            try {
                c.a();
                await();
            } catch (InterruptedException e10) {
                d();
                throw ExceptionHelper.e(e10);
            }
        }
        Throwable th2 = this.f30092b;
        if (th2 == null) {
            return this.f30091a;
        }
        throw ExceptionHelper.e(th2);
    }

    public Throwable c() {
        if (getCount() != 0) {
            try {
                c.a();
                await();
            } catch (InterruptedException e10) {
                d();
                return e10;
            }
        }
        return this.f30092b;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f30094d = true;
        b bVar = this.f30093c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public void onComplete() {
        countDown();
    }

    public void onError(Throwable th2) {
        this.f30092b = th2;
        countDown();
    }

    public void onSuccess(T t10) {
        this.f30091a = t10;
        countDown();
    }
}
