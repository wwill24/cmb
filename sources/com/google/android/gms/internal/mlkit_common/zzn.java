package com.google.android.gms.internal.mlkit_common;

import java.io.FileDescriptor;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzn implements Callable {
    public final /* synthetic */ FileDescriptor zza;

    public /* synthetic */ zzn(FileDescriptor fileDescriptor) {
        this.zza = fileDescriptor;
    }

    public final Object call() {
        return zzo.zze(zzo.zzc.invoke(zzo.zzg, new Object[]{this.zza}));
    }
}
