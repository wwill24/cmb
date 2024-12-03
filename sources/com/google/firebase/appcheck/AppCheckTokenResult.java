package com.google.firebase.appcheck;

import androidx.annotation.NonNull;

public abstract class AppCheckTokenResult {
    public abstract Exception getError();

    @NonNull
    public abstract String getToken();
}
