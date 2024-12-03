package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlk  reason: invalid package */
final class zzlk implements zzyh {
    private final String zza;
    private final int zzb;
    private zztg zzc;
    private zzsi zzd;
    private int zze;
    private zzts zzf;

    zzlk(zzwn zzwn) throws GeneralSecurityException {
        String zzg = zzwn.zzg();
        this.zza = zzg;
        if (zzg.equals(zzcu.zzb)) {
            try {
                zztj zze2 = zztj.zze(zzwn.zzf(), zzajx.zza());
                this.zzc = zztg.zzd(zzcq.zzb(zzwn).zze(), zzajx.zza());
                this.zzb = zze2.zza();
            } catch (zzaks e10) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e10);
            }
        } else if (zzg.equals(zzcu.zza)) {
            try {
                zzsl zzc2 = zzsl.zzc(zzwn.zzf(), zzajx.zza());
                this.zzd = zzsi.zzd(zzcq.zzb(zzwn).zze(), zzajx.zza());
                this.zze = zzc2.zzd().zza();
                this.zzb = this.zze + zzc2.zze().zza();
            } catch (zzaks e11) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e11);
            }
        } else if (zzg.equals(zzjc.zza)) {
            try {
                zztv zze3 = zztv.zze(zzwn.zzf(), zzajx.zza());
                this.zzf = zzts.zzd(zzcq.zzb(zzwn).zze(), zzajx.zza());
                this.zzb = zze3.zza();
            } catch (zzaks e12) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e12);
            }
        } else {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(zzg)));
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzmg zzb(byte[] bArr) throws GeneralSecurityException {
        Class<zzbd> cls = zzbd.class;
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zza.equals(zzcu.zzb)) {
            zztf zzb2 = zztg.zzb();
            zzb2.zzh(this.zzc);
            zzb2.zza(zzajf.zzn(bArr, 0, this.zzb));
            return new zzmg((zzbd) zzcq.zze(this.zza, ((zztg) zzb2.zzi()).zzo(), cls));
        } else if (this.zza.equals(zzcu.zza)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
            zzsn zzb3 = zzso.zzb();
            zzb3.zzh(this.zzd.zze());
            zzajf zzajf = zzajf.zzb;
            zzb3.zza(zzajf.zzn(copyOfRange, 0, copyOfRange.length));
            zzve zzb4 = zzvf.zzb();
            zzb4.zzh(this.zzd.zzf());
            zzb4.zza(zzajf.zzn(copyOfRange2, 0, copyOfRange2.length));
            zzsh zzb5 = zzsi.zzb();
            zzb5.zzc(this.zzd.zza());
            zzb5.zza((zzso) zzb3.zzi());
            zzb5.zzb((zzvf) zzb4.zzi());
            return new zzmg((zzbd) zzcq.zze(this.zza, ((zzsi) zzb5.zzi()).zzo(), cls));
        } else if (this.zza.equals(zzjc.zza)) {
            zztr zzb6 = zzts.zzb();
            zzb6.zzh(this.zzf);
            zzb6.zza(zzajf.zzn(bArr, 0, this.zzb));
            return new zzmg((zzbj) zzcq.zze(this.zza, ((zzts) zzb6.zzi()).zzo(), zzbj.class));
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
