package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

public final /* synthetic */ class e implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler.FetchResponse f21205a;

    public /* synthetic */ e(ConfigFetchHandler.FetchResponse fetchResponse) {
        this.f21205a = fetchResponse;
    }

    public final Task then(Object obj) {
        return Tasks.forResult(this.f21205a);
    }
}
