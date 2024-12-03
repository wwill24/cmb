package com.google.firebase.auth;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzaj implements Continuation {
    final /* synthetic */ ActionCodeSettings zza;
    final /* synthetic */ FirebaseUser zzb;

    zzaj(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.zzb = firebaseUser;
        this.zza = actionCodeSettings;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzb.zza()).zzk(this.zza, (String) p.k(((GetTokenResult) task.getResult()).getToken()));
    }
}
