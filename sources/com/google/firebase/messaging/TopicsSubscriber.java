package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TopicsSubscriber {
    static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final long RPC_TIMEOUT_SEC = 30;
    private final Context context;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new a();
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private boolean syncScheduledOrRunning = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging2, Metadata metadata2, TopicsStore topicsStore, GmsRpc gmsRpc, Context context2, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging2;
        this.metadata = metadata2;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context2;
        this.syncExecutor = scheduledExecutorService;
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.pendingOperations) {
            String serialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(serialize)) {
                arrayDeque = this.pendingOperations.get(serialize);
            } else {
                ArrayDeque arrayDeque2 = new ArrayDeque();
                this.pendingOperations.put(serialize, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    private static <T> void awaitTask(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e10);
            }
        } catch (InterruptedException | TimeoutException e11) {
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE, e11);
        }
    }

    private void blockingSubscribeToTopic(String str) throws IOException {
        awaitTask(this.rpc.subscribeToTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) throws IOException {
        awaitTask(this.rpc.unsubscribeFromTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    static Task<TopicsSubscriber> createInstance(FirebaseMessaging firebaseMessaging2, Metadata metadata2, GmsRpc gmsRpc, Context context2, @NonNull ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new d0(context2, scheduledExecutorService, firebaseMessaging2, metadata2, gmsRpc));
    }

    static boolean isDebugLogEnabled() {
        return Log.isLoggable(Constants.TAG, 3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TopicsSubscriber lambda$createInstance$0(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging2, Metadata metadata2, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging2, metadata2, TopicsStore.getInstance(context2, scheduledExecutorService), gmsRpc, context2, scheduledExecutorService);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void markCompletePendingOperation(com.google.firebase.messaging.TopicOperation r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r0 = r4.pendingOperations
            monitor-enter(r0)
            java.lang.String r5 = r5.serialize()     // Catch:{ all -> 0x0032 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0011:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0032 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0032 }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0025
            r3 = 0
            r2.setResult(r3)     // Catch:{ all -> 0x0032 }
        L_0x0025:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0030
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            r1.remove(r5)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.markCompletePendingOperation(com.google.firebase.messaging.TopicOperation):void");
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0);
        }
    }

    /* access modifiers changed from: package-private */
    public TopicsStore getStore() {
        return this.store;
    }

    /* access modifiers changed from: package-private */
    public boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* access modifiers changed from: package-private */
    public boolean performTopicOperation(TopicOperation topicOperation) throws IOException {
        try {
            String operation = topicOperation.getOperation();
            char c10 = 65535;
            int hashCode = operation.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85) {
                    if (operation.equals("U")) {
                        c10 = 1;
                    }
                }
            } else if (operation.equals("S")) {
                c10 = 0;
            }
            if (c10 == 0) {
                blockingSubscribeToTopic(topicOperation.getTopic());
                if (isDebugLogEnabled()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Subscribe to topic: ");
                    sb2.append(topicOperation.getTopic());
                    sb2.append(" succeeded.");
                }
            } else if (c10 == 1) {
                blockingUnsubscribeFromTopic(topicOperation.getTopic());
                if (isDebugLogEnabled()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unsubscribe from topic: ");
                    sb3.append(topicOperation.getTopic());
                    sb3.append(" succeeded.");
                }
            } else if (isDebugLogEnabled()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Unknown topic operation");
                sb4.append(topicOperation);
                sb4.append(".");
            }
            return true;
        } catch (IOException e10) {
            if (ERROR_SERVICE_NOT_AVAILABLE.equals(e10.getMessage()) || ERROR_INTERNAL_SERVER_ERROR.equals(e10.getMessage())) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Topic operation failed: ");
                sb5.append(e10.getMessage());
                sb5.append(". Will retry Topic operation.");
                return false;
            } else if (e10.getMessage() == null) {
                return false;
            } else {
                throw e10;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j10) {
        this.syncExecutor.schedule(runnable, j10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z10) {
        this.syncScheduledOrRunning = z10;
    }

    /* access modifiers changed from: package-private */
    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> subscribeToTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (performTopicOperation(r0) != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean syncTopics() throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            com.google.firebase.messaging.TopicsStore r0 = r2.store     // Catch:{ all -> 0x0022 }
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0010
            boolean r0 = isDebugLogEnabled()     // Catch:{ all -> 0x0022 }
            r0 = 1
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r0
        L_0x0010:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            boolean r1 = r2.performTopicOperation(r0)
            if (r1 != 0) goto L_0x0019
            r0 = 0
            return r0
        L_0x0019:
            com.google.firebase.messaging.TopicsStore r1 = r2.store
            r1.removeTopicOperation(r0)
            r2.markCompletePendingOperation(r0)
            goto L_0x0000
        L_0x0022:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    /* access modifiers changed from: package-private */
    public void syncWithDelaySecondsInternal(long j10) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30, 2 * j10), MAX_DELAY_SEC)), j10);
        setSyncScheduledOrRunning(true);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> unsubscribeFromTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }
}
