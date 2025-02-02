package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.List;

public abstract class MultiFactor {
    @NonNull
    public abstract Task<Void> enroll(@NonNull MultiFactorAssertion multiFactorAssertion, String str);

    @NonNull
    public abstract List<MultiFactorInfo> getEnrolledFactors();

    @NonNull
    public abstract Task<MultiFactorSession> getSession();

    @NonNull
    public abstract Task<Void> unenroll(@NonNull MultiFactorInfo multiFactorInfo);

    @NonNull
    public abstract Task<Void> unenroll(@NonNull String str);
}
