package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdk  reason: invalid package */
public final class zzdk {
    public static final zzdk zza = new zzdk("SHA1");
    public static final zzdk zzb = new zzdk("SHA224");
    public static final zzdk zzc = new zzdk("SHA256");
    public static final zzdk zzd = new zzdk("SHA384");
    public static final zzdk zze = new zzdk("SHA512");
    private final String zzf;

    private zzdk(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
