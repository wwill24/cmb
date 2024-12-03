package com.uber.autodispose;

import androidx.camera.view.h;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

final class ExceptionHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final Throwable f23301a = new Termination();

    static final class Termination extends Throwable {
        Termination() {
            super("No further exceptions");
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    static boolean a(AtomicReference<Throwable> atomicReference, Throwable th2) {
        Throwable th3;
        Throwable th4;
        do {
            th3 = atomicReference.get();
            if (th3 == f23301a) {
                return false;
            }
            if (th3 == null) {
                th4 = th2;
            } else {
                th4 = new CompositeException(th3, th2);
            }
        } while (!h.a(atomicReference, th3, th4));
        return true;
    }

    static Throwable b(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = f23301a;
        if (th2 != th3) {
            return atomicReference.getAndSet(th3);
        }
        return th2;
    }
}
