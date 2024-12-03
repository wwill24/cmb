package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbe implements q {
    public static final /* synthetic */ zzbe zza = new zzbe();

    private /* synthetic */ zzbe() {
    }

    public final void accept(Object obj, Object obj2) {
        ((zzda) obj).zzt(new LastLocationRequest.a().a(), (TaskCompletionSource) obj2);
    }
}
