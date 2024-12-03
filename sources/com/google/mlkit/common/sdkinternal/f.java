package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.h;

public abstract class f<T, S extends h> extends k {
    public f() {
    }

    @NonNull
    public abstract T i(@NonNull S s10) throws MlKitException;

    protected f(@NonNull n nVar) {
        super(nVar);
    }
}
