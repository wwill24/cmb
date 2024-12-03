package com.facebook.stetho.common;

public interface ThreadBound {
    boolean checkThreadAccess();

    <V> V postAndWait(UncheckedCallable<V> uncheckedCallable);

    void postAndWait(Runnable runnable);

    void postDelayed(Runnable runnable, long j10);

    void removeCallbacks(Runnable runnable);

    void verifyThreadAccess();
}
