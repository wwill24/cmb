package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GooglePlayServicesManifestException extends IllegalStateException {
    private final int zza;

    public GooglePlayServicesManifestException(int i10, @NonNull String str) {
        super(str);
        this.zza = i10;
    }
}
