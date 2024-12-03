package com.uber.autodispose;

import androidx.camera.view.h;
import bk.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
import rn.c;
import tj.b;

final class e {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        a.s(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<c> atomicReference, c cVar, Class<?> cls) {
        j.a(cVar, "next is null");
        if (h.a(atomicReference, (Object) null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == AutoSubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean d(AtomicReference<b> atomicReference, b bVar, Class<?> cls) {
        j.a(bVar, "next is null");
        if (h.a(atomicReference, (Object) null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == AutoDisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }
}
