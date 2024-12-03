package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.common.internal.p;

public final class g {
    @NonNull
    public static <R extends j> f<R> a(@NonNull R r10, @NonNull d dVar) {
        p.l(r10, "Result must not be null");
        p.b(!r10.getStatus().i0(), "Status code must not be SUCCESS");
        r rVar = new r(dVar, r10);
        rVar.setResult(r10);
        return rVar;
    }

    @NonNull
    public static f<Status> b(@NonNull Status status, @NonNull d dVar) {
        p.l(status, "Result must not be null");
        u uVar = new u(dVar);
        uVar.setResult(status);
        return uVar;
    }
}
