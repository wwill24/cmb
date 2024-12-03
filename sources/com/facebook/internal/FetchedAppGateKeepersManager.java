package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.o;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001;B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J!\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010'\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b'\u0010 R\u0014\u0010(\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010)\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b)\u0010 R\u0014\u0010+\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", "", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "callback", "", "loadAppGateKeepersAsync", "pollCallbacks", "", "applicationId", "", "forceRequery", "Lorg/json/b;", "queryAppGateKeepers", "name", "defaultValue", "getGateKeeperForKey", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "gateKeeper", "setRuntimeGateKeeper", "resetRuntimeGateKeeperCache", "getAppGateKeepersQueryResponse", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "(Ljava/lang/String;Lorg/json/b;)Lorg/json/b;", "parseAppGateKeepersFromJSON", "", "timestamp", "isTimestampValid", "(Ljava/lang/Long;)Z", "", "getGateKeepersForApplication", "TAG", "Ljava/lang/String;", "APP_GATEKEEPERS_PREFS_STORE", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_PLATFORM", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_FIELDS", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "fetchedAppGateKeepers", "Ljava/util/Map;", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "J", "Ljava/lang/Long;", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "<init>", "()V", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    private static final String TAG = l.b(FetchedAppGateKeepersManager.class).getSimpleName();
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, b> fetchedAppGateKeepers = new ConcurrentHashMap();
    private static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static Long timestamp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    private final b getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.Companion;
        o oVar = o.f32141a;
        String format2 = String.format("app/%s", Arrays.copyOf(new Object[]{APPLICATION_GATEKEEPER_EDGE}, 1));
        j.f(format2, "java.lang.String.format(format, *args)");
        GraphRequest newGraphPathRequest = companion.newGraphPathRequest((AccessToken) null, format2, (GraphRequest.Callback) null);
        newGraphPathRequest.setParameters(bundle);
        b jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        if (jsonObject == null) {
            return new b();
        }
        return jsonObject;
    }

    public static final boolean getGateKeeperForKey(String str, String str2, boolean z10) {
        Boolean bool;
        j.g(str, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(str2);
        if (gateKeepersForApplication.containsKey(str) && (bool = gateKeepersForApplication.get(str)) != null) {
            return bool.booleanValue();
        }
        return z10;
    }

    private final boolean isTimestampValid(Long l10) {
        return l10 != null && System.currentTimeMillis() - l10.longValue() < 3600000;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppGateKeepersAsync$lambda-0  reason: not valid java name */
    public static final void m115loadAppGateKeepersAsync$lambda0(String str, Context context, String str2) {
        j.g(str, "$applicationId");
        j.g(context, "$context");
        j.g(str2, "$gateKeepersKey");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
        b appGateKeepersQueryResponse = fetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(str);
        if (appGateKeepersQueryResponse.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(str, appGateKeepersQueryResponse);
            context.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str2, appGateKeepersQueryResponse.toString()).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        fetchedAppGateKeepersManager.pollCallbacks();
        isLoading.set(false);
    }

    public static final synchronized b parseAppGateKeepersFromJSON$facebook_core_release(String str, b bVar) {
        b bVar2;
        synchronized (FetchedAppGateKeepersManager.class) {
            j.g(str, "applicationId");
            bVar2 = fetchedAppGateKeepers.get(str);
            if (bVar2 == null) {
                bVar2 = new b();
            }
            int i10 = 0;
            b bVar3 = null;
            if (bVar != null) {
                a optJSONArray = bVar.optJSONArray("data");
                if (optJSONArray != null) {
                    bVar3 = optJSONArray.s(0);
                }
            }
            if (bVar3 == null) {
                bVar3 = new b();
            }
            a optJSONArray2 = bVar3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            if (optJSONArray2 == null) {
                optJSONArray2 = new a();
            }
            int o10 = optJSONArray2.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    try {
                        b j10 = optJSONArray2.j(i10);
                        bVar2.put(j10.getString(SDKConstants.PARAM_KEY), j10.getBoolean("value"));
                    } catch (JSONException e10) {
                        Utility.logd(Utility.LOG_TAG, (Exception) e10);
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
            fetchedAppGateKeepers.put(str, bVar2);
        }
        return bVar2;
    }

    private final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (!concurrentLinkedQueue.isEmpty()) {
                Callback poll = concurrentLinkedQueue.poll();
                if (poll != null) {
                    handler.post(new f(poll));
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m116pollCallbacks$lambda1(Callback callback) {
        callback.onCompleted();
    }

    public static final b queryAppGateKeepers(String str, boolean z10) {
        j.g(str, "applicationId");
        if (!z10) {
            Map<String, b> map = fetchedAppGateKeepers;
            if (map.containsKey(str)) {
                b bVar = map.get(str);
                if (bVar == null) {
                    return new b();
                }
                return bVar;
            }
        }
        b appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(str);
        Context applicationContext = FacebookSdk.getApplicationContext();
        o oVar = o.f32141a;
        String format2 = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{str}, 1));
        j.f(format2, "java.lang.String.format(format, *args)");
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(format2, appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON$facebook_core_release(str, appGateKeepersQueryResponse);
    }

    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, (String) null, 1, (Object) null);
        }
    }

    public static final void setRuntimeGateKeeper(String str, GateKeeper gateKeeper) {
        GateKeeper gateKeeper2;
        GateKeeperRuntimeCache gateKeeperRuntimeCache2;
        j.g(str, "applicationId");
        j.g(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache3 == null) {
            gateKeeper2 = null;
        } else {
            gateKeeper2 = gateKeeperRuntimeCache3.getGateKeeper(str, gateKeeper.getName());
        }
        if (gateKeeper2 != null && (gateKeeperRuntimeCache2 = gateKeeperRuntimeCache) != null) {
            gateKeeperRuntimeCache2.setGateKeeper(str, gateKeeper);
        }
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    public final Map<String, Boolean> getGateKeepersForApplication(String str) {
        List<GateKeeper> list;
        loadAppGateKeepersAsync();
        if (str != null) {
            Map<String, b> map = fetchedAppGateKeepers;
            if (map.containsKey(str)) {
                GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache2 == null) {
                    list = null;
                } else {
                    list = gateKeeperRuntimeCache2.dumpGateKeepers(str);
                }
                if (list != null) {
                    HashMap hashMap = new HashMap();
                    for (GateKeeper gateKeeper : list) {
                        hashMap.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
                    }
                    return hashMap;
                }
                HashMap hashMap2 = new HashMap();
                b bVar = map.get(str);
                if (bVar == null) {
                    bVar = new b();
                }
                Iterator<String> keys = bVar.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    j.f(next, SDKConstants.PARAM_KEY);
                    hashMap2.put(next, Boolean.valueOf(bVar.optBoolean(next)));
                }
                GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache3 == null) {
                    gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
                }
                ArrayList arrayList = new ArrayList(hashMap2.size());
                for (Map.Entry entry : hashMap2.entrySet()) {
                    arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                gateKeeperRuntimeCache3.setGateKeepers(str, arrayList);
                gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
                return hashMap2;
            }
        }
        return new HashMap();
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync((Callback) null);
    }

    public static final synchronized void loadAppGateKeepersAsync(Callback callback) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (callback != null) {
                try {
                    callbacks.add(callback);
                } catch (JSONException e10) {
                    Utility.logd(Utility.LOG_TAG, (Exception) e10);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            String applicationId = FacebookSdk.getApplicationId();
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
            if (!fetchedAppGateKeepersManager.isTimestampValid(timestamp) || !fetchedAppGateKeepers.containsKey(applicationId)) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                o oVar = o.f32141a;
                String format2 = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
                j.f(format2, "java.lang.String.format(format, *args)");
                if (applicationContext != null) {
                    b bVar = null;
                    String string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(format2, (String) null);
                    if (!Utility.isNullOrEmpty(string)) {
                        bVar = new b(string);
                        if (bVar != null) {
                            parseAppGateKeepersFromJSON$facebook_core_release(applicationId, bVar);
                        }
                    }
                    Executor executor = FacebookSdk.getExecutor();
                    if (executor != null) {
                        if (isLoading.compareAndSet(false, true)) {
                            executor.execute(new e(applicationId, applicationContext, format2));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            fetchedAppGateKeepersManager.pollCallbacks();
        }
    }
}
