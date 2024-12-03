package org.jivesoftware.smack;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class AsyncButOrdered<K> {
    private final Executor executor;
    private final Map<K, Queue<Runnable>> pendingRunnables;
    /* access modifiers changed from: private */
    public final Map<K, AsyncButOrdered<K>.Handler> threadActiveMap;

    private class Handler implements Runnable {
        private final K key;
        private final Queue<Runnable> keyQueue;

        Handler(Queue<Runnable> queue, K k10) {
            this.keyQueue = queue;
            this.key = k10;
        }

        public void run() {
            while (true) {
                Runnable poll = this.keyQueue.poll();
                if (poll != null) {
                    try {
                        poll.run();
                    } catch (Throwable th2) {
                        Handler handler = new Handler(this.keyQueue, this.key);
                        synchronized (AsyncButOrdered.this.threadActiveMap) {
                            AsyncButOrdered.this.threadActiveMap.put(this.key, handler);
                            AsyncButOrdered.this.scheduleHandler(handler);
                            throw th2;
                        }
                    }
                } else {
                    synchronized (AsyncButOrdered.this.threadActiveMap) {
                        if (this.keyQueue.isEmpty()) {
                            AsyncButOrdered.this.threadActiveMap.remove(this.key);
                            return;
                        }
                    }
                }
            }
        }
    }

    public AsyncButOrdered() {
        this((Executor) null);
    }

    /* access modifiers changed from: private */
    public void scheduleHandler(AsyncButOrdered<K>.Handler handler) {
        Executor executor2 = this.executor;
        if (executor2 == null) {
            AbstractXMPPConnection.asyncGo(handler);
        } else {
            executor2.execute(handler);
        }
    }

    public Executor asExecutorFor(final K k10) {
        return new Executor() {
            public void execute(Runnable runnable) {
                AsyncButOrdered.this.performAsyncButOrdered(k10, runnable);
            }
        };
    }

    public boolean performAsyncButOrdered(K k10, Runnable runnable) {
        Queue queue;
        synchronized (this.pendingRunnables) {
            queue = this.pendingRunnables.get(k10);
            if (queue == null) {
                queue = new ConcurrentLinkedQueue();
                this.pendingRunnables.put(k10, queue);
            }
        }
        queue.add(runnable);
        Handler handler = null;
        synchronized (this.threadActiveMap) {
            if (!this.threadActiveMap.containsKey(k10)) {
                handler = new Handler(queue, k10);
                this.threadActiveMap.put(k10, handler);
            }
        }
        if (handler == null) {
            return false;
        }
        scheduleHandler(handler);
        return true;
    }

    public AsyncButOrdered(Executor executor2) {
        this.pendingRunnables = new WeakHashMap();
        this.threadActiveMap = new HashMap();
        this.executor = executor2;
    }
}
