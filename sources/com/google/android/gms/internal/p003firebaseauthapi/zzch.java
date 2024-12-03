package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzch  reason: invalid package */
public final class zzch {
    private final Object zza;
    private final Object zzb;
    private final byte[] zzc;
    private final zzxo zzd;
    private final int zze;
    private final String zzf;
    private final zzbn zzg;
    private final int zzh;

    zzch(Object obj, Object obj2, byte[] bArr, int i10, zzxo zzxo, int i11, String str, zzbn zzbn) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzh = i10;
        this.zzd = zzxo;
        this.zze = i11;
        this.zzf = str;
        this.zzg = zzbn;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzbn zzb() {
        return this.zzg;
    }

    public final zzxo zzc() {
        return this.zzd;
    }

    public final Object zzd() {
        return this.zza;
    }

    public final Object zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final byte[] zzg() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzh() {
        return this.zzh;
    }
}
