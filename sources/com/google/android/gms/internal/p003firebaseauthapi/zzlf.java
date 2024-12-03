package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlf  reason: invalid package */
public final class zzlf {
    public static final zzwn zza;
    public static final zzwn zzb;
    public static final zzwn zzc;
    private static final byte[] zzd;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zzux zzux = zzux.NIST_P256;
        zzvc zzvc = zzvc.SHA256;
        zzud zzud = zzud.UNCOMPRESSED;
        zzwn zzwn = zzcw.zza;
        zzxo zzxo = zzxo.TINK;
        zzvc zzvc2 = zzvc;
        zzwn zzwn2 = zzwn;
        byte[] bArr2 = bArr;
        zza = zza(zzux, zzvc2, zzud, zzwn2, zzxo, bArr2);
        zzb = zza(zzux, zzvc2, zzud.COMPRESSED, zzwn2, zzxo.RAW, bArr2);
        zzc = zza(zzux, zzvc2, zzud, zzcw.zze, zzxo, bArr2);
    }

    @Deprecated
    static zzwn zza(zzux zzux, zzvc zzvc, zzud zzud, zzwn zzwn, zzxo zzxo, byte[] bArr) {
        zzui zza2 = zzuj.zza();
        zzuu zza3 = zzuv.zza();
        zza3.zza(zzux);
        zza3.zzb(zzvc);
        zza3.zzc(zzajf.zzn(bArr, 0, 0));
        zzuf zza4 = zzug.zza();
        zza4.zza(zzwn);
        zzul zzc2 = zzum.zzc();
        zzc2.zzc((zzuv) zza3.zzi());
        zzc2.zza((zzug) zza4.zzi());
        zzc2.zzb(zzud);
        zza2.zza((zzum) zzc2.zzi());
        zzwm zza5 = zzwn.zza();
        new zzjl();
        zza5.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza5.zza(zzxo);
        zza5.zzc(((zzuj) zza2.zzi()).zzo());
        return (zzwn) zza5.zzi();
    }
}
