package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzu implements Runnable {
    final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    final /* synthetic */ FirebaseAuth zzb;

    zzu(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzb = firebaseAuth;
        this.zza = authStateListener;
    }

    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
