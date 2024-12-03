package com.google.firebase;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public class FirebaseException extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseException(@NonNull String str) {
        super(str);
        p.h(str, "Detail message must not be empty");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseException(@NonNull String str, @NonNull Throwable th2) {
        super(str, th2);
        p.h(str, "Detail message must not be empty");
    }
}
