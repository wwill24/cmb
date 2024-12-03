package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class h0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f21119a;

    public /* synthetic */ h0(ScheduledFuture scheduledFuture) {
        this.f21119a = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.f21119a.cancel(false);
    }
}
