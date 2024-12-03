package io.reactivex.internal.util;

import androidx.camera.view.h;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f30712a = new Termination();

    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        Termination() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th2) {
        Throwable th3;
        Throwable th4;
        do {
            th3 = atomicReference.get();
            if (th3 == f30712a) {
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

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = f30712a;
        if (th2 != th3) {
            return atomicReference.getAndSet(th3);
        }
        return th2;
    }

    public static <E extends Throwable> Exception c(Throwable th2) throws Throwable {
        if (th2 instanceof Exception) {
            return (Exception) th2;
        }
        throw th2;
    }

    public static String d(long j10, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j10 + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException e(Throwable th2) {
        if (th2 instanceof Error) {
            throw ((Error) th2);
        } else if (th2 instanceof RuntimeException) {
            return (RuntimeException) th2;
        } else {
            return new RuntimeException(th2);
        }
    }
}
