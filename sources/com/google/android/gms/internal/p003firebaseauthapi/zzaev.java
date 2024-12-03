package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaev  reason: invalid package */
final class zzaev implements Runnable {
    final /* synthetic */ zzaex zza;
    final /* synthetic */ zzaew zzb;

    zzaev(zzaew zzaew, zzaex zzaex) {
        this.zzb = zzaew;
        this.zza = zzaex;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzl) {
            if (!this.zzb.zza.zzl.isEmpty()) {
                this.zza.zza((PhoneAuthProvider.OnVerificationStateChangedCallbacks) this.zzb.zza.zzl.get(0), new Object[0]);
            }
        }
    }
}
