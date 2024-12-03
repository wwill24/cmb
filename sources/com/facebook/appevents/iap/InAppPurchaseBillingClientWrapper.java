package com.facebook.appevents.iap;

import android.content.Context;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mparticle.identity.IdentityHttpResponse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u0000 )2\u00020\u0001:\u0005()*+,B«\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001fJ\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001fH\u0002J(\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0&2\u0006\u0010#\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "context", "Landroid/content/Context;", "billingClient", "billingClientClazz", "Ljava/lang/Class;", "purchaseResultClazz", "purchaseClazz", "skuDetailsClazz", "purchaseHistoryRecordClazz", "skuDetailsResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "queryPurchasesMethod", "Ljava/lang/reflect/Method;", "getPurchaseListMethod", "getOriginalJsonMethod", "getOriginalJsonSkuMethod", "getOriginalJsonPurchaseHistoryMethod", "querySkuDetailsAsyncMethod", "queryPurchaseHistoryAsyncMethod", "inAppPurchaseSkuDetailsWrapper", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;)V", "historyPurchaseSet", "", "", "queryPurchase", "", "skuType", "querySkuRunnable", "Ljava/lang/Runnable;", "queryPurchaseHistory", "queryPurchaseHistoryRunnable", "queryPurchaseHistoryAsync", "runnable", "querySkuDetailsAsync", "skuIDs", "", "startConnection", "BillingClientStateListenerWrapper", "Companion", "PurchaseHistoryResponseListenerWrapper", "PurchasesUpdatedListenerWrapper", "SkuDetailsResponseListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppPurchaseBillingClientWrapper {
    private static final String CLASSNAME_BILLING_CLIENT = "com.android.billingclient.api.BillingClient";
    private static final String CLASSNAME_BILLING_CLIENT_BUILDER = "com.android.billingclient.api.BillingClient$Builder";
    private static final String CLASSNAME_BILLING_CLIENT_STATE_LISTENER = "com.android.billingclient.api.BillingClientStateListener";
    private static final String CLASSNAME_PURCHASE = "com.android.billingclient.api.Purchase";
    private static final String CLASSNAME_PURCHASES_RESULT = "com.android.billingclient.api.Purchase$PurchasesResult";
    private static final String CLASSNAME_PURCHASE_HISTORY_RECORD = "com.android.billingclient.api.PurchaseHistoryRecord";
    private static final String CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER = "com.android.billingclient.api.PurchaseHistoryResponseListener";
    private static final String CLASSNAME_PURCHASE_UPDATED_LISTENER = "com.android.billingclient.api.PurchasesUpdatedListener";
    private static final String CLASSNAME_SKU_DETAILS = "com.android.billingclient.api.SkuDetails";
    private static final String CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER = "com.android.billingclient.api.SkuDetailsResponseListener";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String IN_APP = "inapp";
    private static final String METHOD_BUILD = "build";
    private static final String METHOD_ENABLE_PENDING_PURCHASES = "enablePendingPurchases";
    private static final String METHOD_GET_ORIGINAL_JSON = "getOriginalJson";
    private static final String METHOD_GET_PURCHASE_LIST = "getPurchasesList";
    private static final String METHOD_NEW_BUILDER = "newBuilder";
    private static final String METHOD_ON_BILLING_SERVICE_DISCONNECTED = "onBillingServiceDisconnected";
    private static final String METHOD_ON_BILLING_SETUP_FINISHED = "onBillingSetupFinished";
    private static final String METHOD_ON_PURCHASE_HISTORY_RESPONSE = "onPurchaseHistoryResponse";
    private static final String METHOD_ON_SKU_DETAILS_RESPONSE = "onSkuDetailsResponse";
    private static final String METHOD_QUERY_PURCHASES = "queryPurchases";
    private static final String METHOD_QUERY_PURCHASE_HISTORY_ASYNC = "queryPurchaseHistoryAsync";
    private static final String METHOD_QUERY_SKU_DETAILS_ASYNC = "querySkuDetailsAsync";
    private static final String METHOD_SET_LISTENER = "setListener";
    private static final String METHOD_START_CONNECTION = "startConnection";
    private static final String PACKAGE_NAME = "packageName";
    private static final String PRODUCT_ID = "productId";
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static InAppPurchaseBillingClientWrapper instance;
    private static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    private static final Map<String, b> purchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, b> skuDetailsMap = new ConcurrentHashMap();
    private final Object billingClient;
    private final Class<?> billingClientClazz;
    private final Context context;
    private final Method getOriginalJsonMethod;
    private final Method getOriginalJsonPurchaseHistoryMethod;
    private final Method getOriginalJsonSkuMethod;
    private final Method getPurchaseListMethod;
    private final Set<String> historyPurchaseSet;
    private final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    private final Class<?> purchaseClazz;
    private final Class<?> purchaseHistoryRecordClazz;
    private final Class<?> purchaseHistoryResponseListenerClazz;
    private final Class<?> purchaseResultClazz;
    private final Method queryPurchaseHistoryAsyncMethod;
    private final Method queryPurchasesMethod;
    private final Method querySkuDetailsAsyncMethod;
    private final Class<?> skuDetailsClazz;
    private final Class<?> skuDetailsResponseListenerClazz;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$BillingClientStateListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class BillingClientStateListenerWrapper implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                j.g(obj, "proxy");
                j.g(method, NetworkProfile.MALE);
                if (j.b(method.getName(), InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SETUP_FINISHED)) {
                    InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(true);
                } else {
                    String name = method.getName();
                    j.f(name, "m.name");
                    if (r.s(name, InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SERVICE_DISCONNECTED, false, 2, (Object) null)) {
                        InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(false);
                    }
                }
                return null;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b(\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0014\u0010%\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010)\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010*\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b+\u0010\u0019R\u0014\u0010,\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b,\u0010\u0019R\u0014\u0010-\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b-\u0010\u0019R\u0014\u0010.\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b.\u0010\u0019R\u0014\u0010/\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b/\u0010\u0019R\u0014\u00100\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b0\u0010\u0019R\u0014\u00101\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b1\u0010\u0019R\u0014\u00102\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b2\u0010\u0019R\u0014\u00103\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b3\u0010\u0019R\u0014\u00104\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010\rR\u0018\u00105\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$Companion;", "", "Landroid/content/Context;", "context", "", "createInstance", "Ljava/lang/Class;", "billingClientClazz", "createBillingClient", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "getOrCreateInstance", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isServiceConnected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "", "", "Lorg/json/b;", "purchaseDetailsMap", "Ljava/util/Map;", "getPurchaseDetailsMap", "()Ljava/util/Map;", "skuDetailsMap", "getSkuDetailsMap", "CLASSNAME_BILLING_CLIENT", "Ljava/lang/String;", "CLASSNAME_BILLING_CLIENT_BUILDER", "CLASSNAME_BILLING_CLIENT_STATE_LISTENER", "CLASSNAME_PURCHASE", "CLASSNAME_PURCHASES_RESULT", "CLASSNAME_PURCHASE_HISTORY_RECORD", "CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER", "CLASSNAME_PURCHASE_UPDATED_LISTENER", "CLASSNAME_SKU_DETAILS", "CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER", "IN_APP", "METHOD_BUILD", "METHOD_ENABLE_PENDING_PURCHASES", "METHOD_GET_ORIGINAL_JSON", "METHOD_GET_PURCHASE_LIST", "METHOD_NEW_BUILDER", "METHOD_ON_BILLING_SERVICE_DISCONNECTED", "METHOD_ON_BILLING_SETUP_FINISHED", "METHOD_ON_PURCHASE_HISTORY_RESPONSE", "METHOD_ON_SKU_DETAILS_RESPONSE", "METHOD_QUERY_PURCHASES", "METHOD_QUERY_PURCHASE_HISTORY_ASYNC", "METHOD_QUERY_SKU_DETAILS_ASYNC", "METHOD_SET_LISTENER", "METHOD_START_CONNECTION", "PACKAGE_NAME", "PRODUCT_ID", "initialized", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> cls) {
            Object invokeMethod;
            Object invokeMethod2;
            Object invokeMethod3;
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT_BUILDER);
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_UPDATED_LISTENER);
            if (cls2 == null || cls3 == null) {
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseBillingClientWrapper.METHOD_NEW_BUILDER, Context.class);
            Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_ENABLE_PENDING_PURCHASES, new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_SET_LISTENER, cls3);
            Method method4 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_BUILD, new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null || (invokeMethod = InAppPurchaseUtils.invokeMethod(cls, method, (Object) null, context)) == null || (invokeMethod2 = InAppPurchaseUtils.invokeMethod(cls2, method3, invokeMethod, Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new PurchasesUpdatedListenerWrapper()))) == null || (invokeMethod3 = InAppPurchaseUtils.invokeMethod(cls2, method2, invokeMethod2, new Object[0])) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(cls2, method4, invokeMethod3, new Object[0]);
        }

        private final void createInstance(Context context) {
            Class<String> cls = String.class;
            InAppPurchaseSkuDetailsWrapper orCreateInstance = InAppPurchaseSkuDetailsWrapper.Companion.getOrCreateInstance();
            if (orCreateInstance != null) {
                Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT);
                Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE);
                Class<?> cls4 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASES_RESULT);
                Class<?> cls5 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS);
                Class<?> cls6 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RECORD);
                Class<?> cls7 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER);
                Class<?> cls8 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
                if (cls2 == null || cls4 == null || cls3 == null || cls5 == null || cls7 == null || cls6 == null || cls8 == null) {
                    return;
                }
                Method method = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_QUERY_PURCHASES, cls);
                Method method2 = InAppPurchaseUtils.getMethod(cls4, InAppPurchaseBillingClientWrapper.METHOD_GET_PURCHASE_LIST, new Class[0]);
                Method method3 = InAppPurchaseUtils.getMethod(cls3, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method4 = InAppPurchaseUtils.getMethod(cls5, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method5 = InAppPurchaseUtils.getMethod(cls6, InAppPurchaseBillingClientWrapper.METHOD_GET_ORIGINAL_JSON, new Class[0]);
                Method method6 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_QUERY_SKU_DETAILS_ASYNC, orCreateInstance.getSkuDetailsParamsClazz(), cls7);
                Method method7 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_QUERY_PURCHASE_HISTORY_ASYNC, cls, cls8);
                if (method == null || method2 == null || method3 == null || method4 == null || method5 == null || method6 == null || method7 == null) {
                    return;
                }
                Object createBillingClient = createBillingClient(context, cls2);
                if (createBillingClient != null) {
                    InAppPurchaseBillingClientWrapper.access$setInstance$cp(new InAppPurchaseBillingClientWrapper(context, createBillingClient, cls2, cls4, cls3, cls5, cls6, cls7, cls8, method, method2, method3, method4, method5, method6, method7, orCreateInstance, (DefaultConstructorMarker) null));
                    InAppPurchaseBillingClientWrapper access$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                    if (access$getInstance$cp != null) {
                        InAppPurchaseBillingClientWrapper.access$startConnection(access$getInstance$cp);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
                }
            }
        }

        public final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            if (InAppPurchaseBillingClientWrapper.access$getInitialized$cp().get()) {
                return InAppPurchaseBillingClientWrapper.access$getInstance$cp();
            }
            createInstance(context);
            InAppPurchaseBillingClientWrapper.access$getInitialized$cp().set(true);
            return InAppPurchaseBillingClientWrapper.access$getInstance$cp();
        }

        public final Map<String, b> getPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapper.access$getPurchaseDetailsMap$cp();
        }

        public final Map<String, b> getSkuDetailsMap() {
            return InAppPurchaseBillingClientWrapper.access$getSkuDetailsMap$cp();
        }

        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapper.access$isServiceConnected$cp();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J0\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchaseHistoryResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "getPurchaseHistoryRecord", "", "purchaseHistoryRecordList", "", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {
        private Runnable runnable;
        final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public PurchaseHistoryResponseListenerWrapper(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            j.g(inAppPurchaseBillingClientWrapper, "this$0");
            j.g(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        private final void getPurchaseHistoryRecord(List<?> list) {
            String str;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    for (Object next : list) {
                        try {
                            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                            Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$getPurchaseHistoryRecordClazz$p(this.this$0), InAppPurchaseBillingClientWrapper.access$getGetOriginalJsonPurchaseHistoryMethod$p(this.this$0), next, new Object[0]);
                            if (invokeMethod instanceof String) {
                                str = (String) invokeMethod;
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                b bVar = new b(str);
                                bVar.put("packageName", (Object) InAppPurchaseBillingClientWrapper.access$getContext$p(this.this$0).getPackageName());
                                if (bVar.has(InAppPurchaseBillingClientWrapper.PRODUCT_ID)) {
                                    String string = bVar.getString(InAppPurchaseBillingClientWrapper.PRODUCT_ID);
                                    InAppPurchaseBillingClientWrapper.access$getHistoryPurchaseSet$p(this.this$0).add(string);
                                    Map<String, b> purchaseDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap();
                                    j.f(string, "skuID");
                                    purchaseDetailsMap.put(string, bVar);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.runnable.run();
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }

        public final Runnable getRunnable() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return this.runnable;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                j.g(obj, "proxy");
                j.g(method, FirebaseAnalytics.Param.METHOD);
                if (j.b(method.getName(), InAppPurchaseBillingClientWrapper.METHOD_ON_PURCHASE_HISTORY_RESPONSE)) {
                    if (objArr == null) {
                        list = null;
                    } else {
                        list = objArr[1];
                    }
                    if (list != null && (list instanceof List)) {
                        getPurchaseHistoryRecord(list);
                    }
                }
                return null;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        public final void setRunnable(Runnable runnable2) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    j.g(runnable2, "<set-?>");
                    this.runnable = runnable2;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchasesUpdatedListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                j.g(obj, "proxy");
                j.g(method, NetworkProfile.MALE);
                return null;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$SkuDetailsResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "parseSkuDetails", "", "skuDetailsObjectList", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        private Runnable runnable;
        final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public SkuDetailsResponseListenerWrapper(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            j.g(inAppPurchaseBillingClientWrapper, "this$0");
            j.g(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        public final Runnable getRunnable() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return this.runnable;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                j.g(obj, "proxy");
                j.g(method, NetworkProfile.MALE);
                if (j.b(method.getName(), InAppPurchaseBillingClientWrapper.METHOD_ON_SKU_DETAILS_RESPONSE)) {
                    if (objArr == null) {
                        list = null;
                    } else {
                        list = objArr[1];
                    }
                    if (list != null && (list instanceof List)) {
                        parseSkuDetails(list);
                    }
                }
                return null;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        public final void parseSkuDetails(List<?> list) {
            String str;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    j.g(list, "skuDetailsObjectList");
                    for (Object next : list) {
                        try {
                            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                            Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$getSkuDetailsClazz$p(this.this$0), InAppPurchaseBillingClientWrapper.access$getGetOriginalJsonSkuMethod$p(this.this$0), next, new Object[0]);
                            if (invokeMethod instanceof String) {
                                str = (String) invokeMethod;
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                b bVar = new b(str);
                                if (bVar.has(InAppPurchaseBillingClientWrapper.PRODUCT_ID)) {
                                    String string = bVar.getString(InAppPurchaseBillingClientWrapper.PRODUCT_ID);
                                    Map<String, b> skuDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getSkuDetailsMap();
                                    j.f(string, "skuID");
                                    skuDetailsMap.put(string, bVar);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.runnable.run();
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }

        public final void setRunnable(Runnable runnable2) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    j.g(runnable2, "<set-?>");
                    this.runnable = runnable2;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }
    }

    private InAppPurchaseBillingClientWrapper(Context context2, Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2) {
        this.context = context2;
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.purchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper2;
        this.historyPurchaseSet = new CopyOnWriteArraySet();
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapper(Context context2, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, inAppPurchaseSkuDetailsWrapper2);
    }

    public static final /* synthetic */ Context access$getContext$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.context;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonPurchaseHistoryMethod$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonPurchaseHistoryMethod;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonSkuMethod$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonSkuMethod;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Set access$getHistoryPurchaseSet$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.historyPurchaseSet;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$getInitialized$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return initialized;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapper access$getInstance$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getPurchaseDetailsMap$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return purchaseDetailsMap;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getPurchaseHistoryRecordClazz$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.purchaseHistoryRecordClazz;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getSkuDetailsClazz$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.skuDetailsClazz;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSkuDetailsMap$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return skuDetailsMap;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$isServiceConnected$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return isServiceConnected;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                instance = inAppPurchaseBillingClientWrapper;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final /* synthetic */ void access$startConnection(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                inAppPurchaseBillingClientWrapper.startConnection();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(Context context2) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        synchronized (cls) {
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return null;
            }
            try {
                InAppPurchaseBillingClientWrapper orCreateInstance = Companion.getOrCreateInstance(context2);
                return orCreateInstance;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: queryPurchaseHistory$lambda-0  reason: not valid java name */
    public static final void m70queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(inAppPurchaseBillingClientWrapper, "this$0");
                j.g(runnable, "$queryPurchaseHistoryRunnable");
                inAppPurchaseBillingClientWrapper.querySkuDetailsAsync(IN_APP, new ArrayList(inAppPurchaseBillingClientWrapper.historyPurchaseSet), runnable);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final void queryPurchaseHistoryAsync(String str, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this.purchaseHistoryResponseListenerClazz}, new PurchaseHistoryResponseListenerWrapper(this, runnable));
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchaseHistoryAsyncMethod, this.billingClient, str, newProxyInstance);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void querySkuDetailsAsync(String str, List<String> list, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{this.skuDetailsResponseListenerClazz}, new SkuDetailsResponseListenerWrapper(this, runnable));
                Object skuDetailsParams = this.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(str, list);
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.querySkuDetailsAsyncMethod, this.billingClient, skuDetailsParams, newProxyInstance);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void startConnection() {
        Method method;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Class<?> cls = InAppPurchaseUtils.getClass(CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
                if (cls != null && (method = InAppPurchaseUtils.getMethod(this.billingClientClazz, METHOD_START_CONNECTION, cls)) != null) {
                    Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BillingClientStateListenerWrapper());
                    InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method, this.billingClient, newProxyInstance);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void queryPurchase(String str, Runnable runnable) {
        List list;
        String str2;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(str, "skuType");
                j.g(runnable, "querySkuRunnable");
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseResultClazz, this.getPurchaseListMethod, InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchasesMethod, this.billingClient, IN_APP), new Object[0]);
                if (invokeMethod instanceof List) {
                    list = (List) invokeMethod;
                } else {
                    list = null;
                }
                if (list != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Object next : list) {
                            InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                            Object invokeMethod2 = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.getOriginalJsonMethod, next, new Object[0]);
                            if (invokeMethod2 instanceof String) {
                                str2 = (String) invokeMethod2;
                            } else {
                                str2 = null;
                            }
                            if (str2 != null) {
                                b bVar = new b(str2);
                                if (bVar.has(PRODUCT_ID)) {
                                    String string = bVar.getString(PRODUCT_ID);
                                    arrayList.add(string);
                                    Map<String, b> map = purchaseDetailsMap;
                                    j.f(string, "skuID");
                                    map.put(string, bVar);
                                }
                            }
                        }
                        querySkuDetailsAsync(str, arrayList, runnable);
                    } catch (JSONException unused) {
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void queryPurchaseHistory(String str, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(str, "skuType");
                j.g(runnable, "queryPurchaseHistoryRunnable");
                queryPurchaseHistoryAsync(str, new e(this, runnable));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
