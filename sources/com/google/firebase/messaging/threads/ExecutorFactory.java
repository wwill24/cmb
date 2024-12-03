package com.google.firebase.messaging.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public interface ExecutorFactory {
    void executeOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable);

    ScheduledExecutorService newScheduledThreadPool(int i10, ThreadPriority threadPriority);

    ScheduledExecutorService newScheduledThreadPool(int i10, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newSingleThreadExecutor(ThreadPriority threadPriority);

    ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newThreadPool(int i10, ThreadPriority threadPriority);

    ExecutorService newThreadPool(int i10, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService newThreadPool(ThreadPriority threadPriority);

    ExecutorService newThreadPool(ThreadFactory threadFactory, ThreadPriority threadPriority);

    Future<?> submitOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable);
}
