package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class x<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    private final k.a f38801a;

    protected x(@NonNull k.a<L> aVar) {
        this.f38801a = aVar;
    }

    @NonNull
    public k.a<L> a() {
        return this.f38801a;
    }

    /* access modifiers changed from: protected */
    public abstract void b(@NonNull A a10, @NonNull TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
