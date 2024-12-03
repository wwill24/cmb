package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class TopicsStore {
    private static final String DIVIDER_QUEUE_OPERATIONS = ",";
    static final String KEY_TOPIC_OPERATIONS_QUEUE = "topic_operation_queue";
    static final String PREFERENCES = "com.google.android.gms.appid";
    private static WeakReference<TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private SharedPreferencesQueue topicOperationsQueue;

    private TopicsStore(SharedPreferences sharedPreferences2, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences2;
    }

    static synchronized void clearCaches() {
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }

    public static synchronized TopicsStore getInstance(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            topicsStore = null;
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                topicsStore = weakReference.get();
            }
            if (topicsStore == null) {
                topicsStore = new TopicsStore(context.getSharedPreferences(PREFERENCES, 0), executor);
                topicsStore.initStore();
                topicsStoreWeakReference = new WeakReference<>(topicsStore);
            }
        }
        return topicsStore;
    }

    private synchronized void initStore() {
        this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, KEY_TOPIC_OPERATIONS_QUEUE, ",", this.syncExecutor);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean addTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.add(topicOperation.serialize());
    }

    /* access modifiers changed from: package-private */
    public synchronized void clearTopicOperations() {
        this.topicOperationsQueue.clear();
    }

    /* access modifiers changed from: package-private */
    public synchronized TopicOperation getNextTopicOperation() {
        return TopicOperation.from(this.topicOperationsQueue.peek());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized List<TopicOperation> getOperations() {
        ArrayList arrayList;
        List<String> list = this.topicOperationsQueue.toList();
        arrayList = new ArrayList(list.size());
        for (String from : list) {
            arrayList.add(TopicOperation.from(from));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.firebase.messaging.TopicOperation pollTopicOperation() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.firebase.messaging.SharedPreferencesQueue r0 = r1.topicOperationsQueue     // Catch:{ NoSuchElementException -> 0x0010, all -> 0x000d }
            java.lang.String r0 = r0.remove()     // Catch:{ NoSuchElementException -> 0x0010, all -> 0x000d }
            com.google.firebase.messaging.TopicOperation r0 = com.google.firebase.messaging.TopicOperation.from(r0)     // Catch:{ NoSuchElementException -> 0x0010, all -> 0x000d }
            monitor-exit(r1)
            return r0
        L_0x000d:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0010:
            r0 = 0
            monitor-exit(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsStore.pollTopicOperation():com.google.firebase.messaging.TopicOperation");
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean removeTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.remove(topicOperation.serialize());
    }
}
