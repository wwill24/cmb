package com.google.firebase.auth.internal;

import androidx.annotation.NonNull;
import com.google.firebase.internal.InternalTokenResult;

public interface IdTokenListener {
    void onIdTokenChanged(@NonNull InternalTokenResult internalTokenResult);
}
