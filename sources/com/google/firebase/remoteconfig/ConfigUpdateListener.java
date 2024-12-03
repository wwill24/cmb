package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;

public interface ConfigUpdateListener {
    void onError(FirebaseRemoteConfigException firebaseRemoteConfigException);

    void onUpdate(@NonNull ConfigUpdate configUpdate);
}
