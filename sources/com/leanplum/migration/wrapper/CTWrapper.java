package com.leanplum.migration.wrapper;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.b;
import com.clevertap.android.sdk.f;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.h;
import com.leanplum.callbacks.CleverTapInstanceCallback;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;
import com.leanplum.migration.MigrationConstants;
import com.leanplum.migration.MigrationManager;
import com.leanplum.migration.push.FcmMigrationHandler;
import com.leanplum.migration.push.HmsMigrationHandler;
import com.leanplum.migration.push.MiPushMigrationHandler;
import com.leanplum.utils.SharedPreferencesUtil;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.kits.AppsFlyerKit;
import com.mparticle.kits.LeanplumKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import tk.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J4\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u00032\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0016J\u001e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+H\u0016J \u0010,\u001a\u0004\u0018\u00010&2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010&0.H\u0002J\u0011\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0001J\u0010\u00102\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u00103\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J\u0011\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u000206H\u0001J\u001c\u00107\u001a\u00020\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030%H\u0016J \u00108\u001a\u00020\u001f2\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0016J\u0012\u0010:\u001a\u00020\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J<\u0010;\u001a\u00020\u001f2\b\u0010<\u001a\u0004\u0018\u00010\u00032\u0006\u0010=\u001a\u00020>2\b\u0010#\u001a\u0004\u0018\u00010\u00032\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0016JX\u0010?\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u00032\u0006\u0010=\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u00010\u00032\b\u0010B\u001a\u0004\u0018\u00010\u00032\b\u0010C\u001a\u0004\u0018\u00010\u00032\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0016J:\u0010D\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0016J\b\u0010E\u001a\u00020\u001fH\u0002J\f\u0010F\u001a\u00020\u001f*\u00020\nH\u0002J\f\u0010G\u001a\u00020\u001f*\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006H"}, d2 = {"Lcom/leanplum/migration/wrapper/CTWrapper;", "Lcom/leanplum/migration/wrapper/IWrapper;", "accountId", "", "accountToken", "accountRegion", "deviceId", "userId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cleverTapInstance", "Lcom/clevertap/android/sdk/CleverTapAPI;", "fcmHandler", "Lcom/leanplum/migration/push/FcmMigrationHandler;", "getFcmHandler", "()Lcom/leanplum/migration/push/FcmMigrationHandler;", "firstTimeStart", "", "hmsHandler", "Lcom/leanplum/migration/push/HmsMigrationHandler;", "getHmsHandler", "()Lcom/leanplum/migration/push/HmsMigrationHandler;", "identityManager", "Lcom/leanplum/migration/wrapper/IdentityManager;", "instanceCallbackList", "", "Lcom/leanplum/callbacks/CleverTapInstanceCallback;", "miPushHandler", "Lcom/leanplum/migration/push/MiPushMigrationHandler;", "getMiPushHandler", "()Lcom/leanplum/migration/push/MiPushMigrationHandler;", "addInstanceCallback", "", "callback", "advanceTo", "state", "info", "params", "", "", "launch", "context", "Landroid/content/Context;", "callbacks", "", "mapNotSupportedValues", "entry", "", "registerLifecycleCallback", "app", "Landroid/app/Application;", "removeInstanceCallback", "sendPushTokens", "setLogLevel", "lpLevel", "", "setTrafficSourceInfo", "setUserAttributes", "attributes", "setUserId", "track", "event", "value", "", "trackGooglePlayPurchase", "item", "currencyCode", "purchaseData", "dataSignature", "trackPurchase", "triggerInstanceCallbacks", "setAnonymousDeviceProperty", "setDevicesProperty", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class CTWrapper implements IWrapper {
    private final /* synthetic */ StaticMethodsWrapper $$delegate_0 = StaticMethodsWrapper.INSTANCE;
    private final String accountId;
    private final String accountRegion;
    private final String accountToken;
    private CleverTapAPI cleverTapInstance;
    private final FcmMigrationHandler fcmHandler;
    private boolean firstTimeStart;
    private final HmsMigrationHandler hmsHandler;
    private IdentityManager identityManager;
    private List<CleverTapInstanceCallback> instanceCallbackList;
    private final MiPushMigrationHandler miPushHandler;

    public CTWrapper(String str, String str2, String str3, String str4, String str5) {
        String str6;
        j.g(str, Constants.Params.CT_ACCOUNT_ID);
        j.g(str2, "accountToken");
        j.g(str3, "accountRegion");
        j.g(str4, Constants.Params.DEVICE_ID);
        this.accountId = str;
        this.accountToken = str2;
        this.accountRegion = str3;
        this.fcmHandler = new FcmMigrationHandler();
        this.hmsHandler = new HmsMigrationHandler();
        this.miPushHandler = new MiPushMigrationHandler();
        this.instanceCallbackList = new ArrayList();
        if (str5 != null) {
            str6 = str5;
        } else {
            str6 = str4;
        }
        IdentityManager identityManager2 = new IdentityManager(str4, str6, (d) null, (d) null, 12, (DefaultConstructorMarker) null);
        this.identityManager = identityManager2;
        this.firstTimeStart = identityManager2.isFirstTimeStart();
    }

    private final Object mapNotSupportedValues(Map.Entry<String, ? extends Object> entry) {
        Object value = entry.getValue();
        if (value instanceof Iterable) {
            return CollectionsKt___CollectionsKt.W(CollectionsKt___CollectionsKt.K((Iterable) value), AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
        }
        if (value instanceof Byte) {
            return Integer.valueOf(((Number) value).byteValue());
        }
        if (value instanceof Short) {
            return Integer.valueOf(((Number) value).shortValue());
        }
        return value;
    }

    private final void sendPushTokens(Context context) {
        String string = SharedPreferencesUtil.getString(context, Constants.Defaults.LEANPLUM_PUSH, Constants.Defaults.PROPERTY_FCM_TOKEN_ID);
        if (!TextUtils.isEmpty(string)) {
            h.d().a(context, string, PushConstants.PushType.FCM.h());
            Log.d("Wrapper: fcm token sent", new Object[0]);
        }
        String string2 = SharedPreferencesUtil.getString(context, Constants.Defaults.LEANPLUM_PUSH, Constants.Defaults.PROPERTY_MIPUSH_TOKEN_ID);
        if (!TextUtils.isEmpty(string2)) {
            h.d().a(context, string2, PushConstants.PushType.XPS.h());
            Log.d("Wrapper: xps token sent", new Object[0]);
        }
        String string3 = SharedPreferencesUtil.getString(context, Constants.Defaults.LEANPLUM_PUSH, Constants.Defaults.PROPERTY_HMS_TOKEN_ID);
        if (!TextUtils.isEmpty(string3)) {
            h.d().a(context, string3, PushConstants.PushType.HPS.h());
            Log.d("Wrapper: hms token sent", new Object[0]);
        }
    }

    private final void setAnonymousDeviceProperty(CleverTapAPI cleverTapAPI) {
        if (this.identityManager.isDeviceIdHashed()) {
            String originalDeviceId = this.identityManager.getOriginalDeviceId();
            Log.d("Wrapper: property lp_device set " + originalDeviceId, new Object[0]);
            cleverTapAPI.W(g0.f(gk.h.a(MigrationConstants.ANONYMOUS_DEVICE_PROPERTY, originalDeviceId)));
        }
    }

    private final void setDevicesProperty(CleverTapAPI cleverTapAPI) {
        if (this.identityManager.isDeviceIdHashed()) {
            String originalDeviceId = this.identityManager.getOriginalDeviceId();
            Log.d("Wrapper: property lp_devices add " + originalDeviceId, new Object[0]);
            f.f10208a.a(MigrationConstants.DEVICES_USER_PROPERTY, originalDeviceId, cleverTapAPI);
        }
    }

    private final void triggerInstanceCallbacks() {
        CleverTapAPI cleverTapAPI = this.cleverTapInstance;
        if (cleverTapAPI != null) {
            Log.d("Wrapper: notifying " + this.instanceCallbackList.size() + " instance callbacks", new Object[0]);
            for (CleverTapInstanceCallback onInstance : this.instanceCallbackList) {
                onInstance.onInstance(cleverTapAPI);
            }
        }
    }

    public void addInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback) {
        j.g(cleverTapInstanceCallback, "callback");
        this.instanceCallbackList.add(cleverTapInstanceCallback);
        CleverTapAPI cleverTapAPI = this.cleverTapInstance;
        if (cleverTapAPI != null) {
            Log.d("Wrapper: notifying new instance callback", new Object[0]);
            cleverTapInstanceCallback.onInstance(cleverTapAPI);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0047, code lost:
        if (r6 != null) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void advanceTo(java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, ? extends java.lang.Object> r6) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "state_"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            if (r6 == 0) goto L_0x004a
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            int r1 = r6.size()
            int r1 = kotlin.collections.g0.e(r1)
            r0.<init>(r1)
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x002b:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0043
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r3.mapNotSupportedValues(r1)
            r0.put(r2, r1)
            goto L_0x002b
        L_0x0043:
            java.util.Map r6 = kotlin.collections.h0.w(r0)
            if (r6 == 0) goto L_0x004a
            goto L_0x004f
        L_0x004a:
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
        L_0x004f:
            if (r5 == 0) goto L_0x0056
            java.lang.String r0 = "info"
            r6.put(r0, r5)
        L_0x0056:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Wrapper: Leanplum.advance will call pushEvent with "
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = " and "
            r5.append(r0)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.leanplum.internal.Log.d(r5, r0)
            com.clevertap.android.sdk.CleverTapAPI r5 = r3.cleverTapInstance
            if (r5 == 0) goto L_0x007c
            r5.T(r4, r6)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.migration.wrapper.CTWrapper.advanceTo(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public FcmMigrationHandler getFcmHandler() {
        return this.fcmHandler;
    }

    public HmsMigrationHandler getHmsHandler() {
        return this.hmsHandler;
    }

    public MiPushMigrationHandler getMiPushHandler() {
        return this.miPushHandler;
    }

    public void launch(Context context, List<? extends CleverTapInstanceCallback> list) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "callbacks");
        this.instanceCallbackList.addAll(list);
        int logLevel = Log.getLogLevel();
        int a10 = MigrationConstants.INSTANCE.mapLogLevel(logLevel).a();
        CleverTapInstanceConfig c10 = CleverTapInstanceConfig.c(context, this.accountId, this.accountToken, this.accountRegion);
        c10.F(true);
        c10.E(a10);
        setLogLevel(logLevel);
        String cleverTapId = this.identityManager.cleverTapId();
        Map<String, String> profile = this.identityManager.profile();
        Log.d("Wrapper: using CleverTapID=__h" + cleverTapId, new Object[0]);
        CleverTapAPI G = CleverTapAPI.G(context, c10, cleverTapId);
        Application application = null;
        if (G != null) {
            G.e0(LeanplumKit.NAME);
            if (!b.f10117a) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Application) {
                    application = applicationContext;
                }
                b.a(application);
            }
            if (this.identityManager.isAnonymous()) {
                Log.d("Wrapper: identity not set for anonymous user", new Object[0]);
                setAnonymousDeviceProperty(G);
            } else {
                Log.d("Wrapper: will call onUserLogin with " + profile + " and __h" + cleverTapId, new Object[0]);
                G.Q(profile, cleverTapId);
                setDevicesProperty(G);
            }
            Log.d("Wrapper: CleverTap instance created by Leanplum", new Object[0]);
            Unit unit = Unit.f32013a;
        } else {
            G = null;
        }
        this.cleverTapInstance = G;
        if (this.firstTimeStart) {
            sendPushTokens(context);
        }
        triggerInstanceCallbacks();
    }

    public void registerLifecycleCallback(Application application) {
        j.g(application, "app");
        this.$$delegate_0.registerLifecycleCallback(application);
    }

    public void removeInstanceCallback(CleverTapInstanceCallback cleverTapInstanceCallback) {
        j.g(cleverTapInstanceCallback, "callback");
        this.instanceCallbackList.remove(cleverTapInstanceCallback);
    }

    public void setLogLevel(int i10) {
        this.$$delegate_0.setLogLevel(i10);
    }

    public void setTrafficSourceInfo(Map<String, String> map) {
        j.g(map, "info");
        String str = map.get("publisherName");
        String str2 = map.get("publisherSubPublisher");
        String str3 = map.get("publisherSubCampaign");
        Log.d("Wrapper: Leanplum.setTrafficSourceInfo will call pushInstallReferrer with " + str + ", " + str2 + ", and " + str3, new Object[0]);
        CleverTapAPI cleverTapAPI = this.cleverTapInstance;
        if (cleverTapAPI != null) {
            cleverTapAPI.U(str, str2, str3);
        }
    }

    public void setUserAttributes(Map<String, ? extends Object> map) {
        boolean z10;
        if (map != null && !map.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<String, ? extends Object>> it = map.entrySet().iterator();
            while (true) {
                boolean z11 = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (next.getValue() == null) {
                    z11 = false;
                }
                if (z11) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.e(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry.getKey(), mapNotSupportedValues(entry));
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(g0.e(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                linkedHashMap3.put(MigrationManager.INSTANCE.mapAttributeName((Map.Entry<String, ? extends Object>) entry2), entry2.getValue());
            }
            Log.d("Wrapper: Leanplum.setUserAttributes will call pushProfile with " + linkedHashMap3, new Object[0]);
            CleverTapAPI cleverTapAPI = this.cleverTapInstance;
            if (cleverTapAPI != null) {
                cleverTapAPI.W(linkedHashMap3);
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            for (Map.Entry next2 : map.entrySet()) {
                if (next2.getValue() == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    linkedHashMap4.put(next2.getKey(), next2.getValue());
                }
            }
            MigrationManager migrationManager = MigrationManager.INSTANCE;
            LinkedHashMap linkedHashMap5 = new LinkedHashMap(g0.e(linkedHashMap4.size()));
            for (Map.Entry entry3 : linkedHashMap4.entrySet()) {
                linkedHashMap5.put(migrationManager.mapAttributeName((Map.Entry<String, ? extends Object>) entry3), entry3.getValue());
            }
            for (Map.Entry entry4 : linkedHashMap5.entrySet()) {
                Log.d("Wrapper: Leanplum.setUserAttributes will call removeValueForKey with " + ((String) entry4.getKey()), new Object[0]);
                CleverTapAPI cleverTapAPI2 = this.cleverTapInstance;
                if (cleverTapAPI2 != null) {
                    cleverTapAPI2.X((String) entry4.getKey());
                }
            }
        }
    }

    public void setUserId(String str) {
        boolean z10;
        if (str != null) {
            if (str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && this.identityManager.setUserId(str)) {
                String cleverTapId = this.identityManager.cleverTapId();
                Map<String, String> profile = this.identityManager.profile();
                Log.d("Wrapper: Leanplum.setUserId will call onUserLogin with " + profile + " and __h" + cleverTapId, new Object[0]);
                CleverTapAPI cleverTapAPI = this.cleverTapInstance;
                if (cleverTapAPI != null) {
                    cleverTapAPI.Q(profile, cleverTapId);
                }
                CleverTapAPI cleverTapAPI2 = this.cleverTapInstance;
                if (cleverTapAPI2 != null) {
                    setDevicesProperty(cleverTapAPI2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r8 != null) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void track(java.lang.String r4, double r5, java.lang.String r7, java.util.Map<java.lang.String, ? extends java.lang.Object> r8) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "Push Delivered"
            boolean r0 = kotlin.jvm.internal.j.b(r4, r0)
            if (r0 != 0) goto L_0x0085
            java.lang.String r0 = "Push Opened"
            boolean r0 = kotlin.jvm.internal.j.b(r4, r0)
            if (r0 == 0) goto L_0x0014
            goto L_0x0085
        L_0x0014:
            if (r8 == 0) goto L_0x004a
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            int r1 = r8.size()
            int r1 = kotlin.collections.g0.e(r1)
            r0.<init>(r1)
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x002b:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0043
            java.lang.Object r1 = r8.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r3.mapNotSupportedValues(r1)
            r0.put(r2, r1)
            goto L_0x002b
        L_0x0043:
            java.util.Map r8 = kotlin.collections.h0.w(r0)
            if (r8 == 0) goto L_0x004a
            goto L_0x004f
        L_0x004a:
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
        L_0x004f:
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            java.lang.String r6 = "value"
            r8.put(r6, r5)
            if (r7 == 0) goto L_0x005f
            java.lang.String r5 = "info"
            r8.put(r5, r7)
        L_0x005f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Wrapper: Leanplum.track will call pushEvent with "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r6 = " and "
            r5.append(r6)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.leanplum.internal.Log.d(r5, r6)
            com.clevertap.android.sdk.CleverTapAPI r5 = r3.cleverTapInstance
            if (r5 == 0) goto L_0x0085
            r5.T(r4, r8)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.migration.wrapper.CTWrapper.track(java.lang.String, double, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (r12 != null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackGooglePlayPurchase(java.lang.String r5, java.lang.String r6, double r7, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.util.Map<java.lang.String, ? extends java.lang.Object> r12) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.j.g(r5, r0)
            if (r12 == 0) goto L_0x003b
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            int r2 = r12.size()
            int r2 = kotlin.collections.g0.e(r2)
            r1.<init>(r2)
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x001c:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r12.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r2 = r4.mapNotSupportedValues(r2)
            r1.put(r3, r2)
            goto L_0x001c
        L_0x0034:
            java.util.Map r12 = kotlin.collections.h0.w(r1)
            if (r12 == 0) goto L_0x003b
            goto L_0x0040
        L_0x003b:
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
        L_0x0040:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>(r12)
            r1.put(r0, r5)
            java.lang.Double r5 = java.lang.Double.valueOf(r7)
            java.lang.String r7 = "value"
            r1.put(r7, r5)
            java.lang.String r5 = "currencyCode"
            r1.put(r5, r9)
            java.lang.String r5 = "googlePlayPurchaseData"
            r1.put(r5, r10)
            java.lang.String r5 = "googlePlayPurchaseDataSignature"
            r1.put(r5, r11)
            java.lang.String r5 = "item"
            r1.put(r5, r6)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Wrapper: Leanplum.trackGooglePlayPurchase will call pushChargedEvent with "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = " and "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            com.leanplum.internal.Log.d(r6, r7)
            com.clevertap.android.sdk.CleverTapAPI r6 = r4.cleverTapInstance
            if (r6 == 0) goto L_0x0090
            r6.S(r1, r5)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.migration.wrapper.CTWrapper.trackGooglePlayPurchase(java.lang.String, java.lang.String, double, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (r9 != null) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackPurchase(java.lang.String r5, double r6, java.lang.String r8, java.util.Map<java.lang.String, ? extends java.lang.Object> r9) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.j.g(r5, r0)
            if (r9 == 0) goto L_0x003b
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            int r2 = r9.size()
            int r2 = kotlin.collections.g0.e(r2)
            r1.<init>(r2)
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x001c:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r9.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r2 = r4.mapNotSupportedValues(r2)
            r1.put(r3, r2)
            goto L_0x001c
        L_0x0034:
            java.util.Map r9 = kotlin.collections.h0.w(r1)
            if (r9 == 0) goto L_0x003b
            goto L_0x0040
        L_0x003b:
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
        L_0x0040:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>(r9)
            r1.put(r0, r5)
            java.lang.Double r5 = java.lang.Double.valueOf(r6)
            java.lang.String r6 = "value"
            r1.put(r6, r5)
            if (r8 == 0) goto L_0x0058
            java.lang.String r5 = "currencyCode"
            r1.put(r5, r8)
        L_0x0058:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Wrapper: Leanplum.trackPurchase will call pushChargedEvent with "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = " and "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            com.leanplum.internal.Log.d(r6, r7)
            com.clevertap.android.sdk.CleverTapAPI r6 = r4.cleverTapInstance
            if (r6 == 0) goto L_0x0083
            r6.S(r1, r5)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.migration.wrapper.CTWrapper.trackPurchase(java.lang.String, double, java.lang.String, java.util.Map):void");
    }
}
