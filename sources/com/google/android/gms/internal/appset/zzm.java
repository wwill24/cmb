package com.google.android.gms.internal.appset;

import com.google.android.gms.appset.zza;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzm implements q {
    public final /* synthetic */ zzp zza;

    public /* synthetic */ zzm(zzp zzp) {
        this.zza = zzp;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzg) ((zzd) obj).getService()).zzc(new zza((String) null, (String) null), new zzo(this.zza, (TaskCompletionSource) obj2));
    }
}
