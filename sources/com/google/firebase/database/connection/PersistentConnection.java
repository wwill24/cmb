package com.google.firebase.database.connection;

import com.google.android.gms.tasks.Task;
import java.util.List;
import java.util.Map;

public interface PersistentConnection {

    public interface Delegate {
        void onConnect();

        void onConnectionStatus(boolean z10);

        void onDataUpdate(List<String> list, Object obj, boolean z10, Long l10);

        void onDisconnect();

        void onRangeMergeUpdate(List<String> list, List<RangeMerge> list2, Long l10);

        void onServerInfoUpdate(Map<String, Object> map);
    }

    void compareAndPut(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback);

    Task<Object> get(List<String> list, Map<String, Object> map);

    void initialize();

    void interrupt(String str);

    boolean isInterrupted(String str);

    void listen(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l10, RequestResultCallback requestResultCallback);

    void merge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback);

    void onDisconnectCancel(List<String> list, RequestResultCallback requestResultCallback);

    void onDisconnectMerge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback);

    void onDisconnectPut(List<String> list, Object obj, RequestResultCallback requestResultCallback);

    void purgeOutstandingWrites();

    void put(List<String> list, Object obj, RequestResultCallback requestResultCallback);

    void refreshAppCheckToken();

    void refreshAppCheckToken(String str);

    void refreshAuthToken();

    void refreshAuthToken(String str);

    void resume(String str);

    void shutdown();

    void unlisten(List<String> list, Map<String, Object> map);
}
