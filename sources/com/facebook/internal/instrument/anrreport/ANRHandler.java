package com.facebook.internal.instrument.anrreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.a;
import xc.b;
import xc.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "()V", "MAX_ANR_REPORT_NUM", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enable", "", "sendANRReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ANRHandler {
    public static final ANRHandler INSTANCE = new ANRHandler();
    private static final int MAX_ANR_REPORT_NUM = 5;
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private ANRHandler() {
    }

    public static final synchronized void enable() {
        Class<ANRHandler> cls = ANRHandler.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    if (!enabled.getAndSet(true)) {
                        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                            sendANRReports();
                        }
                        ANRDetector.start();
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, cls);
                }
            }
        }
    }

    public static final void sendANRReports() {
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!Utility.isDataProcessingRestricted()) {
                    File[] listAnrReportFiles = InstrumentUtility.listAnrReportFiles();
                    ArrayList arrayList = new ArrayList(listAnrReportFiles.length);
                    for (File load : listAnrReportFiles) {
                        arrayList.add(InstrumentData.Builder.load(load));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object next : arrayList) {
                        if (((InstrumentData) next).isValid()) {
                            arrayList2.add(next);
                        }
                    }
                    List q02 = CollectionsKt___CollectionsKt.q0(arrayList2, new b());
                    a aVar = new a();
                    Iterator it = j.o(0, Math.min(q02.size(), 5)).iterator();
                    while (it.hasNext()) {
                        aVar.E(q02.get(((b0) it).nextInt()));
                    }
                    InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                    InstrumentUtility.sendReports("anr_reports", aVar, new c(q02));
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-2  reason: not valid java name */
    public static final int m143sendANRReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
        Class<ANRHandler> cls = ANRHandler.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            j.f(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-5  reason: not valid java name */
    public static final void m144sendANRReports$lambda5(List list, GraphResponse graphResponse) {
        Boolean bool;
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(list, "$validReports");
                j.g(graphResponse, "response");
                try {
                    if (graphResponse.getError() == null) {
                        org.json.b jsonObject = graphResponse.getJsonObject();
                        if (jsonObject == null) {
                            bool = null;
                        } else {
                            bool = Boolean.valueOf(jsonObject.getBoolean("success"));
                        }
                        if (j.b(bool, Boolean.TRUE)) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((InstrumentData) it.next()).clear();
                            }
                        }
                    }
                } catch (JSONException unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }
}
