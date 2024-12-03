package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgw  reason: invalid package */
public final class zzgw {
    private String zza;
    private zzgx zzb;
    private zzcx zzc;

    private zzgw() {
    }

    /* synthetic */ zzgw(zzgv zzgv) {
    }

    public final zzgw zza(zzcx zzcx) {
        this.zzc = zzcx;
        return this;
    }

    public final zzgw zzb(zzgx zzgx) {
        this.zzb = zzgx;
        return this;
    }

    public final zzgw zzc(String str) {
        this.zza = str;
        return this;
    }

    public final zzgz zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            zzgx zzgx = this.zzb;
            if (zzgx != null) {
                zzcx zzcx = this.zzc;
                if (zzcx == null) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must be set");
                } else if (zzcx.zza()) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must note have ID Requirements");
                } else if ((zzgx.equals(zzgx.zza) && (zzcx instanceof zzey)) || ((zzgx.equals(zzgx.zzc) && (zzcx instanceof zzga)) || ((zzgx.equals(zzgx.zzb) && (zzcx instanceof zzhr)) || ((zzgx.equals(zzgx.zzd) && (zzcx instanceof zzdn)) || ((zzgx.equals(zzgx.zze) && (zzcx instanceof zzeh)) || (zzgx.equals(zzgx.zzf) && (zzcx instanceof zzfp))))))) {
                    return new zzgz(this.zza, this.zzb, this.zzc, (zzgy) null);
                } else {
                    String zzgx2 = this.zzb.toString();
                    String valueOf = String.valueOf(this.zzc);
                    throw new GeneralSecurityException("Cannot use parsing strategy " + zzgx2 + " when new keys are picked according to " + valueOf + ".");
                }
            } else {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
        } else {
            throw new GeneralSecurityException("kekUri must be set");
        }
    }
}
