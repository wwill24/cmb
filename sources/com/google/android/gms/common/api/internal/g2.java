package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;

final class g2 extends x {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p.a f38627b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g2(p.a aVar, k.a aVar2) {
        super(aVar2);
        this.f38627b = aVar;
    }

    /* access modifiers changed from: protected */
    public final void b(a.b bVar, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        this.f38627b.f38718b.accept(bVar, taskCompletionSource);
    }
}
