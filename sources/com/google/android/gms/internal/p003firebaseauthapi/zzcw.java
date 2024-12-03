package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcw  reason: invalid package */
public final class zzcw {
    public static final zzwn zza = zzc(16);
    public static final zzwn zzb = zzc(32);
    public static final zzwn zzc = zzb(16, 16);
    public static final zzwn zzd = zzb(32, 16);
    public static final zzwn zze;
    public static final zzwn zzf;
    public static final zzwn zzg;
    public static final zzwn zzh;

    static {
        zzvc zzvc = zzvc.SHA256;
        zze = zza(16, 16, 32, 16, zzvc);
        zzf = zza(32, 16, 32, 32, zzvc);
        zzwm zza2 = zzwn.zza();
        new zzfy();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzxo zzxo = zzxo.TINK;
        zza2.zza(zzxo);
        zzg = (zzwn) zza2.zzi();
        zzwm zza3 = zzwn.zza();
        new zzhp();
        zza3.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza3.zza(zzxo);
        zzh = (zzwn) zza3.zzi();
    }

    public static zzwn zza(int i10, int i11, int i12, int i13, zzvc zzvc) {
        zzsq zzb2 = zzsr.zzb();
        zzst zzb3 = zzsu.zzb();
        zzb3.zza(16);
        zzb2.zzb((zzsu) zzb3.zzi());
        zzb2.zza(i10);
        zzvh zzc2 = zzvi.zzc();
        zzvk zzc3 = zzvl.zzc();
        zzc3.zza(zzvc);
        zzc3.zzb(i13);
        zzc2.zzb((zzvl) zzc3.zzi());
        zzc2.zza(32);
        zzsk zza2 = zzsl.zza();
        zza2.zza((zzsr) zzb2.zzi());
        zza2.zzb((zzvi) zzc2.zzi());
        zzwm zza3 = zzwn.zza();
        zza3.zzc(((zzsl) zza2.zzi()).zzo());
        new zzdh();
        zza3.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zza3.zza(zzxo.TINK);
        return (zzwn) zza3.zzi();
    }

    public static zzwn zzb(int i10, int i11) {
        zzsz zzb2 = zzta.zzb();
        zzb2.zza(i10);
        zztc zzb3 = zztd.zzb();
        zzb3.zza(16);
        zzb2.zzb((zztd) zzb3.zzi());
        zzwm zza2 = zzwn.zza();
        zza2.zzc(((zzta) zzb2.zzi()).zzo());
        new zzec();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza2.zza(zzxo.TINK);
        return (zzwn) zza2.zzi();
    }

    public static zzwn zzc(int i10) {
        zzti zzc2 = zztj.zzc();
        zzc2.zza(i10);
        zzwm zza2 = zzwn.zza();
        zza2.zzc(((zztj) zzc2.zzi()).zzo());
        new zzet();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zza2.zza(zzxo.TINK);
        return (zzwn) zza2.zzi();
    }
}
