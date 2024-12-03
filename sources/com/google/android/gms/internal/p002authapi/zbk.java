package com.google.android.gms.internal.p002authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;

/* renamed from: com.google.android.gms.internal.auth-api.zbk  reason: invalid package */
final class zbk extends zbd {
    private final e zba;

    zbk(e eVar) {
        this.zba = eVar;
    }

    public final void zbc(Status status) {
        this.zba.setResult(status);
    }
}
