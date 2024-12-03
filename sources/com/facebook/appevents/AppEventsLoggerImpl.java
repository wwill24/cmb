package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mparticle.identity.IdentityHttpResponse;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u0000 :2\u00020\u0001:\u0001:B%\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J;\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J.\u0010 \u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J)\u0010 \u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010%J\u0001\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001a\u00104\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J&\u00104\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J,\u00104\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0013J$\u00105\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010\u0005J'\u00109\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010%R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl;", "", "context", "Landroid/content/Context;", "applicationId", "", "accessToken", "Lcom/facebook/AccessToken;", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "activityName", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "getApplicationId", "()Ljava/lang/String;", "contextName", "flush", "", "isValidForAccessToken", "", "logEvent", "eventName", "parameters", "Landroid/os/Bundle;", "valueToSum", "", "isImplicitlyLogged", "currentSessionId", "Ljava/util/UUID;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZLjava/util/UUID;)V", "logEventFromSE", "buttonText", "logEventImplicitly", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logProductItem", "itemID", "availability", "Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "condition", "Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "description", "imageLink", "link", "title", "priceAmount", "gtin", "mpn", "brand", "logPurchase", "logPurchaseImplicitly", "logPushNotificationOpen", "payload", "action", "logSdkEvent", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventsLoggerImpl {
    private static final String ACCOUNT_KIT_EVENT_NAME_PREFIX = "fb_ak";
    private static final String APP_EVENTS_KILLSWITCH = "app_events_killswitch";
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    private static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    private static final String TAG;
    private static String anonymousAppDeviceGUID;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static AppEventsLogger.FlushBehavior flushBehaviorField = AppEventsLogger.FlushBehavior.AUTO;
    private static boolean isActivateAppEventRequested;
    private static String pushNotificationsRegistrationIdField;
    private static final Object staticLock = new Object();
    private AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u0006\u0010\"\u001a\u00020\u0019J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0004H\u0007J\b\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010(\u001a\u00020\u0013H\u0007J\n\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010,\u001a\u00020\u0019H\u0002J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0004H\u0002J\b\u00104\u001a\u00020\u0019H\u0007J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0013H\u0007J\u0012\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl$Companion;", "", "()V", "ACCOUNT_KIT_EVENT_NAME_PREFIX", "", "APP_EVENTS_KILLSWITCH", "APP_EVENT_NAME_PUSH_OPENED", "APP_EVENT_PREFERENCES", "APP_EVENT_PUSH_PARAMETER_ACTION", "APP_EVENT_PUSH_PARAMETER_CAMPAIGN", "APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS", "", "PUSH_PAYLOAD_CAMPAIGN_KEY", "PUSH_PAYLOAD_KEY", "TAG", "anonymousAppDeviceGUID", "backgroundExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "flushBehaviorField", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "isActivateAppEventRequested", "", "pushNotificationsRegistrationIdField", "staticLock", "activateApp", "", "application", "Landroid/app/Application;", "applicationId", "augmentWebView", "webView", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "eagerFlush", "functionDEPRECATED", "extraMsg", "getAnalyticsExecutor", "Ljava/util/concurrent/Executor;", "getAnonymousAppDeviceGUID", "getFlushBehavior", "getInstallReferrer", "getPushNotificationsRegistrationId", "initializeLib", "initializeTimersIfNeeded", "logEvent", "event", "Lcom/facebook/appevents/AppEvent;", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "notifyDeveloperError", "message", "onContextStop", "setFlushBehavior", "flushBehavior", "setInstallReferrer", "referrer", "setPushNotificationsRegistrationId", "registrationId", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: initializeLib$lambda-4  reason: not valid java name */
        public static final void m43initializeLib$lambda4(Context context, AppEventsLoggerImpl appEventsLoggerImpl) {
            j.g(context, "$context");
            j.g(appEventsLoggerImpl, "$logger");
            Bundle bundle = new Bundle();
            String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
            String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = i10 + 1;
                String str = strArr[i10];
                String str2 = strArr2[i10];
                try {
                    Class.forName(str);
                    bundle.putInt(str2, 1);
                    i11 |= 1 << i10;
                } catch (ClassNotFoundException unused) {
                }
                if (i12 > 10) {
                    break;
                }
                i10 = i12;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (sharedPreferences.getInt("kitsBitmask", 0) != i11) {
                sharedPreferences.edit().putInt("kitsBitmask", i11).apply();
                appEventsLoggerImpl.logEventImplicitly(AnalyticsEvents.EVENT_SDK_INITIALIZE, (Double) null, bundle);
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            r3 = new com.facebook.appevents.i();
            r2 = com.facebook.appevents.AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
            if (r2 == null) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            r2.scheduleAtFixedRate(r3, 0, 86400, java.util.concurrent.TimeUnit.SECONDS);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
            throw new java.lang.IllegalStateException("Required value was null.".toString());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void initializeTimersIfNeeded() {
            /*
                r9 = this;
                java.lang.Object r0 = com.facebook.appevents.AppEventsLoggerImpl.access$getStaticLock$cp()
                monitor-enter(r0)
                java.util.concurrent.ScheduledThreadPoolExecutor r1 = com.facebook.appevents.AppEventsLoggerImpl.access$getBackgroundExecutor$cp()     // Catch:{ all -> 0x003b }
                if (r1 == 0) goto L_0x000d
                monitor-exit(r0)
                return
            L_0x000d:
                java.util.concurrent.ScheduledThreadPoolExecutor r1 = new java.util.concurrent.ScheduledThreadPoolExecutor     // Catch:{ all -> 0x003b }
                r2 = 1
                r1.<init>(r2)     // Catch:{ all -> 0x003b }
                com.facebook.appevents.AppEventsLoggerImpl.access$setBackgroundExecutor$cp(r1)     // Catch:{ all -> 0x003b }
                kotlin.Unit r1 = kotlin.Unit.f32013a     // Catch:{ all -> 0x003b }
                monitor-exit(r0)
                com.facebook.appevents.i r3 = new com.facebook.appevents.i
                r3.<init>()
                java.util.concurrent.ScheduledThreadPoolExecutor r2 = com.facebook.appevents.AppEventsLoggerImpl.access$getBackgroundExecutor$cp()
                if (r2 == 0) goto L_0x002f
                r4 = 0
                r6 = 86400(0x15180, double:4.26873E-319)
                java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
                r2.scheduleAtFixedRate(r3, r4, r6, r8)
                return
            L_0x002f:
                java.lang.String r0 = "Required value was null."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            L_0x003b:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLoggerImpl.Companion.initializeTimersIfNeeded():void");
        }

        /* access modifiers changed from: private */
        /* renamed from: initializeTimersIfNeeded$lambda-6  reason: not valid java name */
        public static final void m44initializeTimersIfNeeded$lambda6() {
            HashSet<String> hashSet = new HashSet<>();
            for (AccessTokenAppIdPair applicationId : AppEventQueue.getKeySet()) {
                hashSet.add(applicationId.getApplicationId());
            }
            for (String queryAppSettings : hashSet) {
                FetchedAppSettingsManager.queryAppSettings(queryAppSettings, true);
            }
        }

        /* access modifiers changed from: private */
        public final void logEvent(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
            AppEventQueue.add(accessTokenAppIdPair, appEvent);
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDevicePostInstallEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendCustomEventAsync(accessTokenAppIdPair.getApplicationId(), appEvent);
            }
            if (!appEvent.getIsImplicit() && !AppEventsLoggerImpl.access$isActivateAppEventRequested$cp()) {
                if (j.b(appEvent.getName(), AppEventsConstants.EVENT_NAME_ACTIVATED_APP)) {
                    AppEventsLoggerImpl.access$setActivateAppEventRequested$cp(true);
                } else {
                    Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
                }
            }
        }

        /* access modifiers changed from: private */
        public final void notifyDeveloperError(String str) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
        }

        public final void activateApp(Application application, String str) {
            j.g(application, "application");
            if (FacebookSdk.isInitialized()) {
                AnalyticsUserIDStore.initStore();
                UserDataStore.initStore();
                if (str == null) {
                    str = FacebookSdk.getApplicationId();
                }
                FacebookSdk.publishInstallAsync(application, str);
                ActivityLifecycleTracker.startTracking(application, str);
                return;
            }
            throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
        }

        public final void augmentWebView(WebView webView, Context context) {
            boolean z10;
            int i10;
            j.g(webView, "webView");
            String str = Build.VERSION.RELEASE;
            j.f(str, "RELEASE");
            List C0 = StringsKt__StringsKt.C0(str, new String[]{"."}, false, 0, 6, (Object) null);
            int i11 = 0;
            Object[] array2 = C0.toArray(new String[0]);
            if (array2 != null) {
                String[] strArr = (String[]) array2;
                if (strArr.length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    i10 = Integer.parseInt(strArr[0]);
                } else {
                    i10 = 0;
                }
                if (strArr.length > 1) {
                    i11 = Integer.parseInt(strArr[1]);
                }
                if (i10 < 4 || (i10 == 4 && i11 <= 1)) {
                    Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, AppEventsLoggerImpl.access$getTAG$cp(), "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
                } else {
                    webView.addJavascriptInterface(new FacebookSDKJSInterface(context), j.p("fbmq_", FacebookSdk.getApplicationId()));
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }

        public final void eagerFlush() {
            if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
                AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
            }
        }

        public final void functionDEPRECATED(String str) {
            j.g(str, "extraMsg");
            AppEventsLoggerImpl.access$getTAG$cp();
            j.p("This function is deprecated. ", str);
        }

        public final Executor getAnalyticsExecutor() {
            if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() == null) {
                initializeTimersIfNeeded();
            }
            ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
            if (access$getBackgroundExecutor$cp != null) {
                return access$getBackgroundExecutor$cp;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final String getAnonymousAppDeviceGUID(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                    if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                        AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp(context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", (String) null));
                        if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                            UUID randomUUID = UUID.randomUUID();
                            j.f(randomUUID, "randomUUID()");
                            AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp(j.p("XZ", randomUUID));
                            context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp()).apply();
                        }
                    }
                    Unit unit = Unit.f32013a;
                }
            }
            String access$getAnonymousAppDeviceGUID$cp = AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp();
            if (access$getAnonymousAppDeviceGUID$cp != null) {
                return access$getAnonymousAppDeviceGUID$cp;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            AppEventsLogger.FlushBehavior access$getFlushBehaviorField$cp;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                access$getFlushBehaviorField$cp = AppEventsLoggerImpl.access$getFlushBehaviorField$cp();
            }
            return access$getFlushBehaviorField$cp;
        }

        public final String getInstallReferrer() {
            InstallReferrerUtil installReferrerUtil = InstallReferrerUtil.INSTANCE;
            InstallReferrerUtil.tryUpdateReferrerInfo(new AppEventsLoggerImpl$Companion$getInstallReferrer$1());
            return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("install_referrer", (String) null);
        }

        public final String getPushNotificationsRegistrationId() {
            String access$getPushNotificationsRegistrationIdField$cp;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                access$getPushNotificationsRegistrationIdField$cp = AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp();
            }
            return access$getPushNotificationsRegistrationIdField$cp;
        }

        public final void initializeLib(Context context, String str) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, str, (AccessToken) null);
                ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                if (access$getBackgroundExecutor$cp != null) {
                    access$getBackgroundExecutor$cp.execute(new j(context, appEventsLoggerImpl));
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        }

        public final void onContextStop() {
            AppEventQueue.persistToDisk();
        }

        public final void setFlushBehavior(AppEventsLogger.FlushBehavior flushBehavior) {
            j.g(flushBehavior, "flushBehavior");
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                AppEventsLoggerImpl.access$setFlushBehaviorField$cp(flushBehavior);
                Unit unit = Unit.f32013a;
            }
        }

        public final void setInstallReferrer(String str) {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (str != null) {
                sharedPreferences.edit().putString("install_referrer", str).apply();
            }
        }

        public final void setPushNotificationsRegistrationId(String str) {
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.stringsEqualOrEmpty(AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp(), str)) {
                    AppEventsLoggerImpl.access$setPushNotificationsRegistrationIdField$cp(str);
                    AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), (String) null, (AccessToken) null);
                    appEventsLoggerImpl.logEvent(AppEventsConstants.EVENT_NAME_PUSH_TOKEN_OBTAINED);
                    if (AppEventsLoggerImpl.Companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                        appEventsLoggerImpl.flush();
                    }
                }
                Unit unit = Unit.f32013a;
            }
        }
    }

    static {
        String canonicalName = AppEventsLoggerImpl.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.AppEventsLoggerImpl";
        }
        TAG = canonicalName;
    }

    public AppEventsLoggerImpl(String str, String str2, AccessToken accessToken) {
        j.g(str, "activityName");
        Validate.sdkInitialized();
        this.contextName = str;
        accessToken = accessToken == null ? AccessToken.Companion.getCurrentAccessToken() : accessToken;
        if (accessToken == null || accessToken.isExpired() || (str2 != null && !j.b(str2, accessToken.getApplicationId()))) {
            if (str2 == null) {
                Utility utility = Utility.INSTANCE;
                str2 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
            }
            if (str2 != null) {
                this.accessTokenAppId = new AccessTokenAppIdPair((String) null, str2);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        }
        Companion.initializeTimersIfNeeded();
    }

    public static final /* synthetic */ String access$getAnonymousAppDeviceGUID$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return anonymousAppDeviceGUID;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return backgroundExecutor;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ AppEventsLogger.FlushBehavior access$getFlushBehaviorField$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return flushBehaviorField;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getPushNotificationsRegistrationIdField$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return pushNotificationsRegistrationIdField;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Object access$getStaticLock$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return staticLock;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ boolean access$isActivateAppEventRequested$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return isActivateAppEventRequested;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final /* synthetic */ void access$setActivateAppEventRequested$cp(boolean z10) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                isActivateAppEventRequested = z10;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final /* synthetic */ void access$setAnonymousAppDeviceGUID$cp(String str) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                anonymousAppDeviceGUID = str;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final /* synthetic */ void access$setBackgroundExecutor$cp(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                backgroundExecutor = scheduledThreadPoolExecutor;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final /* synthetic */ void access$setFlushBehaviorField$cp(AppEventsLogger.FlushBehavior flushBehavior) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                flushBehaviorField = flushBehavior;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final /* synthetic */ void access$setPushNotificationsRegistrationIdField$cp(String str) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                pushNotificationsRegistrationIdField = str;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void activateApp(Application application, String str) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.activateApp(application, str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void augmentWebView(WebView webView, Context context) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.augmentWebView(webView, context);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void functionDEPRECATED(String str) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.functionDEPRECATED(str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final Executor getAnalyticsExecutor() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getAnalyticsExecutor();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final String getAnonymousAppDeviceGUID(Context context) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getAnonymousAppDeviceGUID(context);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final AppEventsLogger.FlushBehavior getFlushBehavior() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getFlushBehavior();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final String getInstallReferrer() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getInstallReferrer();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final String getPushNotificationsRegistrationId() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getPushNotificationsRegistrationId();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void initializeLib(Context context, String str) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.initializeLib(context, str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static /* synthetic */ void logEvent$default(AppEventsLoggerImpl appEventsLoggerImpl, String str, Bundle bundle, int i10, Object obj) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i10 & 2) != 0) {
                bundle = null;
            }
            try {
                appEventsLoggerImpl.logEvent(str, bundle);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static /* synthetic */ void logPurchase$default(AppEventsLoggerImpl appEventsLoggerImpl, BigDecimal bigDecimal, Currency currency, Bundle bundle, int i10, Object obj) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if ((i10 & 4) != 0) {
                bundle = null;
            }
            try {
                appEventsLoggerImpl.logPurchase(bigDecimal, currency, bundle);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void onContextStop() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.onContextStop();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void setFlushBehavior(AppEventsLogger.FlushBehavior flushBehavior) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.setFlushBehavior(flushBehavior);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void setInstallReferrer(String str) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.setInstallReferrer(str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void setPushNotificationsRegistrationId(String str) {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.setPushNotificationsRegistrationId(str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public final void flush() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
                AppEventQueue.flush(FlushReason.EXPLICIT);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final String getApplicationId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.accessTokenAppId.getApplicationId();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final boolean isValidForAccessToken(AccessToken accessToken) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            j.g(accessToken, SDKConstants.PARAM_ACCESS_TOKEN);
            return j.b(this.accessTokenAppId, new AccessTokenAppIdPair(accessToken));
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    public final void logEvent(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logEvent(str, (Bundle) null);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logEventFromSE(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("_is_suggested_event", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                bundle.putString("_button_text", str2);
                logEvent(str, bundle);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logEventImplicitly(String str, Double d10, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logEvent(str, d10, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logProductItem(String str, AppEventsLogger.ProductAvailability productAvailability, AppEventsLogger.ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (str == null) {
                try {
                    Companion.notifyDeveloperError("itemID cannot be null");
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            } else if (productAvailability == null) {
                Companion.notifyDeveloperError("availability cannot be null");
            } else if (productCondition == null) {
                Companion.notifyDeveloperError("condition cannot be null");
            } else if (str2 == null) {
                Companion.notifyDeveloperError("description cannot be null");
            } else if (str3 == null) {
                Companion.notifyDeveloperError("imageLink cannot be null");
            } else if (str4 == null) {
                Companion.notifyDeveloperError("link cannot be null");
            } else if (str5 == null) {
                Companion.notifyDeveloperError("title cannot be null");
            } else if (bigDecimal == null) {
                Companion.notifyDeveloperError("priceAmount cannot be null");
            } else if (currency == null) {
                Companion.notifyDeveloperError("currency cannot be null");
            } else if (str6 == null && str7 == null && str8 == null) {
                Companion.notifyDeveloperError("Either gtin, mpn or brand is required");
            } else {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_ITEM_ID, str);
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_AVAILABILITY, productAvailability.name());
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_CONDITION, productCondition.name());
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_DESCRIPTION, str2);
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_IMAGE_LINK, str3);
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_LINK, str4);
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_TITLE, str5);
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_AMOUNT, bigDecimal.setScale(3, 4).toString());
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_CURRENCY, currency.getCurrencyCode());
                if (str6 != null) {
                    bundle.putString(Constants.EVENT_PARAM_PRODUCT_GTIN, str6);
                }
                if (str7 != null) {
                    bundle.putString(Constants.EVENT_PARAM_PRODUCT_MPN, str7);
                }
                if (str8 != null) {
                    bundle.putString(Constants.EVENT_PARAM_PRODUCT_BRAND, str8);
                }
                logEvent(AppEventsConstants.EVENT_NAME_PRODUCT_CATALOG_UPDATE, bundle);
                Companion.eagerFlush();
            }
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logPurchase(bigDecimal, currency, (Bundle) null);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logPurchase(bigDecimal, currency, bundle, true);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logPushNotificationOpen(Bundle bundle, String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(bundle, "payload");
                String str2 = null;
                try {
                    String string = bundle.getString(PUSH_PAYLOAD_KEY);
                    if (!Utility.isNullOrEmpty(string)) {
                        str2 = new b(string).getString("campaign");
                        if (str2 == null) {
                            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(APP_EVENT_PUSH_PARAMETER_CAMPAIGN, str2);
                        if (str != null) {
                            bundle2.putString(APP_EVENT_PUSH_PARAMETER_ACTION, str);
                        }
                        logEvent(APP_EVENT_NAME_PUSH_OPENED, bundle2);
                    }
                } catch (JSONException unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logSdkEvent(String str, Double d10, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(str, "eventName");
                if (r.J(str, ACCOUNT_KIT_EVENT_NAME_PREFIX, false, 2, (Object) null) && FacebookSdk.getAutoLogAppEventsEnabled()) {
                    logEvent(str, d10, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logEvent(String str, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logEvent(str, (Double) null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (bigDecimal == null || currency == null) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, "purchaseAmount and currency cannot be null");
                return;
            }
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                    return;
                }
            }
            Bundle bundle2 = bundle;
            bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            logEvent(str, Double.valueOf(bigDecimal.doubleValue()), bundle2, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                boolean isImplicitPurchaseLoggingEnabled = AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
                logPurchase(bigDecimal, currency, bundle, false);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logEvent(String str, double d10) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logEvent(str, d10, (Bundle) null);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z10) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (bigDecimal == null) {
                try {
                    Companion.notifyDeveloperError("purchaseAmount cannot be null");
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            } else if (currency == null) {
                Companion.notifyDeveloperError("currency cannot be null");
            } else {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                Bundle bundle2 = bundle;
                bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
                logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, Double.valueOf(bigDecimal.doubleValue()), bundle2, z10, ActivityLifecycleTracker.getCurrentSessionGuid());
                Companion.eagerFlush();
            }
        }
    }

    public final void logEvent(String str, double d10, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                logEvent(str, Double.valueOf(d10), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void logEvent(String str, Double d10, Bundle bundle, boolean z10, UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(this) && str != null) {
            try {
                if (!(str.length() == 0)) {
                    FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
                    if (FetchedAppGateKeepersManager.getGateKeeperForKey(APP_EVENTS_KILLSWITCH, FacebookSdk.getApplicationId(), false)) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", str);
                    } else {
                        Companion.logEvent(new AppEvent(this.contextName, str, d10, bundle, z10, ActivityLifecycleTracker.isInBackground(), uuid), this.accessTokenAppId);
                    }
                }
            } catch (JSONException e10) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e10.toString());
            } catch (FacebookException e11) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e11.toString());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public AppEventsLoggerImpl(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }
}
