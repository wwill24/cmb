package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class h implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f21118a;

    public /* synthetic */ h(String str) {
        this.f21118a = str;
    }

    public final Task then(Object obj) {
        return ((TopicsSubscriber) obj).unsubscribeFromTopic(this.f21118a);
    }
}
