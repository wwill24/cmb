package io.reactivex.internal.observers;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import qj.u;
import tj.b;

public abstract class c<T> extends CountDownLatch implements u<T>, b {

    /* renamed from: a  reason: collision with root package name */
    T f30087a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f30088b;

    /* renamed from: c  reason: collision with root package name */
    b f30089c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f30090d;

    public c() {
        super(1);
    }

    public final void a(b bVar) {
        this.f30089c = bVar;
        if (this.f30090d) {
            bVar.dispose();
        }
    }

    public final T b() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.a();
                await();
            } catch (InterruptedException e10) {
                dispose();
                throw ExceptionHelper.e(e10);
            }
        }
        Throwable th2 = this.f30088b;
        if (th2 == null) {
            return this.f30087a;
        }
        throw ExceptionHelper.e(th2);
    }

    public final boolean c() {
        return this.f30090d;
    }

    public final void dispose() {
        this.f30090d = true;
        b bVar = this.f30089c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public final void onComplete() {
        countDown();
    }
}
