package com.facebook.internal.instrument;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\r\u0010\n\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/instrument/ExceptionAnalyzer;", "", "()V", "enabled", "", "enable", "", "execute", "e", "", "isDebug", "isDebug$facebook_core_release", "sendExceptionAnalysisReports", "sendExceptionAnalysisReports$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExceptionAnalyzer {
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    private static boolean enabled;

    private ExceptionAnalyzer() {
    }

    public static final void enable() {
        enabled = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            INSTANCE.sendExceptionAnalysisReports$facebook_core_release();
        }
    }

    public static final void execute(Throwable th2) {
        if (enabled && !isDebug$facebook_core_release() && th2 != null) {
            HashSet hashSet = new HashSet();
            StackTraceElement[] stackTrace = th2.getStackTrace();
            j.f(stackTrace, "e.stackTrace");
            for (StackTraceElement className : stackTrace) {
                FeatureManager featureManager = FeatureManager.INSTANCE;
                String className2 = className.getClassName();
                j.f(className2, "it.className");
                FeatureManager.Feature feature = FeatureManager.getFeature(className2);
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            if (FacebookSdk.getAutoLogAppEventsEnabled() && (!hashSet.isEmpty())) {
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData.Builder.build(new a((Collection<?>) hashSet)).save();
            }
        }
    }

    public static final boolean isDebug$facebook_core_release() {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: sendExceptionAnalysisReports$lambda-1  reason: not valid java name */
    public static final void m135sendExceptionAnalysisReports$lambda1(InstrumentData instrumentData, GraphResponse graphResponse) {
        Boolean bool;
        j.g(instrumentData, "$instrumentData");
        j.g(graphResponse, "response");
        try {
            if (graphResponse.getError() == null) {
                b jsonObject = graphResponse.getJsonObject();
                if (jsonObject == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(jsonObject.getBoolean("success"));
                }
                if (j.b(bool, Boolean.TRUE)) {
                    instrumentData.clear();
                }
            }
        } catch (JSONException unused) {
        }
    }

    public final void sendExceptionAnalysisReports$facebook_core_release() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
            ArrayList arrayList = new ArrayList();
            int length = listExceptionAnalysisReportFiles.length;
            int i10 = 0;
            while (i10 < length) {
                File file = listExceptionAnalysisReportFiles[i10];
                i10++;
                InstrumentData load = InstrumentData.Builder.load(file);
                if (load.isValid()) {
                    b bVar = new b();
                    try {
                        bVar.put("crash_shield", (Object) load.toString());
                        GraphRequest.Companion companion = GraphRequest.Companion;
                        o oVar = o.f32141a;
                        String format2 = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                        j.f(format2, "java.lang.String.format(format, *args)");
                        arrayList.add(companion.newPostRequest((AccessToken) null, format2, bVar, new wc.a(load)));
                    } catch (JSONException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                new GraphRequestBatch((Collection<GraphRequest>) arrayList).executeAsync();
            }
        }
    }
}
