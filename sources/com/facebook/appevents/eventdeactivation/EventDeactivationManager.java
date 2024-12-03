package com.facebook.appevents.eventdeactivation;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0002J&\u0010\u000e\u001a\u00020\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager;", "", "()V", "deprecatedEvents", "", "", "deprecatedParamFilters", "", "Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "enabled", "", "enable", "", "initialize", "processDeprecatedParameters", "parameters", "", "eventName", "processEvents", "events", "Lcom/facebook/appevents/AppEvent;", "DeprecatedParamFilter", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventDeactivationManager {
    public static final EventDeactivationManager INSTANCE = new EventDeactivationManager();
    private static final Set<String> deprecatedEvents = new HashSet();
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    private static boolean enabled;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "", "eventName", "", "deprecateParams", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDeprecateParams", "()Ljava/util/List;", "setDeprecateParams", "(Ljava/util/List;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DeprecatedParamFilter {
        private List<String> deprecateParams;
        private String eventName;

        public DeprecatedParamFilter(String str, List<String> list) {
            j.g(str, "eventName");
            j.g(list, "deprecateParams");
            this.eventName = str;
            this.deprecateParams = list;
        }

        public final List<String> getDeprecateParams() {
            return this.deprecateParams;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final void setDeprecateParams(List<String> list) {
            j.g(list, "<set-?>");
            this.deprecateParams = list;
        }

        public final void setEventName(String str) {
            j.g(str, "<set-?>");
            this.eventName = str;
        }
    }

    private EventDeactivationManager() {
    }

    public static final void enable() {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                enabled = true;
                INSTANCE.initialize();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final synchronized void initialize() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                boolean z10 = false;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null) {
                    String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
                    if (restrictiveDataSetting != null) {
                        if (restrictiveDataSetting.length() > 0) {
                            z10 = true;
                        }
                        if (z10) {
                            b bVar = new b(restrictiveDataSetting);
                            deprecatedParamFilters.clear();
                            Iterator<String> keys = bVar.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                b jSONObject = bVar.getJSONObject(next);
                                if (jSONObject != null) {
                                    if (jSONObject.optBoolean("is_deprecated_event")) {
                                        Set<String> set = deprecatedEvents;
                                        j.f(next, SDKConstants.PARAM_KEY);
                                        set.add(next);
                                    } else {
                                        a optJSONArray = jSONObject.optJSONArray("deprecated_param");
                                        j.f(next, SDKConstants.PARAM_KEY);
                                        DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter(next, new ArrayList());
                                        if (optJSONArray != null) {
                                            deprecatedParamFilter.setDeprecateParams(Utility.convertJSONArrayToList(optJSONArray));
                                        }
                                        deprecatedParamFilters.add(deprecatedParamFilter);
                                    }
                                }
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

    public static final void processDeprecatedParameters(Map<String, String> map, String str) {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(map, "parameters");
                j.g(str, "eventName");
                if (enabled) {
                    ArrayList<String> arrayList = new ArrayList<>(map.keySet());
                    for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                        if (j.b(deprecatedParamFilter.getEventName(), str)) {
                            for (String str2 : arrayList) {
                                if (deprecatedParamFilter.getDeprecateParams().contains(str2)) {
                                    map.remove(str2);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void processEvents(List<AppEvent> list) {
        Class<EventDeactivationManager> cls = EventDeactivationManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(list, Constants.Params.API_EVENTS_STATE);
                if (enabled) {
                    Iterator<AppEvent> it = list.iterator();
                    while (it.hasNext()) {
                        if (deprecatedEvents.contains(it.next().getName())) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }
}
