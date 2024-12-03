package com.leanplum.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class OperationQueue {
    private static final String OPERATION_QUEUE_NAME = "com.leanplum.operation_queue";
    private static final int OPERATION_QUEUE_PRIORITY = 0;
    private static OperationQueue instance;
    private Executor executor = Executors.newCachedThreadPool();
    private Handler handler;
    private HandlerThread handlerThread;
    private Handler uiHandler = new Handler(Looper.getMainLooper());

    OperationQueue() {
        start();
    }

    public static OperationQueue sharedInstance() {
        if (instance == null) {
            instance = new OperationQueue();
        }
        return instance;
    }

    private void start() {
        if (this.handlerThread == null) {
            HandlerThread handlerThread2 = new HandlerThread(OPERATION_QUEUE_NAME, 0);
            this.handlerThread = handlerThread2;
            handlerThread2.start();
        }
        this.handler = new Handler(this.handlerThread.getLooper());
    }

    private void stop() {
        removeAllOperations();
        this.handlerThread.quit();
        this.handlerThread = null;
    }

    public boolean addOperation(Runnable runnable) {
        Handler handler2;
        if (runnable == null || (handler2 = this.handler) == null) {
            return false;
        }
        return handler2.post(runnable);
    }

    public boolean addOperationAfterDelay(Runnable runnable, long j10) {
        Handler handler2;
        if (runnable == null || (handler2 = this.handler) == null) {
            return false;
        }
        return handler2.postDelayed(runnable, j10);
    }

    public boolean addOperationAtFront(Runnable runnable) {
        Handler handler2;
        if (runnable == null || (handler2 = this.handler) == null) {
            return false;
        }
        return handler2.postAtFrontOfQueue(runnable);
    }

    public boolean addOperationAtTime(Runnable runnable, long j10) {
        Handler handler2;
        if (runnable == null || (handler2 = this.handler) == null) {
            return false;
        }
        return handler2.postAtTime(runnable, j10);
    }

    public void addParallelOperation(Runnable runnable) {
        Executor executor2;
        if (runnable != null && (executor2 = this.executor) != null) {
            executor2.execute(runnable);
        }
    }

    public void addUiOperation(Runnable runnable) {
        Handler handler2;
        if (runnable != null && (handler2 = this.uiHandler) != null) {
            handler2.post(runnable);
        }
    }

    public void removeAllOperations() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public void removeOperation(Runnable runnable) {
        Handler handler2;
        if (runnable != null && (handler2 = this.handler) != null) {
            handler2.removeCallbacks(runnable);
        }
    }
}
