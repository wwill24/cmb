package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.p;

final class f3 {

    /* renamed from: a  reason: collision with root package name */
    private final int f38602a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f38603b;

    f3(ConnectionResult connectionResult, int i10) {
        p.k(connectionResult);
        this.f38603b = connectionResult;
        this.f38602a = i10;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f38602a;
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.f38603b;
    }
}
