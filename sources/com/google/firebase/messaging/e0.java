package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class e0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f21113a;

    public /* synthetic */ e0(Intent intent) {
        this.f21113a = intent;
    }

    public final void onComplete(Task task) {
        WakeLockHolder.completeWakefulIntent(this.f21113a);
    }
}
