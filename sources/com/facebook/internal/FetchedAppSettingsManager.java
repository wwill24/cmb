package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.camera.view.h;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002LMB\t\b\u0002¢\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u00150\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n \u001c*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0014\u0010$\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0014\u0010&\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0014\u0010'\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b'\u0010\u001eR\u0014\u0010(\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0014\u0010)\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b)\u0010\u001eR\u0014\u0010+\u001a\u00020*8\u0002XT¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*8\u0002XT¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020*8\u0002XT¢\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020*8\u0002XT¢\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00100\u001a\u00020*8\u0002XT¢\u0006\u0006\n\u0004\b0\u0010,R\u0014\u00101\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b1\u0010\u001eR\u0014\u00102\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b2\u0010\u001eR\u0014\u00103\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b3\u0010\u001eR\u0014\u00104\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b4\u0010\u001eR\u0014\u00105\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b5\u0010\u001eR\u0014\u00106\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b6\u0010\u001eR\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b:\u0010\u001eR \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\"\u0010?\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010>0>0=8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0A8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006N"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager;", "", "", "loadAppSettingsAsync", "", "applicationId", "Lcom/facebook/internal/FetchedAppSettings;", "getAppSettingsWithoutQuery", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "callback", "getAppSettingsAsync", "pollCallbacks", "", "forceRequery", "queryAppSettings", "flag", "setIsUnityInit", "Lorg/json/b;", "getAppSettingsQueryResponse", "dialogConfigResponse", "", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "parseDialogConfigurations", "settingsJSON", "parseAppSettingsFromJSON$facebook_core_release", "(Ljava/lang/String;Lorg/json/b;)Lcom/facebook/internal/FetchedAppSettings;", "parseAppSettingsFromJSON", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "APP_SETTINGS_PREFS_STORE", "APP_SETTINGS_PREFS_KEY_FORMAT", "APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING", "APP_SETTING_NUX_CONTENT", "APP_SETTING_NUX_ENABLED", "APP_SETTING_DIALOG_CONFIGS", "APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES", "APP_SETTING_APP_EVENTS_SESSION_TIMEOUT", "APP_SETTING_APP_EVENTS_FEATURE_BITMASK", "APP_SETTING_APP_EVENTS_EVENT_BINDINGS", "APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD", "", "AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "I", "IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "CODELESS_EVENTS_ENABLED_BITMASK_FIELD", "TRACK_UNINSTALL_ENABLED_BITMASK_FIELD", "MONITOR_ENABLED_BITMASK_FIELD", "APP_SETTING_SMART_LOGIN_OPTIONS", "SMART_LOGIN_BOOKMARK_ICON_URL", "SMART_LOGIN_MENU_ICON_URL", "SDK_UPDATE_MESSAGE", "APP_SETTING_APP_EVENTS_AAM_RULE", "SUGGESTED_EVENTS_SETTING", "", "APP_SETTING_FIELDS", "Ljava/util/List;", "APPLICATION_FIELDS", "fetchedAppSettings", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "loadingState", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "fetchedAppSettingsCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "printedSDKUpdatedMessage", "Z", "isUnityInit", "Lorg/json/a;", "unityEventBindings", "Lorg/json/a;", "<init>", "()V", "FetchAppSettingState", "FetchedAppSettingsCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class FetchedAppSettingsManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    private static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final List<String> APP_SETTING_FIELDS = q.m(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL, APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD, APP_SETTING_APP_EVENTS_AAM_RULE, SUGGESTED_EVENTS_SETTING);
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    private static final int MONITOR_ENABLED_BITMASK_FIELD = 16384;
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    private static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";
    private static final String TAG = FetchedAppSettingsManager.class.getSimpleName();
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
    private static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();
    private static boolean isUnityInit;
    private static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
    private static boolean printedSDKUpdatedMessage;
    private static a unityEventBindings;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "SUCCESS", "ERROR", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    private FetchedAppSettingsManager() {
    }

    public static final void getAppSettingsAsync(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        j.g(fetchedAppSettingsCallback, "callback");
        fetchedAppSettingsCallbacks.add(fetchedAppSettingsCallback);
        loadAppSettingsAsync();
    }

    private final b getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(AppsFlyerKit.COMMA, arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app", (GraphRequest.Callback) null);
        newGraphPathRequest.setForceApplicationRequest(true);
        newGraphPathRequest.setParameters(bundle);
        b jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        if (jsonObject == null) {
            return new b();
        }
        return jsonObject;
    }

    public static final FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    public static final void loadAppSettingsAsync() {
        boolean z10;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
        } else if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
        } else {
            AtomicReference<FetchAppSettingState> atomicReference = loadingState;
            FetchAppSettingState fetchAppSettingState = FetchAppSettingState.NOT_LOADED;
            FetchAppSettingState fetchAppSettingState2 = FetchAppSettingState.LOADING;
            if (h.a(atomicReference, fetchAppSettingState, fetchAppSettingState2) || h.a(atomicReference, FetchAppSettingState.ERROR, fetchAppSettingState2)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                INSTANCE.pollCallbacks();
                return;
            }
            o oVar = o.f32141a;
            String format2 = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
            j.f(format2, "java.lang.String.format(format, *args)");
            FacebookSdk.getExecutor().execute(new g(applicationContext, format2, applicationId));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppSettingsAsync$lambda-0  reason: not valid java name */
    public static final void m117loadAppSettingsAsync$lambda0(Context context, String str, String str2) {
        FetchAppSettingState fetchAppSettingState;
        b bVar;
        j.g(context, "$context");
        j.g(str, "$settingsKey");
        j.g(str2, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0);
        FetchedAppSettings fetchedAppSettings2 = null;
        String string = sharedPreferences.getString(str, (String) null);
        if (!Utility.isNullOrEmpty(string)) {
            if (string != null) {
                try {
                    bVar = new b(string);
                } catch (JSONException e10) {
                    Utility.logd(Utility.LOG_TAG, (Exception) e10);
                    bVar = null;
                }
                if (bVar != null) {
                    fetchedAppSettings2 = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(str2, bVar);
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        b appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(str2);
        if (appSettingsQueryResponse != null) {
            fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(str2, appSettingsQueryResponse);
            sharedPreferences.edit().putString(str, appSettingsQueryResponse.toString()).apply();
        }
        if (fetchedAppSettings2 != null) {
            String sdkUpdateMessage = fetchedAppSettings2.getSdkUpdateMessage();
            if (!printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                printedSDKUpdatedMessage = true;
            }
        }
        FetchedAppGateKeepersManager.queryAppGateKeepers(str2, true);
        AutomaticAnalyticsLogger.logActivateAppEvent();
        AtomicReference<FetchAppSettingState> atomicReference = loadingState;
        if (fetchedAppSettings.containsKey(str2)) {
            fetchAppSettingState = FetchAppSettingState.SUCCESS;
        } else {
            fetchAppSettingState = FetchAppSettingState.ERROR;
        }
        atomicReference.set(fetchAppSettingState);
        fetchedAppSettingsManager.pollCallbacks();
    }

    private final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(b bVar) {
        a optJSONArray;
        HashMap hashMap = new HashMap();
        if (bVar != null && (optJSONArray = bVar.optJSONArray("data")) != null) {
            int i10 = 0;
            int o10 = optJSONArray.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    FetchedAppSettings.DialogFeatureConfig.Companion companion = FetchedAppSettings.DialogFeatureConfig.Companion;
                    b s10 = optJSONArray.s(i10);
                    j.f(s10, "dialogConfigData.optJSONObject(i)");
                    FetchedAppSettings.DialogFeatureConfig parseDialogConfig = companion.parseDialogConfig(s10);
                    if (parseDialogConfig != null) {
                        String dialogName = parseDialogConfig.getDialogName();
                        Map map = (Map) hashMap.get(dialogName);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(dialogName, map);
                        }
                        map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void pollCallbacks() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicReference<com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState> r0 = loadingState     // Catch:{ all -> 0x005f }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x005f }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState) r0     // Catch:{ all -> 0x005f }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED     // Catch:{ all -> 0x005f }
            if (r1 == r0) goto L_0x005d
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.LOADING     // Catch:{ all -> 0x005f }
            if (r1 != r0) goto L_0x0012
            goto L_0x005d
        L_0x0012:
            java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ all -> 0x005f }
            java.util.Map<java.lang.String, com.facebook.internal.FetchedAppSettings> r2 = fetchedAppSettings     // Catch:{ all -> 0x005f }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x005f }
            com.facebook.internal.FetchedAppSettings r1 = (com.facebook.internal.FetchedAppSettings) r1     // Catch:{ all -> 0x005f }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x005f }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x005f }
            r2.<init>(r3)     // Catch:{ all -> 0x005f }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r3 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.ERROR     // Catch:{ all -> 0x005f }
            if (r3 != r0) goto L_0x0044
        L_0x002b:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x005f }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x005f }
            if (r1 != 0) goto L_0x0042
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x005f }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x005f }
            com.facebook.internal.h r1 = new com.facebook.internal.h     // Catch:{ all -> 0x005f }
            r1.<init>(r0)     // Catch:{ all -> 0x005f }
            r2.post(r1)     // Catch:{ all -> 0x005f }
            goto L_0x002b
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x005f }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x005f }
            if (r3 != 0) goto L_0x005b
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x005f }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x005f }
            com.facebook.internal.i r3 = new com.facebook.internal.i     // Catch:{ all -> 0x005f }
            r3.<init>(r0, r1)     // Catch:{ all -> 0x005f }
            r2.post(r3)     // Catch:{ all -> 0x005f }
            goto L_0x0044
        L_0x005b:
            monitor-exit(r4)
            return
        L_0x005d:
            monitor-exit(r4)
            return
        L_0x005f:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.pollCallbacks():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m118pollCallbacks$lambda1(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        fetchedAppSettingsCallback.onError();
    }

    /* access modifiers changed from: private */
    /* renamed from: pollCallbacks$lambda-2  reason: not valid java name */
    public static final void m119pollCallbacks$lambda2(FetchedAppSettingsCallback fetchedAppSettingsCallback, FetchedAppSettings fetchedAppSettings2) {
        fetchedAppSettingsCallback.onSuccess(fetchedAppSettings2);
    }

    public static final FetchedAppSettings queryAppSettings(String str, boolean z10) {
        j.g(str, "applicationId");
        if (!z10) {
            Map<String, FetchedAppSettings> map = fetchedAppSettings;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        b appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(str);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release = fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(str, appSettingsQueryResponse);
        if (j.b(str, FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager.pollCallbacks();
        }
        return parseAppSettingsFromJSON$facebook_core_release;
    }

    public static final void setIsUnityInit(boolean z10) {
        isUnityInit = z10;
        if (unityEventBindings != null && z10) {
            UnityReflection unityReflection = UnityReflection.INSTANCE;
            UnityReflection.sendEventMapping(String.valueOf(unityEventBindings));
        }
    }

    public final FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(String str, b bVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str2;
        b bVar2 = bVar;
        j.g(str, "applicationId");
        j.g(bVar2, "settingsJSON");
        a optJSONArray = bVar2.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES);
        FacebookRequestErrorClassification.Companion companion = FacebookRequestErrorClassification.Companion;
        FacebookRequestErrorClassification createFromJSON = companion.createFromJSON(optJSONArray);
        if (createFromJSON == null) {
            createFromJSON = companion.getDefaultErrorClassification();
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = createFromJSON;
        int optInt = bVar2.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        if ((optInt & 8) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((optInt & 16) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((optInt & 32) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if ((optInt & 256) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if ((optInt & 16384) != 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        a optJSONArray2 = bVar2.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = optJSONArray2;
        if (optJSONArray2 != null && InternalSettings.isUnityApp()) {
            UnityReflection unityReflection = UnityReflection.INSTANCE;
            if (optJSONArray2 == null) {
                str2 = null;
            } else {
                str2 = optJSONArray2.toString();
            }
            UnityReflection.sendEventMapping(str2);
        }
        boolean optBoolean = bVar2.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false);
        String optString = bVar2.optString(APP_SETTING_NUX_CONTENT, "");
        String str3 = optString;
        j.f(optString, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = bVar2.optBoolean(APP_SETTING_NUX_ENABLED, false);
        int optInt2 = bVar2.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> parseOptions = SmartLoginOption.Companion.parseOptions(bVar2.optLong(APP_SETTING_SMART_LOGIN_OPTIONS));
        Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations = parseDialogConfigurations(bVar2.optJSONObject(APP_SETTING_DIALOG_CONFIGS));
        String optString2 = bVar2.optString(SMART_LOGIN_BOOKMARK_ICON_URL);
        j.f(optString2, "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = bVar2.optString(SMART_LOGIN_MENU_ICON_URL);
        String str4 = optString3;
        FetchedAppSettings fetchedAppSettings2 = r3;
        j.f(optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = bVar2.optString(SDK_UPDATE_MESSAGE);
        j.f(optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings3 = new FetchedAppSettings(optBoolean, str3, optBoolean2, optInt2, parseOptions, parseDialogConfigurations, z10, facebookRequestErrorClassification, optString2, str4, z11, z12, optJSONArray2, optString4, z13, z14, bVar2.optString(APP_SETTING_APP_EVENTS_AAM_RULE), bVar2.optString(SUGGESTED_EVENTS_SETTING), bVar2.optString(APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD));
        FetchedAppSettings fetchedAppSettings4 = fetchedAppSettings2;
        fetchedAppSettings.put(str, fetchedAppSettings4);
        return fetchedAppSettings4;
    }
}
