package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class CrashlyticsAppQualitySessionsStore {
    private static final String AQS_SESSION_ID_FILENAME_PREFIX = "aqs.";
    private static final FilenameFilter AQS_SESSION_ID_FILE_FILTER = new a();
    private static final Comparator<File> FILE_RECENCY_COMPARATOR = new b();
    private String appQualitySessionId = null;
    private final FileStore fileStore;
    private String sessionId = null;

    CrashlyticsAppQualitySessionsStore(FileStore fileStore2) {
        this.fileStore = fileStore2;
    }

    private static void persist(FileStore fileStore2, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                fileStore2.getSessionFile(str, AQS_SESSION_ID_FILENAME_PREFIX + str2).createNewFile();
            } catch (IOException e10) {
                Logger.getLogger().w("Failed to persist App Quality Sessions session id.", e10);
            }
        }
    }

    static String readAqsSessionIdFile(FileStore fileStore2, @NonNull String str) {
        List<File> sessionFiles = fileStore2.getSessionFiles(str, AQS_SESSION_ID_FILE_FILTER);
        if (!sessionFiles.isEmpty()) {
            return ((File) Collections.min(sessionFiles, FILE_RECENCY_COMPARATOR)).getName().substring(4);
        }
        Logger.getLogger().w("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String getAppQualitySessionId(@NonNull String str) {
        if (Objects.equals(this.sessionId, str)) {
            return this.appQualitySessionId;
        }
        return readAqsSessionIdFile(this.fileStore, str);
    }

    public synchronized void rotateAppQualitySessionId(@NonNull String str) {
        if (!Objects.equals(this.appQualitySessionId, str)) {
            persist(this.fileStore, this.sessionId, str);
            this.appQualitySessionId = str;
        }
    }

    public synchronized void rotateSessionId(String str) {
        if (!Objects.equals(this.sessionId, str)) {
            persist(this.fileStore, str, this.appQualitySessionId);
            this.sessionId = str;
        }
    }
}
