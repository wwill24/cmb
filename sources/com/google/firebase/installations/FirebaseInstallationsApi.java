package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

public interface FirebaseInstallationsApi {
    @NonNull
    Task<Void> delete();

    @NonNull
    Task<String> getId();

    @NonNull
    Task<InstallationTokenResult> getToken(boolean z10);

    @DeferredApi
    FidListenerHandle registerFidListener(@NonNull FidListener fidListener);
}
