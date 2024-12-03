package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class a implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsAppQualitySessionsStore.AQS_SESSION_ID_FILENAME_PREFIX);
    }
}
