package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class w implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f38476a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f38477b;

    public /* synthetic */ w(c cVar, Bundle bundle) {
        this.f38476a = cVar;
        this.f38477b = bundle;
    }

    public final Object then(Task task) {
        return this.f38476a.c(this.f38477b, task);
    }
}
