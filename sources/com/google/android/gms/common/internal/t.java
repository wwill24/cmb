package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", explanation = "Use canonical fakes instead.", link = "go/gmscore-restrictedinheritance")
public interface t {
    @NonNull
    Task<Void> a(@NonNull TelemetryData telemetryData);
}
