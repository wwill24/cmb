package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

public class SessionReportingCoordinator implements CrashlyticsLifecycleEvents {
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final int EVENT_THREAD_IMPORTANCE = 4;
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
    private final CrashlyticsReportDataCapture dataCapture;
    private final IdManager idManager;
    private final LogFileManager logFileManager;
    private final UserMetadata reportMetadata;
    private final CrashlyticsReportPersistence reportPersistence;
    private final DataTransportCrashlyticsReportSender reportsSender;

    SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager2, UserMetadata userMetadata, IdManager idManager2) {
        this.dataCapture = crashlyticsReportDataCapture;
        this.reportPersistence = crashlyticsReportPersistence;
        this.reportsSender = dataTransportCrashlyticsReportSender;
        this.logFileManager = logFileManager2;
        this.reportMetadata = userMetadata;
        this.idManager = idManager2;
    }

    private CrashlyticsReport.Session.Event addLogsAndCustomKeysToEvent(CrashlyticsReport.Session.Event event) {
        return addLogsAndCustomKeysToEvent(event, this.logFileManager, this.reportMetadata);
    }

    private static CrashlyticsReport.ApplicationExitInfo convertApplicationExitInfo(ApplicationExitInfo applicationExitInfo) {
        String str = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                str = convertInputStreamToString(traceInputStream);
            }
        } catch (IOException e10) {
            Logger logger = Logger.getLogger();
            logger.w("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e10);
        }
        return CrashlyticsReport.ApplicationExitInfo.builder().setImportance(applicationExitInfo.getImportance()).setProcessName(applicationExitInfo.getProcessName()).setReasonCode(applicationExitInfo.getReason()).setTimestamp(applicationExitInfo.getTimestamp()).setPid(applicationExitInfo.getPid()).setPss(applicationExitInfo.getPss()).setRss(applicationExitInfo.getRss()).setTraceFile(str).build();
    }

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static SessionReportingCoordinator create(Context context, IdManager idManager2, FileStore fileStore, AppData appData, LogFileManager logFileManager2, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        SettingsProvider settingsProvider2 = settingsProvider;
        FileStore fileStore2 = fileStore;
        Context context2 = context;
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager2, appData, stackTraceTrimmingStrategy, settingsProvider), new CrashlyticsReportPersistence(fileStore, settingsProvider2, crashlyticsAppQualitySessionsSubscriber), DataTransportCrashlyticsReportSender.create(context, settingsProvider2, onDemandCounter), logFileManager2, userMetadata, idManager2);
    }

    private CrashlyticsReportWithSessionId ensureHasFid(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        if (crashlyticsReportWithSessionId.getReport().getFirebaseInstallationId() != null) {
            return crashlyticsReportWithSessionId;
        }
        return CrashlyticsReportWithSessionId.create(crashlyticsReportWithSessionId.getReport().withFirebaseInstallationId(this.idManager.fetchTrueFid()), crashlyticsReportWithSessionId.getSessionId(), crashlyticsReportWithSessionId.getReportFile());
    }

    private ApplicationExitInfo findRelevantApplicationExitInfo(String str, List<ApplicationExitInfo> list) {
        long startTimestampMillis = this.reportPersistence.getStartTimestampMillis(str);
        for (ApplicationExitInfo next : list) {
            if (next.getTimestamp() < startTimestampMillis) {
                return null;
            }
            if (next.getReason() == 6) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    private static List<CrashlyticsReport.CustomAttribute> getSortedCustomAttributes(@NonNull Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey((String) next.getKey()).setValue((String) next.getValue()).build());
        }
        Collections.sort(arrayList, new e());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public boolean onReportSendComplete(@NonNull Task<CrashlyticsReportWithSessionId> task) {
        if (task.isSuccessful()) {
            CrashlyticsReportWithSessionId result = task.getResult();
            Logger logger = Logger.getLogger();
            logger.d("Crashlytics report successfully enqueued to DataTransport: " + result.getSessionId());
            File reportFile = result.getReportFile();
            if (reportFile.delete()) {
                Logger logger2 = Logger.getLogger();
                logger2.d("Deleted report file: " + reportFile.getPath());
                return true;
            }
            Logger logger3 = Logger.getLogger();
            logger3.w("Crashlytics could not delete report file: " + reportFile.getPath());
            return true;
        }
        Logger.getLogger().w("Crashlytics report could not be enqueued to DataTransport", task.getException());
        return false;
    }

    private void persistEvent(@NonNull Throwable th2, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j10, boolean z10) {
        boolean equals = str2.equals(EVENT_TYPE_CRASH);
        CrashlyticsReport.Session.Event captureEventData = this.dataCapture.captureEventData(th2, thread, str2, j10, 4, 8, z10);
        String str3 = str;
        this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(captureEventData), str, equals);
    }

    public void finalizeSessionWithNativeEvent(@NonNull String str, @NonNull List<NativeSessionFile> list, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        Logger.getLogger().d("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        for (NativeSessionFile asFilePayload : list) {
            CrashlyticsReport.FilesPayload.File asFilePayload2 = asFilePayload.asFilePayload();
            if (asFilePayload2 != null) {
                arrayList.add(asFilePayload2);
            }
        }
        this.reportPersistence.finalizeSessionWithNativeEvent(str, CrashlyticsReport.FilesPayload.builder().setFiles(ImmutableList.from(arrayList)).build(), applicationExitInfo);
    }

    public void finalizeSessions(long j10, String str) {
        this.reportPersistence.finalizeReports(str, j10);
    }

    public boolean hasReportsToSend() {
        return this.reportPersistence.hasFinalizedReports();
    }

    public SortedSet<String> listSortedOpenSessionIds() {
        return this.reportPersistence.getOpenSessionIds();
    }

    public void onBeginSession(@NonNull String str, long j10) {
        this.reportPersistence.persistReport(this.dataCapture.captureReportData(str, j10));
    }

    public void onCustomKey(String str, String str2) {
        this.reportMetadata.setCustomKey(str, str2);
    }

    public void onLog(long j10, String str) {
        this.logFileManager.writeToLog(j10, str);
    }

    public void onUserId(String str) {
        this.reportMetadata.setUserId(str);
    }

    public void persistFatalEvent(@NonNull Throwable th2, @NonNull Thread thread, @NonNull String str, long j10) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting fatal event for session " + str);
        persistEvent(th2, thread, str, EVENT_TYPE_CRASH, j10, true);
    }

    public void persistNonFatalEvent(@NonNull Throwable th2, @NonNull Thread thread, @NonNull String str, long j10) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting non-fatal event for session " + str);
        persistEvent(th2, thread, str, "error", j10, false);
    }

    public void persistRelevantAppExitInfoEvent(String str, List<ApplicationExitInfo> list, LogFileManager logFileManager2, UserMetadata userMetadata) {
        ApplicationExitInfo findRelevantApplicationExitInfo = findRelevantApplicationExitInfo(str, list);
        if (findRelevantApplicationExitInfo == null) {
            Logger logger = Logger.getLogger();
            logger.v("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        CrashlyticsReport.Session.Event captureAnrEventData = this.dataCapture.captureAnrEventData(convertApplicationExitInfo(findRelevantApplicationExitInfo));
        Logger logger2 = Logger.getLogger();
        logger2.d("Persisting anr for session " + str);
        this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(captureAnrEventData, logFileManager2, userMetadata), str, true);
    }

    public void removeAllReports() {
        this.reportPersistence.deleteAllReports();
    }

    public Task<Void> sendReports(@NonNull Executor executor) {
        return sendReports(executor, (String) null);
    }

    private CrashlyticsReport.Session.Event addLogsAndCustomKeysToEvent(CrashlyticsReport.Session.Event event, LogFileManager logFileManager2, UserMetadata userMetadata) {
        CrashlyticsReport.Session.Event.Builder builder = event.toBuilder();
        String logString = logFileManager2.getLogString();
        if (logString != null) {
            builder.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(logString).build());
        } else {
            Logger.getLogger().v("No log data to include with this event.");
        }
        List<CrashlyticsReport.CustomAttribute> sortedCustomAttributes = getSortedCustomAttributes(userMetadata.getCustomKeys());
        List<CrashlyticsReport.CustomAttribute> sortedCustomAttributes2 = getSortedCustomAttributes(userMetadata.getInternalKeys());
        if (!sortedCustomAttributes.isEmpty() || !sortedCustomAttributes2.isEmpty()) {
            builder.setApp(event.getApp().toBuilder().setCustomAttributes(ImmutableList.from(sortedCustomAttributes)).setInternalKeys(ImmutableList.from(sortedCustomAttributes2)).build());
        }
        return builder.build();
    }

    public Task<Void> sendReports(@NonNull Executor executor, String str) {
        List<CrashlyticsReportWithSessionId> loadFinalizedReports = this.reportPersistence.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId next : loadFinalizedReports) {
            if (str == null || str.equals(next.getSessionId())) {
                arrayList.add(this.reportsSender.enqueueReport(ensureHasFid(next), str != null).continueWith(executor, new f(this)));
            }
        }
        return Tasks.whenAll((Collection<? extends Task<?>>) arrayList);
    }
}
