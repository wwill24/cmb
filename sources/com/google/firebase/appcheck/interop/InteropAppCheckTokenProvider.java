package com.google.firebase.appcheck.interop;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appcheck.AppCheckTokenResult;

public interface InteropAppCheckTokenProvider {
    void addAppCheckTokenListener(@NonNull AppCheckTokenListener appCheckTokenListener);

    @NonNull
    Task<AppCheckTokenResult> getLimitedUseToken();

    @NonNull
    Task<AppCheckTokenResult> getToken(boolean z10);

    void removeAppCheckTokenListener(@NonNull AppCheckTokenListener appCheckTokenListener);
}
