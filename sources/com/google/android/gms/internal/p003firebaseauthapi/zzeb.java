package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeb  reason: invalid package */
final class zzeb extends zznf {
    final /* synthetic */ zzec zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeb(zzec zzec, Class cls) {
        super(cls);
        this.zza = zzec;
    }

    public final /* bridge */ /* synthetic */ zzalp zza(zzalp zzalp) throws GeneralSecurityException {
        zzta zzta = (zzta) zzalp;
        zzsw zzb = zzsx.zzb();
        byte[] zzb2 = zzor.zzb(zzta.zza());
        zzb.zza(zzajf.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(zzta.zze());
        zzb.zzc(0);
        return (zzsx) zzb.zzi();
    }

    public final /* synthetic */ zzalp zzb(zzajf zzajf) throws zzaks {
        return zzta.zzd(zzajf, zzajx.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzhl.zzc);
        zzee zzee = new zzee((zzed) null);
        zzee.zza(16);
        zzee.zzb(16);
        zzee.zzc(16);
        zzef zzef = zzef.zzc;
        zzee.zzd(zzef);
        hashMap.put("AES128_EAX_RAW", zzee.zze());
        hashMap.put("AES256_EAX", zzhl.zzd);
        zzee zzee2 = new zzee((zzed) null);
        zzee2.zza(16);
        zzee2.zzb(32);
        zzee2.zzc(16);
        zzee2.zzd(zzef);
        hashMap.put("AES256_EAX_RAW", zzee2.zze());
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzalp zzalp) throws GeneralSecurityException {
        zzta zzta = (zzta) zzalp;
        zzzl.zzb(zzta.zza());
        if (zzta.zze().zza() != 12 && zzta.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
