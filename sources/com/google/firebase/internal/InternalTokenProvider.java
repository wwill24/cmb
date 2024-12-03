package com.google.firebase.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

public interface InternalTokenProvider {
    @NonNull
    Task<GetTokenResult> getAccessToken(boolean z10);

    String getUid();
}
