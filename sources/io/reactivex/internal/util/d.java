package io.reactivex.internal.util;

import androidx.camera.view.h;
import bk.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import tj.b;

public final class d {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        a.s(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<b> atomicReference, b bVar, Class<?> cls) {
        xj.b.e(bVar, "next is null");
        if (h.a(atomicReference, (Object) null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }
}
