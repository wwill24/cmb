package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.tasks.TaskCompletionSource;

final class p2 extends v {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ v.a f38731d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p2(v.a aVar, Feature[] featureArr, boolean z10, int i10) {
        super(featureArr, z10, i10);
        this.f38731d = aVar;
    }

    /* access modifiers changed from: protected */
    public final void b(a.b bVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f38731d.f38784a.accept(bVar, taskCompletionSource);
    }
}
