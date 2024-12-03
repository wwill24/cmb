package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdo  reason: invalid package */
public final /* synthetic */ class zzdo implements zznz {
    public static final /* synthetic */ zzdo zza = new zzdo();

    private /* synthetic */ zzdo() {
    }

    public final zzot zza(zzce zzce) {
        zzvc zzvc;
        zzxo zzxo;
        zzdn zzdn = (zzdn) zzce;
        int i10 = zzds.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzsk zza3 = zzsl.zza();
        zzsq zzb = zzsr.zzb();
        zzst zzb2 = zzsu.zzb();
        zzb2.zza(zzdn.zzd());
        zzb.zzb((zzsu) zzb2.zzi());
        zzb.zza(zzdn.zzb());
        zza3.zza((zzsr) zzb.zzi());
        zzvh zzc = zzvi.zzc();
        zzvk zzc2 = zzvl.zzc();
        zzc2.zzb(zzdn.zze());
        zzdk zzg = zzdn.zzg();
        if (zzdk.zza.equals(zzg)) {
            zzvc = zzvc.SHA1;
        } else if (zzdk.zzb.equals(zzg)) {
            zzvc = zzvc.SHA224;
        } else if (zzdk.zzc.equals(zzg)) {
            zzvc = zzvc.SHA256;
        } else if (zzdk.zzd.equals(zzg)) {
            zzvc = zzvc.SHA384;
        } else if (zzdk.zze.equals(zzg)) {
            zzvc = zzvc.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzg)));
        }
        zzc2.zza(zzvc);
        zzc.zzb((zzvl) zzc2.zzi());
        zzc.zza(zzdn.zzc());
        zza3.zzb((zzvi) zzc.zzi());
        zza2.zzc(((zzsl) zza3.zzi()).zzo());
        zzdl zzh = zzdn.zzh();
        if (zzdl.zza.equals(zzh)) {
            zzxo = zzxo.TINK;
        } else if (zzdl.zzb.equals(zzh)) {
            zzxo = zzxo.CRUNCHY;
        } else if (zzdl.zzc.equals(zzh)) {
            zzxo = zzxo.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzh)));
        }
        zza2.zza(zzxo);
        return zzop.zzb((zzwn) zza2.zzi());
    }
}
