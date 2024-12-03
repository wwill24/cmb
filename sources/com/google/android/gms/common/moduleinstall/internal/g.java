package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;
import je.a;

final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f39120a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f39121b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ie.a f39122c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ i f39123d;

    g(i iVar, AtomicReference atomicReference, TaskCompletionSource taskCompletionSource, ie.a aVar) {
        this.f39123d = iVar;
        this.f39120a = atomicReference;
        this.f39121b = taskCompletionSource;
        this.f39122c = aVar;
    }

    public final void b0(Status status, ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.f39120a.set(moduleInstallResponse);
        }
        w.c(status, null, this.f39121b);
        if (!status.i0() || (moduleInstallResponse != null && moduleInstallResponse.Y())) {
            this.f39123d.doUnregisterEventListener(l.c(this.f39122c, ie.a.class.getSimpleName()), 27306);
        }
    }
}
