package io.reactivex.internal.util;

import bk.a;
import io.reactivex.internal.schedulers.g;

public final class c {
    public static void a() {
        if (!a.j()) {
            return;
        }
        if ((Thread.currentThread() instanceof g) || a.q()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
