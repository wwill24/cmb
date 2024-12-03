package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p003firebaseauthapi.zzahb;
import com.google.firebase.auth.internal.zzbx;

final class zzx implements zzbx {
    final /* synthetic */ FirebaseAuth zza;

    zzx(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzahb zzahb, FirebaseUser firebaseUser) {
        FirebaseAuth.zzT(this.zza, firebaseUser, zzahb, true, true);
    }

    public final void zzb(Status status) {
        int Y = status.Y();
        if (Y == 17011 || Y == 17021 || Y == 17005) {
            this.zza.signOut();
        }
    }
}
