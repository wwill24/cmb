package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.p;

public final class zzbv implements j {
    private final Status zza;
    private final String zzb;

    public zzbv(Status status) {
        this.zza = (Status) p.k(status);
        this.zzb = "";
    }

    public final String getSpatulaHeader() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public zzbv(String str) {
        this.zzb = (String) p.k(str);
        this.zza = Status.f38500g;
    }
}
