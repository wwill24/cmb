package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class b implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f21098a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f21099b;

    public /* synthetic */ b(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f21098a = enhancedIntentService;
        this.f21099b = intent;
    }

    public final void onComplete(Task task) {
        this.f21098a.lambda$onStartCommand$1(this.f21099b, task);
    }
}
