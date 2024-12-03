package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqj  reason: invalid package */
public final class zzqj extends zzng {
    private static final zzof zza;
    private static final zzof zzb;

    static {
        Class<zzqe> cls = zzqe.class;
        zza = zzof.zzb(zzqf.zza, cls, zzpx.class);
        zzb = zzof.zzb(zzqg.zza, cls, zzcd.class);
    }

    public zzqj() {
        super(zzvf.class, new zzqh(zzcd.class));
    }

    public static void zzh(boolean z10) throws GeneralSecurityException {
        zzcq.zzg(new zzqj(), true);
        int i10 = zzrk.zza;
        zzrk.zzd(zznt.zzc());
        zznq.zza().zze(zza);
        zznq.zza().zze(zzb);
    }

    public static final void zzm(zzvf zzvf) throws GeneralSecurityException {
        zzzl.zzc(zzvf.zza(), 0);
        if (zzvf.zzg().zzd() >= 16) {
            zzn(zzvf.zzf());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: private */
    public static void zzn(zzvl zzvl) throws GeneralSecurityException {
        if (zzvl.zza() >= 10) {
            zzvc zzvc = zzvc.UNKNOWN_HASH;
            int ordinal = zzvl.zzb().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzvl.zza() > 28) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzvl.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzvl.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzvl.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzvl.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final zznf zza() {
        return new zzqi(this, zzvi.class);
    }

    public final zzwh zzb() {
        return zzwh.SYMMETRIC;
    }

    public final /* synthetic */ zzalp zzc(zzajf zzajf) throws zzaks {
        return zzvf.zze(zzajf, zzajx.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzalp zzalp) throws GeneralSecurityException {
        zzm((zzvf) zzalp);
    }

    public final int zzf() {
        return 2;
    }
}
