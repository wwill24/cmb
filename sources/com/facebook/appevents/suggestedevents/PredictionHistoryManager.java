package com.facebook.appevents.suggestedevents;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/suggestedevents/PredictionHistoryManager;", "", "()V", "CLICKED_PATH_STORE", "", "SUGGESTED_EVENTS_HISTORY", "clickedViewPaths", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shardPreferences", "Landroid/content/SharedPreferences;", "addPrediction", "", "pathID", "predictedEvent", "getPathID", "view", "Landroid/view/View;", "text", "initAndWait", "queryEvent", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PredictionHistoryManager {
    private static final String CLICKED_PATH_STORE = "com.facebook.internal.SUGGESTED_EVENTS_HISTORY";
    public static final PredictionHistoryManager INSTANCE = new PredictionHistoryManager();
    private static final String SUGGESTED_EVENTS_HISTORY = "SUGGESTED_EVENTS_HISTORY";
    private static final Map<String, String> clickedViewPaths = new LinkedHashMap();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static SharedPreferences shardPreferences;

    private PredictionHistoryManager() {
    }

    public static final void addPrediction(String str, String str2) {
        Class<PredictionHistoryManager> cls = PredictionHistoryManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(str, "pathID");
                j.g(str2, "predictedEvent");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                Map<String, String> map = clickedViewPaths;
                map.put(str, str2);
                SharedPreferences sharedPreferences = shardPreferences;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    Utility utility = Utility.INSTANCE;
                    edit.putString(SUGGESTED_EVENTS_HISTORY, Utility.mapToJsonStr(h0.u(map))).apply();
                    return;
                }
                j.y("shardPreferences");
                throw null;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|7|(1:9)|17|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getPathID(android.view.View r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "text"
            java.lang.Class<com.facebook.appevents.suggestedevents.PredictionHistoryManager> r1 = com.facebook.appevents.suggestedevents.PredictionHistoryManager.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "view"
            kotlin.jvm.internal.j.g(r4, r2)     // Catch:{ all -> 0x0043 }
            kotlin.jvm.internal.j.g(r5, r0)     // Catch:{ all -> 0x0043 }
            org.json.b r2 = new org.json.b     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            r2.put((java.lang.String) r0, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x0038 }
            org.json.a r5 = new org.json.a     // Catch:{ JSONException -> 0x0038 }
            r5.<init>()     // Catch:{ JSONException -> 0x0038 }
        L_0x0021:
            if (r4 == 0) goto L_0x0033
            java.lang.Class r0 = r4.getClass()     // Catch:{ JSONException -> 0x0038 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ JSONException -> 0x0038 }
            r5.E(r0)     // Catch:{ JSONException -> 0x0038 }
            android.view.ViewGroup r4 = com.facebook.appevents.codeless.internal.ViewHierarchy.getParentOfView(r4)     // Catch:{ JSONException -> 0x0038 }
            goto L_0x0021
        L_0x0033:
            java.lang.String r4 = "classname"
            r2.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x0038 }
        L_0x0038:
            com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0043 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0043 }
            java.lang.String r4 = com.facebook.internal.Utility.sha256hash((java.lang.String) r4)     // Catch:{ all -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.PredictionHistoryManager.getPathID(android.view.View, java.lang.String):java.lang.String");
    }

    private final void initAndWait() {
        String str = "";
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AtomicBoolean atomicBoolean = initialized;
                if (!atomicBoolean.get()) {
                    SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(CLICKED_PATH_STORE, 0);
                    j.f(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(CLICKED_PATH_STORE, Context.MODE_PRIVATE)");
                    shardPreferences = sharedPreferences;
                    Map<String, String> map = clickedViewPaths;
                    Utility utility = Utility.INSTANCE;
                    SharedPreferences sharedPreferences2 = shardPreferences;
                    if (sharedPreferences2 != null) {
                        String string = sharedPreferences2.getString(SUGGESTED_EVENTS_HISTORY, str);
                        if (string != null) {
                            str = string;
                        }
                        map.putAll(Utility.jsonStrToMap(str));
                        atomicBoolean.set(true);
                        return;
                    }
                    j.y("shardPreferences");
                    throw null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public static final String queryEvent(String str) {
        Class<PredictionHistoryManager> cls = PredictionHistoryManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(str, "pathID");
            Map<String, String> map = clickedViewPaths;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }
}
