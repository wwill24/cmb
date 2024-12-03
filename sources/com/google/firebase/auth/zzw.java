package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzw implements Runnable {
    final /* synthetic */ FirebaseAuth zza;

    zzw(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void run() {
        for (FirebaseAuth.AuthStateListener onAuthStateChanged : this.zza.zze) {
            onAuthStateChanged.onAuthStateChanged(this.zza);
        }
    }
}
