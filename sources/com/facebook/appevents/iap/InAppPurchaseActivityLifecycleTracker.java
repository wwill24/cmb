package com.facebook.appevents.iap;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0007J\b\u0010\u001f\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker;", "", "()V", "BILLING_ACTIVITY_NAME", "", "SERVICE_INTERFACE_NAME", "TAG", "kotlin.jvm.PlatformType", "callbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "hasBillingActivity", "", "Ljava/lang/Boolean;", "hasBillingService", "inAppBillingObj", "intent", "Landroid/content/Intent;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "serviceConnection", "Landroid/content/ServiceConnection;", "initializeIfNotInitialized", "", "logPurchase", "context", "Landroid/content/Context;", "purchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSubscription", "startIapLogging", "startTracking", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppPurchaseActivityLifecycleTracker {
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    public static final InAppPurchaseActivityLifecycleTracker INSTANCE = new InAppPurchaseActivityLifecycleTracker();
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    private static Application.ActivityLifecycleCallbacks callbacks;
    /* access modifiers changed from: private */
    public static Boolean hasBillingActivity;
    private static Boolean hasBillingService;
    /* access modifiers changed from: private */
    public static Object inAppBillingObj;
    private static Intent intent;
    private static final AtomicBoolean isTracking = new AtomicBoolean(false);
    private static ServiceConnection serviceConnection;

    private InAppPurchaseActivityLifecycleTracker() {
    }

    private final void initializeIfNotInitialized() {
        boolean z10;
        if (hasBillingService == null) {
            boolean z11 = true;
            if (InAppPurchaseUtils.getClass(SERVICE_INTERFACE_NAME) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Boolean valueOf = Boolean.valueOf(z10);
            hasBillingService = valueOf;
            if (!j.b(valueOf, Boolean.FALSE)) {
                if (InAppPurchaseUtils.getClass(BILLING_ACTIVITY_NAME) == null) {
                    z11 = false;
                }
                hasBillingActivity = Boolean.valueOf(z11);
                InAppPurchaseEventManager.clearSkuDetailsCache();
                Intent intent2 = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                j.f(intent2, "Intent(\"com.android.vending.billing.InAppBillingService.BIND\")\n            .setPackage(\"com.android.vending\")");
                intent = intent2;
                serviceConnection = new InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1();
                callbacks = new InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void logPurchase(Context context, ArrayList<String> arrayList, boolean z10) {
        if (!arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    String string = new b(next).getString("productId");
                    j.f(string, "sku");
                    j.f(next, "purchase");
                    hashMap.put(string, next);
                    arrayList2.add(string);
                } catch (JSONException unused) {
                }
            }
            InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
            for (Map.Entry next2 : InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, z10).entrySet()) {
                String str = (String) next2.getValue();
                String str2 = (String) hashMap.get((String) next2.getKey());
                if (str2 != null) {
                    AutomaticAnalyticsLogger.logPurchase(str2, str, z10);
                }
            }
        }
    }

    public static final void startIapLogging() {
        InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = INSTANCE;
        inAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized();
        if (!j.b(hasBillingService, Boolean.FALSE) && AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            inAppPurchaseActivityLifecycleTracker.startTracking();
        }
    }

    private final void startTracking() {
        if (isTracking.compareAndSet(false, true)) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                Application application = (Application) applicationContext;
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = callbacks;
                if (activityLifecycleCallbacks != null) {
                    application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    Intent intent2 = intent;
                    if (intent2 != null) {
                        ServiceConnection serviceConnection2 = serviceConnection;
                        if (serviceConnection2 != null) {
                            applicationContext.bindService(intent2, serviceConnection2, 1);
                        } else {
                            j.y("serviceConnection");
                            throw null;
                        }
                    } else {
                        j.y(SDKConstants.PARAM_INTENT);
                        throw null;
                    }
                } else {
                    j.y("callbacks");
                    throw null;
                }
            }
        }
    }
}
