package com.facebook.stetho.inspector.helper;

import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

public abstract class ThreadBoundProxy implements ThreadBound {
    private final ThreadBound mEnforcer;

    public ThreadBoundProxy(ThreadBound threadBound) {
        this.mEnforcer = (ThreadBound) Util.throwIfNull(threadBound);
    }

    public final boolean checkThreadAccess() {
        return this.mEnforcer.checkThreadAccess();
    }

    public final <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return this.mEnforcer.postAndWait(uncheckedCallable);
    }

    public final void postDelayed(Runnable runnable, long j10) {
        this.mEnforcer.postDelayed(runnable, j10);
    }

    public final void removeCallbacks(Runnable runnable) {
        this.mEnforcer.removeCallbacks(runnable);
    }

    public final void verifyThreadAccess() {
        this.mEnforcer.verifyThreadAccess();
    }

    public final void postAndWait(Runnable runnable) {
        this.mEnforcer.postAndWait(runnable);
    }
}
