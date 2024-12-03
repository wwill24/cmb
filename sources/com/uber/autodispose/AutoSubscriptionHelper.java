package com.uber.autodispose;

import androidx.camera.view.h;
import bk.a;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rn.c;

enum AutoSubscriptionHelper implements c {
    CANCELLED;

    static boolean a(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        AutoSubscriptionHelper autoSubscriptionHelper = CANCELLED;
        if (cVar == autoSubscriptionHelper || (andSet = atomicReference.getAndSet(autoSubscriptionHelper)) == autoSubscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    static void b(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j10) {
        c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.r(j10);
        } else if (h(j10)) {
            b.a(atomicLong, j10);
            c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    cVar2.r(andSet);
                }
            }
        }
    }

    static boolean c(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (!e(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        cVar.r(andSet);
        return true;
    }

    static void d() {
        a.s(new IllegalStateException("Subscription already set!"));
    }

    static boolean e(AtomicReference<c> atomicReference, c cVar) {
        j.a(cVar, "s is null");
        if (h.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        d();
        return false;
    }

    static boolean h(long j10) {
        if (j10 > 0) {
            return true;
        }
        a.s(new IllegalArgumentException("n > 0 required but it was " + j10));
        return false;
    }

    public void cancel() {
    }

    public void r(long j10) {
    }
}
