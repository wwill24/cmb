package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.b;

public abstract class MultiFactorInfo extends AbstractSafeParcelable {
    @NonNull
    public static final String FACTOR_ID_KEY = "factorIdKey";

    public abstract String getDisplayName();

    public abstract long getEnrollmentTimestamp();

    @NonNull
    public abstract String getFactorId();

    @NonNull
    public abstract String getUid();

    public abstract b toJson();
}
