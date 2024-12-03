package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.leanplum.internal.Constants;
import ve.a;
import we.p;

final class zzd implements a.C0511a {
    final /* synthetic */ zze zza;

    public zzd(zze zze) {
        this.zza = zze;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            int i10 = zzc.zza;
            String a10 = p.a(str2);
            if (a10 != null) {
                str2 = a10;
            }
            bundle2.putString(Constants.Params.API_EVENTS_STATE, str2);
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
