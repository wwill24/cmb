package com.leanplum;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.leanplum.ActionContext;
import com.leanplum.actions.internal.ActionDefinition;
import com.leanplum.actions.internal.ActionManagerDefinitionKt;
import com.leanplum.callbacks.ActionCallback;
import com.leanplum.callbacks.CleverTapInstanceCallback;
import com.leanplum.callbacks.ForceContentUpdateCallback;
import com.leanplum.callbacks.RegisterDeviceCallback;
import com.leanplum.callbacks.RegisterDeviceFinishedCallback;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.callbacks.VariablesChangedCallback;
import com.leanplum.internal.APIConfig;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.ApiConfigLoader;
import com.leanplum.internal.Constants;
import com.leanplum.internal.CountAggregator;
import com.leanplum.internal.FeatureFlagManager;
import com.leanplum.internal.FileManager;
import com.leanplum.internal.FileTransferManager;
import com.leanplum.internal.JsonConverter;
import com.leanplum.internal.LeanplumEventDataManager;
import com.leanplum.internal.LeanplumInternal;
import com.leanplum.internal.Log;
import com.leanplum.internal.OperationQueue;
import com.leanplum.internal.Registration;
import com.leanplum.internal.Request;
import com.leanplum.internal.RequestBuilder;
import com.leanplum.internal.RequestSender;
import com.leanplum.internal.RequestSenderTimer;
import com.leanplum.internal.RequestUtil;
import com.leanplum.internal.Util;
import com.leanplum.internal.VarCache;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import com.leanplum.migration.MigrationManager;
import com.leanplum.migration.model.MigrationConfig;
import com.leanplum.migration.model.MigrationState;
import com.leanplum.models.GeofenceEventType;
import com.leanplum.utils.BuildUtil;
import com.leanplum.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Unit;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.a;
import org.json.b;

public class Leanplum {
    public static final int ACTION_KIND_ACTION = 2;
    public static final int ACTION_KIND_MESSAGE = 1;
    private static final String LEANPLUM_NOTIFICATION_CHANNEL = "com.leanplum.LeanplumNotificationChannel";
    private static final String LEANPLUM_PUSH_SERVICE = "com.leanplum.LeanplumPushService";
    public static final String PURCHASE_EVENT_NAME = "Purchase";
    /* access modifiers changed from: private */
    public static Context context;
    private static CountAggregator countAggregator = new CountAggregator();
    private static String customAppVersion = null;
    private static String customDeviceId;
    private static String customLocale = null;
    private static LeanplumDeviceIdMode deviceIdMode = LeanplumDeviceIdMode.MD5_MAC_ADDRESS;
    private static FeatureFlagManager featureFlagManager = FeatureFlagManager.INSTANCE;
    private static boolean locationCollectionEnabled = true;
    private static final ArrayList<VariablesChangedCallback> noDownloadsHandlers = new ArrayList<>();
    private static final ArrayList<VariablesChangedCallback> onceNoDownloadsHandlers = new ArrayList<>();
    private static volatile boolean pushDeliveryTrackingEnabled = true;
    /* access modifiers changed from: private */
    public static RegisterDeviceFinishedCallback registerDeviceFinishedHandler;
    private static RegisterDeviceCallback registerDeviceHandler;
    private static final ArrayList<StartCallback> startHandlers = new ArrayList<>();
    private static boolean userSpecifiedDeviceId;
    private static final ArrayList<VariablesChangedCallback> variablesChangedHandlers = new ArrayList<>();

    /* renamed from: com.leanplum.Leanplum$18  reason: invalid class name */
    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$leanplum$PushProviderType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.leanplum.PushProviderType[] r0 = com.leanplum.PushProviderType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$leanplum$PushProviderType = r0
                com.leanplum.PushProviderType r1 = com.leanplum.PushProviderType.FCM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$leanplum$PushProviderType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.leanplum.PushProviderType r1 = com.leanplum.PushProviderType.MIPUSH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$leanplum$PushProviderType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.leanplum.PushProviderType r1 = com.leanplum.PushProviderType.HMS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.leanplum.Leanplum.AnonymousClass18.<clinit>():void");
        }
    }

    private Leanplum() {
    }

    public static void addCleverTapInstanceCallback(@NonNull CleverTapInstanceCallback cleverTapInstanceCallback) {
        MigrationManager.addCleverTapInstanceCallback(cleverTapInstanceCallback);
    }

    public static void addOnceVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback variablesChangedCallback) {
        if (variablesChangedCallback == null) {
            Log.e("addOnceVariablesChangedAndNoDownloadsPendingHandler - Invalid handler parameter provided.", new Object[0]);
        } else if (areVariablesReceivedAndNoDownloadsPending()) {
            variablesChangedCallback.variablesChanged();
        } else {
            ArrayList<VariablesChangedCallback> arrayList = onceNoDownloadsHandlers;
            synchronized (arrayList) {
                arrayList.add(variablesChangedCallback);
            }
        }
    }

    public static void addStartResponseHandler(StartCallback startCallback) {
        if (startCallback == null) {
            Log.e("addStartResponseHandler - Invalid handler parameter provided.", new Object[0]);
        } else if (LeanplumInternal.hasStarted()) {
            if (LeanplumInternal.isStartSuccessful()) {
                startCallback.setSuccess(true);
            }
            startCallback.run();
        } else {
            ArrayList<StartCallback> arrayList = startHandlers;
            synchronized (arrayList) {
                if (arrayList.indexOf(startCallback) == -1) {
                    arrayList.add(startCallback);
                }
            }
        }
    }

    public static void addVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback variablesChangedCallback) {
        if (variablesChangedCallback == null) {
            Log.e("addVariablesChangedAndNoDownloadsPendingHandler - Invalid handler parameter provided.", new Object[0]);
            return;
        }
        ArrayList<VariablesChangedCallback> arrayList = noDownloadsHandlers;
        synchronized (arrayList) {
            arrayList.add(variablesChangedCallback);
        }
        if (VarCache.hasReceivedDiffs() && FileTransferManager.getInstance().numPendingDownloads() == 0) {
            variablesChangedCallback.variablesChanged();
        }
    }

    public static void addVariablesChangedHandler(VariablesChangedCallback variablesChangedCallback) {
        if (variablesChangedCallback == null) {
            Log.e("addVariablesChangedHandler - Invalid handler parameter provided.", new Object[0]);
            return;
        }
        ArrayList<VariablesChangedCallback> arrayList = variablesChangedHandlers;
        synchronized (arrayList) {
            arrayList.add(variablesChangedCallback);
        }
        if (VarCache.hasReceivedDiffs()) {
            variablesChangedCallback.variablesChanged();
        }
    }

    public static void advanceTo(String str, String str2, Map<String, ?> map) {
        final Map<String, T> map2;
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call advanceTo before calling start", new Object[0]);
                return;
            }
            try {
                final HashMap hashMap = new HashMap();
                hashMap.put("info", str2);
                hashMap.put("state", str);
                if (map != null) {
                    Map<String, T> validateAttributes = LeanplumInternal.validateAttributes(map, "params", false);
                    hashMap.put("params", JsonConverter.toJson(validateAttributes));
                    map2 = validateAttributes;
                } else {
                    map2 = null;
                }
                if (LeanplumInternal.issuedStart()) {
                    MigrationManager.getWrapper().advanceTo(str, str2, map);
                    advanceToInternal(str, map2, hashMap);
                    return;
                }
                final String str3 = str;
                final String str4 = str2;
                final Map<String, ?> map3 = map;
                LeanplumInternal.addStartIssuedHandler(new Runnable() {
                    public void run() {
                        try {
                            MigrationManager.getWrapper().advanceTo(str3, str4, map3);
                            Leanplum.advanceToInternal(str3, map2, hashMap);
                        } catch (Throwable th2) {
                            Log.exception(th2);
                        }
                    }
                });
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void advanceToInternal(String str, Map<String, ?> map, Map<String, Object> map2) {
        RequestSender.getInstance().send(RequestBuilder.withAdvanceAction().andParams(map2).create());
        ActionContext.ContextualValues contextualValues = new ActionContext.ContextualValues();
        contextualValues.parameters = map;
        LeanplumInternal.maybePerformActions("state", str, 3, (String) null, contextualValues);
    }

    /* access modifiers changed from: private */
    public static void applyContentInResponse(b bVar) {
        String str;
        Map mapFromJson = JsonConverter.mapFromJson(bVar.optJSONObject("vars"));
        Map mapFromJsonOrDefault = JsonConverter.mapFromJsonOrDefault(bVar.optJSONObject(Constants.Keys.MESSAGES));
        Map mapFromJsonOrDefault2 = JsonConverter.mapFromJsonOrDefault(bVar.optJSONObject("regions"));
        List listFromJsonOrDefault = JsonConverter.listFromJsonOrDefault(bVar.optJSONArray(Constants.Keys.VARIANTS));
        List listFromJsonOrDefault2 = JsonConverter.listFromJsonOrDefault(bVar.optJSONArray(Constants.Keys.LOCAL_CAPS));
        Map mapFromJsonOrDefault3 = JsonConverter.mapFromJsonOrDefault(bVar.optJSONObject(Constants.Keys.VARIANT_DEBUG_INFO));
        b optJSONObject = bVar.optJSONObject("vars");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        } else {
            str = null;
        }
        VarCache.applyVariableDiffs(mapFromJson, mapFromJsonOrDefault, mapFromJsonOrDefault2, listFromJsonOrDefault, listFromJsonOrDefault2, mapFromJsonOrDefault3, str, bVar.optString(Constants.Keys.VARS_SIGNATURE));
    }

    static boolean areVariablesReceivedAndNoDownloadsPending() {
        if (!VarCache.hasReceivedDiffs() || FileTransferManager.getInstance().numPendingDownloads() != 0) {
            return false;
        }
        return true;
    }

    private static void attachDeviceParams(@NonNull Map<String, Object> map) {
        String versionName = Util.getVersionName();
        String str = customAppVersion;
        if (str != null) {
            versionName = str;
        }
        if (versionName == null) {
            versionName = "";
        }
        String string = SharedPreferencesUtil.getString(context, Constants.Defaults.LEANPLUM_PUSH, Constants.Defaults.PROPERTY_FCM_TOKEN_ID);
        String string2 = SharedPreferencesUtil.getString(context, Constants.Defaults.LEANPLUM_PUSH, Constants.Defaults.PROPERTY_MIPUSH_TOKEN_ID);
        String string3 = SharedPreferencesUtil.getString(context, Constants.Defaults.LEANPLUM_PUSH, Constants.Defaults.PROPERTY_HMS_TOKEN_ID);
        map.put(Constants.Params.VERSION_NAME, versionName);
        map.put(Constants.Params.DEVICE_NAME, Util.getDeviceName());
        map.put(Constants.Params.DEVICE_MODEL, Util.getDeviceModel());
        map.put(Constants.Params.DEVICE_SYSTEM_NAME, Util.getSystemName());
        map.put(Constants.Params.DEVICE_SYSTEM_VERSION, Util.getSystemVersion());
        if (!TextUtils.isEmpty(string)) {
            map.put(Constants.Params.DEVICE_FCM_PUSH_TOKEN, string);
        }
        if (!TextUtils.isEmpty(string2)) {
            map.put(Constants.Params.DEVICE_MIPUSH_TOKEN, string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            map.put(Constants.Params.DEVICE_HMS_TOKEN, string3);
        }
    }

    private static void checkAndStartNotificationsModules() {
        try {
            Log.d("Trying to start LeanplumPushService", new Object[0]);
            String str = LeanplumPushService.LEANPLUM_SENDER_ID;
            LeanplumPushService.class.getDeclaredMethod("onStart", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void clearUserContent() {
        VarCache.clearUserContent();
    }

    public static CountAggregator countAggregator() {
        return countAggregator;
    }

    public static void defineAction(String str, int i10, ActionArgs actionArgs, ActionCallback actionCallback, ActionCallback actionCallback2) {
        defineAction(str, i10, actionArgs, (Map<String, Object>) null, actionCallback, actionCallback2);
    }

    public static void disableLocationCollection() {
        locationCollectionEnabled = false;
    }

    public static void enableTestMode() {
        Constants.isTestMode = true;
    }

    @Deprecated
    public static void enableVerboseLoggingInDevelopmentMode() {
        setLogLevel(3);
    }

    public static FeatureFlagManager featureFlagManager() {
        return featureFlagManager;
    }

    public static void forceContentUpdate() {
        forceContentUpdate((ForceContentUpdateCallback) new i());
    }

    @Deprecated
    public static void forceNewDeviceId(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("forceNewDeviceId - Empty deviceId parameter provided.", new Object[0]);
        } else if (!str.equals(APIConfig.getInstance().deviceId())) {
            if (MigrationManager.getState().useCleverTap()) {
                Log.i("Setting new device ID is not allowed when migration to CleverTap is turned on.", new Object[0]);
            } else if (hasStarted()) {
                APIConfig.getInstance().setDeviceId(str);
                APIConfig.getInstance().save();
                VarCache.saveDiffs();
                HashMap hashMap = new HashMap();
                attachDeviceParams(hashMap);
                RequestSender.getInstance().send(RequestBuilder.withSetDeviceAttributesAction().andParams(hashMap).andType(Request.RequestType.IMMEDIATE).create());
            }
        }
    }

    public static Context getContext() {
        if (context == null) {
            Log.e("Your application context is not set. You should call Leanplum.setApplicationContext(this) or LeanplumActivityHelper.enableLifecycleCallbacks(this) in your application's onCreate method, or have your application extend LeanplumApplication.", new Object[0]);
        }
        return context;
    }

    public static String getDeviceId() {
        if (LeanplumInternal.hasCalledStart()) {
            return APIConfig.getInstance().deviceId();
        }
        Log.i("Leanplum.start() must be called before calling getDeviceId.", new Object[0]);
        return null;
    }

    public static LeanplumInbox getInbox() {
        return LeanplumInbox.getInstance();
    }

    public static String getUserId() {
        if (LeanplumInternal.hasCalledStart()) {
            return APIConfig.getInstance().userId();
        }
        Log.i("Leanplum.start() must be called before calling getUserId()", new Object[0]);
        return null;
    }

    public static Map<String, Object> getVariantDebugInfo() {
        return VarCache.getVariantDebugInfo();
    }

    private static void handleStartResponse(b bVar) {
        final Context context2;
        RegisterDeviceCallback registerDeviceCallback;
        boolean isResponseSuccess = RequestUtil.isResponseSuccess(bVar);
        if (!isResponseSuccess) {
            try {
                LeanplumInternal.setHasStarted(true);
                LeanplumInternal.setStartSuccessful(false);
                VarCache.loadDiffs();
            } catch (Throwable th2) {
                triggerStartResponse(isResponseSuccess);
                throw th2;
            }
            triggerStartResponse(isResponseSuccess);
            return;
        }
        try {
            LeanplumInternal.setHasStarted(true);
            LeanplumInternal.setStartSuccessful(true);
            if (bVar.optJSONObject("vars") == null) {
                Log.e("No variable values were received from the server. Please contact us to investigate.", new Object[0]);
            }
            if (bVar.optJSONObject(Constants.Keys.MESSAGES) == null) {
                Log.d("No messages received from the server.", new Object[0]);
            }
            if (bVar.optJSONObject("regions") == null) {
                Log.d("No regions received from the server.", new Object[0]);
            }
            if (bVar.optJSONArray(Constants.Keys.VARIANTS) == null) {
                Log.d("No variants received from the server.", new Object[0]);
            }
            FileManager.setFilenameToURLs(parseFilenameToURLs(bVar));
            if (BuildUtil.isNotificationChannelSupported(context)) {
                a optJSONArray = bVar.optJSONArray(Constants.Keys.NOTIFICATION_CHANNELS);
                a optJSONArray2 = bVar.optJSONArray(Constants.Keys.NOTIFICATION_GROUPS);
                String optString = bVar.optString(Constants.Keys.DEFAULT_NOTIFICATION_CHANNEL);
                try {
                    LeanplumNotificationChannel.class.getDeclaredMethod("configureChannels", new Class[]{Context.class, a.class, a.class, String.class}).invoke(new Object(), new Object[]{context, optJSONArray2, optJSONArray, optString});
                } catch (Throwable unused) {
                }
            }
            APIConfig.getInstance().setToken(bVar.optString("token", (String) null));
            applyContentInResponse(bVar);
            VarCache.saveUserAttributes();
            if (bVar.optBoolean(Constants.Keys.SYNC_INBOX, false)) {
                LeanplumInbox.getInstance().downloadMessages();
            }
            if (bVar.optBoolean(Constants.Keys.LOGGING_ENABLED, false)) {
                Constants.loggingEnabled = true;
            }
            countAggregator.setEnabledCounters(parseSdkCounters(bVar));
            FeatureFlagManager.INSTANCE.setEnabledFeatureFlags(parseFeatureFlags(bVar));
            parseVariantDebugInfo(bVar);
            if (Constants.isDevelopmentModeEnabled) {
                if (LeanplumActivityHelper.getCurrentActivity() == context || LeanplumActivityHelper.getCurrentActivity() == null) {
                    context2 = context;
                } else {
                    context2 = LeanplumActivityHelper.getCurrentActivity();
                }
                if (!bVar.optBoolean(Constants.Keys.IS_REGISTERED) && (registerDeviceCallback = registerDeviceHandler) != null) {
                    registerDeviceCallback.setResponseHandler(new RegisterDeviceCallback.EmailCallback() {
                        public void onResponse(String str) {
                            if (str != null) {
                                try {
                                    Registration.registerDevice(str, new StartCallback() {
                                        public void onResponse(boolean z10) {
                                            if (Leanplum.registerDeviceFinishedHandler != null) {
                                                Leanplum.registerDeviceFinishedHandler.setSuccess(z10);
                                                OperationQueue.sharedInstance().addUiOperation(Leanplum.registerDeviceFinishedHandler);
                                            }
                                            if (z10) {
                                                try {
                                                    LeanplumInternal.onHasStartedAndRegisteredAsDeveloper();
                                                } catch (Throwable th2) {
                                                    Log.exception(th2);
                                                }
                                            }
                                        }
                                    });
                                } catch (Throwable th2) {
                                    Log.exception(th2);
                                }
                            }
                        }
                    });
                    OperationQueue.sharedInstance().addUiOperation(registerDeviceHandler);
                }
                if (bVar.optBoolean(Constants.Keys.IS_REGISTERED_FROM_OTHER_APP)) {
                    OperationQueue.sharedInstance().addUiOperation(new Runnable() {
                        public void run() {
                            Class<LeanplumPushService> cls = LeanplumPushService.class;
                            try {
                                String str = LeanplumPushService.LEANPLUM_SENDER_ID;
                                cls.getDeclaredMethod("showDeviceRegistedPush", new Class[]{Context.class, Context.class}).invoke(new Object(), new Object[]{Leanplum.context, context2});
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
                boolean optBoolean = bVar.optBoolean(Constants.Keys.IS_REGISTERED);
                String optString2 = bVar.optString(Constants.Keys.LATEST_VERSION);
                if (optBoolean && !TextUtils.isEmpty(optString2)) {
                    Log.i("Version %s of Leanplum SDK is available. Update your gradle dependencies to use it.", optString2);
                }
                b optJSONObject = bVar.optJSONObject(Constants.Keys.VARS_FROM_CODE);
                if (optJSONObject == null) {
                    optJSONObject = new b();
                }
                b optJSONObject2 = bVar.optJSONObject(Constants.Params.ACTION_DEFINITIONS);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new b();
                }
                b optJSONObject3 = bVar.optJSONObject(Constants.Params.FILE_ATTRIBUTES);
                if (optJSONObject3 == null) {
                    optJSONObject3 = new b();
                }
                VarCache.setDevModeValuesFromServer(JsonConverter.mapFromJson(optJSONObject), JsonConverter.mapFromJson(optJSONObject3), JsonConverter.mapFromJson(optJSONObject2));
                if (optBoolean) {
                    LeanplumInternal.onHasStartedAndRegisteredAsDeveloper();
                }
            }
            LeanplumInternal.moveToForeground();
            startRequestTimer();
        } catch (Throwable th3) {
            triggerStartResponse(isResponseSuccess);
            throw th3;
        }
        triggerStartResponse(isResponseSuccess);
    }

    public static boolean hasStarted() {
        return LeanplumInternal.hasStarted();
    }

    public static boolean hasStartedAndRegisteredAsDeveloper() {
        return LeanplumInternal.hasStartedAndRegisteredAsDeveloper();
    }

    public static boolean isLocationCollectionEnabled() {
        return locationCollectionEnabled;
    }

    public static boolean isPushDeliveryTrackingEnabled() {
        return pushDeliveryTrackingEnabled;
    }

    public static boolean isResourceSyncingEnabled() {
        return FileManager.isResourceSyncingEnabled();
    }

    public static boolean isScreenTrackingEnabled() {
        return LeanplumInternal.getIsScreenTrackingEnabled();
    }

    public static boolean isTestModeEnabled() {
        return Constants.isTestMode;
    }

    private static void issueLeanplumStart(boolean z10, Map<String, Object> map) {
        Request.RequestType requestType;
        if (z10) {
            requestType = Request.RequestType.DEFAULT;
        } else {
            requestType = Request.RequestType.IMMEDIATE;
        }
        Request create = RequestBuilder.withStartAction().andParams(map).andType(requestType).create();
        create.onResponse(new b());
        create.onError(new e());
        RequestSender.getInstance().send(create);
        LeanplumInternal.triggerStartIssued();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$forceContentUpdate$7(boolean z10) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$forceContentUpdate$8(VariablesChangedCallback variablesChangedCallback, boolean z10) {
        if (variablesChangedCallback != null) {
            variablesChangedCallback.variablesChanged();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$issueLeanplumStart$2(b bVar) {
        Log.d("Received start response: %s", bVar);
        handleStartResponse(bVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$issueLeanplumStart$3(Exception exc) {
        Log.e("Failed to receive start response", (Throwable) exc);
        handleStartResponse((b) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$startHelper$1(boolean z10, HashMap hashMap, MigrationState migrationState) {
        if (migrationState.useLeanplum()) {
            issueLeanplumStart(z10, hashMap);
            return null;
        }
        overrideLeanplumStart();
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$trackGooglePlayPurchase$6(String str, String str2, long j10, String str3, String str4, String str5, Map map) {
        if (MigrationManager.trackGooglePlayPurchases()) {
            MigrationManager.getWrapper().trackGooglePlayPurchase(str, str2, ((double) j10) / 1000000.0d, str3, str4, str5, map);
        }
    }

    private static void loadApiConfigFromResources() {
        new ApiConfigLoader(getContext()).loadFromResources(new l(), new m());
    }

    public static String messageBodyFromContext(ActionContext actionContext) {
        Object obj = actionContext.getArgs().get(MessageTemplateConstants.Args.MESSAGE);
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        HashMap hashMap = (HashMap) obj;
        if (hashMap.get("Text") != null && (hashMap.get("Text") instanceof String)) {
            return (String) hashMap.get("Text");
        }
        if (hashMap.get("Text value") == null || !(hashMap.get("Text value") instanceof String)) {
            return null;
        }
        return (String) hashMap.get("Text value");
    }

    public static Map<String, Object> messageMetadata() {
        Map<String, Object> messages = VarCache.messages();
        if (messages == null) {
            return new HashMap();
        }
        return messages;
    }

    public static Object objectForKeyPath(Object... objArr) {
        return objectForKeyPathComponents(objArr);
    }

    public static Object objectForKeyPathComponents(Object[] objArr) {
        try {
            return VarCache.getMergedValueFromComponentArray(objArr);
        } catch (Throwable th2) {
            Log.exception(th2);
            return null;
        }
    }

    private static void overrideLeanplumStart() {
        LeanplumInternal.triggerStartIssued();
        LeanplumInternal.setHasStarted(true);
        LeanplumInternal.setStartSuccessful(true);
        LeanplumInternal.moveToForeground();
        triggerStartResponse(true);
    }

    public static Set<String> parseFeatureFlags(b bVar) {
        return toSet(bVar.optJSONArray(Constants.Keys.ENABLED_FEATURE_FLAGS));
    }

    public static Map<String, String> parseFilenameToURLs(b bVar) {
        b optJSONObject = bVar.optJSONObject(Constants.Keys.FILES);
        if (optJSONObject != null) {
            return JsonConverter.mapFromJson(optJSONObject);
        }
        return null;
    }

    public static Set<String> parseSdkCounters(b bVar) {
        return toSet(bVar.optJSONArray(Constants.Keys.ENABLED_COUNTERS));
    }

    /* access modifiers changed from: private */
    public static void parseVariantDebugInfo(b bVar) {
        Map mapFromJsonOrDefault = JsonConverter.mapFromJsonOrDefault(bVar.optJSONObject(Constants.Keys.VARIANT_DEBUG_INFO));
        if (mapFromJsonOrDefault.size() > 0) {
            VarCache.setVariantDebugInfo(mapFromJsonOrDefault);
        }
    }

    public static String pathForResource(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("pathForResource - Empty filename parameter provided.", new Object[0]);
            return null;
        }
        Var<String> defineFile = Var.defineFile(str, str);
        if (defineFile != null) {
            return defineFile.fileValue();
        }
        return null;
    }

    static void pause() {
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call pause before calling start", new Object[0]);
            } else if (LeanplumInternal.issuedStart()) {
                pauseInternal();
            } else {
                LeanplumInternal.addStartIssuedHandler(new Runnable() {
                    public void run() {
                        try {
                            Leanplum.pauseInternal();
                        } catch (Throwable th2) {
                            Log.exception(th2);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void pauseInternal() {
        RequestSender.getInstance().send(RequestBuilder.withPauseSessionAction().andType(Request.RequestType.IMMEDIATE).create());
        stopRequestTimer();
        LeanplumInternal.setIsPaused(true);
    }

    public static void pauseState() {
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call pauseState before calling start", new Object[0]);
                return;
            }
            try {
                if (LeanplumInternal.issuedStart()) {
                    pauseStateInternal();
                } else {
                    LeanplumInternal.addStartIssuedHandler(new Runnable() {
                        public void run() {
                            try {
                                Leanplum.pauseStateInternal();
                            } catch (Throwable th2) {
                                Log.exception(th2);
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void pauseStateInternal() {
        RequestSender.getInstance().send(RequestBuilder.withPauseStateAction().create());
    }

    public static void removeCleverTapInstanceCallback(@NonNull CleverTapInstanceCallback cleverTapInstanceCallback) {
        MigrationManager.removeCleverTapInstanceCallback(cleverTapInstanceCallback);
    }

    public static void removeOnceVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback variablesChangedCallback) {
        if (variablesChangedCallback == null) {
            Log.e("removeOnceVariablesChangedAndNoDownloadsPendingHandler - Invalid handler parameter provided.", new Object[0]);
            return;
        }
        ArrayList<VariablesChangedCallback> arrayList = onceNoDownloadsHandlers;
        synchronized (arrayList) {
            arrayList.remove(variablesChangedCallback);
        }
    }

    public static void removeStartResponseHandler(StartCallback startCallback) {
        if (startCallback == null) {
            Log.e("removeStartResponseHandler - Invalid handler parameter provided.", new Object[0]);
            return;
        }
        ArrayList<StartCallback> arrayList = startHandlers;
        synchronized (arrayList) {
            arrayList.remove(startCallback);
        }
    }

    public static void removeVariablesChangedAndNoDownloadsPendingHandler(VariablesChangedCallback variablesChangedCallback) {
        if (variablesChangedCallback == null) {
            Log.e("removeVariablesChangedAndNoDownloadsPendingHandler - Invalid handler parameter provided.", new Object[0]);
            return;
        }
        ArrayList<VariablesChangedCallback> arrayList = noDownloadsHandlers;
        synchronized (arrayList) {
            arrayList.remove(variablesChangedCallback);
        }
    }

    public static void removeVariablesChangedHandler(VariablesChangedCallback variablesChangedCallback) {
        if (variablesChangedCallback == null) {
            Log.e("removeVariablesChangedHandler - Invalid handler parameter provided.", new Object[0]);
            return;
        }
        ArrayList<VariablesChangedCallback> arrayList = variablesChangedHandlers;
        synchronized (arrayList) {
            arrayList.remove(variablesChangedCallback);
        }
    }

    static void resume() {
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call resume before calling start", new Object[0]);
            } else if (LeanplumInternal.issuedStart()) {
                resumeInternal();
            } else {
                LeanplumInternal.addStartIssuedHandler(new Runnable() {
                    public void run() {
                        try {
                            Leanplum.resumeInternal();
                        } catch (Throwable th2) {
                            Log.exception(th2);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void resumeInternal() {
        RequestSender.getInstance().send(RequestBuilder.withResumeSessionAction().andType(Request.RequestType.IMMEDIATE).create());
        if (LeanplumInternal.hasStartedInBackground()) {
            LeanplumInternal.setStartedInBackground(false);
        } else {
            LeanplumInternal.maybePerformActions(StreamManagement.Resume.ELEMENT, (String) null, 3, (String) null, (ActionContext.ContextualValues) null);
        }
        startRequestTimer();
        LeanplumInternal.setIsPaused(false);
    }

    public static void resumeState() {
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call resumeState before calling start", new Object[0]);
                return;
            }
            try {
                if (LeanplumInternal.issuedStart()) {
                    resumeStateInternal();
                } else {
                    LeanplumInternal.addStartIssuedHandler(new Runnable() {
                        public void run() {
                            try {
                                Leanplum.resumeStateInternal();
                            } catch (Throwable th2) {
                                Log.exception(th2);
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void resumeStateInternal() {
        RequestSender.getInstance().send(RequestBuilder.withResumeStateAction().create());
    }

    public static SecuredVars securedVars() {
        return VarCache.getSecuredVars();
    }

    public static void setApiConnectionSettings(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            Log.i("setApiConnectionSettings - Empty hostName parameter provided.", new Object[0]);
        } else if (TextUtils.isEmpty(str2)) {
            Log.i("setApiConnectionSettings - Empty apiPath parameter provided.", new Object[0]);
        } else {
            APIConfig.getInstance().setApiConfig(str, str2, z10);
        }
    }

    public static void setAppIdForDevelopmentMode(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.e("setAppIdForDevelopmentMode - Empty appId parameter provided.", new Object[0]);
        } else if (TextUtils.isEmpty(str2)) {
            Log.e("setAppIdForDevelopmentMode - Empty accessKey parameter provided.", new Object[0]);
        } else {
            Constants.isDevelopmentModeEnabled = true;
            APIConfig.getInstance().setAppId(str, str2);
            MigrationConfig.setAppId(str);
        }
    }

    public static void setAppIdForProductionMode(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.e("setAppIdForProductionMode - Empty appId parameter provided.", new Object[0]);
        } else if (TextUtils.isEmpty(str2)) {
            Log.e("setAppIdForProductionMode - Empty accessKey parameter provided.", new Object[0]);
        } else {
            Constants.isDevelopmentModeEnabled = false;
            APIConfig.getInstance().setAppId(str, str2);
            MigrationConfig.setAppId(str);
        }
    }

    public static void setAppVersion(String str) {
        customAppVersion = str;
    }

    public static void setApplicationContext(Context context2) {
        if (context2 == null) {
            Log.i("setApplicationContext - Null context parameter provided.", new Object[0]);
        }
        context = context2;
        MigrationManager.updateWrapper();
    }

    static void setClient(String str, String str2, String str3) {
        Constants.CLIENT = str;
        Constants.LEANPLUM_VERSION = str2;
        Constants.defaultDeviceId = str3;
    }

    public static void setDeviceId(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("setDeviceId - Empty deviceId parameter provided.", new Object[0]);
        }
        customDeviceId = str;
        userSpecifiedDeviceId = true;
    }

    public static void setDeviceIdMode(LeanplumDeviceIdMode leanplumDeviceIdMode) {
        if (leanplumDeviceIdMode == null) {
            Log.i("setDeviceIdMode - Invalid mode parameter provided.", new Object[0]);
            return;
        }
        deviceIdMode = leanplumDeviceIdMode;
        userSpecifiedDeviceId = true;
    }

    public static void setDeviceLocation(Location location) {
        setDeviceLocation(location, LeanplumLocationAccuracyType.CELL);
    }

    public static void setEventsUploadInterval(EventsUploadInterval eventsUploadInterval) {
        if (eventsUploadInterval != null) {
            RequestSenderTimer.get().setTimerInterval(eventsUploadInterval);
        }
    }

    public static void setFileUploadingEnabledInDevelopmentMode(boolean z10) {
        Constants.enableFileUploadingInDevelopmentMode = z10;
    }

    public static void setIsTestModeEnabled(boolean z10) {
        Constants.isTestMode = z10;
    }

    public static void setLocale(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("setLocale - Empty locale parameter provided.", new Object[0]);
        }
        customLocale = str;
    }

    public static void setLogLevel(int i10) {
        Log.setLogLevel(i10);
        MigrationManager.getWrapper().setLogLevel(i10);
    }

    public static void setNetworkTimeout(int i10, int i11) {
        if (i10 < 0) {
            Log.i("setNetworkTimeout - Invalid seconds parameter provided.", new Object[0]);
        } else if (i11 < 0) {
            Log.i("setNetworkTimeout - Invalid downloadSeconds parameter provided.", new Object[0]);
        } else {
            Constants.NETWORK_TIMEOUT_SECONDS = i10;
            Constants.NETWORK_TIMEOUT_SECONDS_FOR_DOWNLOADS = i11;
        }
    }

    public static void setPushDeliveryTracking(boolean z10) {
        pushDeliveryTrackingEnabled = z10;
    }

    static void setRegistrationId(PushProviderType pushProviderType, final String str) {
        final String str2;
        if (!Constants.isNoop()) {
            int i10 = AnonymousClass18.$SwitchMap$com$leanplum$PushProviderType[pushProviderType.ordinal()];
            if (i10 == 1) {
                str2 = Constants.Params.DEVICE_FCM_PUSH_TOKEN;
            } else if (i10 == 2) {
                str2 = Constants.Params.DEVICE_MIPUSH_TOKEN;
            } else if (i10 == 3) {
                str2 = Constants.Params.DEVICE_HMS_TOKEN;
            } else {
                return;
            }
            LeanplumInternal.addStartIssuedHandler(new Runnable() {
                public void run() {
                    if (!Constants.isNoop()) {
                        try {
                            RequestSender.getInstance().send(RequestBuilder.withSetDeviceAttributesAction().andParam(str2, str).andType(Request.RequestType.IMMEDIATE).create());
                        } catch (Throwable th2) {
                            Log.exception(th2);
                        }
                    }
                }
            });
        }
    }

    public static void setSocketConnectionSettings(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            Log.i("setSocketConnectionSettings - Empty hostName parameter provided.", new Object[0]);
        } else if (i10 < 1 || i10 > 65535) {
            Log.i("setSocketConnectionSettings - Invalid port parameter provided.", new Object[0]);
        } else if (!str.equals(APIConfig.getInstance().getSocketHost())) {
            APIConfig.getInstance().setSocketConfig(str, i10);
            LeanplumInternal.connectDevelopmentServer();
        }
    }

    public static void setTrafficSourceInfo(final Map<String, String> map) {
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call setTrafficSourceInfo before calling start", new Object[0]);
            } else if (map == null || map.isEmpty()) {
                Log.e("setTrafficSourceInfo - Invalid info parameter provided (null or empty).", new Object[0]);
            } else {
                try {
                    final HashMap hashMap = new HashMap();
                    hashMap.put(Constants.Params.TRAFFIC_SOURCE, JsonConverter.toJson(LeanplumInternal.validateAttributes(map, "info", false)));
                    if (LeanplumInternal.issuedStart()) {
                        MigrationManager.getWrapper().setTrafficSourceInfo(map);
                        setTrafficSourceInfoInternal(hashMap);
                        return;
                    }
                    LeanplumInternal.addStartIssuedHandler(new Runnable() {
                        public void run() {
                            try {
                                MigrationManager.getWrapper().setTrafficSourceInfo(map);
                                Leanplum.setTrafficSourceInfoInternal(hashMap);
                            } catch (Throwable th2) {
                                Log.exception(th2);
                            }
                        }
                    });
                } catch (Throwable th2) {
                    Log.exception(th2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setTrafficSourceInfoInternal(HashMap<String, Object> hashMap) {
        RequestSender.getInstance().send(RequestBuilder.withSetTrafficSourceInfoAction().andParams(hashMap).create());
    }

    public static void setUserAttributes(final String str, final Map<String, ?> map) {
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call setUserAttributes before calling start", new Object[0]);
                return;
            }
            try {
                final HashMap hashMap = new HashMap();
                if (str != null) {
                    hashMap.put(Constants.Params.USER_ID, getUserId());
                    hashMap.put(Constants.Params.NEW_USER_ID, str);
                }
                if (map != null) {
                    Map<String, T> validateAttributes = LeanplumInternal.validateAttributes(map, Constants.Params.USER_ATTRIBUTES, true);
                    hashMap.put(Constants.Params.USER_ATTRIBUTES, JsonConverter.toJson(validateAttributes));
                    LeanplumInternal.getUserAttributeChanges().add(validateAttributes);
                }
                if (LeanplumInternal.issuedStart()) {
                    MigrationManager.getWrapper().setUserId(str);
                    MigrationManager.getWrapper().setUserAttributes(map);
                    setUserAttributesInternal(str, hashMap);
                    return;
                }
                LeanplumInternal.addStartIssuedHandler(new Runnable() {
                    public void run() {
                        try {
                            MigrationManager.getWrapper().setUserId(str);
                            MigrationManager.getWrapper().setUserAttributes(map);
                            Leanplum.setUserAttributesInternal(str, hashMap);
                        } catch (Throwable th2) {
                            Log.exception(th2);
                        }
                    }
                });
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setUserAttributesInternal(String str, HashMap<String, Object> hashMap) {
        RequestSender.getInstance().send(RequestBuilder.withSetUserAttributesAction().andParams(hashMap).create());
        if (str != null && str.length() > 0) {
            APIConfig.getInstance().setUserId(str);
            if (LeanplumInternal.hasStarted()) {
                VarCache.saveDiffs();
            }
        }
        LeanplumInternal.recordAttributeChanges();
    }

    public static void setUserId(String str) {
        if (str == null) {
            Log.e("setUserId - Invalid userId parameter provided.", new Object[0]);
        } else {
            setUserAttributes(str, (Map<String, ?>) null);
        }
    }

    public static void setVariantDebugInfoEnabled(boolean z10) {
        LeanplumInternal.setIsVariantDebugInfoEnabled(z10);
    }

    public static void start(Context context2) {
        start(context2, (String) null, (Map<String, ?>) null, (StartCallback) null, (Boolean) null);
    }

    /* access modifiers changed from: private */
    public static void startHelper(String str, Map<String, ?> map, boolean z10) {
        String str2;
        LeanplumEventDataManager.sharedInstance();
        checkAndStartNotificationsModules();
        Boolean bool = null;
        if (APIConfig.getInstance().deviceId() == null) {
            if (!userSpecifiedDeviceId && Constants.defaultDeviceId != null) {
                Log.d("Using default deviceID", new Object[0]);
                str2 = Constants.defaultDeviceId;
            } else if (customDeviceId != null) {
                Log.d("Using custom deviceID", new Object[0]);
                str2 = customDeviceId;
            } else {
                Log.d("Using deviceID for mode: %s", deviceIdMode);
                Util.DeviceIdInfo deviceId = Util.getDeviceId(deviceIdMode);
                String str3 = deviceId.f22204id;
                bool = Boolean.valueOf(deviceId.limitAdTracking);
                str2 = str3;
            }
            APIConfig.getInstance().setDeviceId(str2);
        }
        if (str == null && (str = APIConfig.getInstance().userId()) == null) {
            Log.d("setting deviceID as userID", new Object[0]);
            str = APIConfig.getInstance().deviceId();
        }
        APIConfig.getInstance().setUserId(str);
        MigrationManager.getWrapper().setUserId(str);
        String locale = Util.getLocale();
        if (!TextUtils.isEmpty(customLocale)) {
            locale = customLocale;
        }
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getOffset(new Date().getTime()) / 1000;
        HashMap hashMap = new HashMap();
        attachDeviceParams(hashMap);
        hashMap.put(Constants.Params.INCLUDE_DEFAULTS, Boolean.toString(false));
        if (z10) {
            hashMap.put(Constants.Params.BACKGROUND, Boolean.toString(true));
        }
        hashMap.put(Constants.Keys.TIMEZONE, timeZone.getID());
        hashMap.put(Constants.Keys.TIMEZONE_OFFSET_SECONDS, Integer.toString(offset));
        hashMap.put(Constants.Keys.LOCALE, locale);
        hashMap.put("country", Constants.Values.DETECT);
        hashMap.put(Constants.Keys.REGION, Constants.Values.DETECT);
        hashMap.put(Constants.Keys.CITY, Constants.Values.DETECT);
        hashMap.put("location", Constants.Values.DETECT);
        Boolean bool2 = Boolean.TRUE;
        if (bool2.equals(bool)) {
            hashMap.put(Constants.Params.LIMIT_TRACKING, bool.toString());
        }
        if (map != null) {
            hashMap.put(Constants.Params.USER_ATTRIBUTES, JsonConverter.toJson(map));
        }
        if (Constants.isDevelopmentModeEnabled) {
            hashMap.put(Constants.Params.DEV_MODE, bool2.toString());
        }
        hashMap.put("newsfeedMessages", LeanplumInbox.getInstance().messagesIds());
        hashMap.put(Constants.Params.INCLUDE_VARIANT_DEBUG_INFO, Boolean.valueOf(LeanplumInternal.getIsVariantDebugInfoEnabled()));
        Util.initializePreLeanplumInstall(hashMap);
        MigrationManager.fetchState(new k(z10, hashMap));
    }

    private static void startRequestTimer() {
        RequestSenderTimer.get().start();
    }

    static void stop() {
        if (!Constants.isNoop()) {
            if (!LeanplumInternal.hasCalledStart()) {
                Log.e("You cannot call stop before calling start", new Object[0]);
            } else if (LeanplumInternal.issuedStart()) {
                stopInternal();
            } else {
                LeanplumInternal.addStartIssuedHandler(new Runnable() {
                    public void run() {
                        try {
                            Leanplum.stopInternal();
                        } catch (Throwable th2) {
                            Log.exception(th2);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void stopInternal() {
        RequestSender.getInstance().send(RequestBuilder.withStopAction().andType(Request.RequestType.IMMEDIATE).create());
    }

    private static void stopRequestTimer() {
        RequestSenderTimer.get().stop();
    }

    public static void syncResources() {
        if (!Constants.isNoop()) {
            try {
                FileManager.enableResourceSyncing((List<String>) null, (List<String>) null, false);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    public static void syncResourcesAsync() {
        if (!Constants.isNoop()) {
            try {
                FileManager.enableResourceSyncing((List<String>) null, (List<String>) null, true);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    private static Set<String> toSet(a aVar) {
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            for (int i10 = 0; i10 < aVar.o(); i10++) {
                hashSet.add(aVar.w(i10));
            }
        }
        return hashSet;
    }

    public static void track(String str, double d10, String str2, Map<String, ?> map) {
        LeanplumInternal.addStartIssuedHandler(new j(str, d10, str2, map));
        LeanplumInternal.track(str, d10, str2, map, (Map<String, String>) null);
    }

    public static void trackAllAppScreens() {
        LeanplumInternal.enableAutomaticScreenTracking();
    }

    public static void trackGeofence(GeofenceEventType geofenceEventType, String str) {
        if (featureFlagManager().isFeatureFlagEnabled("track_geofence").booleanValue()) {
            LeanplumInternal.trackGeofence(geofenceEventType, 0.0d, str, (Map<String, ?>) null, (Map<String, String>) null);
        }
    }

    public static void trackGooglePlayPurchase(String str, long j10, String str2, String str3, String str4) {
        trackGooglePlayPurchase(PURCHASE_EVENT_NAME, str, j10, str2, str3, str4, (Map<String, ?>) null);
    }

    public static void trackPurchase(String str, double d10, String str2, Map<String, ?> map) {
        try {
            if (TextUtils.isEmpty(str)) {
                Log.i("Failed to trackPurchase, event name is null", new Object[0]);
            }
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("currencyCode", str2);
            }
            LeanplumInternal.addStartIssuedHandler(new h(str, d10, str2, map));
            LeanplumInternal.track(str, d10, (String) null, map, hashMap);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    private static void triggerStartResponse(boolean z10) {
        ArrayList<StartCallback> arrayList = startHandlers;
        synchronized (arrayList) {
            Iterator<StartCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                StartCallback next = it.next();
                next.setSuccess(z10);
                OperationQueue.sharedInstance().addUiOperation(next);
            }
            startHandlers.clear();
        }
    }

    /* access modifiers changed from: private */
    public static void triggerVariablesChanged() {
        ArrayList<VariablesChangedCallback> arrayList = variablesChangedHandlers;
        synchronized (arrayList) {
            Iterator<VariablesChangedCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                OperationQueue.sharedInstance().addUiOperation(it.next());
            }
        }
    }

    static void triggerVariablesChangedAndNoDownloadsPending() {
        ArrayList<VariablesChangedCallback> arrayList = noDownloadsHandlers;
        synchronized (arrayList) {
            Iterator<VariablesChangedCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                OperationQueue.sharedInstance().addUiOperation(it.next());
            }
        }
        ArrayList<VariablesChangedCallback> arrayList2 = onceNoDownloadsHandlers;
        synchronized (arrayList2) {
            Iterator<VariablesChangedCallback> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                OperationQueue.sharedInstance().addUiOperation(it2.next());
            }
            onceNoDownloadsHandlers.clear();
        }
    }

    public static List<Map<String, Object>> variants() {
        List<Map<String, Object>> variants = VarCache.variants();
        if (variants == null) {
            return new ArrayList();
        }
        return variants;
    }

    private static void defineAction(String str, int i10, ActionArgs actionArgs, Map<String, Object> map, ActionCallback actionCallback, ActionCallback actionCallback2) {
        if (TextUtils.isEmpty(str)) {
            Log.e("defineAction - Empty name parameter provided.", new Object[0]);
        } else if (actionArgs == null) {
            Log.e("defineAction - Invalid args parameter provided.", new Object[0]);
        } else {
            if (map == null) {
                try {
                    map = new HashMap<>();
                } catch (Throwable th2) {
                    Log.exception(th2);
                    return;
                }
            }
            ActionManagerDefinitionKt.defineAction(ActionManager.getInstance(), new ActionDefinition(str, i10, actionArgs, map, actionCallback, actionCallback2));
        }
    }

    public static void forceContentUpdate(VariablesChangedCallback variablesChangedCallback) {
        forceContentUpdate((ForceContentUpdateCallback) new f(variablesChangedCallback));
    }

    public static void setDeviceLocation(Location location, LeanplumLocationAccuracyType leanplumLocationAccuracyType) {
        if (locationCollectionEnabled) {
            Log.i("Leanplum is automatically collecting device location, so there is no need to call setDeviceLocation. If you prefer to always set location manually, then call disableLocationCollection.", new Object[0]);
        }
        LeanplumInternal.setUserLocationAttribute(location, leanplumLocationAccuracyType, new LeanplumInternal.locationAttributeRequestsCallback() {
            public void response(boolean z10) {
                if (z10) {
                    Log.d("setUserAttributes with location is successfully called", new Object[0]);
                }
            }
        });
    }

    public static void start(Context context2, StartCallback startCallback) {
        start(context2, (String) null, (Map<String, ?>) null, startCallback, (Boolean) null);
    }

    public static void trackGooglePlayPurchase(String str, long j10, String str2, String str3, String str4, Map<String, ?> map) {
        trackGooglePlayPurchase(PURCHASE_EVENT_NAME, str, j10, str2, str3, str4, map);
    }

    public static void forceContentUpdate(@NonNull final ForceContentUpdateCallback forceContentUpdateCallback) {
        if (Constants.isNoop()) {
            OperationQueue.sharedInstance().addUiOperation(new c(forceContentUpdateCallback));
            return;
        }
        try {
            Request create = RequestBuilder.withGetVarsAction().andParam(Constants.Params.INCLUDE_DEFAULTS, Boolean.toString(false)).andParam("newsfeedMessages", LeanplumInbox.getInstance().messagesIds()).andParam(Constants.Params.INCLUDE_VARIANT_DEBUG_INFO, Boolean.valueOf(LeanplumInternal.getIsVariantDebugInfoEnabled())).andType(Request.RequestType.IMMEDIATE).create();
            create.onResponse(new Request.ResponseCallback() {
                public void response(b bVar) {
                    if (bVar == null) {
                        try {
                            Log.e("No response received from the server. Please contact us to investigate.", new Object[0]);
                        } catch (Throwable th2) {
                            Log.exception(th2);
                            return;
                        }
                    } else {
                        Leanplum.applyContentInResponse(bVar);
                        if (bVar.optBoolean(Constants.Keys.SYNC_INBOX, false)) {
                            LeanplumInbox.getInstance().downloadMessages();
                        } else {
                            LeanplumInbox.getInstance().triggerInboxSyncedWithStatus(true);
                        }
                        if (bVar.optBoolean(Constants.Keys.LOGGING_ENABLED, false)) {
                            Constants.loggingEnabled = true;
                        }
                        Leanplum.parseVariantDebugInfo(bVar);
                        FileManager.setFilenameToURLs(Leanplum.parseFilenameToURLs(bVar));
                    }
                    OperationQueue.sharedInstance().addUiOperation(new n(ForceContentUpdateCallback.this));
                }
            });
            create.onError(new Request.ErrorCallback() {
                public void error(Exception exc) {
                    OperationQueue.sharedInstance().addUiOperation(new o(ForceContentUpdateCallback.this));
                    LeanplumInbox.getInstance().triggerInboxSyncedWithStatus(false);
                }
            });
            RequestSender.getInstance().send(create);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public static void start(Context context2, Map<String, ?> map) {
        start(context2, (String) null, map, (StartCallback) null, (Boolean) null);
    }

    public static void track(String str) {
        track(str, 0.0d, "", (Map<String, ?>) null);
    }

    public static void trackGooglePlayPurchase(String str, String str2, long j10, String str3, String str4, String str5, Map<String, ?> map) {
        HashMap hashMap;
        Map<String, ?> map2 = map;
        if (TextUtils.isEmpty(str)) {
            Log.i("Failed to trackGooglePlayPurchase, event name is null", new Object[0]);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("googlePlayPurchaseData", str4);
        hashMap2.put("googlePlayPurchaseDataSignature", str5);
        hashMap2.put("currencyCode", str3);
        if (map2 == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map2);
        }
        HashMap hashMap3 = hashMap;
        hashMap3.put("item", str2);
        LeanplumInternal.addStartIssuedHandler(new g(str, str2, j10, str3, str4, str5, map));
        LeanplumInternal.track(str, ((double) j10) / 1000000.0d, (String) null, hashMap3, hashMap2);
    }

    public static void start(Context context2, String str) {
        start(context2, str, (Map<String, ?>) null, (StartCallback) null, (Boolean) null);
    }

    public static void syncResources(List<String> list, List<String> list2) {
        try {
            FileManager.enableResourceSyncing(list, list2, false);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public static void syncResourcesAsync(List<String> list, List<String> list2) {
        try {
            FileManager.enableResourceSyncing(list, list2, true);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public static void track(String str, double d10) {
        track(str, d10, "", (Map<String, ?>) null);
    }

    public static void start(Context context2, String str, StartCallback startCallback) {
        start(context2, str, (Map<String, ?>) null, startCallback, (Boolean) null);
    }

    public static void track(String str, String str2) {
        track(str, 0.0d, str2, (Map<String, ?>) null);
    }

    public static void start(Context context2, String str, Map<String, ?> map) {
        start(context2, str, map, (StartCallback) null, (Boolean) null);
    }

    public static void track(String str, Map<String, ?> map) {
        track(str, 0.0d, "", map);
    }

    public static synchronized void start(Context context2, String str, Map<String, ?> map, StartCallback startCallback) {
        synchronized (Leanplum.class) {
            start(context2, str, map, startCallback, (Boolean) null);
        }
    }

    public static void track(String str, double d10, Map<String, ?> map) {
        track(str, d10, "", map);
    }

    public static void track(String str, double d10, String str2) {
        track(str, d10, str2, (Map<String, ?>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void start(android.content.Context r14, final java.lang.String r15, java.util.Map<java.lang.String, ?> r16, com.leanplum.callbacks.StartCallback r17, java.lang.Boolean r18) {
        /*
            r0 = r16
            java.lang.Class<com.leanplum.Leanplum> r1 = com.leanplum.Leanplum.class
            monitor-enter(r1)
            com.leanplum.migration.MigrationManager.verifyCleverTapVersion()     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.APIConfig r2 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ all -> 0x0100 }
            java.lang.String r2 = r2.appId()     // Catch:{ all -> 0x0100 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0100 }
            if (r2 == 0) goto L_0x0019
            loadApiConfigFromResources()     // Catch:{ all -> 0x0100 }
        L_0x0019:
            com.leanplum.LeanplumActivityHelper.setCurrentActivity(r14)     // Catch:{ all -> 0x0100 }
            r2 = 0
            r3 = 1
            if (r18 != 0) goto L_0x0031
            android.app.Activity r4 = com.leanplum.LeanplumActivityHelper.getCurrentActivity()     // Catch:{ all -> 0x0100 }
            if (r4 == 0) goto L_0x002f
            boolean r4 = com.leanplum.LeanplumActivityHelper.isActivityPaused()     // Catch:{ all -> 0x0100 }
            if (r4 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r4 = r2
            goto L_0x0035
        L_0x002f:
            r4 = r3
            goto L_0x0035
        L_0x0031:
            boolean r4 = r18.booleanValue()     // Catch:{ all -> 0x0100 }
        L_0x0035:
            boolean r5 = com.leanplum.internal.Constants.isNoop()     // Catch:{ all -> 0x0100 }
            if (r5 == 0) goto L_0x007d
            com.leanplum.internal.LeanplumInternal.setHasStarted(r3)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.LeanplumInternal.setStartSuccessful(r3)     // Catch:{ all -> 0x0100 }
            triggerStartResponse(r3)     // Catch:{ all -> 0x0100 }
            triggerVariablesChanged()     // Catch:{ all -> 0x0100 }
            triggerVariablesChangedAndNoDownloadsPending()     // Catch:{ all -> 0x0100 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0100 }
            r6.<init>()     // Catch:{ all -> 0x0100 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0100 }
            r7.<init>()     // Catch:{ all -> 0x0100 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0100 }
            r8.<init>()     // Catch:{ all -> 0x0100 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0100 }
            r9.<init>()     // Catch:{ all -> 0x0100 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0100 }
            r10.<init>()     // Catch:{ all -> 0x0100 }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ all -> 0x0100 }
            r11.<init>()     // Catch:{ all -> 0x0100 }
            java.lang.String r12 = ""
            java.lang.String r13 = ""
            com.leanplum.internal.VarCache.applyVariableDiffs(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0100 }
            com.leanplum.LeanplumInbox r0 = com.leanplum.LeanplumInbox.getInstance()     // Catch:{ all -> 0x0100 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0100 }
            r3.<init>()     // Catch:{ all -> 0x0100 }
            r0.update(r3, r2, r2)     // Catch:{ all -> 0x0100 }
            monitor-exit(r1)
            return
        L_0x007d:
            if (r17 == 0) goto L_0x0082
            addStartResponseHandler(r17)     // Catch:{ all -> 0x0100 }
        L_0x0082:
            if (r14 == 0) goto L_0x008b
            android.content.Context r5 = r14.getApplicationContext()     // Catch:{ all -> 0x0100 }
            setApplicationContext(r5)     // Catch:{ all -> 0x0100 }
        L_0x008b:
            boolean r5 = com.leanplum.internal.LeanplumInternal.hasCalledStart()     // Catch:{ all -> 0x0100 }
            if (r5 == 0) goto L_0x00a1
            if (r4 != 0) goto L_0x009f
            boolean r0 = com.leanplum.internal.LeanplumInternal.hasStartedInBackground()     // Catch:{ all -> 0x0100 }
            if (r0 == 0) goto L_0x009f
            com.leanplum.internal.LeanplumInternal.setStartedInBackground(r2)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.LeanplumInternal.moveToForeground()     // Catch:{ all -> 0x0100 }
        L_0x009f:
            monitor-exit(r1)
            return
        L_0x00a1:
            android.content.Context r5 = getContext()     // Catch:{ all -> 0x0100 }
            com.leanplum.messagetemplates.MessageTemplates.register(r5)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.LeanplumInternal.setStartedInBackground(r4)     // Catch:{ all -> 0x0100 }
            com.leanplum.d r5 = new com.leanplum.d     // Catch:{ all -> 0x0100 }
            r5.<init>(r0)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.LeanplumInternal.addStartIssuedHandler(r5)     // Catch:{ all -> 0x0100 }
            java.lang.String r5 = "userAttributes"
            java.util.Map r0 = com.leanplum.internal.LeanplumInternal.validateAttributes(r0, r5, r3)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.LeanplumInternal.setCalledStart(r3)     // Catch:{ all -> 0x0100 }
            if (r0 == 0) goto L_0x00c5
            java.util.Queue r5 = com.leanplum.internal.LeanplumInternal.getUserAttributeChanges()     // Catch:{ all -> 0x0100 }
            r5.add(r0)     // Catch:{ all -> 0x0100 }
        L_0x00c5:
            com.leanplum.internal.APIConfig.getInstance()     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.VarCache.setSilent(r3)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.VarCache.loadDiffs()     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.VarCache.setSilent(r2)     // Catch:{ all -> 0x0100 }
            com.leanplum.LeanplumInbox r2 = com.leanplum.LeanplumInbox.getInstance()     // Catch:{ all -> 0x0100 }
            r2.load()     // Catch:{ all -> 0x0100 }
            com.leanplum.Leanplum$1 r2 = new com.leanplum.Leanplum$1     // Catch:{ all -> 0x0100 }
            r2.<init>()     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.VarCache.onUpdate(r2)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.FileTransferManager r2 = com.leanplum.internal.FileTransferManager.getInstance()     // Catch:{ all -> 0x0100 }
            com.leanplum.Leanplum$2 r3 = new com.leanplum.Leanplum$2     // Catch:{ all -> 0x0100 }
            r3.<init>()     // Catch:{ all -> 0x0100 }
            r2.onNoPendingDownloads(r3)     // Catch:{ all -> 0x0100 }
            com.leanplum.migration.MigrationManager.updateWrapper()     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.OperationQueue r2 = com.leanplum.internal.OperationQueue.sharedInstance()     // Catch:{ all -> 0x0100 }
            com.leanplum.Leanplum$3 r3 = new com.leanplum.Leanplum$3     // Catch:{ all -> 0x0100 }
            r5 = r15
            r3.<init>(r15, r0, r4)     // Catch:{ all -> 0x0100 }
            r2.addParallelOperation(r3)     // Catch:{ all -> 0x0100 }
            com.leanplum.internal.Util.initExceptionHandling(r14)     // Catch:{ all -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r0 = move-exception
            com.leanplum.internal.Log.exception(r0)     // Catch:{ all -> 0x0106 }
        L_0x0104:
            monitor-exit(r1)
            return
        L_0x0106:
            r0 = move-exception
            r2 = r0
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.Leanplum.start(android.content.Context, java.lang.String, java.util.Map, com.leanplum.callbacks.StartCallback, java.lang.Boolean):void");
    }

    public static void advanceTo(String str) {
        advanceTo(str, "", (Map<String, ?>) null);
    }

    public static void advanceTo(String str, String str2) {
        advanceTo(str, str2, (Map<String, ?>) null);
    }

    public static void advanceTo(String str, Map<String, ?> map) {
        advanceTo(str, "", map);
    }

    public static void setUserAttributes(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            Log.e("setUserAttributes - Invalid userAttributes parameter provided (null or empty).", new Object[0]);
        } else {
            setUserAttributes((String) null, map);
        }
    }
}
