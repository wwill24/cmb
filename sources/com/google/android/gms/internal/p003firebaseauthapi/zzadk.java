package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadk  reason: invalid package */
final class zzadk extends zzaez {
    private final zzaac zza;

    public zzadk(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, String str2, long j10, boolean z10, boolean z11, String str3, String str4, boolean z12) {
        super(8);
        p.k(phoneMultiFactorInfo);
        p.g(str);
        this.zza = new zzaac(phoneMultiFactorInfo, str, str2, j10, z10, z11, str3, str4, z12);
    }

    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzC(this.zza, this.zzf);
    }
}
