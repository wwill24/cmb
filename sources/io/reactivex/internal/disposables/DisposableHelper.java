package io.reactivex.internal.disposables;

import androidx.camera.view.h;
import bk.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
import tj.b;

public enum DisposableHelper implements b {
    DISPOSED;

    public static boolean a(AtomicReference<b> atomicReference) {
        b andSet;
        b bVar = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (bVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean b(b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean d(AtomicReference<b> atomicReference, b bVar) {
        b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!h.a(atomicReference, bVar2, bVar));
        return true;
    }

    public static void e() {
        a.s(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean h(AtomicReference<b> atomicReference, b bVar) {
        b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!h.a(atomicReference, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }

    public static boolean i(AtomicReference<b> atomicReference, b bVar) {
        xj.b.e(bVar, "d is null");
        if (h.a(atomicReference, (Object) null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        e();
        return false;
    }

    public static boolean j(AtomicReference<b> atomicReference, b bVar) {
        if (h.a(atomicReference, (Object) null, bVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        bVar.dispose();
        return false;
    }

    public static boolean k(b bVar, b bVar2) {
        if (bVar2 == null) {
            a.s(new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.dispose();
            e();
            return false;
        }
    }

    public boolean c() {
        return true;
    }

    public void dispose() {
    }
}
