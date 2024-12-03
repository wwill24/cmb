package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;
import tj.b;

enum AutoDisposableHelper implements b {
    DISPOSED;

    static boolean a(AtomicReference<b> atomicReference) {
        b andSet;
        b bVar = atomicReference.get();
        AutoDisposableHelper autoDisposableHelper = DISPOSED;
        if (bVar == autoDisposableHelper || (andSet = atomicReference.getAndSet(autoDisposableHelper)) == autoDisposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public boolean c() {
        return true;
    }

    public void dispose() {
    }
}
