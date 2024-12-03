package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import fe.b;
import n1.a;

public final class zzax {
    private static zzax zza;
    private boolean zzb = false;
    private BroadcastReceiver zzc;

    private zzax() {
    }

    public static zzax zza() {
        if (zza == null) {
            zza = new zzax();
        }
        return zza;
    }

    static void zze(Context context) {
        zzax zzax = zza;
        zzax.zzb = false;
        if (zzax.zzc != null) {
            a.b(context).e(zza.zzc);
        }
        zza.zzc = null;
    }

    private final void zzh(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.zzc = broadcastReceiver;
        a.b(activity).c(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    private static final AuthCredential zzi(Intent intent) {
        p.k(intent);
        zzaic zzaic = (zzaic) b.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzaic.CREATOR);
        zzaic.zze(true);
        return zze.zzb(zzaic);
    }

    public final boolean zzf(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (this.zzb) {
            return false;
        }
        zzh(activity, new zzav(this, activity, taskCompletionSource, firebaseAuth, firebaseUser));
        this.zzb = true;
        return true;
    }

    public final boolean zzg(Activity activity, TaskCompletionSource taskCompletionSource) {
        if (this.zzb) {
            return false;
        }
        zzh(activity, new zzaw(this, activity, taskCompletionSource));
        this.zzb = true;
        return true;
    }
}
