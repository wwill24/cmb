package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public final /* synthetic */ class zzbx implements q {
    public final /* synthetic */ List zza;

    public /* synthetic */ zzbx(List list) {
        this.zza = list;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzda) obj).zzy(this.zza, (TaskCompletionSource) obj2);
    }
}
