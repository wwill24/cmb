package com.google.firebase.database.connection;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import java.util.Map;

public final /* synthetic */ class d implements PersistentConnectionImpl.ConnectionRequestCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21059a;

    public /* synthetic */ d(TaskCompletionSource taskCompletionSource) {
        this.f21059a = taskCompletionSource;
    }

    public final void onResponse(Map map) {
        PersistentConnectionImpl.lambda$get$0(this.f21059a, map);
    }
}
