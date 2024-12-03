package io.reactivex.internal.subscriptions;

import androidx.camera.view.h;
import bk.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rn.c;

public enum SubscriptionHelper implements c {
    CANCELLED;

    public static boolean a(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (cVar == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void b(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j10) {
        c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.r(j10);
        } else if (j(j10)) {
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

    public static boolean c(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (!h(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        cVar.r(andSet);
        return true;
    }

    public static void d(long j10) {
        a.s(new ProtocolViolationException("More produced than requested: " + j10));
    }

    public static void e() {
        a.s(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean h(AtomicReference<c> atomicReference, c cVar) {
        xj.b.e(cVar, "s is null");
        if (h.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        e();
        return false;
    }

    public static boolean i(AtomicReference<c> atomicReference, c cVar, long j10) {
        if (!h(atomicReference, cVar)) {
            return false;
        }
        cVar.r(j10);
        return true;
    }

    public static boolean j(long j10) {
        if (j10 > 0) {
            return true;
        }
        a.s(new IllegalArgumentException("n > 0 required but it was " + j10));
        return false;
    }

    public static boolean k(c cVar, c cVar2) {
        if (cVar2 == null) {
            a.s(new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.cancel();
            e();
            return false;
        }
    }

    public void cancel() {
    }

    public void r(long j10) {
    }
}
