package com.google.firebase.database.core;

import android.annotation.SuppressLint;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadPoolEventTarget implements EventTarget {
    private final ThreadPoolExecutor executor;

    @SuppressLint({"ThreadPoolCreation"})
    public ThreadPoolEventTarget(final ThreadFactory threadFactory, final ThreadInitializer threadInitializer) {
        this.executor = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread newThread = threadFactory.newThread(runnable);
                threadInitializer.setName(newThread, "FirebaseDatabaseEventTarget");
                threadInitializer.setDaemon(newThread, true);
                return newThread;
            }
        });
    }

    public void postEvent(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public void restart() {
        this.executor.setCorePoolSize(1);
    }

    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }
}
