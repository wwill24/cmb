package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.tasks.TaskCompletionSource;

final class h extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f39124a;

    h(i iVar, TaskCompletionSource taskCompletionSource) {
        this.f39124a = taskCompletionSource;
    }

    public final void onResult(Status status) {
        w.c(status, Boolean.TRUE, this.f39124a);
    }
}
