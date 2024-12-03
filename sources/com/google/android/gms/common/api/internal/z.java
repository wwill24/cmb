package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;

final class z implements f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f38827a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b0 f38828b;

    z(b0 b0Var, BasePendingResult basePendingResult) {
        this.f38828b = b0Var;
        this.f38827a = basePendingResult;
    }

    public final void a(Status status) {
        this.f38828b.f38549a.remove(this.f38827a);
    }
}
