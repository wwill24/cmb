package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface SafeParcelable extends Parcelable {
    @NonNull
    public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";
}
