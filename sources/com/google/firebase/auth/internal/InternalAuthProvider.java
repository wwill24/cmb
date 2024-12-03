package com.google.firebase.auth.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;

public interface InternalAuthProvider extends InternalTokenProvider {
    @DeferredApi
    void addIdTokenListener(@NonNull IdTokenListener idTokenListener);

    @NonNull
    Task<GetTokenResult> getAccessToken(boolean z10);

    String getUid();

    void removeIdTokenListener(@NonNull IdTokenListener idTokenListener);
}
