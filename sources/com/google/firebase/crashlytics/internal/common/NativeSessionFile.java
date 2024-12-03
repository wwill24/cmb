package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;

interface NativeSessionFile {
    CrashlyticsReport.FilesPayload.File asFilePayload();

    @NonNull
    String getReportsEndpointFilename();

    InputStream getStream();
}
