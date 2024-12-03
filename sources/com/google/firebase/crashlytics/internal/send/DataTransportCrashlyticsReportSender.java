package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import cd.b;
import cd.d;
import com.google.android.datatransport.cct.a;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import ed.u;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

public class DataTransportCrashlyticsReportSender {
    private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    private static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private static final d<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = new a();
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private final ReportQueue reportQueue;
    private final d<CrashlyticsReport, byte[]> transportTransform;

    DataTransportCrashlyticsReportSender(ReportQueue reportQueue2, d<CrashlyticsReport, byte[]> dVar) {
        this.reportQueue = reportQueue2;
        this.transportTransform = dVar;
    }

    public static DataTransportCrashlyticsReportSender create(Context context, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        u.f(context);
        b b10 = b.b(JsonPacketExtension.ELEMENT);
        d<CrashlyticsReport, byte[]> dVar = DEFAULT_TRANSFORM;
        return new DataTransportCrashlyticsReportSender(new ReportQueue(u.c().g(new a(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY)).a(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, b10, dVar), settingsProvider.getSettingsSync(), onDemandCounter), dVar);
    }

    private static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb2.append(str2.charAt(i10));
            }
        }
        return sb2.toString();
    }

    @NonNull
    public Task<CrashlyticsReportWithSessionId> enqueueReport(@NonNull CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z10) {
        return this.reportQueue.enqueueReport(crashlyticsReportWithSessionId, z10).getTask();
    }
}
