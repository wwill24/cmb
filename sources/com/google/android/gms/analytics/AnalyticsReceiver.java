package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.gtm.zzfi;

public final class AnalyticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private zzfi f38167a;

    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (this.f38167a == null) {
            this.f38167a = new zzfi();
        }
        zzfi.zzb(context, intent);
    }
}
