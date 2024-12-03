package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjr  reason: invalid package */
public final class zzjr {
    private zzjs zza;
    private zzjt zzb;
    private zzju zzc;
    private zzce zzd;
    private zzjv zze;
    private zzzo zzf;

    private zzjr() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        throw null;
    }

    /* synthetic */ zzjr(zzjq zzjq) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = zzjv.zzc;
        this.zzf = null;
    }

    public final zzjr zza(zzjs zzjs) {
        this.zza = zzjs;
        return this;
    }

    public final zzjr zzb(zzce zzce) throws GeneralSecurityException {
        if (zzjx.zza.contains(zzce)) {
            this.zzd = zzce;
            return this;
        }
        String obj = zzce.toString();
        throw new GeneralSecurityException("Invalid DEM parameters " + obj + "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
    }

    public final zzjr zzc(zzjt zzjt) {
        this.zzb = zzjt;
        return this;
    }

    public final zzjr zzd(zzju zzju) {
        this.zzc = zzju;
        return this;
    }

    public final zzjr zze(zzzo zzzo) {
        if (zzzo.zza() == 0) {
            this.zzf = null;
            return this;
        }
        this.zzf = zzzo;
        return this;
    }

    public final zzjr zzf(zzjv zzjv) {
        this.zze = zzjv;
        return this;
    }

    public final zzjx zzg() throws GeneralSecurityException {
        zzjs zzjs = this.zza;
        if (zzjs == null) {
            throw new GeneralSecurityException("Elliptic curve type is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("Hash type is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("DEM parameters are not set");
        } else if (this.zze != null) {
            zzjs zzjs2 = zzjs.zzd;
            if (zzjs != zzjs2 && this.zzc == null) {
                throw new GeneralSecurityException("Point format is not set");
            } else if (zzjs != zzjs2 || this.zzc == null) {
                return new zzjx(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (zzjw) null);
            } else {
                throw new GeneralSecurityException("For Curve25519 point format must not be set");
            }
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }
}
