package com.google.firebase.auth;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzai implements Continuation {
    final /* synthetic */ FirebaseUser zza;

    zzai(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zza.zza()).zzk((ActionCodeSettings) null, (String) p.k(((GetTokenResult) task.getResult()).getToken()));
    }
}
