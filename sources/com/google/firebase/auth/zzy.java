package com.google.firebase.auth;

import com.google.android.gms.internal.p003firebaseauthapi.zzac;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

final class zzy implements Continuation {
    zzy(FirebaseAuth firebaseAuth) {
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        String str;
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = exception.getMessage();
        } else {
            str = "";
        }
        return Tasks.forException(new FirebaseAuthException("INTERNAL_ERROR", zzac.zzc(str)));
    }
}
