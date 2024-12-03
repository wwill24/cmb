package com.google.firebase.auth.internal;

import android.util.Base64;
import com.google.android.gms.internal.p003firebaseauthapi.zzagx;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import java.security.MessageDigest;

final class zzb implements Continuation {
    final /* synthetic */ String zza;
    final /* synthetic */ IntegrityManager zzb;
    final /* synthetic */ zzf zzc;

    zzb(zzf zzf, String str, IntegrityManager integrityManager) {
        this.zzc = zzf;
        this.zza = str;
        this.zzb = integrityManager;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            this.zzc.zzc = ((zzagx) task.getResult()).zzb();
            return this.zzb.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(((zzagx) task.getResult()).zzb())).setNonce(new String(Base64.encode(MessageDigest.getInstance("SHA-256").digest(this.zza.getBytes("UTF-8")), 11))).build());
        }
        String unused = zzf.zza;
        "Problem retrieving Play Integrity producer project:  ".concat(String.valueOf(task.getException().getMessage()));
        return Tasks.forException(task.getException());
    }
}
