package com.google.firebase.messaging.threads;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolableExecutors {
    private static final ExecutorFactory DEFAULT_INSTANCE;
    private static volatile ExecutorFactory instance;

    private static class DefaultExecutorFactory implements ExecutorFactory {
        private static final long CORE_THREAD_TIMEOUT_SECS = 60;

        private DefaultExecutorFactory() {
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public void executeOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable) {
            new Thread(runnable, str2).start();
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ScheduledExecutorService newScheduledThreadPool(int i10, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i10));
        }

        @NonNull
        public ExecutorService newSingleThreadExecutor(ThreadPriority threadPriority) {
            return newThreadPool(1, threadPriority);
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ExecutorService newThreadPool(ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public Future<?> submitOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable) {
            FutureTask futureTask = new FutureTask(runnable, (Object) null);
            new Thread(futureTask, str2).start();
            return futureTask;
        }

        @NonNull
        public ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return newThreadPool(1, threadFactory, threadPriority);
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ExecutorService newThreadPool(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(threadFactory));
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ScheduledExecutorService newScheduledThreadPool(int i10, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i10, threadFactory));
        }

        @NonNull
        public ExecutorService newThreadPool(int i10, ThreadPriority threadPriority) {
            return newThreadPool(i10, Executors.defaultThreadFactory(), threadPriority);
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ExecutorService newThreadPool(int i10, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        DefaultExecutorFactory defaultExecutorFactory = new DefaultExecutorFactory();
        DEFAULT_INSTANCE = defaultExecutorFactory;
        instance = defaultExecutorFactory;
    }

    private PoolableExecutors() {
    }

    public static ExecutorFactory factory() {
        return instance;
    }

    static void installExecutorFactory(ExecutorFactory executorFactory) {
        if (instance == DEFAULT_INSTANCE) {
            instance = executorFactory;
            return;
        }
        throw new IllegalStateException("Trying to install an ExecutorFactory twice!");
    }
}
