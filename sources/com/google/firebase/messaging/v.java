package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class v implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f21138a;

    public /* synthetic */ v(GmsRpc gmsRpc) {
        this.f21138a = gmsRpc;
    }

    public final Object then(Task task) {
        return this.f21138a.lambda$extractResponseWhenComplete$0(task);
    }
}
