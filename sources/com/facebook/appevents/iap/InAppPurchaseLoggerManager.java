package com.facebook.appevents.iap;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.pool.TypePool;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\n\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bH\u0007J\u001c\u0010\u000b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0007J/\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0011\u0010\u0012JE\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bH\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010%\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010'\u001a\u00020&8\u0002XT¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8\u0002XT¢\u0006\u0006\n\u0004\b)\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseLoggerManager;", "", "", "readPurchaseCache", "", "", "Lorg/json/b;", "purchaseDetailsMap", "", "skuDetailsMap", "filterPurchaseLogging", "logPurchases", "", "eligibleQueryPurchaseHistory", "cacheDeDupPurchase$facebook_core_release", "(Ljava/util/Map;)Ljava/util/Map;", "cacheDeDupPurchase", "clearOutdatedProductInfoInCache$facebook_core_release", "()V", "clearOutdatedProductInfoInCache", "constructLoggingReadyMap$facebook_core_release", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "constructLoggingReadyMap", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "", "cachedPurchaseSet", "Ljava/util/Set;", "", "cachedPurchaseMap", "Ljava/util/Map;", "PURCHASE_TIME", "Ljava/lang/String;", "PRODUCT_DETAILS_STORE", "LAST_CLEARED_TIME", "PURCHASE_DETAILS_SET", "LAST_QUERY_PURCHASE_HISTORY_TIME", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "I", "PURCHASE_IN_CACHE_INTERVAL", "<init>", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class InAppPurchaseLoggerManager {
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    public static final InAppPurchaseLoggerManager INSTANCE = new InAppPurchaseLoggerManager();
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_QUERY_PURCHASE_HISTORY_TIME = "LAST_QUERY_PURCHASE_HISTORY_TIME";
    private static final String PRODUCT_DETAILS_STORE = "com.facebook.internal.iap.PRODUCT_DETAILS";
    private static final String PURCHASE_DETAILS_SET = "PURCHASE_DETAILS_SET";
    private static final int PURCHASE_IN_CACHE_INTERVAL = 86400;
    private static final String PURCHASE_TIME = "purchaseTime";
    private static final Map<String, Long> cachedPurchaseMap = new ConcurrentHashMap();
    private static final Set<String> cachedPurchaseSet = new CopyOnWriteArraySet();
    private static SharedPreferences sharedPreferences;

    private InAppPurchaseLoggerManager() {
    }

    public static final boolean eligibleQueryPurchaseHistory() {
        Class<InAppPurchaseLoggerManager> cls = InAppPurchaseLoggerManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.readPurchaseCache();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                long j10 = sharedPreferences2.getLong(LAST_QUERY_PURCHASE_HISTORY_TIME, 0);
                if (j10 != 0 && currentTimeMillis - j10 < ((long) PURCHASE_IN_CACHE_INTERVAL)) {
                    return false;
                }
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 != null) {
                    sharedPreferences3.edit().putLong(LAST_QUERY_PURCHASE_HISTORY_TIME, currentTimeMillis).apply();
                    return true;
                }
                j.y("sharedPreferences");
                throw null;
            }
            j.y("sharedPreferences");
            throw null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final void filterPurchaseLogging(Map<String, b> map, Map<String, ? extends b> map2) {
        Class<InAppPurchaseLoggerManager> cls = InAppPurchaseLoggerManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(map, "purchaseDetailsMap");
                j.g(map2, "skuDetailsMap");
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager = INSTANCE;
                inAppPurchaseLoggerManager.readPurchaseCache();
                inAppPurchaseLoggerManager.logPurchases(inAppPurchaseLoggerManager.constructLoggingReadyMap$facebook_core_release(inAppPurchaseLoggerManager.cacheDeDupPurchase$facebook_core_release(map), map2));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final void logPurchases(Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    String str2 = (String) next.getValue();
                    if (!(str == null || str2 == null)) {
                        AutomaticAnalyticsLogger.logPurchase(str, str2, false);
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void readPurchaseCache() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
                SharedPreferences sharedPreferences3 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
                if (sharedPreferences2.contains(LAST_CLEARED_TIME)) {
                    sharedPreferences2.edit().clear().apply();
                    sharedPreferences3.edit().clear().apply();
                }
                SharedPreferences sharedPreferences4 = FacebookSdk.getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, 0);
                j.f(sharedPreferences4, "getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, Context.MODE_PRIVATE)");
                sharedPreferences = sharedPreferences4;
                Set<String> set = cachedPurchaseSet;
                if (sharedPreferences4 != null) {
                    Collection stringSet = sharedPreferences4.getStringSet(PURCHASE_DETAILS_SET, new HashSet());
                    if (stringSet == null) {
                        stringSet = new HashSet();
                    }
                    set.addAll(stringSet);
                    for (String C0 : set) {
                        List C02 = StringsKt__StringsKt.C0(C0, new String[]{";"}, false, 2, 2, (Object) null);
                        cachedPurchaseMap.put(C02.get(0), Long.valueOf(Long.parseLong((String) C02.get(1))));
                    }
                    clearOutdatedProductInfoInCache$facebook_core_release();
                    return;
                }
                j.y("sharedPreferences");
                throw null;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final Map<String, b> cacheDeDupPurchase$facebook_core_release(Map<String, b> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            j.g(map, "purchaseDetailsMap");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (Map.Entry entry : h0.u(map).entrySet()) {
                String str = (String) entry.getKey();
                b bVar = (b) entry.getValue();
                try {
                    if (bVar.has(SDKConstants.PARAM_PURCHASE_TOKEN)) {
                        String string = bVar.getString(SDKConstants.PARAM_PURCHASE_TOKEN);
                        if (cachedPurchaseMap.containsKey(string)) {
                            map.remove(str);
                        } else {
                            Set<String> set = cachedPurchaseSet;
                            set.add(string + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER + currentTimeMillis);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).apply();
                return new HashMap(map);
            }
            j.y("sharedPreferences");
            throw null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final void clearOutdatedProductInfoInCache$facebook_core_release() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    long j10 = sharedPreferences2.getLong(LAST_CLEARED_TIME, 0);
                    if (j10 == 0) {
                        SharedPreferences sharedPreferences3 = sharedPreferences;
                        if (sharedPreferences3 != null) {
                            sharedPreferences3.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                        } else {
                            j.y("sharedPreferences");
                            throw null;
                        }
                    } else if (currentTimeMillis - j10 > 604800) {
                        for (Map.Entry entry : h0.u(cachedPurchaseMap).entrySet()) {
                            String str = (String) entry.getKey();
                            long longValue = ((Number) entry.getValue()).longValue();
                            if (currentTimeMillis - longValue > 86400) {
                                Set<String> set = cachedPurchaseSet;
                                set.remove(str + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER + longValue);
                                cachedPurchaseMap.remove(str);
                            }
                        }
                        SharedPreferences sharedPreferences4 = sharedPreferences;
                        if (sharedPreferences4 != null) {
                            sharedPreferences4.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                        } else {
                            j.y("sharedPreferences");
                            throw null;
                        }
                    }
                } else {
                    j.y("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final Map<String, String> constructLoggingReadyMap$facebook_core_release(Map<String, ? extends b> map, Map<String, ? extends b> map2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            j.g(map, "purchaseDetailsMap");
            j.g(map2, "skuDetailsMap");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                b bVar = (b) next.getValue();
                b bVar2 = (b) map2.get((String) next.getKey());
                if (bVar != null && bVar.has(PURCHASE_TIME)) {
                    try {
                        if (currentTimeMillis - (bVar.getLong(PURCHASE_TIME) / 1000) <= 86400) {
                            if (bVar2 != null) {
                                String bVar3 = bVar.toString();
                                j.f(bVar3, "purchaseDetail.toString()");
                                String bVar4 = bVar2.toString();
                                j.f(bVar4, "skuDetail.toString()");
                                linkedHashMap.put(bVar3, bVar4);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }
}
