package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ne.b;

class WithinAppServiceConnection implements ServiceConnection {
    private WithinAppServiceBinder binder;
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    static class BindRequest {
        final Intent intent;
        private final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        BindRequest(Intent intent2) {
            this.intent = intent2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$arrangeTimeout$0() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Service took too long to process intent: ");
            sb2.append(this.intent.getAction());
            sb2.append(" finishing.");
            finish();
        }

        /* access modifiers changed from: package-private */
        public void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            getTask().addOnCompleteListener((Executor) scheduledExecutorService, new h0(scheduledExecutorService.schedule(new g0(this), 20, TimeUnit.SECONDS)));
        }

        /* access modifiers changed from: package-private */
        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }

        /* access modifiers changed from: package-private */
        public Task<Void> getTask() {
            return this.taskCompletionSource.getTask();
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    WithinAppServiceConnection(Context context2, String str) {
        this(context2, str, new ScheduledThreadPoolExecutor(0, new b("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    private synchronized void flushQueue() {
        boolean isLoggable = Log.isLoggable(Constants.TAG, 3);
        while (!this.intentQueue.isEmpty()) {
            boolean isLoggable2 = Log.isLoggable(Constants.TAG, 3);
            WithinAppServiceBinder withinAppServiceBinder = this.binder;
            if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                startConnectionIfNeeded();
                return;
            }
            boolean isLoggable3 = Log.isLoggable(Constants.TAG, 3);
            this.binder.send(this.intentQueue.poll());
        }
    }

    private void startConnectionIfNeeded() {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("binder is dead. start connection? ");
            sb2.append(!this.connectionInProgress);
        }
        if (!this.connectionInProgress) {
            this.connectionInProgress = true;
            try {
                if (le.b.b().a(this.context, this.connectionIntent, this, 65)) {
                    return;
                }
            } catch (SecurityException unused) {
            }
            this.connectionInProgress = false;
            finishAllInQueue();
        }
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceConnected: ");
            sb2.append(componentName);
        }
        this.connectionInProgress = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid service connection: ");
            sb3.append(iBinder);
            finishAllInQueue();
            return;
        }
        this.binder = (WithinAppServiceBinder) iBinder;
        flushQueue();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onServiceDisconnected: ");
            sb2.append(componentName);
        }
        flushQueue();
    }

    /* access modifiers changed from: package-private */
    public synchronized Task<Void> sendIntent(Intent intent) {
        BindRequest bindRequest;
        boolean isLoggable = Log.isLoggable(Constants.TAG, 3);
        bindRequest = new BindRequest(intent);
        bindRequest.arrangeTimeout(this.scheduledExecutorService);
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.getTask();
    }

    WithinAppServiceConnection(Context context2, String str, ScheduledExecutorService scheduledExecutorService2) {
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(str).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService2;
    }
}
