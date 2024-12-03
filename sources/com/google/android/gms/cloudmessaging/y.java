package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class y implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f38479a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f38480b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f38481c;

    public /* synthetic */ y(c cVar, String str, ScheduledFuture scheduledFuture) {
        this.f38479a = cVar;
        this.f38480b = str;
        this.f38481c = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.f38479a.e(this.f38480b, this.f38481c, task);
    }
}
