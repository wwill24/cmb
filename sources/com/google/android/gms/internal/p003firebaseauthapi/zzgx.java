package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgx  reason: invalid package */
public final class zzgx {
    public static final zzgx zza = new zzgx("ASSUME_AES_GCM");
    public static final zzgx zzb = new zzgx("ASSUME_XCHACHA20POLY1305");
    public static final zzgx zzc = new zzgx("ASSUME_CHACHA20POLY1305");
    public static final zzgx zzd = new zzgx("ASSUME_AES_CTR_HMAC");
    public static final zzgx zze = new zzgx("ASSUME_AES_EAX");
    public static final zzgx zzf = new zzgx("ASSUME_AES_GCM_SIV");
    private final String zzg;

    private zzgx(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
