package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: b */
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(AbstractDirectTask.f30602a);
            this.runner = null;
        }
    }
}
