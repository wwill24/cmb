package com.google.android.gms.internal.p002authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;

/* renamed from: com.google.android.gms.internal.auth-api.zbe  reason: invalid package */
public final class zbe implements j {
    private final Status zba;
    private final Credential zbb;

    public zbe(Status status, Credential credential) {
        this.zba = status;
        this.zbb = credential;
    }

    public final Credential getCredential() {
        return this.zbb;
    }

    public final Status getStatus() {
        return this.zba;
    }
}
