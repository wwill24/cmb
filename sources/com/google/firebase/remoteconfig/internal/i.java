package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;

public final /* synthetic */ class i implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigFetchHandler f21216a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f21217b;

    public /* synthetic */ i(ConfigFetchHandler configFetchHandler, Map map) {
        this.f21216a = configFetchHandler;
        this.f21217b = map;
    }

    public final Object then(Task task) {
        return this.f21216a.lambda$fetchNowWithTypeAndAttemptNumber$1(this.f21217b, task);
    }
}
