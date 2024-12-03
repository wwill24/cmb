package com.google.firebase.auth;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzahb;
import com.google.firebase.auth.internal.zzg;

class zzac implements zzg {
    final /* synthetic */ FirebaseAuth zza;

    zzac(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(zzahb zzahb, FirebaseUser firebaseUser) {
        p.k(zzahb);
        p.k(firebaseUser);
        firebaseUser.zzh(zzahb);
        this.zza.zzQ(firebaseUser, zzahb, true);
    }
}
