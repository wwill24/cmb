package com.mparticle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.leanplum.internal.Constants;
import com.mparticle.MPEvent;
import com.mparticle.MParticleOptions;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.identity.IdentityApi;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.IdentityApiResult;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.identity.IdentityStateListener;
import com.mparticle.identity.MParticleUser;
import com.mparticle.identity.TaskFailureListener;
import com.mparticle.identity.TaskSuccessListener;
import com.mparticle.internal.InternalSession;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.MParticleJSInterface;
import com.mparticle.internal.PushRegistrationHelper;
import com.mparticle.internal.j;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.internal.o;
import com.mparticle.kits.CommerceEventUtils;
import com.mparticle.media.MPMediaAPI;
import com.mparticle.media.MediaCallbacks;
import com.mparticle.messaging.MPMessagingAPI;
import com.mparticle.messaging.ProviderCloudMessage;
import com.mparticle.segmentation.SegmentListener;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

public class MParticle {
    private static volatile MParticle instance = null;
    static volatile boolean sAndroidIdEnabled = false;
    static volatile boolean sDevicePerformanceMetricsDisabled;
    @NonNull
    protected boolean locationTrackingEnabled = false;
    @NonNull
    protected Context mAppContext;
    @NonNull
    protected com.mparticle.internal.a mAppStateManager;
    @NonNull
    protected volatile AttributionListener mAttributionListener;
    @NonNull
    protected com.mparticle.internal.b mConfigManager;
    @NonNull
    protected d0 mDatabaseManager;
    private IdentityStateListener mDeferredModifyPushRegistrationListener;
    @NonNull
    protected IdentityApi mIdentityApi;
    @NonNull
    protected e mInternal = new e();
    @NonNull
    protected com.mparticle.internal.d mKitManager;
    @NonNull
    protected z mLocationListener;
    @NonNull
    protected MPMediaAPI mMedia;
    @NonNull
    protected j mMessageManager;
    @NonNull
    protected MPMessagingAPI mMessaging;
    @NonNull
    protected SharedPreferences mPreferences;
    @NonNull
    private w0 wrapperSdkVersion = new w0(v0.WrapperNone, (String) null);

    public enum Environment {
        AutoDetect(0),
        Development(1),
        Production(2);
        
        private final int value;

        private Environment(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum EventType {
        Unknown,
        Navigation,
        Location,
        Search,
        Transaction,
        UserContent,
        UserPreference,
        Social,
        Other,
        Media;

        @NonNull
        public String toString() {
            return name();
        }
    }

    public enum IdentityType {
        Other(0),
        CustomerId(1),
        Facebook(2),
        Twitter(3),
        Google(4),
        Microsoft(5),
        Yahoo(6),
        Email(7),
        Alias(8),
        FacebookCustomAudienceId(9),
        Other2(10),
        Other3(11),
        Other4(12),
        Other5(13),
        Other6(14),
        Other7(15),
        Other8(16),
        Other9(17),
        Other10(18),
        MobileNumber(19),
        PhoneNumber2(20),
        PhoneNumber3(21);
        
        private final int value;

        private IdentityType(int i10) {
            this.value = i10;
        }

        @NonNull
        public static IdentityType parseInt(int i10) {
            switch (i10) {
                case 1:
                    return CustomerId;
                case 2:
                    return Facebook;
                case 3:
                    return Twitter;
                case 4:
                    return Google;
                case 5:
                    return Microsoft;
                case 6:
                    return Yahoo;
                case 7:
                    return Email;
                case 8:
                    return Alias;
                case 9:
                    return FacebookCustomAudienceId;
                case 10:
                    return Other2;
                case 11:
                    return Other3;
                case 12:
                    return Other4;
                case 13:
                    return Other5;
                case 14:
                    return Other6;
                case 15:
                    return Other7;
                case 16:
                    return Other8;
                case 17:
                    return Other9;
                case 18:
                    return Other10;
                case 19:
                    return MobileNumber;
                case 20:
                    return PhoneNumber2;
                case 21:
                    return PhoneNumber3;
                default:
                    return Other;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum InstallType {
        AutoDetect,
        KnownInstall,
        KnownUpgrade;

        @NonNull
        public String toString() {
            return name();
        }
    }

    public enum LogLevel {
        NONE(a.e.API_PRIORITY_OTHER),
        ERROR(6),
        WARNING(5),
        DEBUG(3),
        VERBOSE(2),
        INFO(4);
        
        public int logLevel;

        private LogLevel(int i10) {
            this.logLevel = i10;
        }
    }

    public enum OperatingSystem {
        ANDROID,
        FIRE_OS
    }

    public interface ResetListener {
        void onReset();
    }

    public interface ServiceProviders {
        public static final int ADJUST = 68;
        public static final int ADOBE = 124;
        public static final int APPBOY = 28;
        public static final int APPSFLYER = 92;
        public static final int APPTENTIVE = 97;
        public static final int APPTIMIZE = 105;
        public static final int BLUESHIFT = 1144;
        public static final int BRANCH_METRICS = 80;
        @NonNull
        public static final String BROADCAST_ACTIVE = "MPARTICLE_SERVICE_PROVIDER_ACTIVE_";
        @NonNull
        public static final String BROADCAST_DISABLED = "MPARTICLE_SERVICE_PROVIDER_DISABLED_";
        public static final int BUTTON = 1022;
        public static final int CLEVERTAP = 135;
        public static final int COMSCORE = 39;
        public static final int CRITTERCISM = 86;
        public static final int FLURRY = 83;
        public static final int FORESEE_ID = 64;
        public static final int GOOGLE_ANALYTICS_FIREBASE = 136;
        public static final int GOOGLE_ANALYTICS_FIREBASE_GA4 = 160;
        public static final int ITERABLE = 1003;
        public static final int KOCHAVA = 37;
        public static final int LEANPLUM = 98;
        public static final int LOCALYTICS = 84;
        public static final int NEURA = 147;
        public static final int ONETRUST = 134;
        public static final int OPTIMIZELY = 54;
        public static final int PILGRIM = 211;
        public static final int RADAR = 117;
        public static final int RESPONSYS = 102;
        public static final int REVEAL_MOBILE = 112;
        public static final int SINGULAR = 119;
        public static final int SKYHOOK = 121;
        public static final int SWRVE = 1145;
        public static final int TAPLYTICS = 129;
        public static final int TUNE = 32;
        public static final int URBAN_AIRSHIP = 25;
        public static final int WOOTRIC = 90;
    }

    public interface UserAttributes {
        @NonNull
        public static final String ADDRESS = "$Address";
        @NonNull
        public static final String AGE = "$Age";
        @NonNull
        public static final String CITY = "$City";
        @NonNull
        public static final String COUNTRY = "$Country";
        @NonNull
        public static final String FIRSTNAME = "$FirstName";
        @NonNull
        public static final String GENDER = "$Gender";
        @NonNull
        public static final String LASTNAME = "$LastName";
        @NonNull
        public static final String MOBILE_NUMBER = "$Mobile";
        @NonNull
        public static final String STATE = "$State";
        @NonNull
        public static final String ZIPCODE = "$Zip";
    }

    class a implements MediaCallbacks {
        a() {
        }

        public void onAudioPlaying() {
            MParticle.this.mAppStateManager.e();
        }

        public void onAudioStopped() {
            try {
                MParticle.this.mAppStateManager.j().mLastEventTime = System.currentTimeMillis();
            } catch (Exception unused) {
            }
        }
    }

    class b implements TaskFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MParticleOptions f22231a;

        b(MParticleOptions mParticleOptions) {
            this.f22231a = mParticleOptions;
        }

        public void onFailure(IdentityHttpResponse identityHttpResponse) {
            this.f22231a.getIdentityTask().setFailed(identityHttpResponse);
        }
    }

    class c implements TaskSuccessListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MParticleOptions f22233a;

        c(MParticleOptions mParticleOptions) {
            this.f22233a = mParticleOptions;
        }

        public void onSuccess(IdentityApiResult identityApiResult) {
            this.f22233a.getIdentityTask().setSuccessful(identityApiResult);
        }
    }

    class d implements IdentityStateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22235a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22236b;

        d(String str, String str2) {
            this.f22235a = str;
            this.f22236b = str2;
        }

        public void onUserIdentified(MParticleUser mParticleUser, MParticleUser mParticleUser2) {
            if (mParticleUser != null) {
                MParticle.this.Identity().removeIdentityStateListener(this);
                Logger.verbose("Sending previously deferred logPushRegistration Modify request.");
                MParticle.this.sendPushTokenModifyRequest(mParticleUser, this.f22235a, this.f22236b);
            }
        }
    }

    public class e {
        protected e() {
        }

        @NonNull
        public com.mparticle.internal.a a() {
            return MParticle.this.mAppStateManager;
        }

        @NonNull
        public com.mparticle.internal.b b() {
            return MParticle.this.mConfigManager;
        }

        @NonNull
        public com.mparticle.internal.d c() {
            return MParticle.this.mKitManager;
        }

        @NonNull
        public j d() {
            return MParticle.this.mMessageManager;
        }
    }

    protected MParticle() {
    }

    public static void addListener(@NonNull Context context, @NonNull SdkListener sdkListener) {
        InternalListenerManager start = InternalListenerManager.start(context);
        if (start != null) {
            start.addListener(sdkListener);
        }
    }

    private void endSession() {
        if (this.mConfigManager.V()) {
            this.mAppStateManager.j().mLastEventTime = System.currentTimeMillis();
            this.mAppStateManager.d();
        }
    }

    static String getAppState() {
        MParticle instance2;
        if (!com.mparticle.internal.a.f22381o || (instance2 = getInstance()) == null) {
            return "not_running";
        }
        if (instance2.mAppStateManager.l()) {
            return Constants.Params.BACKGROUND;
        }
        return "foreground";
    }

    public static String getDeviceImei() {
        return com.mparticle.internal.c.a();
    }

    @NonNull
    private static MParticle getInstance(@NonNull Context context, @NonNull MParticleOptions mParticleOptions) {
        if (instance == null) {
            synchronized (MParticle.class) {
                if (instance == null) {
                    sDevicePerformanceMetricsDisabled = mParticleOptions.isDevicePerformanceMetricsDisabled().booleanValue();
                    sAndroidIdEnabled = mParticleOptions.isAndroidIdEnabled().booleanValue();
                    setLogLevel(mParticleOptions.getLogLevel());
                    if (!MPUtility.checkPermission(context.getApplicationContext(), "android.permission.INTERNET")) {
                        Logger.error("mParticle requires android.permission.INTERNET permission.");
                    }
                    instance = new MParticle(mParticleOptions);
                    instance.mKitManager = new com.mparticle.internal.d(mParticleOptions.getContext(), instance.mMessageManager, instance.Internal().b(), instance.Internal().a(), mParticleOptions);
                    instance.mIdentityApi = new IdentityApi(mParticleOptions.getContext(), instance.mInternal.a(), instance.mMessageManager, instance.mConfigManager, instance.mKitManager, mParticleOptions.getOperatingSystem());
                    instance.mMessageManager.x();
                    instance.identify(mParticleOptions);
                    if (mParticleOptions.hasLocationTracking()) {
                        MParticleOptions.LocationTracking locationTracking = mParticleOptions.getLocationTracking();
                        if (locationTracking.enabled) {
                            instance.enableLocationTracking(locationTracking.provider, locationTracking.minTime, locationTracking.minDistance);
                        } else {
                            instance.disableLocationTracking();
                        }
                    }
                    if (instance.Internal().b().D()) {
                        instance.enableUncaughtExceptionLogging();
                    }
                    if (mParticleOptions.getAttributionListener() != null) {
                        instance.mAttributionListener = mParticleOptions.getAttributionListener();
                    }
                    instance.mMessageManager.r();
                    instance.mInternal.a().a(Build.VERSION.SDK_INT);
                    if (context instanceof Activity) {
                        instance.mAppStateManager.d((Activity) context);
                    }
                    PushRegistrationHelper.PushRegistration pushRegistration = mParticleOptions.getPushRegistration();
                    if (pushRegistration != null) {
                        instance.logPushRegistration(pushRegistration.instanceId, pushRegistration.senderId);
                    } else {
                        String L = instance.mConfigManager.L();
                        if (L != null) {
                            instance.updatePushToken(instance.mConfigManager.K(), L);
                            instance.mConfigManager.e();
                        }
                    }
                    instance.mConfigManager.a0();
                }
            }
        }
        return instance;
    }

    private void identify(MParticleOptions mParticleOptions) {
        IdentityApiRequest identifyRequest = mParticleOptions.getIdentifyRequest();
        if (identifyRequest == null) {
            MParticleUser currentUser = Identity().getCurrentUser();
            if (currentUser != null) {
                identifyRequest = IdentityApiRequest.withUser(currentUser).build();
            } else {
                identifyRequest = IdentityApiRequest.withEmptyUser().build();
            }
        }
        MParticleTask<IdentityApiResult> identify = instance.mIdentityApi.identify(identifyRequest);
        if (mParticleOptions.getIdentityTask() != null) {
            identify.addFailureListener(new b(mParticleOptions));
            identify.addSuccessListener(new c(mParticleOptions));
        }
    }

    @Deprecated
    public static boolean isAndroidIdDisabled() {
        return !sAndroidIdEnabled;
    }

    public static boolean isAndroidIdEnabled() {
        return sAndroidIdEnabled;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$reset$0(Context context, ResetListener resetListener, HandlerThread handlerThread) {
        reset(context);
        if (resetListener != null) {
            try {
                resetListener.onReset();
            } catch (Exception unused) {
            }
        }
        handlerThread.quit();
    }

    private void logCommerceEvent(@NonNull CommerceEvent commerceEvent) {
        if (this.mConfigManager.V()) {
            this.mAppStateManager.e();
            this.mMessageManager.a(commerceEvent);
            Logger.debug("Logged commerce event - \n", commerceEvent.toString());
            this.mKitManager.logEvent(commerceEvent);
        }
    }

    private void logMPEvent(@NonNull MPEvent mPEvent) {
        if (this.mConfigManager.V()) {
            this.mAppStateManager.e();
            this.mMessageManager.a(mPEvent, this.mAppStateManager.g());
            Logger.debug("Logged event - \n", mPEvent.toString());
            this.mKitManager.logEvent(mPEvent);
        }
    }

    public static void removeListener(SdkListener sdkListener) {
        InternalListenerManager start = InternalListenerManager.start((Context) null);
        if (start != null) {
            start.removeListener(sdkListener);
        }
    }

    public static void reset(@NonNull Context context) {
        reset(context, true);
    }

    /* access modifiers changed from: private */
    public void sendPushTokenModifyRequest(MParticleUser mParticleUser, String str, String str2) {
        Identity().modify(new Builder(mParticleUser).pushToken(str, str2).build());
    }

    public static void setDeviceImei(String str) {
        com.mparticle.internal.c.a(str);
    }

    public static void setInstance(MParticle mParticle) {
        instance = mParticle;
    }

    public static void setLogLevel(@NonNull LogLevel logLevel) {
        if (logLevel != null) {
            Logger.setMinLogLevel(logLevel, Boolean.TRUE);
        }
    }

    public static void start(@NonNull MParticleOptions mParticleOptions) {
        getInstance(mParticleOptions.getContext(), mParticleOptions);
    }

    private void updatePushToken(String str, String str2) {
        MParticleUser currentUser = Identity().getCurrentUser();
        if (currentUser != null) {
            sendPushTokenModifyRequest(currentUser, str, str2);
            return;
        }
        if (this.mDeferredModifyPushRegistrationListener != null) {
            Identity().removeIdentityStateListener(this.mDeferredModifyPushRegistrationListener);
            Logger.verbose("Removed deferred logPushRegistration Modify request.");
        }
        this.mDeferredModifyPushRegistrationListener = new d(str, str2);
        Identity().addIdentityStateListener(this.mDeferredModifyPushRegistrationListener);
        Logger.verbose("Deferred logPushRegistration Modify request, MParticleUser not present.");
    }

    @NonNull
    public IdentityApi Identity() {
        return this.mIdentityApi;
    }

    @NonNull
    public e Internal() {
        return this.mInternal;
    }

    @NonNull
    public MPMediaAPI Media() {
        if (this.mMedia == null) {
            this.mMedia = new MPMediaAPI(this.mAppContext, new a());
        }
        return this.mMedia;
    }

    @NonNull
    public MPMessagingAPI Messaging() {
        if (this.mMessaging == null) {
            this.mMessaging = new MPMessagingAPI(this.mAppContext);
        }
        return this.mMessaging;
    }

    @SuppressLint({"MissingPermission"})
    public void disableLocationTracking() {
        if (this.mLocationListener != null) {
            try {
                LocationManager locationManager = (LocationManager) this.mAppContext.getSystemService("location");
                if (MPUtility.checkPermission(this.mAppContext, "android.permission.ACCESS_FINE_LOCATION") || MPUtility.checkPermission(this.mAppContext, "android.permission.ACCESS_COARSE_LOCATION")) {
                    try {
                        locationManager.removeUpdates(this.mLocationListener);
                        this.locationTrackingEnabled = false;
                    } catch (SecurityException unused) {
                    }
                }
                this.mLocationListener = null;
                this.mPreferences.edit().remove("mp::location:provider").remove("mp::location:mintime").remove("mp::location:mindistance").apply();
            } catch (Exception unused2) {
            }
        }
    }

    public void disableUncaughtExceptionLogging() {
        this.mConfigManager.a(true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|(1:10)(1:11)|12|13|14|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableLocationTracking(@androidx.annotation.NonNull java.lang.String r8, long r9, long r11) {
        /*
            r7 = this;
            com.mparticle.internal.b r0 = r7.mConfigManager
            boolean r0 = r0.V()
            if (r0 == 0) goto L_0x0062
            android.content.Context r0 = r7.mAppContext     // Catch:{ SecurityException -> 0x0059 }
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ SecurityException -> 0x0059 }
            r1 = r0
            android.location.LocationManager r1 = (android.location.LocationManager) r1     // Catch:{ SecurityException -> 0x0059 }
            boolean r0 = r1.isProviderEnabled(r8)     // Catch:{ SecurityException -> 0x0059 }
            if (r0 != 0) goto L_0x0023
            java.lang.String r8 = "That requested location provider is not available."
            java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch:{ SecurityException -> 0x0059 }
            com.mparticle.internal.Logger.error(r8)     // Catch:{ SecurityException -> 0x0059 }
            return
        L_0x0023:
            com.mparticle.z r0 = r7.mLocationListener     // Catch:{ SecurityException -> 0x003d }
            if (r0 != 0) goto L_0x002f
            com.mparticle.z r0 = new com.mparticle.z     // Catch:{ SecurityException -> 0x003d }
            r0.<init>(r7)     // Catch:{ SecurityException -> 0x003d }
            r7.mLocationListener = r0     // Catch:{ SecurityException -> 0x003d }
            goto L_0x0032
        L_0x002f:
            r1.removeUpdates(r0)     // Catch:{ SecurityException -> 0x003d }
        L_0x0032:
            float r5 = (float) r11     // Catch:{ SecurityException -> 0x003d }
            com.mparticle.z r6 = r7.mLocationListener     // Catch:{ SecurityException -> 0x003d }
            r2 = r8
            r3 = r9
            r1.requestLocationUpdates(r2, r3, r5, r6)     // Catch:{ SecurityException -> 0x003d }
            r0 = 1
            r7.locationTrackingEnabled = r0     // Catch:{ SecurityException -> 0x003d }
        L_0x003d:
            android.content.SharedPreferences r0 = r7.mPreferences     // Catch:{ SecurityException -> 0x0059 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ SecurityException -> 0x0059 }
            java.lang.String r1 = "mp::location:provider"
            android.content.SharedPreferences$Editor r8 = r0.putString(r1, r8)     // Catch:{ SecurityException -> 0x0059 }
            java.lang.String r0 = "mp::location:mintime"
            android.content.SharedPreferences$Editor r8 = r8.putLong(r0, r9)     // Catch:{ SecurityException -> 0x0059 }
            java.lang.String r9 = "mp::location:mindistance"
            android.content.SharedPreferences$Editor r8 = r8.putLong(r9, r11)     // Catch:{ SecurityException -> 0x0059 }
            r8.apply()     // Catch:{ SecurityException -> 0x0059 }
            goto L_0x0062
        L_0x0059:
            java.lang.String r8 = "The app must require the appropriate permissions to track location using this provider."
            java.lang.String[] r8 = new java.lang.String[]{r8}
            com.mparticle.internal.Logger.error(r8)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.MParticle.enableLocationTracking(java.lang.String, long, long):void");
    }

    public void enableUncaughtExceptionLogging() {
        this.mConfigManager.b(true);
    }

    public AttributionListener getAttributionListener() {
        return this.mAttributionListener;
    }

    @NonNull
    public Map<Integer, AttributionResult> getAttributionResults() {
        return this.mKitManager.getAttributionResults();
    }

    public Session getCurrentSession() {
        InternalSession j10 = this.mAppStateManager.j();
        if (j10 == null || !j10.isActive() || j10.isTimedOut(this.mConfigManager.O())) {
            return null;
        }
        return new Session(j10.mSessionID, Long.valueOf(j10.mSessionStartTime));
    }

    @NonNull
    public Environment getEnvironment() {
        return com.mparticle.internal.b.u();
    }

    public String getInstallReferrer() {
        return k.a(this.mAppContext);
    }

    @NonNull
    public Map<String, String> getIntegrationAttributes(int i10) {
        return Internal().b().a(i10);
    }

    public Object getKitInstance(int i10) {
        return this.mKitManager.getKitInstance(i10);
    }

    @NonNull
    public Boolean getOptOut() {
        return Boolean.valueOf(this.mConfigManager.H());
    }

    public int getSessionTimeout() {
        return this.mConfigManager.O() / 1000;
    }

    public Uri getSurveyUrl(int i10) {
        return this.mKitManager.getSurveyUrl(i10, (Map<String, String>) null, (Map<String, List<String>>) null);
    }

    public void getUserSegments(long j10, @NonNull String str, @NonNull SegmentListener segmentListener) {
        o oVar;
        j jVar = this.mMessageManager;
        if (jVar != null && (oVar = jVar.f22501g) != null) {
            oVar.a(j10, str, segmentListener);
        }
    }

    public w0 getWrapperSdkVersion() {
        return this.wrapperSdkVersion;
    }

    public void incrementSessionAttribute(@NonNull String str, int i10) {
        if (str == null) {
            Logger.warning("incrementSessionAttribute called with null key. Ignoring...");
        } else if (this.mConfigManager.V()) {
            this.mAppStateManager.e();
            Logger.debug("Incrementing session attribute: " + str + "=" + i10);
            if (MPUtility.setCheckedAttribute(this.mAppStateManager.j().mSessionAttributes, str, Integer.valueOf(i10), true, true).booleanValue()) {
                this.mMessageManager.y();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void installReferrerUpdated() {
        this.mMessageManager.s();
        this.mKitManager.installReferrerUpdated();
    }

    @NonNull
    @Deprecated
    public Boolean isAutoTrackingEnabled() {
        return Boolean.FALSE;
    }

    public boolean isDevicePerformanceMetricsDisabled() {
        return this.mMessageManager.t();
    }

    public boolean isKitActive(int i10) {
        return this.mKitManager.isKitActive(i10);
    }

    public boolean isLocationTrackingEnabled() {
        return this.locationTrackingEnabled;
    }

    public boolean isProviderActive(int i10) {
        return isKitActive(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean isSessionActive() {
        return this.mAppStateManager.j().isActive();
    }

    public void leaveBreadcrumb(@NonNull String str) {
        if (!this.mConfigManager.V()) {
            return;
        }
        if (MPUtility.isEmpty((CharSequence) str)) {
            Logger.error("breadcrumb is required for leaveBreadcrumb.");
        } else if (str.length() > 256) {
            Logger.error("The breadcrumb name was too long. Discarding event.");
        } else {
            this.mAppStateManager.e();
            this.mMessageManager.a(str);
            Logger.debug("Logged breadcrumb: " + str);
            this.mKitManager.leaveBreadcrumb(str);
        }
    }

    public void logError(@NonNull String str) {
        logError(str, (Map<String, String>) null);
    }

    public void logEvent(@NonNull BaseEvent baseEvent) {
        if ((baseEvent instanceof MPEvent) && baseEvent.isShouldUploadEvent()) {
            logMPEvent((MPEvent) baseEvent);
        } else if ((baseEvent instanceof CommerceEvent) && baseEvent.isShouldUploadEvent()) {
            logCommerceEvent((CommerceEvent) baseEvent);
        } else if (this.mConfigManager.V()) {
            this.mAppStateManager.e();
            Logger.debug("Logged event - \n", baseEvent.toString());
            this.mKitManager.logEvent(baseEvent);
        }
    }

    public void logException(@NonNull Exception exc) {
        logException(exc, (Map<String, String>) null, (String) null);
    }

    public void logLtvIncrease(@NonNull BigDecimal bigDecimal, String str, Map<String, String> map) {
        if (bigDecimal == null) {
            Logger.error("ValueIncreased must not be null.");
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(CommerceEventUtils.Constants.RESERVED_KEY_LTV, bigDecimal.toPlainString());
        map.put("$MethodName", "LogLTVIncrease");
        if (str == null) {
            str = "Increase LTV";
        }
        logEvent(new MPEvent.Builder(str, EventType.Transaction).customAttributes(map).build());
    }

    public void logNetworkPerformance(@NonNull String str, long j10, @NonNull String str2, long j11, long j12, long j13, String str3, int i10) {
        if (this.mConfigManager.V()) {
            this.mAppStateManager.e();
            this.mMessageManager.a(j10, str2, str, j11, j12, j13, str3);
            this.mKitManager.logNetworkPerformance(str, j10, str2, j11, j12, j13, str3, i10);
        }
    }

    public void logNotification(@NonNull Intent intent) {
        if (this.mConfigManager.V()) {
            this.mMessageManager.a(ProviderCloudMessage.createMessage(intent, com.mparticle.internal.b.e(this.mAppContext)), getAppState());
        }
    }

    public void logNotificationOpened(@NonNull Intent intent) {
        logNotification(ProviderCloudMessage.createMessage(intent, com.mparticle.internal.b.e(this.mAppContext)), true, getAppState(), 6);
    }

    public void logPushRegistration(String str, String str2) {
        this.mAppStateManager.e();
        PushRegistrationHelper.PushRegistration pushRegistration = new PushRegistrationHelper.PushRegistration(str, str2);
        String K = this.mConfigManager.K();
        this.mConfigManager.a(pushRegistration);
        this.mMessageManager.a(str, true);
        this.mKitManager.onPushRegistration(str, str2);
        updatePushToken(str, K);
    }

    public void logScreen(@NonNull String str) {
        logScreen(str, (Map<String, String>) null);
    }

    /* access modifiers changed from: package-private */
    public void logUnhandledError(Throwable th2) {
        String str;
        if (this.mConfigManager.V()) {
            j jVar = this.mMessageManager;
            if (th2 != null) {
                str = th2.getMessage();
            } else {
                str = null;
            }
            jVar.a(str, th2, (org.json.b) null, false);
            com.mparticle.internal.a aVar = this.mAppStateManager;
            aVar.a("app_exit", aVar.g());
            this.mAppStateManager.j().mLastEventTime = System.currentTimeMillis();
            this.mAppStateManager.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshConfiguration() {
        Logger.debug("Refreshing configuration...");
        this.mMessageManager.x();
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void registerWebView(@NonNull WebView webView) {
        registerWebView(webView, (String) null);
    }

    public void removeAttributionListener() {
        this.mAttributionListener = null;
    }

    public void setInstallReferrer(String str) {
        k.a(this.mAppContext, str);
    }

    public void setIntegrationAttributes(int i10, Map<String, String> map) {
        Internal().b().a(i10, map);
    }

    public void setLocation(Location location) {
        this.mMessageManager.a(location);
        this.mKitManager.setLocation(location);
    }

    public void setOptOut(@NonNull Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue() != this.mConfigManager.H()) {
                if (!bool.booleanValue()) {
                    this.mAppStateManager.e();
                }
                this.mMessageManager.a(System.currentTimeMillis(), bool.booleanValue());
                if (bool.booleanValue() && isSessionActive()) {
                    endSession();
                }
                this.mConfigManager.f(bool.booleanValue());
                Logger.debug("Set opt-out: " + bool);
            }
            this.mKitManager.setOptOut(bool.booleanValue());
        }
    }

    public void setSessionAttribute(@NonNull String str, Object obj) {
        if (str == null) {
            Logger.warning("setSessionAttribute called with null key. Ignoring...");
            return;
        }
        if (obj != null) {
            obj = obj.toString();
        }
        if (this.mConfigManager.V()) {
            this.mAppStateManager.e();
            Logger.debug("Set session attribute: " + str + "=" + obj);
            if (MPUtility.setCheckedAttribute(this.mAppStateManager.j().mSessionAttributes, str, obj, false, false).booleanValue()) {
                this.mMessageManager.y();
            }
        }
    }

    public void setUpdateInterval(int i10) {
        long j10 = ((long) i10) * 1000;
        if (j10 >= 1 && this.mConfigManager.R() != j10) {
            upload();
            this.mConfigManager.d(i10);
        }
    }

    public void setWrapperSdk(v0 v0Var, String str) {
        v0 a10 = this.wrapperSdkVersion.a();
        v0 v0Var2 = v0.WrapperNone;
        if (a10 == v0Var2 && v0Var != v0Var2 && !str.isEmpty()) {
            this.wrapperSdkVersion = new w0(v0Var, str);
        }
    }

    public void upload() {
        this.mMessageManager.j();
    }

    class Builder extends IdentityApiRequest.Builder {
        Builder(MParticleUser mParticleUser) {
            super(mParticleUser);
        }

        /* access modifiers changed from: protected */
        @NonNull
        public IdentityApiRequest.Builder pushToken(String str, String str2) {
            return super.pushToken(str, str2);
        }

        Builder() {
        }
    }

    static void reset(@NonNull Context context, boolean z10) {
        synchronized (MParticle.class) {
            context.getSharedPreferences("mp_preferences", 0).edit().clear().commit();
            if (instance != null) {
                if (instance.isLocationTrackingEnabled()) {
                    instance.disableLocationTracking();
                }
                instance.mMessageManager.i();
                instance.mIdentityApi.Internal().a();
                setInstance((MParticle) null);
            }
            j.h();
            HashSet hashSet = new HashSet();
            hashSet.add("mp_preferences");
            hashSet.add("mParticlePrefs");
            hashSet.add("mparticle_config.json");
            hashSet.add(JsonPacketExtension.ELEMENT);
            hashSet.add("com.mparticle.kits.urbanairship");
            String replace = context.getFilesDir().getPath().replace(Constants.Keys.FILES, "shared_prefs/");
            File[] listFiles = new File(replace).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    String replace2 = file.getPath().replace(replace, "").replace(".xml", "");
                    if (replace2.startsWith("mp::kit::") || replace2.startsWith("mp_preferences:") || hashSet.contains(replace2)) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(replace2, 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().clear().commit();
                        }
                        file.delete();
                    }
                }
            }
            if (z10) {
                context.deleteDatabase(e0.a());
            }
        }
    }

    public void logError(@NonNull String str, Map<String, String> map) {
        if (!this.mConfigManager.V()) {
            return;
        }
        if (MPUtility.isEmpty((CharSequence) str)) {
            Logger.error("message is required for logErrorEvent.");
            return;
        }
        this.mAppStateManager.e();
        org.json.b enforceAttributeConstraints = MPUtility.enforceAttributeConstraints(map);
        this.mMessageManager.a(str, (Throwable) null, enforceAttributeConstraints);
        String[] strArr = new String[1];
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Logged error with message: ");
        String str2 = "<none>";
        sb2.append(str == null ? str2 : str);
        sb2.append(" with data: ");
        if (enforceAttributeConstraints != null) {
            str2 = enforceAttributeConstraints.toString();
        }
        sb2.append(str2);
        strArr[0] = sb2.toString();
        Logger.debug(strArr);
        this.mKitManager.logError(str, map);
    }

    public void logException(@NonNull Exception exc, Map<String, String> map) {
        logException(exc, map, (String) null);
    }

    public void logScreen(@NonNull String str, Map<String, String> map) {
        logScreen(str, map, Boolean.TRUE);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void registerWebView(@NonNull WebView webView, String str) {
        MParticleJSInterface.registerWebView(webView, str);
    }

    public void logException(@NonNull Exception exc, Map<String, String> map, String str) {
        String str2;
        if (this.mConfigManager.V()) {
            this.mAppStateManager.e();
            org.json.b enforceAttributeConstraints = MPUtility.enforceAttributeConstraints(map);
            this.mMessageManager.a(str, (Throwable) exc, enforceAttributeConstraints);
            String[] strArr = new String[1];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Logged exception with message: ");
            String str3 = "<none>";
            sb2.append(str == null ? str3 : str);
            sb2.append(" with data: ");
            if (enforceAttributeConstraints == null) {
                str2 = str3;
            } else {
                str2 = enforceAttributeConstraints.toString();
            }
            sb2.append(str2);
            sb2.append(" with exception: ");
            if (exc != null) {
                str3 = exc.getMessage();
            }
            sb2.append(str3);
            strArr[0] = sb2.toString();
            Logger.debug(strArr);
            this.mKitManager.logException(exc, map, str);
        }
    }

    public void logScreen(@NonNull String str, Map<String, String> map, @NonNull Boolean bool) {
        logScreen(new MPEvent.Builder(str).shouldUploadEvent(bool.booleanValue()).customAttributes(map).build().setScreenEvent(true));
    }

    /* access modifiers changed from: package-private */
    public void logNotification(@NonNull ProviderCloudMessage providerCloudMessage, boolean z10, @NonNull String str, int i10) {
        if (this.mConfigManager.V()) {
            if (z10) {
                this.mAppStateManager.e();
            }
            this.mMessageManager.a(providerCloudMessage.getId(), providerCloudMessage.getRedactedJsonPayload().toString(), str, i10);
        }
    }

    public void logScreen(@NonNull MPEvent mPEvent) {
        mPEvent.setScreenEvent(true);
        if (MPUtility.isEmpty((CharSequence) mPEvent.getEventName())) {
            Logger.error("screenName is required for logScreen.");
        } else if (mPEvent.getEventName().length() > 256) {
            Logger.error("The screen name was too long. Discarding event.");
        } else {
            this.mAppStateManager.e();
            if (this.mConfigManager.V() && mPEvent.isShouldUploadEvent()) {
                this.mMessageManager.a(mPEvent, mPEvent.getNavigationDirection());
                Logger.debug("Logged screen: ", mPEvent.toString());
            }
            if (mPEvent.getNavigationDirection()) {
                this.mKitManager.logScreen(mPEvent);
            }
        }
    }

    private MParticle(MParticleOptions mParticleOptions) {
        com.mparticle.internal.b bVar = new com.mparticle.internal.b(mParticleOptions);
        bVar.d(mParticleOptions.getUploadInterval().intValue());
        bVar.c(mParticleOptions.getSessionTimeout().intValue());
        bVar.b(mParticleOptions.getConnectionTimeout());
        com.mparticle.internal.a aVar = new com.mparticle.internal.a(mParticleOptions.getContext());
        aVar.a(bVar);
        Context context = mParticleOptions.getContext();
        this.mAppContext = context;
        this.mConfigManager = bVar;
        this.mAppStateManager = aVar;
        this.mDatabaseManager = new d0(context, mParticleOptions);
        if (mParticleOptions.isUncaughtExceptionLoggingEnabled().booleanValue()) {
            enableUncaughtExceptionLogging();
        } else {
            disableUncaughtExceptionLogging();
        }
        this.mMessageManager = new j(bVar, aVar, this.mKitManager, sDevicePerformanceMetricsDisabled, this.mDatabaseManager, mParticleOptions);
        this.mConfigManager.a(mParticleOptions.getNetworkOptions());
        this.mPreferences = mParticleOptions.getContext().getSharedPreferences("mParticlePrefs", 0);
    }

    /* access modifiers changed from: package-private */
    public void logNotification(@NonNull ProviderCloudMessage providerCloudMessage, boolean z10, @NonNull String str) {
        if (this.mConfigManager.V()) {
            if (z10) {
                this.mAppStateManager.e();
            }
            this.mMessageManager.a(providerCloudMessage, str);
        }
    }

    public static void reset(@NonNull Context context, ResetListener resetListener) {
        HandlerThread handlerThread = new HandlerThread("mParticleShutdownHandler");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new x0(context, resetListener, handlerThread));
    }

    public static MParticle getInstance() {
        if (instance != null) {
            return getInstance((Context) null, (MParticleOptions) null);
        }
        Logger.debug("Failed to get MParticle instance, getInstance() called prior to start().");
        return null;
    }
}
