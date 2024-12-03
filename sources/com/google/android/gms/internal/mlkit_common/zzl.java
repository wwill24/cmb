package com.google.android.gms.internal.mlkit_common;

import android.system.Os;
import java.io.FileDescriptor;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzl implements Callable {
    public final /* synthetic */ FileDescriptor zza;

    public /* synthetic */ zzl(FileDescriptor fileDescriptor) {
        this.zza = fileDescriptor;
    }

    public final Object call() {
        return Os.fstat(this.zza);
    }
}
