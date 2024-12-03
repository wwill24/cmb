package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbb implements q {
    public final /* synthetic */ boolean zza;

    public /* synthetic */ zzbb(boolean z10) {
        this.zza = z10;
    }

    public final void accept(Object obj, Object obj2) {
        a aVar = zzbp.zzb;
        ((zzda) obj).zzA(this.zza, (TaskCompletionSource) obj2);
    }
}
