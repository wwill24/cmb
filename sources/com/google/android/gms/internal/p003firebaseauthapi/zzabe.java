package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabe  reason: invalid package */
final class zzabe implements zzafe {
    final /* synthetic */ zzahr zza;
    final /* synthetic */ zzadx zzb;

    zzabe(zzabz zzabz, zzahr zzahr, zzadx zzadx) {
        this.zza = zzahr;
        this.zzb = zzadx;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzahr zzahr = this.zza;
        zzahs zzahs = (zzahs) obj;
        if (zzahr instanceof zzahv) {
            this.zzb.zzb(zzahs.zzc());
        } else if (zzahr instanceof zzahx) {
            this.zzb.zzp(zzahs);
        } else {
            String name = zzahr.getClass().getName();
            throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + name + ".");
        }
    }
}
