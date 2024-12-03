package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class e implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f39118a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f39119b;

    public /* synthetic */ e(i iVar, b bVar) {
        this.f39118a = iVar;
        this.f39119b = bVar;
    }

    public final void accept(Object obj, Object obj2) {
        i iVar = this.f39118a;
        b bVar = this.f39119b;
        ((c) ((j) obj).getService()).g(new h(iVar, (TaskCompletionSource) obj2), bVar);
    }
}
