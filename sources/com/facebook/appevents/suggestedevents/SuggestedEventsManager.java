package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.b;
import vc.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0002J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001a\u00020\u000fH\u0007J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0014J\u0017\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventsManager;", "", "()V", "ELIGIBLE_EVENTS_KEY", "", "PRODUCTION_EVENTS_KEY", "eligibleEvents", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "productionEvents", "enable", "", "initialize", "isEligibleEvents", "", "event", "isEligibleEvents$facebook_core_release", "isEnabled", "isProductionEvents", "isProductionEvents$facebook_core_release", "populateEventsFromRawJsonString", "rawSuggestedEventSetting", "populateEventsFromRawJsonString$facebook_core_release", "trackActivity", "activity", "Landroid/app/Activity;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SuggestedEventsManager {
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    private static final Set<String> eligibleEvents = new LinkedHashSet();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);
    private static final Set<String> productionEvents = new LinkedHashSet();

    private SuggestedEventsManager() {
    }

    public static final synchronized void enable() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    FacebookSdk.getExecutor().execute(new a());
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, cls);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m83enable$lambda0() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                AtomicBoolean atomicBoolean = enabled;
                if (!atomicBoolean.get()) {
                    atomicBoolean.set(true);
                    INSTANCE.initialize();
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final void initialize() {
        String suggestedEventsSetting;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && (suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting()) != null) {
                    populateEventsFromRawJsonString$facebook_core_release(suggestedEventsSetting);
                    if ((!productionEvents.isEmpty()) || (!eligibleEvents.isEmpty())) {
                        ModelManager modelManager = ModelManager.INSTANCE;
                        File ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION);
                        if (ruleFile != null) {
                            FeatureExtractor.initialize(ruleFile);
                            Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                            if (currentActivity != null) {
                                trackActivity(currentActivity);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public static final boolean isEligibleEvents$facebook_core_release(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            j.g(str, "event");
            return eligibleEvents.contains(str);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final boolean isEnabled() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return enabled.get();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final boolean isProductionEvents$facebook_core_release(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            j.g(str, "event");
            return productionEvents.contains(str);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final void trackActivity(Activity activity) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(activity, "activity");
                try {
                    if (!enabled.get() || !FeatureExtractor.isInitialized() || (productionEvents.isEmpty() && eligibleEvents.isEmpty())) {
                        ViewObserver.Companion.stopTrackingActivity(activity);
                    } else {
                        ViewObserver.Companion.startTrackingActivity(activity);
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public final void populateEventsFromRawJsonString$facebook_core_release(String str) {
        org.json.a jSONArray;
        int o10;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                b bVar = new b(str);
                int i10 = 0;
                if (bVar.has(PRODUCTION_EVENTS_KEY)) {
                    org.json.a jSONArray2 = bVar.getJSONArray(PRODUCTION_EVENTS_KEY);
                    int o11 = jSONArray2.o();
                    if (o11 > 0) {
                        int i11 = 0;
                        while (true) {
                            int i12 = i11 + 1;
                            Set<String> set = productionEvents;
                            String n10 = jSONArray2.n(i11);
                            j.f(n10, "jsonArray.getString(i)");
                            set.add(n10);
                            if (i12 >= o11) {
                                break;
                            }
                            i11 = i12;
                        }
                    }
                }
                if (bVar.has(ELIGIBLE_EVENTS_KEY) && (o10 = jSONArray.o()) > 0) {
                    while (true) {
                        int i13 = i10 + 1;
                        Set<String> set2 = eligibleEvents;
                        String n11 = (jSONArray = bVar.getJSONArray(ELIGIBLE_EVENTS_KEY)).n(i10);
                        j.f(n11, "jsonArray.getString(i)");
                        set2.add(n11);
                        if (i13 < o10) {
                            i10 = i13;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
