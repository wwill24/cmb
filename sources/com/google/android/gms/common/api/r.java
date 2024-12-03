package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.j;

final class r<R extends j> extends BasePendingResult<R> {

    /* renamed from: a  reason: collision with root package name */
    private final j f38861a;

    public r(d dVar, j jVar) {
        super(dVar);
        this.f38861a = jVar;
    }

    /* access modifiers changed from: protected */
    public final R createFailedResult(Status status) {
        return this.f38861a;
    }
}
