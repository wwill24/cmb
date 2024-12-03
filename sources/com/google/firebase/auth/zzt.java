package com.google.firebase.auth;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzahs;
import com.google.android.gms.internal.p003firebaseauthapi.zzahy;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzbw;

final class zzt implements Continuation {
    final /* synthetic */ FirebaseAuth zza;

    zzt(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) p.k(task.getException()));
        }
        zzahs zzahs = (zzahs) task.getResult();
        if (zzahs instanceof zzahy) {
            zzahy zzahy = (zzahy) zzahs;
            return Tasks.forResult(new zzbw(p.g(zzahy.zzi()), p.g(zzahy.zzh()), zzahy.zze(), zzahy.zzd(), zzahy.zzf(), p.g(zzahy.zzc()), this.zza));
        }
        String name = zzahs.getClass().getName();
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + name + ".");
    }
}
