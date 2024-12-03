package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm  reason: invalid package */
public final class zzqm {
    public static final zzqm zza = new zzqm("SHA1");
    public static final zzqm zzb = new zzqm("SHA224");
    public static final zzqm zzc = new zzqm("SHA256");
    public static final zzqm zzd = new zzqm("SHA384");
    public static final zzqm zze = new zzqm("SHA512");
    private final String zzf;

    private zzqm(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
