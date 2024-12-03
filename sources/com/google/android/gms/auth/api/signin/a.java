package com.google.android.gms.auth.api.signin;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public final class a {
    @NonNull
    public static b a(@NonNull Context context, @NonNull GoogleSignInOptions googleSignInOptions) {
        return new b(context, (GoogleSignInOptions) p.k(googleSignInOptions));
    }
}
