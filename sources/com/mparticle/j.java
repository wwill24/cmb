package com.mparticle;

import com.mparticle.internal.Logger;
import java.lang.Thread;

public class j implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f22586a = null;

    public j(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != null && !(uncaughtExceptionHandler instanceof j)) {
            this.f22586a = uncaughtExceptionHandler;
        }
    }

    public Thread.UncaughtExceptionHandler a() {
        return this.f22586a;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                instance.logUnhandledError(th2);
            }
        } catch (Exception e10) {
            Logger.error(e10, "Failed to log error event for uncaught exception.");
        }
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f22586a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        } catch (Exception e11) {
            Logger.error(e11, "Failed to log error event for uncaught exception.");
        }
    }
}
