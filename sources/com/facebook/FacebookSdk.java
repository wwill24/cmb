package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020?H\u0007J\b\u0010H\u001a\u00020FH\u0007J\b\u0010I\u001a\u00020FH\u0007J\b\u0010J\u001a\u00020*H\u0007J\b\u0010K\u001a\u00020&H\u0007J\b\u0010L\u001a\u00020\u0004H\u0007J\n\u0010M\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010N\u001a\u0004\u0018\u00010\u00042\b\u0010O\u001a\u0004\u0018\u00010&H\u0007J\b\u0010P\u001a\u00020*H\u0007J\b\u0010Q\u001a\u00020*H\u0007J\n\u0010R\u001a\u0004\u0018\u00010-H\u0007J\b\u0010S\u001a\u00020\u0016H\u0007J\b\u0010T\u001a\u00020\u0004H\u0007J\b\u0010U\u001a\u00020*H\u0007J\b\u0010V\u001a\u00020*H\u0007J\b\u0010W\u001a\u000202H\u0007J\b\u0010X\u001a\u00020\u0004H\u0007J\b\u0010Y\u001a\u00020\u0004H\u0007J\b\u0010Z\u001a\u00020\u0004H\u0007J\b\u0010[\u001a\u00020\u0004H\u0007J\b\u0010\\\u001a\u00020\u0004H\u0007J\u0010\u0010]\u001a\u00020*2\u0006\u0010O\u001a\u00020&H\u0007J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020?0_H\u0007J\b\u0010`\u001a\u00020*H\u0007J\b\u0010a\u001a\u00020bH\u0007J\b\u0010c\u001a\u00020\u0004H\u0007J\b\u0010d\u001a\u00020*H\u0007J\u0010\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020\u0016H\u0007J\b\u0010;\u001a\u00020*H\u0007J\b\u0010g\u001a\u00020*H\u0007J\b\u0010<\u001a\u00020*H\u0007J\u0010\u0010h\u001a\u00020*2\u0006\u0010G\u001a\u00020?H\u0007J\u0017\u0010i\u001a\u00020F2\b\u0010O\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0003J\u0018\u0010l\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0010\u0010m\u001a\u00020F2\u0006\u0010G\u001a\u00020?H\u0007J\u0010\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&H\u0007J\u001a\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\b\u0010o\u001a\u0004\u0018\u00010pH\u0007J\u0018\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0016H\u0007J\"\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u00162\b\u0010o\u001a\u0004\u0018\u00010pH\u0007J\u0010\u0010q\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010s\u001a\u00020F2\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0012\u0010t\u001a\u00020F2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010u\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010v\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010w\u001a\u00020F2\u0006\u0010+\u001a\u00020-H\u0007J\u0012\u0010x\u001a\u00020F2\b\u0010y\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010z\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u001d\u0010{\u001a\u00020F2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010}H\u0007¢\u0006\u0002\u0010~J/\u0010{\u001a\u00020F2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010}2\u0006\u0010\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0016H\u0007¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00101\u001a\u000202H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00103\u001a\u00020\u0004H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00104\u001a\u00020\u0004H\u0007J\u0017\u0010\u0001\u001a\u00020F2\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u001a\u0010\u0001\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020bH\u0007J\t\u0010\u0001\u001a\u00020FH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \"*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/facebook/FacebookSdk;", "", "()V", "ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY", "", "APPLICATION_ID_PROPERTY", "APPLICATION_NAME_PROPERTY", "APP_EVENT_PREFERENCES", "ATTRIBUTION_PREFERENCES", "AUTO_INIT_ENABLED_PROPERTY", "AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY", "CALLBACK_OFFSET_CHANGED_AFTER_INIT", "CALLBACK_OFFSET_NEGATIVE", "CALLBACK_OFFSET_PROPERTY", "CLIENT_TOKEN_PROPERTY", "CLOUDBRIDGE_SAVED_CREDENTIALS", "CODELESS_DEBUG_LOG_ENABLED_PROPERTY", "DATA_PROCESSING_OPTIONS_PREFERENCES", "DATA_PROCESSION_OPTIONS", "DATA_PROCESSION_OPTIONS_COUNTRY", "DATA_PROCESSION_OPTIONS_STATE", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "", "FACEBOOK_COM", "FB_GG", "GAMING", "INSTAGRAM", "INSTAGRAM_COM", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "MAX_REQUEST_CODE_RANGE", "MONITOR_ENABLED_PROPERTY", "PUBLISH_ACTIVITY_PATH", "TAG", "kotlin.jvm.PlatformType", "WEB_DIALOG_THEME", "appClientToken", "applicationContext", "Landroid/content/Context;", "applicationId", "applicationName", "bypassAppSwitch", "", "cacheDir", "Lcom/facebook/internal/LockOnGetVariable;", "Ljava/io/File;", "callbackRequestCodeOffset", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "executor", "Ljava/util/concurrent/Executor;", "facebookDomain", "graphApiVersion", "graphRequestCreator", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "instagramDomain", "isDebugEnabledField", "isFullyInitialized", "isLegacyTokenUpgradeSupported", "loggingBehaviors", "Ljava/util/HashSet;", "Lcom/facebook/LoggingBehavior;", "Lkotlin/collections/HashSet;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "addLoggingBehavior", "", "behavior", "clearLoggingBehaviors", "fullyInitialize", "getAdvertiserIDCollectionEnabled", "getApplicationContext", "getApplicationId", "getApplicationName", "getApplicationSignature", "context", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCacheDir", "getCallbackRequestCodeOffset", "getClientToken", "getCodelessDebugLogEnabled", "getCodelessSetupEnabled", "getExecutor", "getFacebookDomain", "getFacebookGamingDomain", "getGraphApiVersion", "getGraphDomain", "getInstagramDomain", "getLimitEventAndDataUsage", "getLoggingBehaviors", "", "getMonitorEnabled", "getOnProgressThreshold", "", "getSdkVersion", "isDebugEnabled", "isFacebookRequestCode", "requestCode", "isInitialized", "isLoggingBehaviorEnabled", "loadDefaultsFromMetadata", "loadDefaultsFromMetadata$facebook_core_release", "publishInstallAndWaitForResponse", "publishInstallAsync", "removeLoggingBehavior", "sdkInitialize", "callback", "Lcom/facebook/FacebookSdk$InitializeCallback;", "setAdvertiserIDCollectionEnabled", "flag", "setApplicationId", "setApplicationName", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setCacheDir", "setClientToken", "clientToken", "setCodelessDebugLogEnabled", "setDataProcessingOptions", "options", "", "([Ljava/lang/String;)V", "country", "state", "([Ljava/lang/String;II)V", "setExecutor", "setFacebookDomain", "setGraphApiVersion", "setGraphRequestCreator", "setGraphRequestCreator$facebook_core_release", "setIsDebugEnabled", "enabled", "setLegacyTokenUpgradeSupported", "supported", "setLimitEventAndDataUsage", "limitEventUsage", "setMonitorEnabled", "setOnProgressThreshold", "threshold", "updateGraphDebugBehavior", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacebookSdk {
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    public static final String FACEBOOK_COM = "facebook.com";
    public static final String FB_GG = "fb.gg";
    public static final String GAMING = "gaming";
    public static final String INSTAGRAM = "instagram";
    public static final String INSTAGRAM_COM = "instagram.com";
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    public static boolean bypassAppSwitch;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    private static volatile String facebookDomain = "facebook.com";
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static GraphRequestCreator graphRequestCreator = new o();
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    private static volatile String instagramDomain = INSTAGRAM_COM;
    private static volatile boolean isDebugEnabledField;
    private static boolean isFullyInitialized;
    private static boolean isLegacyTokenUpgradeSupported;
    private static final HashSet<LoggingBehavior> loggingBehaviors = n0.f(LoggingBehavior.DEVELOPER_ERRORS);
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bá\u0001\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\f"}, d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", "", "Lcom/facebook/AccessToken;", "accessToken", "", "publishUrl", "Lorg/json/b;", "publishParams", "Lcom/facebook/GraphRequest$Callback;", "callback", "Lcom/facebook/GraphRequest;", "createPostRequest", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphRequestCreator {
        GraphRequest createPostRequest(AccessToken accessToken, String str, b bVar, GraphRequest.Callback callback);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", "", "onInitialized", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface InitializeCallback {
        void onInitialized();
    }

    private FacebookSdk() {
    }

    public static final void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        j.g(loggingBehavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(loggingBehavior);
            INSTANCE.updateGraphDebugBehavior();
            Unit unit = Unit.f32013a;
        }
    }

    public static final void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
            Unit unit = Unit.f32013a;
        }
    }

    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        j.y("applicationContext");
        throw null;
    }

    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    public static final String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getApplicationSignature(android.content.Context r4) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.facebook.internal.Validate.sdkInitialized()     // Catch:{ all -> 0x004c }
            if (r4 != 0) goto L_0x0010
            return r2
        L_0x0010:
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0017
            return r2
        L_0x0017:
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x004c }
            r3 = 64
            android.content.pm.PackageInfo r4 = r1.getPackageInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x004b }
            android.content.pm.Signature[] r1 = r4.signatures     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x004b
            int r1 = r1.length     // Catch:{ all -> 0x004c }
            r3 = 0
            if (r1 != 0) goto L_0x002b
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = r3
        L_0x002c:
            if (r1 == 0) goto L_0x002f
            goto L_0x004b
        L_0x002f:
            java.lang.String r1 = "SHA-1"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{  }
            android.content.pm.Signature[] r4 = r4.signatures     // Catch:{ all -> 0x004c }
            r4 = r4[r3]     // Catch:{ all -> 0x004c }
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x004c }
            r1.update(r4)     // Catch:{ all -> 0x004c }
            byte[] r4 = r1.digest()     // Catch:{ all -> 0x004c }
            r1 = 9
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r1)     // Catch:{ all -> 0x004c }
            return r4
        L_0x004b:
            return r2
        L_0x004c:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.getApplicationSignature(android.content.Context):java.lang.String");
    }

    public static final boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    public static final File getCacheDir() {
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = cacheDir;
        if (lockOnGetVariable != null) {
            return lockOnGetVariable.getValue();
        }
        j.y("cacheDir");
        throw null;
    }

    public static final int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static final String getClientToken() {
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    public static final boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        Boolean bool = codelessDebugLogEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static final boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    /* JADX INFO: finally extract failed */
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            Unit unit = Unit.f32013a;
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    public static final String getFacebookGamingDomain() {
        return "fb.gg";
    }

    public static final String getGraphApiVersion() {
        Utility utility = Utility.INSTANCE;
        String str = TAG;
        o oVar = o.f32141a;
        String format2 = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        j.f(format2, "java.lang.String.format(format, *args)");
        Utility.logd(str, format2);
        return graphApiVersion;
    }

    public static final String getGraphDomain() {
        String str;
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken != null) {
            str = currentAccessToken.getGraphDomain();
        } else {
            str = null;
        }
        return Utility.getGraphDomainFromTokenDomain(str);
    }

    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    public static final boolean getLimitEventAndDataUsage(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
            j.f(unmodifiableSet, "unmodifiableSet(HashSet(loggingBehaviors))");
        }
        return unmodifiableSet;
    }

    public static final boolean getMonitorEnabled() {
        return UserSettingsManager.getMonitorEnabled();
    }

    public static final long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static final String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    /* access modifiers changed from: private */
    /* renamed from: graphRequestCreator$lambda-0  reason: not valid java name */
    public static final GraphRequest m18graphRequestCreator$lambda0(AccessToken accessToken, String str, b bVar, GraphRequest.Callback callback) {
        return GraphRequest.Companion.newPostRequest(accessToken, str, bVar, callback);
    }

    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    public static final boolean isFacebookRequestCode(int i10) {
        int i11 = callbackRequestCodeOffset;
        return i10 >= i11 && i10 < i11 + 100;
    }

    public static final synchronized boolean isFullyInitialized() {
        boolean z10;
        synchronized (FacebookSdk.class) {
            z10 = isFullyInitialized;
        }
        return z10;
    }

    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z10;
        j.g(loggingBehavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            if (!isDebugEnabled() || !hashSet.contains(loggingBehavior)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public static final void loadDefaultsFromMetadata$facebook_core_release(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                j.f(applicationInfo, "try {\n          context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)\n        } catch (e: PackageManager.NameNotFoundException) {\n          return\n        }");
                if (applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            Locale locale = Locale.ROOT;
                            j.f(locale, "ROOT");
                            String lowerCase = str.toLowerCase(locale);
                            j.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            if (r.J(lowerCase, "fb", false, 2, (Object) null)) {
                                String substring = str.substring(2);
                                j.f(substring, "(this as java.lang.String).substring(startIndex)");
                                applicationId = substring;
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Number) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                    if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                        callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
                    }
                    if (codelessDebugLogEnabled == null) {
                        codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    private final void publishInstallAndWaitForResponse(Context context, String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
                String p10 = j.p(str, Ping.ELEMENT);
                long j10 = sharedPreferences.getLong(p10, 0);
                AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                b jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                o oVar = o.f32141a;
                String format2 = String.format(PUBLISH_ACTIVITY_PATH, Arrays.copyOf(new Object[]{str}, 1));
                j.f(format2, "java.lang.String.format(format, *args)");
                GraphRequest createPostRequest = graphRequestCreator.createPostRequest((AccessToken) null, format2, jSONObjectForGraphAPICall, (GraphRequest.Callback) null);
                if (j10 == 0 && createPostRequest.executeAndWait().getError() == null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(p10, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (JSONException e10) {
                throw new FacebookException("An error occurred while publishing install.", (Throwable) e10);
            } catch (Exception e11) {
                try {
                    Utility.logd("Facebook-publish", e11);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }
    }

    public static final void publishInstallAsync(Context context, String str) {
        Class<FacebookSdk> cls = FacebookSdk.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(context, IdentityHttpResponse.CONTEXT);
                j.g(str, "applicationId");
                getExecutor().execute(new g(context.getApplicationContext(), str));
                FeatureManager featureManager = FeatureManager.INSTANCE;
                if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                    OnDeviceProcessingManager.sendInstallEventAsync(str, ATTRIBUTION_PREFERENCES);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: publishInstallAsync$lambda-15  reason: not valid java name */
    public static final void m19publishInstallAsync$lambda15(Context context, String str) {
        j.g(str, "$applicationId");
        FacebookSdk facebookSdk = INSTANCE;
        j.f(context, "applicationContext");
        facebookSdk.publishInstallAndWaitForResponse(context, str);
    }

    public static final void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        j.g(loggingBehavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(loggingBehavior);
        }
    }

    public static final synchronized void sdkInitialize(Context context, int i10) {
        synchronized (FacebookSdk.class) {
            j.g(context, "applicationContext");
            sdkInitialize(context, i10, (InitializeCallback) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-3  reason: not valid java name */
    public static final File m20sdkInitialize$lambda3() {
        Context context = applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        j.y("applicationContext");
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-4  reason: not valid java name */
    public static final void m21sdkInitialize$lambda4(boolean z10) {
        if (z10) {
            InstrumentManager.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-5  reason: not valid java name */
    public static final void m22sdkInitialize$lambda5(boolean z10) {
        if (z10) {
            AppEventsManager.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-6  reason: not valid java name */
    public static final void m23sdkInitialize$lambda6(boolean z10) {
        if (z10) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-7  reason: not valid java name */
    public static final void m24sdkInitialize$lambda7(boolean z10) {
        if (z10) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-8  reason: not valid java name */
    public static final void m25sdkInitialize$lambda8(boolean z10) {
        if (z10) {
            bypassAppSwitch = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-9  reason: not valid java name */
    public static final Void m26sdkInitialize$lambda9(InitializeCallback initializeCallback) {
        AccessTokenManager.Companion.getInstance().loadCurrentAccessToken();
        ProfileManager.Companion.getInstance().loadCurrentProfile();
        if (AccessToken.Companion.isCurrentAccessTokenActive()) {
            Profile.Companion companion = Profile.Companion;
            if (companion.getCurrentProfile() == null) {
                companion.fetchProfileForCurrentAccessToken();
            }
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.Companion companion2 = AppEventsLogger.Companion;
        companion2.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager.logIfAutoAppLinkEnabled();
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        j.f(applicationContext2, "getApplicationContext().applicationContext");
        companion2.newLogger(applicationContext2).flush();
        return null;
    }

    public static final void setAdvertiserIDCollectionEnabled(boolean z10) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z10);
    }

    public static final void setApplicationId(String str) {
        j.g(str, "applicationId");
        Validate.notEmpty(str, "applicationId");
        applicationId = str;
    }

    public static final void setApplicationName(String str) {
        applicationName = str;
    }

    public static final void setAutoInitEnabled(boolean z10) {
        UserSettingsManager.setAutoInitEnabled(z10);
        if (z10) {
            fullyInitialize();
        }
    }

    public static final void setAutoLogAppEventsEnabled(boolean z10) {
        UserSettingsManager.setAutoLogAppEventsEnabled(z10);
        if (z10) {
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            ActivityLifecycleTracker.startTracking((Application) getApplicationContext(), getApplicationId());
        }
    }

    public static final void setCacheDir(File file) {
        j.g(file, "cacheDir");
        cacheDir = new LockOnGetVariable<>(file);
    }

    public static final void setClientToken(String str) {
        appClientToken = str;
    }

    public static final void setCodelessDebugLogEnabled(boolean z10) {
        codelessDebugLogEnabled = Boolean.valueOf(z10);
    }

    public static final void setDataProcessingOptions(String[] strArr) {
        Class<FacebookSdk> cls = FacebookSdk.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                setDataProcessingOptions(strArr, 0, 0);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void setExecutor(Executor executor2) {
        j.g(executor2, "executor");
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            executor = executor2;
            Unit unit = Unit.f32013a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static final void setFacebookDomain(String str) {
        j.g(str, "facebookDomain");
        facebookDomain = str;
    }

    public static final void setGraphApiVersion(String str) {
        j.g(str, "graphApiVersion");
        if (!Utility.isNullOrEmpty(str) && !j.b(graphApiVersion, str)) {
            graphApiVersion = str;
        }
    }

    public static final void setGraphRequestCreator$facebook_core_release(GraphRequestCreator graphRequestCreator2) {
        j.g(graphRequestCreator2, "graphRequestCreator");
        graphRequestCreator = graphRequestCreator2;
    }

    public static final void setIsDebugEnabled(boolean z10) {
        isDebugEnabledField = z10;
    }

    public static final void setLegacyTokenUpgradeSupported(boolean z10) {
        isLegacyTokenUpgradeSupported = z10;
    }

    public static final void setLimitEventAndDataUsage(Context context, boolean z10) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z10).apply();
    }

    public static final void setMonitorEnabled(boolean z10) {
        UserSettingsManager.setMonitorEnabled(z10);
    }

    public static final void setOnProgressThreshold(long j10) {
        onProgressThreshold.set(j10);
    }

    private final void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if (!hashSet.contains(loggingBehavior)) {
                hashSet.add(loggingBehavior);
            }
        }
    }

    public static final synchronized void sdkInitialize(Context context, int i10, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            j.g(context, "applicationContext");
            if (sdkInitialized.get()) {
                if (i10 != callbackRequestCodeOffset) {
                    throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
                }
            }
            if (i10 >= 0) {
                callbackRequestCodeOffset = i10;
                sdkInitialize(context, initializeCallback);
            } else {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            }
        }
    }

    public static final void setDataProcessingOptions(String[] strArr, int i10, int i11) {
        Class<FacebookSdk> cls = FacebookSdk.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if (strArr == null) {
                try {
                    strArr = new String[0];
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, cls);
                    return;
                }
            }
            try {
                b bVar = new b();
                bVar.put(DATA_PROCESSION_OPTIONS, (Object) new a((Collection<?>) l.p0(strArr)));
                bVar.put(DATA_PROCESSION_OPTIONS_COUNTRY, i10);
                bVar.put(DATA_PROCESSION_OPTIONS_STATE, i11);
                Context context = applicationContext;
                if (context != null) {
                    context.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSION_OPTIONS, bVar.toString()).apply();
                } else {
                    j.y("applicationContext");
                    throw null;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public static final synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            j.g(context, "applicationContext");
            sdkInitialize(context, (InitializeCallback) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void sdkInitialize(android.content.Context r5, com.facebook.FacebookSdk.InitializeCallback r6) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            monitor-enter(r0)
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.j.g(r5, r1)     // Catch:{ all -> 0x0107 }
            java.util.concurrent.atomic.AtomicBoolean r1 = sdkInitialized     // Catch:{ all -> 0x0107 }
            boolean r2 = r1.get()     // Catch:{ all -> 0x0107 }
            if (r2 == 0) goto L_0x0018
            if (r6 != 0) goto L_0x0013
            goto L_0x0016
        L_0x0013:
            r6.onInitialized()     // Catch:{ all -> 0x0107 }
        L_0x0016:
            monitor-exit(r0)
            return
        L_0x0018:
            r2 = 0
            com.facebook.internal.Validate.hasFacebookActivity(r5, r2)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.Validate.hasInternetPermissions(r5, r2)     // Catch:{ all -> 0x0107 }
            android.content.Context r3 = r5.getApplicationContext()     // Catch:{ all -> 0x0107 }
            java.lang.String r4 = "applicationContext.applicationContext"
            kotlin.jvm.internal.j.f(r3, r4)     // Catch:{ all -> 0x0107 }
            applicationContext = r3     // Catch:{ all -> 0x0107 }
            com.facebook.appevents.AppEventsLogger$Companion r3 = com.facebook.appevents.AppEventsLogger.Companion     // Catch:{ all -> 0x0107 }
            r3.getAnonymousAppDeviceGUID(r5)     // Catch:{ all -> 0x0107 }
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x0107 }
            r3 = 0
            if (r5 == 0) goto L_0x0101
            loadDefaultsFromMetadata$facebook_core_release(r5)     // Catch:{ all -> 0x0107 }
            java.lang.String r5 = applicationId     // Catch:{ all -> 0x0107 }
            r4 = 1
            if (r5 == 0) goto L_0x0045
            int r5 = r5.length()     // Catch:{ all -> 0x0107 }
            if (r5 != 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r5 = r2
            goto L_0x0046
        L_0x0045:
            r5 = r4
        L_0x0046:
            if (r5 != 0) goto L_0x00f9
            java.lang.String r5 = appClientToken     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0052
            int r5 = r5.length()     // Catch:{ all -> 0x0107 }
            if (r5 != 0) goto L_0x0053
        L_0x0052:
            r2 = r4
        L_0x0053:
            if (r2 != 0) goto L_0x00f1
            r1.set(r4)     // Catch:{ all -> 0x0107 }
            boolean r5 = getAutoInitEnabled()     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0061
            fullyInitialize()     // Catch:{ all -> 0x0107 }
        L_0x0061:
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x00eb
            boolean r5 = r5 instanceof android.app.Application     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0083
            boolean r5 = com.facebook.UserSettingsManager.getAutoLogAppEventsEnabled()     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0083
            com.facebook.appevents.internal.ActivityLifecycleTracker r5 = com.facebook.appevents.internal.ActivityLifecycleTracker.INSTANCE     // Catch:{ all -> 0x0107 }
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x007d
            android.app.Application r5 = (android.app.Application) r5     // Catch:{ all -> 0x0107 }
            java.lang.String r1 = applicationId     // Catch:{ all -> 0x0107 }
            com.facebook.appevents.internal.ActivityLifecycleTracker.startTracking(r5, r1)     // Catch:{ all -> 0x0107 }
            goto L_0x0083
        L_0x007d:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x0083:
            com.facebook.internal.FetchedAppSettingsManager.loadAppSettingsAsync()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.NativeProtocol.updateAllAvailableProtocolVersionsAsync()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.BoltsMeasurementEventListener$Companion r5 = com.facebook.internal.BoltsMeasurementEventListener.Companion     // Catch:{ all -> 0x0107 }
            android.content.Context r1 = applicationContext     // Catch:{ all -> 0x0107 }
            if (r1 == 0) goto L_0x00e5
            r5.getInstance(r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.LockOnGetVariable r5 = new com.facebook.internal.LockOnGetVariable     // Catch:{ all -> 0x0107 }
            com.facebook.h r1 = new com.facebook.h     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            r5.<init>(r1)     // Catch:{ all -> 0x0107 }
            cacheDir = r5     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager r5 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.Instrument     // Catch:{ all -> 0x0107 }
            com.facebook.i r1 = new com.facebook.i     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.AppEvents     // Catch:{ all -> 0x0107 }
            com.facebook.j r1 = new com.facebook.j     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.ChromeCustomTabsPrefetching     // Catch:{ all -> 0x0107 }
            com.facebook.k r1 = new com.facebook.k     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.IgnoreAppSwitchToLoggedOut     // Catch:{ all -> 0x0107 }
            com.facebook.l r1 = new com.facebook.l     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.BypassAppSwitch     // Catch:{ all -> 0x0107 }
            com.facebook.m r1 = new com.facebook.m     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            java.util.concurrent.FutureTask r5 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x0107 }
            com.facebook.n r1 = new com.facebook.n     // Catch:{ all -> 0x0107 }
            r1.<init>(r6)     // Catch:{ all -> 0x0107 }
            r5.<init>(r1)     // Catch:{ all -> 0x0107 }
            java.util.concurrent.Executor r6 = getExecutor()     // Catch:{ all -> 0x0107 }
            r6.execute(r5)     // Catch:{ all -> 0x0107 }
            monitor-exit(r0)
            return
        L_0x00e5:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x00eb:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x00f1:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk."
            r5.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0107 }
            throw r5     // Catch:{ all -> 0x0107 }
        L_0x00f9:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
            r5.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0107 }
            throw r5     // Catch:{ all -> 0x0107 }
        L_0x0101:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x0107:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, com.facebook.FacebookSdk$InitializeCallback):void");
    }
}
