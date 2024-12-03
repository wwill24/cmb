package com.google.firebase.auth;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzak implements Continuation {
    final /* synthetic */ String zza;
    final /* synthetic */ ActionCodeSettings zzb;
    final /* synthetic */ FirebaseUser zzc;

    zzak(FirebaseUser firebaseUser, String str, ActionCodeSettings actionCodeSettings) {
        this.zzc = firebaseUser;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzc.zza()).zzu((String) p.k(((GetTokenResult) task.getResult()).getToken()), this.zza, this.zzb);
    }
}
