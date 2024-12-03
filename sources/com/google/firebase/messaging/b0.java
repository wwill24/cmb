package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class b0 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestDeduplicator f21100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21101b;

    public /* synthetic */ b0(RequestDeduplicator requestDeduplicator, String str) {
        this.f21100a = requestDeduplicator;
        this.f21101b = str;
    }

    public final Object then(Task task) {
        return this.f21100a.lambda$getOrStartGetTokenRequest$0(this.f21101b, task);
    }
}
