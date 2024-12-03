package com.google.firebase.auth;

import android.net.Uri;
import androidx.annotation.NonNull;

public interface UserInfo {
    String getDisplayName();

    String getEmail();

    String getPhoneNumber();

    Uri getPhotoUrl();

    @NonNull
    String getProviderId();

    @NonNull
    String getUid();

    boolean isEmailVerified();
}
