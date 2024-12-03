package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.a;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzb  reason: invalid package */
public final class zzb extends a {
    @Deprecated
    public static Intent zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i10;
        if (!zza.zza()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != zza.zza()) {
            i10 = 0;
        } else {
            i10 = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i10);
    }
}
