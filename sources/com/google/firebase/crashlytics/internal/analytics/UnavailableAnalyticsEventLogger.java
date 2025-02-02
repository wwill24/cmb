package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;

public class UnavailableAnalyticsEventLogger implements AnalyticsEventLogger {
    public void logEvent(@NonNull String str, Bundle bundle) {
        Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
