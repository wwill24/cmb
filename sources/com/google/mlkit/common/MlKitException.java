package com.google.mlkit.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public class MlKitException extends Exception {
    private final int zza;

    public MlKitException(@NonNull String str, int i10) {
        super(p.h(str, "Provided message must not be empty."));
        this.zza = i10;
    }

    public int a() {
        return this.zza;
    }

    public MlKitException(@NonNull String str, int i10, Throwable th2) {
        super(p.h(str, "Provided message must not be empty."), th2);
        this.zza = i10;
    }
}
