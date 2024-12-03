package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import ve.a;

final class zzf implements a.C0511a {
    final /* synthetic */ zzg zza;

    public zzf(zzg zzg) {
        this.zza = zzg;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        if (str != null && zzc.zzc(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j10);
            bundle2.putBundle("params", bundle);
            this.zza.zza.onMessageTriggered(3, bundle2);
        }
    }
}
