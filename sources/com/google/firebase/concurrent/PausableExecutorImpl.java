package com.google.firebase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

final class PausableExecutorImpl implements PausableExecutor {
    private final Executor delegate;
    private volatile boolean paused;
    final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    PausableExecutorImpl(boolean z10, Executor executor) {
        this.paused = z10;
        this.delegate = executor;
    }

    private void maybeEnqueueNext() {
        if (!this.paused) {
            Runnable poll = this.queue.poll();
            while (poll != null) {
                this.delegate.execute(poll);
                if (!this.paused) {
                    poll = this.queue.poll();
                } else {
                    poll = null;
                }
            }
        }
    }

    public void execute(Runnable runnable) {
        this.queue.offer(runnable);
        maybeEnqueueNext();
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void pause() {
        this.paused = true;
    }

    public void resume() {
        this.paused = false;
        maybeEnqueueNext();
    }
}
