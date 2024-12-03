package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzes  reason: invalid package */
final class zzes extends zznf {
    final /* synthetic */ zzet zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzes(zzet zzet, Class cls) {
        super(cls);
        this.zza = zzet;
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        zztf zzb = zztg.zzb();
        byte[] zzb2 = zzor.zzb(((zztj) zzalp).zza());
        zzb.zza(zzajf.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(0);
        return (zztg) zzb.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zztj.zze(zzajf, zzajx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzhl.zza);
        zzev zzev = new zzev((zzeu) null);
        zzev.zza(12);
        zzev.zzb(16);
        zzev.zzc(16);
        zzew zzew = zzew.zzc;
        zzev.zzd(zzew);
        hashMap.put("AES128_GCM_RAW", zzev.zze());
        hashMap.put("AES256_GCM", zzhl.zzb);
        zzev zzev2 = new zzev((zzeu) null);
        zzev2.zza(12);
        zzev2.zzb(32);
        zzev2.zzc(16);
        zzev2.zzd(zzew);
        hashMap.put("AES256_GCM_RAW", zzev2.zze());
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zzzl.zzb(((zztj) zzalp).zza());
    }
}
