package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class f0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f21114a;

    public /* synthetic */ f0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f21114a = bindRequest;
    }

    public final void onComplete(Task task) {
        this.f21114a.finish();
    }
}
