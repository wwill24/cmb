package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class o<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    private final k f38697a;

    /* renamed from: b  reason: collision with root package name */
    private final Feature[] f38698b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38699c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38700d;

    protected o(@NonNull k<L> kVar, Feature[] featureArr, boolean z10, int i10) {
        this.f38697a = kVar;
        this.f38698b = featureArr;
        this.f38699c = z10;
        this.f38700d = i10;
    }

    public void a() {
        this.f38697a.a();
    }

    public k.a<L> b() {
        return this.f38697a.b();
    }

    public Feature[] c() {
        return this.f38698b;
    }

    /* access modifiers changed from: protected */
    public abstract void d(@NonNull A a10, @NonNull TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final int e() {
        return this.f38700d;
    }

    public final boolean f() {
        return this.f38699c;
    }
}
