package com.google.android.gms.internal.p002authapi;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbax  reason: invalid package */
final class zbax extends zbaa {
    final /* synthetic */ TaskCompletionSource zba;

    zbax(zbay zbay, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, PendingIntent pendingIntent) {
        w.b(status, pendingIntent, this.zba);
    }
}
