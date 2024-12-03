package com.google.firebase.auth.internal;

import android.net.Uri;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appcheck.AppCheckTokenResult;

public final /* synthetic */ class zzaz implements Continuation {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzaz(Uri uri) {
        this.zza = uri;
    }

    public final Object then(Task task) {
        int i10 = GenericIdpActivity.zzb;
        Uri.Builder buildUpon = this.zza.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.getError() != null) {
                "Error getting App Check token; using placeholder token instead. Error: ".concat(String.valueOf(appCheckTokenResult.getError()));
            }
            buildUpon.fragment("fac=".concat(String.valueOf(appCheckTokenResult.getToken())));
        } else {
            "Unexpected error getting App Check token: ".concat(String.valueOf(task.getException().getMessage()));
        }
        return buildUpon.build();
    }
}
