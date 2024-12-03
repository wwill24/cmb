package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzba implements q {
    public static final /* synthetic */ zzba zza = new zzba();

    private /* synthetic */ zzba() {
    }

    public final void accept(Object obj, Object obj2) {
        a aVar = zzbp.zzb;
        ((TaskCompletionSource) obj2).setResult(((zzda) obj).zzp());
    }
}
