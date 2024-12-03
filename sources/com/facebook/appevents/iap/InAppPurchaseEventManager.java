package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mparticle.identity.IdentityHttpResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.pool.TypePool;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\b\u0010+\u001a\u00020,H\u0007J0\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001e\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u0004\u0018\u00010\"2\n\u00104\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u00105\u001a\u00020\u0004H\u0002J0\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007JF\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0007JF\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0004JA\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00012\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020A2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J,\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040L2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001c\u0010M\u001a\u00020,2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001ej\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f` X\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u001ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"` X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseEventManager;", "", "()V", "AS_INTERFACE", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "", "DETAILS_LIST", "GET_PURCHASES", "GET_PURCHASE_HISTORY", "GET_SKU_DETAILS", "INAPP", "INAPP_CONTINUATION_TOKEN", "INAPP_PURCHASE_DATA_LIST", "IN_APP_BILLING_SERVICE", "IN_APP_BILLING_SERVICE_STUB", "IS_BILLING_SUPPORTED", "ITEM_ID_LIST", "LAST_CLEARED_TIME", "MAX_QUERY_PURCHASE_NUM", "PACKAGE_NAME", "kotlin.jvm.PlatformType", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_INAPP_STORE", "PURCHASE_STOP_QUERY_TIME_SEC", "RESPONSE_CODE", "SKU_DETAILS_STORE", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "classMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/lang/reflect/Method;", "purchaseInappSharedPrefs", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", "asInterface", "context", "Landroid/content/Context;", "service", "Landroid/os/IBinder;", "clearSkuDetailsCache", "", "filterPurchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchases", "getClass", "className", "getMethod", "classObj", "methodName", "getPurchaseHistory", "inAppBillingObj", "type", "getPurchaseHistoryInapp", "getPurchases", "getPurchasesInapp", "getPurchasesSubs", "getSkuDetails", "", "skuList", "isSubscription", "", "getSkuDetailsFromGoogle", "hasFreeTrialPeirod", "skuDetail", "invokeMethod", "obj", "args", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "isBillingSupported", "readSkuDetailsFromCache", "", "writeSkuDetailsToCache", "skuDetailsMap", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    private InAppPurchaseEventManager() {
    }

    public static final Object asInterface(Context context, IBinder iBinder) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return INSTANCE.invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, (Object) null, new Object[]{iBinder});
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void clearSkuDetailsCache() {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences sharedPreferences = skuDetailSharedPrefs;
                long j10 = sharedPreferences.getLong(LAST_CLEARED_TIME, 0);
                if (j10 == 0) {
                    sharedPreferences.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                } else if (currentTimeMillis - j10 > ((long) CACHE_CLEAR_TIME_LIMIT_SEC)) {
                    sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList2 = new ArrayList<>();
            SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    b bVar = new b(next);
                    String string = bVar.getString("productId");
                    long j10 = bVar.getLong("purchaseTime");
                    String string2 = bVar.getString(SDKConstants.PARAM_PURCHASE_TOKEN);
                    if (currentTimeMillis - (j10 / 1000) <= 86400) {
                        if (!j.b(purchaseInappSharedPrefs.getString(string, ""), string2)) {
                            edit.putString(string, string2);
                            arrayList2.add(next);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            edit.apply();
            return arrayList2;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final Class<?> getClass(Context context, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Class<?>> hashMap = classMap;
            Class<?> cls = hashMap.get(str);
            if (cls != null) {
                return cls;
            }
            Class<?> classFromContext$facebook_core_release = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context, str);
            if (classFromContext$facebook_core_release != null) {
                hashMap.put(str, classFromContext$facebook_core_release);
            }
            return classFromContext$facebook_core_release;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method getMethod(java.lang.Class<?> r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = methodMap     // Catch:{ all -> 0x00be }
            java.lang.Object r3 = r1.get(r13)     // Catch:{ all -> 0x00be }
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x0015
            return r3
        L_0x0015:
            int r3 = r13.hashCode()     // Catch:{ all -> 0x00be }
            r4 = 4
            r5 = 2
            java.lang.String r6 = "TYPE"
            r7 = 3
            r8 = 0
            r9 = 1
            switch(r3) {
                case -1801122596: goto L_0x0086;
                case -1450694211: goto L_0x006f;
                case -1123215065: goto L_0x005f;
                case -594356707: goto L_0x0041;
                case -573310373: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x009f
        L_0x0025:
            java.lang.String r3 = "getSkuDetails"
            boolean r3 = r13.equals(r3)     // Catch:{ all -> 0x00be }
            if (r3 != 0) goto L_0x002f
            goto L_0x009f
        L_0x002f:
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ all -> 0x00be }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.j.f(r4, r6)     // Catch:{ all -> 0x00be }
            r3[r8] = r4     // Catch:{ all -> 0x00be }
            r3[r9] = r0     // Catch:{ all -> 0x00be }
            r3[r5] = r0     // Catch:{ all -> 0x00be }
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            r3[r7] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x0041:
            java.lang.String r3 = "getPurchaseHistory"
            boolean r3 = r13.equals(r3)     // Catch:{ all -> 0x00be }
            if (r3 != 0) goto L_0x004a
            goto L_0x009f
        L_0x004a:
            r3 = 5
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ all -> 0x00be }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.j.f(r10, r6)     // Catch:{ all -> 0x00be }
            r3[r8] = r10     // Catch:{ all -> 0x00be }
            r3[r9] = r0     // Catch:{ all -> 0x00be }
            r3[r5] = r0     // Catch:{ all -> 0x00be }
            r3[r7] = r0     // Catch:{ all -> 0x00be }
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            r3[r4] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x005f:
            java.lang.String r0 = "asInterface"
            boolean r0 = r13.equals(r0)     // Catch:{ all -> 0x00be }
            if (r0 != 0) goto L_0x0068
            goto L_0x009f
        L_0x0068:
            java.lang.Class[] r3 = new java.lang.Class[r9]     // Catch:{ all -> 0x00be }
            java.lang.Class<android.os.IBinder> r0 = android.os.IBinder.class
            r3[r8] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x006f:
            java.lang.String r3 = "isBillingSupported"
            boolean r3 = r13.equals(r3)     // Catch:{ all -> 0x00be }
            if (r3 != 0) goto L_0x0078
            goto L_0x009f
        L_0x0078:
            java.lang.Class[] r3 = new java.lang.Class[r7]     // Catch:{ all -> 0x00be }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.j.f(r4, r6)     // Catch:{ all -> 0x00be }
            r3[r8] = r4     // Catch:{ all -> 0x00be }
            r3[r9] = r0     // Catch:{ all -> 0x00be }
            r3[r5] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x0086:
            java.lang.String r3 = "getPurchases"
            boolean r3 = r13.equals(r3)     // Catch:{ all -> 0x00be }
            if (r3 != 0) goto L_0x008f
            goto L_0x009f
        L_0x008f:
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ all -> 0x00be }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.j.f(r4, r6)     // Catch:{ all -> 0x00be }
            r3[r8] = r4     // Catch:{ all -> 0x00be }
            r3[r9] = r0     // Catch:{ all -> 0x00be }
            r3[r5] = r0     // Catch:{ all -> 0x00be }
            r3[r7] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x009f:
            r3 = r2
        L_0x00a0:
            if (r3 != 0) goto L_0x00ab
            java.lang.Class[] r0 = new java.lang.Class[r9]     // Catch:{ all -> 0x00be }
            r0[r8] = r2     // Catch:{ all -> 0x00be }
            java.lang.reflect.Method r12 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r12, r13, r0)     // Catch:{ all -> 0x00be }
            goto L_0x00b8
        L_0x00ab:
            com.facebook.appevents.iap.InAppPurchaseUtils r0 = com.facebook.appevents.iap.InAppPurchaseUtils.INSTANCE     // Catch:{ all -> 0x00be }
            int r0 = r3.length     // Catch:{ all -> 0x00be }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r0)     // Catch:{ all -> 0x00be }
            java.lang.Class[] r0 = (java.lang.Class[]) r0     // Catch:{ all -> 0x00be }
            java.lang.reflect.Method r12 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r12, r13, r0)     // Catch:{ all -> 0x00be }
        L_0x00b8:
            if (r12 == 0) goto L_0x00bd
            r1.put(r13, r12)     // Catch:{ all -> 0x00be }
        L_0x00bd:
            return r12
        L_0x00be:
            r12 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getMethod(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    private final ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (isBillingSupported(context, obj, str)) {
                String str2 = null;
                int i10 = 0;
                boolean z10 = false;
                do {
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                    if (invokeMethod != null) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle = (Bundle) invokeMethod;
                        if (bundle.getInt(RESPONSE_CODE) == 0) {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                            if (stringArrayList != null) {
                                Iterator<String> it = stringArrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String next = it.next();
                                    try {
                                        if (currentTimeMillis - (new b(next).getLong("purchaseTime") / 1000) > 1200) {
                                            z10 = true;
                                            break;
                                        }
                                        arrayList.add(next);
                                        i10++;
                                    } catch (JSONException unused) {
                                    }
                                }
                                str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                                if (i10 >= 30 || str2 == null) {
                                    break;
                                }
                            }
                        }
                    }
                    str2 = null;
                } while (!z10);
            }
            return arrayList;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r3 = INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.ArrayList<java.lang.String> getPurchaseHistoryInapp(android.content.Context r6, java.lang.Object r7) {
        /*
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseEventManager> r0 = com.facebook.appevents.iap.InAppPurchaseEventManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r1 = "context"
            kotlin.jvm.internal.j.g(r6, r1)     // Catch:{ all -> 0x0036 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0036 }
            r1.<init>()     // Catch:{ all -> 0x0036 }
            if (r7 != 0) goto L_0x0017
            return r1
        L_0x0017:
            com.facebook.appevents.iap.InAppPurchaseEventManager r3 = INSTANCE     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = "com.android.vending.billing.IInAppBillingService"
            java.lang.Class r4 = r3.getClass(r6, r4)     // Catch:{ all -> 0x0036 }
            if (r4 != 0) goto L_0x0022
            return r1
        L_0x0022:
            java.lang.String r5 = "getPurchaseHistory"
            java.lang.reflect.Method r4 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x0036 }
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            java.lang.String r1 = "inapp"
            java.util.ArrayList r6 = r3.getPurchaseHistory(r6, r7, r1)     // Catch:{ all -> 0x0036 }
            java.util.ArrayList r6 = r3.filterPurchases(r6)     // Catch:{ all -> 0x0036 }
            return r6
        L_0x0036:
            r6 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchaseHistoryInapp(android.content.Context, java.lang.Object):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A[EDGE_INSN: B:27:0x0062->B:21:0x0062 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r12 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0063 }
            r0.<init>()     // Catch:{ all -> 0x0063 }
            if (r14 != 0) goto L_0x0010
            return r0
        L_0x0010:
            boolean r2 = r12.isBillingSupported(r13, r14, r15)     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0062
            r2 = 0
            r3 = r1
            r4 = r2
        L_0x0019:
            r5 = 4
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ all -> 0x0063 }
            r5 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0063 }
            r11[r2] = r6     // Catch:{ all -> 0x0063 }
            r6 = 1
            java.lang.String r7 = PACKAGE_NAME     // Catch:{ all -> 0x0063 }
            r11[r6] = r7     // Catch:{ all -> 0x0063 }
            r6 = 2
            r11[r6] = r15     // Catch:{ all -> 0x0063 }
            r11[r5] = r3     // Catch:{ all -> 0x0063 }
            java.lang.String r8 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r9 = "getPurchases"
            r6 = r12
            r7 = r13
            r10 = r14
            java.lang.Object r3 = r6.invokeMethod(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x005b
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x005b
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x0062
            int r6 = r5.size()     // Catch:{ all -> 0x0063 }
            int r4 = r4 + r6
            r0.addAll(r5)     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ all -> 0x0063 }
            goto L_0x005c
        L_0x005b:
            r3 = r1
        L_0x005c:
            r5 = 30
            if (r4 >= r5) goto L_0x0062
            if (r3 != 0) goto L_0x0019
        L_0x0062:
            return r0
        L_0x0063:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public static final ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, INAPP));
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, SUBSCRIPTION));
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z10) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(arrayList, "skuList");
            Map<String, String> readSkuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!readSkuDetailsFromCache.containsKey(next)) {
                    arrayList2.add(next);
                }
            }
            readSkuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList2, obj, z10));
            return readSkuDetailsFromCache;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z10) {
        String str;
        int size;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (obj != null) {
                if (!arrayList.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
                    Object[] objArr = new Object[4];
                    int i10 = 0;
                    objArr[0] = 3;
                    objArr[1] = PACKAGE_NAME;
                    if (z10) {
                        str = SUBSCRIPTION;
                    } else {
                        str = INAPP;
                    }
                    objArr[2] = str;
                    objArr[3] = bundle;
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
                    if (invokeMethod != null) {
                        Bundle bundle2 = (Bundle) invokeMethod;
                        if (bundle2.getInt(RESPONSE_CODE) == 0) {
                            ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                            if (stringArrayList != null && arrayList.size() == stringArrayList.size() && arrayList.size() - 1 >= 0) {
                                while (true) {
                                    int i11 = i10 + 1;
                                    String str2 = arrayList.get(i10);
                                    j.f(str2, "skuList[i]");
                                    String str3 = stringArrayList.get(i10);
                                    j.f(str3, "skuDetailsList[i]");
                                    linkedHashMap.put(str2, str3);
                                    if (i11 > size) {
                                        break;
                                    }
                                    i10 = i11;
                                }
                            }
                            writeSkuDetailsToCache(linkedHashMap);
                        }
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, str);
            if (cls == null || (method = getMethod(cls, str2)) == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final boolean isBillingSupported(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this) || obj == null) {
            return false;
        }
        try {
            Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
            if (invokeMethod == null || ((Integer) invokeMethod).intValue() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String string = skuDetailSharedPrefs.getString(next, (String) null);
                if (string != null) {
                    List C0 = StringsKt__StringsKt.C0(string, new String[]{";"}, false, 2, 2, (Object) null);
                    if (currentTimeMillis - Long.parseLong((String) C0.get(0)) < 43200) {
                        j.f(next, "sku");
                        linkedHashMap.put(next, C0.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final void writeSkuDetailsToCache(Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
                for (Map.Entry next : map.entrySet()) {
                    edit.putString((String) next.getKey(), currentTimeMillis + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER + ((String) next.getValue()));
                }
                edit.apply();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final boolean hasFreeTrialPeirod(String str) {
        boolean z10;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            j.g(str, "skuDetail");
            try {
                String optString = new b(str).optString("freeTrialPeriod");
                if (optString == null) {
                    return false;
                }
                if (optString.length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return true;
                }
                return false;
            } catch (JSONException unused) {
                return false;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }
}
