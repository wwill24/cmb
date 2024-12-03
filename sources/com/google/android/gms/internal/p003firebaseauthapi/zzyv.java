package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyv  reason: invalid package */
public final class zzyv {
    public static final zzyv zza = new zzyv(new zzyw());
    public static final zzyv zzb = new zzyv(new zzza());
    public static final zzyv zzc = new zzyv(new zzzc());
    public static final zzyv zzd = new zzyv(new zzzb());
    public static final zzyv zze = new zzyv(new zzyx());
    public static final zzyv zzf = new zzyv(new zzyz());
    public static final zzyv zzg = new zzyv(new zzyy());
    private final zzyu zzh;

    public zzyv(zzzd zzzd) {
        if (zzik.zzb()) {
            this.zzh = new zzyt(zzzd, (zzys) null);
        } else if (zzzk.zza()) {
            this.zzh = new zzyp(zzzd, (zzyo) null);
        } else {
            this.zzh = new zzyr(zzzd, (zzyq) null);
        }
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }
}
