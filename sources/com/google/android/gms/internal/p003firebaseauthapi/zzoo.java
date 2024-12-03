package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoo  reason: invalid package */
public final class zzoo implements zzot {
    private final String zza;
    private final zzzo zzb;
    private final zzajf zzc;
    private final zzwh zzd;
    private final zzxo zze;
    private final Integer zzf;

    private zzoo(String str, zzajf zzajf, zzwh zzwh, zzxo zzxo, Integer num) {
        this.zza = str;
        this.zzb = zzpd.zzb(str);
        this.zzc = zzajf;
        this.zzd = zzwh;
        this.zze = zzxo;
        this.zzf = num;
    }

    public static zzoo zza(String str, zzajf zzajf, zzwh zzwh, zzxo zzxo, Integer num) throws GeneralSecurityException {
        if (zzxo == zzxo.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzoo(str, zzajf, zzwh, zzxo, num);
    }

    public final zzwh zzb() {
        return this.zzd;
    }

    public final zzxo zzc() {
        return this.zze;
    }

    public final zzzo zzd() {
        return this.zzb;
    }

    public final zzajf zze() {
        return this.zzc;
    }

    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
