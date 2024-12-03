package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;

final class c3 implements d.c {

    /* renamed from: a  reason: collision with root package name */
    public final int f38566a;

    /* renamed from: b  reason: collision with root package name */
    public final d f38567b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c f38568c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ d3 f38569d;

    public c3(d3 d3Var, int i10, d dVar, d.c cVar) {
        this.f38569d = d3Var;
        this.f38566a = i10;
        this.f38567b = dVar;
        this.f38568c = cVar;
    }

    public final void g(@NonNull ConnectionResult connectionResult) {
        "beginFailureResolution for ".concat(String.valueOf(connectionResult));
        this.f38569d.h(connectionResult, this.f38566a);
    }
}
