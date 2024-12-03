package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.a;

final class zzeg extends zzei {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze = a.e.API_PRIORITY_OTHER;

    /* synthetic */ zzeg(byte[] bArr, int i10, int i11, boolean z10, zzef zzef) {
        super((zzeh) null);
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i10) throws zzfa {
        int i11 = this.zze;
        this.zze = 0;
        int i12 = this.zzc + this.zzd;
        this.zzc = i12;
        if (i12 > 0) {
            this.zzd = i12;
            this.zzc = i12 - i12;
        } else {
            this.zzd = 0;
        }
        return i11;
    }
}
