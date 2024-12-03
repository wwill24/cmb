package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

final class f2 extends o {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ p.a f38601e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f2(p.a aVar, k kVar, Feature[] featureArr, boolean z10, int i10) {
        super(kVar, featureArr, z10, i10);
        this.f38601e = aVar;
    }

    /* access modifiers changed from: protected */
    public final void d(a.b bVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.f38601e.f38717a.accept(bVar, taskCompletionSource);
    }
}
