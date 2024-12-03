package com.uber.autodispose;

import bk.a;
import java.util.concurrent.atomic.AtomicInteger;
import qj.u;
import rn.b;

final class o {
    public static void a(u<?> uVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b10 = atomicThrowable.b();
            if (b10 != null) {
                uVar.onError(b10);
            } else {
                uVar.onComplete();
            }
        }
    }

    public static void b(b<?> bVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b10 = atomicThrowable.b();
            if (b10 != null) {
                bVar.onError(b10);
            } else {
                bVar.onComplete();
            }
        }
    }

    public static void c(u<?> uVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th2)) {
            a.s(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            uVar.onError(atomicThrowable.b());
        }
    }

    public static void d(b<?> bVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th2)) {
            a.s(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(atomicThrowable.b());
        }
    }

    public static <T> boolean e(u<? super T> uVar, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            uVar.d(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b10 = atomicThrowable.b();
                if (b10 != null) {
                    uVar.onError(b10);
                } else {
                    uVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    public static <T> boolean f(b<? super T> bVar, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.d(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b10 = atomicThrowable.b();
                if (b10 != null) {
                    bVar.onError(b10);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }
}
