package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzcd implements q {
    public final /* synthetic */ LocationSettingsRequest zza;

    public /* synthetic */ zzcd(LocationSettingsRequest locationSettingsRequest) {
        this.zza = locationSettingsRequest;
    }

    public final void accept(Object obj, Object obj2) {
        boolean z10;
        LocationSettingsRequest locationSettingsRequest = this.zza;
        zzda zzda = (zzda) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (locationSettingsRequest != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "locationSettingsRequest can't be null");
        ((zzo) zzda.getService()).zzh(locationSettingsRequest, new zzcq(taskCompletionSource), (String) null);
    }
}
