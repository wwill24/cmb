package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpm  reason: invalid package */
public final class zzpm extends zzng {
    private static final zzof zza;
    private static final zzof zzb;

    static {
        Class<zzph> cls = zzph.class;
        zza = zzof.zzb(zzpi.zza, cls, zzpx.class);
        zzb = zzof.zzb(zzpj.zza, cls, zzcd.class);
    }

    zzpm() {
        super(zzrz.class, new zzpk(zzcd.class));
    }

    public static void zzm(boolean z10) throws GeneralSecurityException {
        zzcq.zzg(new zzpm(), true);
        int i10 = zzpw.zza;
        zzpw.zzc(zznt.zzc());
        zznq.zza().zze(zza);
        zznq.zza().zze(zzb);
    }

    /* access modifiers changed from: private */
    public static void zzn(zzsf zzsf) throws GeneralSecurityException {
        if (zzsf.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzsf.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzo(int i10) throws GeneralSecurityException {
        if (i10 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final zznf zza() {
        return new zzpl(this, zzsc.class);
    }

    public final zzwh zzb() {
        return zzwh.SYMMETRIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzrz.zzd(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzrz zzrz = (zzrz) zzalp;
        zzzl.zzc(zzrz.zza(), 0);
        zzo(zzrz.zzf().zzd());
        zzn(zzrz.zze());
    }
}
