package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

final class zzak implements OnFailureListener {
    final /* synthetic */ zzal zza;

    zzak(zzal zzal) {
        this.zza = zzal;
    }

    public final void onFailure(Exception exc) {
        if (exc instanceof FirebaseNetworkException) {
            zzam.zzg.g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zza.zza.zzd();
        }
    }
}
