package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzahb;
import com.google.firebase.auth.internal.zzbx;

final class zzad implements zzbx {
    final /* synthetic */ FirebaseAuth zza;

    zzad(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzahb zzahb, FirebaseUser firebaseUser) {
        p.k(zzahb);
        p.k(firebaseUser);
        firebaseUser.zzh(zzahb);
        FirebaseAuth.zzT(this.zza, firebaseUser, zzahb, true, true);
    }

    public final void zzb(Status status) {
        if (status.Y() == 17011 || status.Y() == 17021 || status.Y() == 17005 || status.Y() == 17091) {
            this.zza.signOut();
        }
    }
}
