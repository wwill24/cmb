package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;

interface CrashlyticsLifecycleEvents {
    void onBeginSession(@NonNull String str, long j10);

    void onCustomKey(String str, String str2);

    void onLog(long j10, String str);

    void onUserId(String str);
}
