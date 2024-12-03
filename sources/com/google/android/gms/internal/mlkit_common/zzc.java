package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.core.content.a;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzc implements Callable {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzc(Context context) {
        this.zza = context;
    }

    public final Object call() {
        Context context = this.zza;
        int i10 = zzj.zza;
        return a.getExternalFilesDirs(context, (String) null);
    }
}
