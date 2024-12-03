package com.google.firebase.database.core;

import java.lang.Thread;

public interface ThreadInitializer {
    public static final ThreadInitializer defaultInstance = new ThreadInitializer() {
        public void setDaemon(Thread thread, boolean z10) {
            thread.setDaemon(z10);
        }

        public void setName(Thread thread, String str) {
            thread.setName(str);
        }

        public void setUncaughtExceptionHandler(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    };

    void setDaemon(Thread thread, boolean z10);

    void setName(Thread thread, String str);

    void setUncaughtExceptionHandler(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
