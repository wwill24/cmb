package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;

public class UserRecoverableException extends Exception {
    private final Intent zza;

    public UserRecoverableException(@NonNull String str, @NonNull Intent intent) {
        super(str);
        this.zza = intent;
    }
}
