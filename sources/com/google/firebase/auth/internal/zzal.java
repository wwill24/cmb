package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

final class zzal implements Runnable {
    final /* synthetic */ zzam zza;
    private final String zzb;

    zzal(zzam zzam, String str) {
        this.zza = zzam;
        this.zzb = p.g(str);
    }

    public final void run() {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
        if (instance.getCurrentUser() != null) {
            Task accessToken = instance.getAccessToken(true);
            zzam.zzg.g("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzak(this));
        }
    }
}
