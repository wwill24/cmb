package io.reactivex.internal.disposables;

import qj.n;
import qj.u;
import qj.z;
import yj.d;

public enum EmptyDisposable implements d<Object> {
    INSTANCE,
    NEVER;

    public static void a(qj.d dVar) {
        dVar.a(INSTANCE);
        dVar.onComplete();
    }

    public static void d(n<?> nVar) {
        nVar.a(INSTANCE);
        nVar.onComplete();
    }

    public static void e(u<?> uVar) {
        uVar.a(INSTANCE);
        uVar.onComplete();
    }

    public static void h(Throwable th2, qj.d dVar) {
        dVar.a(INSTANCE);
        dVar.onError(th2);
    }

    public static void i(Throwable th2, u<?> uVar) {
        uVar.a(INSTANCE);
        uVar.onError(th2);
    }

    public static void j(Throwable th2, z<?> zVar) {
        zVar.a(INSTANCE);
        zVar.onError(th2);
    }

    public int b(int i10) {
        return i10 & 2;
    }

    public boolean c() {
        return this == INSTANCE;
    }

    public void clear() {
    }

    public void dispose() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }
}
