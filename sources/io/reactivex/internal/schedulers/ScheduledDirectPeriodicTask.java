package io.reactivex.internal.schedulers;

import bk.a;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th2) {
            this.runner = null;
            lazySet(AbstractDirectTask.f30602a);
            a.s(th2);
        }
    }
}
