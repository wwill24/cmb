package com.clevertap.android.sdk;

import android.app.Activity;
import android.app.job.JobParameters;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.j;
import i4.q;
import i4.r;
import i4.w;
import i4.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

public class CleverTapAPI implements CTInboxActivity.c {

    /* renamed from: e  reason: collision with root package name */
    private static int f10047e = LogLevel.INFO.a();

    /* renamed from: f  reason: collision with root package name */
    static CleverTapInstanceConfig f10048f;

    /* renamed from: g  reason: collision with root package name */
    private static HashMap<String, CleverTapAPI> f10049g;

    /* renamed from: h  reason: collision with root package name */
    private static String f10050h;

    /* renamed from: i  reason: collision with root package name */
    private static o4.d f10051i;

    /* renamed from: j  reason: collision with root package name */
    private static o4.d f10052j;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f10053a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public k f10054b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<q> f10055c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<r> f10056d;

    public enum LogLevel {
        OFF(-1),
        INFO(0),
        DEBUG(2),
        VERBOSE(3);
        
        private final int value;

        private LogLevel(int i10) {
            this.value = i10;
        }

        public int a() {
            return this.value;
        }
    }

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CleverTapInstanceConfig f10062a;

        a(CleverTapInstanceConfig cleverTapInstanceConfig) {
            this.f10062a = cleverTapInstanceConfig;
        }

        /* renamed from: a */
        public Void call() {
            if (!this.f10062a.t()) {
                return null;
            }
            CleverTapAPI.this.J();
            return null;
        }
    }

    class b implements Callable<Void> {
        b() {
        }

        /* renamed from: a */
        public Void call() {
            CleverTapAPI.this.f10054b.l().f();
            CleverTapAPI.this.f10054b.g().Z();
            CleverTapAPI.this.f10054b.g().Y();
            return null;
        }
    }

    class c implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CleverTapInstanceConfig f10065a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f10066b;

        c(CleverTapInstanceConfig cleverTapInstanceConfig, Context context) {
            this.f10065a = cleverTapInstanceConfig;
            this.f10066b = context;
        }

        /* renamed from: a */
        public Void call() {
            String G = this.f10065a.G();
            if (G == null) {
                p.o("Unable to save config to SharedPrefs, config Json is null");
                return null;
            }
            s.p(this.f10066b, s.s(this.f10065a, "instance"), G);
            return null;
        }
    }

    class d implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CTInboxMessage f10068a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f10069b;

        d(CTInboxMessage cTInboxMessage, Bundle bundle) {
            this.f10068a = cTInboxMessage;
            this.f10069b = bundle;
        }

        /* renamed from: a */
        public Void call() {
            p.a("CleverTapAPI:messageDidShow() called  in async with: messageId = [" + this.f10068a.f() + "]");
            if (CleverTapAPI.this.z(this.f10068a.f()).k()) {
                return null;
            }
            CleverTapAPI.this.K(this.f10068a);
            CleverTapAPI.this.f10054b.b().D(false, this.f10068a, this.f10069b);
            return null;
        }
    }

    class e implements Callable<Void> {
        e() {
        }

        /* renamed from: a */
        public Void call() {
            w4.a.d(CleverTapAPI.this.f10053a, CleverTapAPI.this.f10054b.g(), CleverTapAPI.this.f10054b.k());
            return null;
        }
    }

    class f implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.clevertap.android.sdk.pushnotification.e f10072a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f10073b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f10074c;

        f(com.clevertap.android.sdk.pushnotification.e eVar, Bundle bundle, Context context) {
            this.f10072a = eVar;
            this.f10073b = bundle;
            this.f10074c = context;
        }

        /* renamed from: a */
        public Void call() {
            synchronized (CleverTapAPI.this.f10054b.k().C()) {
                CleverTapAPI.this.f10054b.k().U(this.f10072a);
                Bundle bundle = this.f10073b;
                if (bundle == null || !bundle.containsKey("notificationId")) {
                    CleverTapAPI.this.f10054b.k().b(this.f10074c, this.f10073b, -1000);
                } else {
                    j k10 = CleverTapAPI.this.f10054b.k();
                    Context context = this.f10074c;
                    Bundle bundle2 = this.f10073b;
                    k10.b(context, bundle2, bundle2.getInt("notificationId"));
                }
            }
            return null;
        }
    }

    class g implements Callable<Void> {
        g() {
        }

        /* renamed from: a */
        public Void call() {
            if (CleverTapAPI.this.p() == null) {
                return null;
            }
            CleverTapAPI.this.f10054b.j().x();
            return null;
        }
    }

    public interface h {
        void a(String str, PushConstants.PushType pushType);
    }

    private CleverTapAPI(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        this.f10053a = context;
        b0(g.a(context, cleverTapInstanceConfig, str));
        p r10 = r();
        r10.t(cleverTapInstanceConfig.e() + ":async_deviceID", "CoreState is set");
        com.clevertap.android.sdk.task.a.a(cleverTapInstanceConfig).c().f("CleverTapAPI#initializeDeviceInfo", new a(cleverTapInstanceConfig));
        if (x.p() - j.m() > 5) {
            this.f10054b.e().D();
        }
        com.clevertap.android.sdk.task.a.a(cleverTapInstanceConfig).c().f("setStatesAsync", new b());
        com.clevertap.android.sdk.task.a.a(cleverTapInstanceConfig).c().f("saveConfigtoSharedPrefs", new c(cleverTapInstanceConfig, context));
        p.j("CleverTap SDK initialized with accountId: " + cleverTapInstanceConfig.e() + " accountToken: " + cleverTapInstanceConfig.g() + " accountRegion: " + cleverTapInstanceConfig.f());
    }

    public static o4.d A() {
        return f10051i;
    }

    public static com.clevertap.android.sdk.pushnotification.g B(Bundle bundle) {
        boolean z10 = false;
        if (bundle == null) {
            return new com.clevertap.android.sdk.pushnotification.g(false, false);
        }
        boolean containsKey = bundle.containsKey("wzrk_pn");
        if (containsKey && bundle.containsKey("nm")) {
            z10 = true;
        }
        return new com.clevertap.android.sdk.pushnotification.g(containsKey, z10);
    }

    public static o4.d C() {
        return f10052j;
    }

    public static void E(Context context, Bundle bundle) {
        if (bundle != null) {
            String str = null;
            try {
                str = bundle.getString("wzrk_acct_id");
            } catch (Throwable unused) {
            }
            HashMap<String, CleverTapAPI> hashMap = f10049g;
            if (hashMap == null) {
                CleverTapAPI h10 = h(context, str);
                if (h10 != null) {
                    h10.V(bundle);
                    return;
                }
                return;
            }
            for (String str2 : hashMap.keySet()) {
                CleverTapAPI cleverTapAPI = f10049g.get(str2);
                boolean z10 = false;
                if (cleverTapAPI != null && ((str == null && cleverTapAPI.f10054b.e().t()) || cleverTapAPI.m().equals(str))) {
                    z10 = true;
                    continue;
                }
                if (z10) {
                    cleverTapAPI.V(bundle);
                    return;
                }
            }
        }
    }

    public static CleverTapAPI F(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        return G(context, cleverTapInstanceConfig, (String) null);
    }

    public static CleverTapAPI G(Context context, @NonNull CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        if (cleverTapInstanceConfig == null) {
            p.o("CleverTapInstanceConfig cannot be null");
            return null;
        }
        if (f10049g == null) {
            f10049g = new HashMap<>();
        }
        CleverTapAPI cleverTapAPI = f10049g.get(cleverTapInstanceConfig.e());
        if (cleverTapAPI == null) {
            cleverTapAPI = new CleverTapAPI(context, cleverTapInstanceConfig, str);
            f10049g.put(cleverTapInstanceConfig.e(), cleverTapAPI);
            com.clevertap.android.sdk.task.a.a(cleverTapAPI.f10054b.e()).c().f("recordDeviceIDErrors", new g());
        } else if (cleverTapAPI.I() && cleverTapAPI.q().k() && x.y(str)) {
            cleverTapAPI.f10054b.j().u((Map<String, Object>) null, (String) null, str);
        }
        p.p(cleverTapInstanceConfig.e() + ":async_deviceID", "CleverTapAPI instance = " + cleverTapAPI);
        return cleverTapAPI;
    }

    public static boolean H() {
        return j.x();
    }

    private boolean I() {
        return this.f10054b.g().R();
    }

    /* access modifiers changed from: private */
    public void J() {
        com.clevertap.android.sdk.task.a.a(this.f10054b.e()).c().f("Manifest Validation", new e());
    }

    static void L(Activity activity) {
        M(activity, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[SYNTHETIC, Splitter:B:29:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081 A[Catch:{ all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009e A[Catch:{ all -> 0x00b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void M(android.app.Activity r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "wzrk_from"
            java.lang.String r1 = "wzrk_acct_id"
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r2 = f10049g
            r3 = 0
            if (r2 != 0) goto L_0x0010
            android.content.Context r2 = r6.getApplicationContext()
            i(r2, r3, r7)
        L_0x0010:
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r7 = f10049g
            if (r7 != 0) goto L_0x001a
            java.lang.String r6 = "Instances is null in onActivityCreated!"
            com.clevertap.android.sdk.p.o(r6)
            return
        L_0x001a:
            r7 = 1
            android.content.Intent r2 = r6.getIntent()     // Catch:{ all -> 0x0032 }
            android.net.Uri r2 = r2.getData()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0033
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0033 }
            android.os.Bundle r4 = v4.e.a(r4, r7)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = r4.getString(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0034
        L_0x0032:
            r2 = r3
        L_0x0033:
            r4 = r3
        L_0x0034:
            r5 = 0
            android.content.Intent r6 = r6.getIntent()     // Catch:{ all -> 0x0089 }
            android.os.Bundle r3 = r6.getExtras()     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x0089
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0089 }
            if (r6 != 0) goto L_0x0089
            boolean r6 = r3.containsKey(r0)     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0058
            java.lang.String r6 = "CTPushNotificationReceiver"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x0089 }
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r7 = r5
        L_0x0059:
            if (r7 == 0) goto L_0x007b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r6.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = "ActivityLifecycleCallback: Notification Clicked already processed for "
            r6.append(r0)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0079 }
            r6.append(r0)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = ", dropping duplicate."
            r6.append(r0)     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0079 }
            com.clevertap.android.sdk.p.o(r6)     // Catch:{ all -> 0x0079 }
            goto L_0x007b
        L_0x0079:
            r5 = r7
            goto L_0x0089
        L_0x007b:
            boolean r6 = r3.containsKey(r1)     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x0079
            java.lang.Object r6 = r3.get(r1)     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0079 }
            r4 = r6
            goto L_0x0079
        L_0x0089:
            if (r5 == 0) goto L_0x008e
            if (r2 != 0) goto L_0x008e
            return
        L_0x008e:
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r6 = f10049g     // Catch:{ all -> 0x00b8 }
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x00b8 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00b8 }
        L_0x0098:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x00b8 }
            if (r7 == 0) goto L_0x00d1
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00b8 }
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r0 = f10049g     // Catch:{ all -> 0x00b8 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x00b8 }
            com.clevertap.android.sdk.CleverTapAPI r7 = (com.clevertap.android.sdk.CleverTapAPI) r7     // Catch:{ all -> 0x00b8 }
            if (r7 == 0) goto L_0x0098
            com.clevertap.android.sdk.k r7 = r7.f10054b     // Catch:{ all -> 0x00b8 }
            com.clevertap.android.sdk.a r7 = r7.a()     // Catch:{ all -> 0x00b8 }
            r7.i(r3, r2, r4)     // Catch:{ all -> 0x00b8 }
            goto L_0x0098
        L_0x00b8:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Throwable - "
            r7.append(r0)
            java.lang.String r6 = r6.getLocalizedMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.clevertap.android.sdk.p.o(r6)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.M(android.app.Activity, java.lang.String):void");
    }

    public static void N() {
        HashMap<String, CleverTapAPI> hashMap = f10049g;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                CleverTapAPI cleverTapAPI = f10049g.get(str);
                if (cleverTapAPI != null) {
                    try {
                        cleverTapAPI.f10054b.a().f();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static void O(Activity activity) {
        P(activity, (String) null);
    }

    public static void P(Activity activity, String str) {
        if (f10049g == null) {
            i(activity.getApplicationContext(), (String) null, str);
        }
        j.I(true);
        if (f10049g == null) {
            p.o("Instances is null in onActivityResumed!");
            return;
        }
        String j10 = j.j();
        j.N(activity);
        if (j10 == null || !j10.equals(activity.getLocalClassName())) {
            j.w();
        }
        if (j.m() <= 0) {
            j.T(x.p());
        }
        for (String str2 : f10049g.keySet()) {
            CleverTapAPI cleverTapAPI = f10049g.get(str2);
            if (cleverTapAPI != null) {
                try {
                    cleverTapAPI.f10054b.a().g(activity);
                } catch (Throwable th2) {
                    p.o("Throwable - " + th2.getLocalizedMessage());
                }
            }
        }
    }

    public static void R(Context context, Bundle bundle) {
        CleverTapAPI l10 = l(context, bundle);
        if (l10 != null) {
            l10.f10054b.k().M(bundle);
        }
    }

    public static void Z(Context context) {
        HashMap<String, CleverTapAPI> hashMap = f10049g;
        if (hashMap == null) {
            CleverTapAPI v10 = v(context);
            if (v10 == null) {
                return;
            }
            if (v10.q().q()) {
                v10.f10054b.k().S(context, (JobParameters) null);
            } else {
                p.a("Instance doesn't allow Background sync, not running the Job");
            }
        } else {
            for (String next : hashMap.keySet()) {
                CleverTapAPI cleverTapAPI = f10049g.get(next);
                if (cleverTapAPI != null) {
                    if (cleverTapAPI.q().p()) {
                        p.b(next, "Instance is Analytics Only not processing device token");
                    } else if (!cleverTapAPI.q().q()) {
                        p.b(next, "Instance doesn't allow Background sync, not running the Job");
                    } else {
                        cleverTapAPI.f10054b.k().S(context, (JobParameters) null);
                    }
                }
            }
        }
    }

    public static void a0(Context context, JobParameters jobParameters) {
        HashMap<String, CleverTapAPI> hashMap = f10049g;
        if (hashMap == null) {
            CleverTapAPI v10 = v(context);
            if (v10 == null) {
                return;
            }
            if (v10.q().q()) {
                v10.f10054b.k().S(context, jobParameters);
            } else {
                p.a("Instance doesn't allow Background sync, not running the Job");
            }
        } else {
            for (String next : hashMap.keySet()) {
                CleverTapAPI cleverTapAPI = f10049g.get(next);
                if (cleverTapAPI != null && cleverTapAPI.q().p()) {
                    p.b(next, "Instance is Analytics Only not running the Job");
                } else if (cleverTapAPI == null || !cleverTapAPI.q().q()) {
                    p.b(next, "Instance doesn't allow Background sync, not running the Job");
                } else {
                    cleverTapAPI.f10054b.k().S(context, jobParameters);
                }
            }
        }
    }

    public static void c0(int i10) {
        f10047e = i10;
    }

    public static void d0(LogLevel logLevel) {
        f10047e = logLevel.a();
    }

    public static void f0(Context context, String str, PushConstants.PushType pushType) {
        Iterator<CleverTapAPI> it = o(context).iterator();
        while (it.hasNext()) {
            it.next().f10054b.k().s(str, pushType);
        }
    }

    private static CleverTapAPI h(Context context, String str) {
        return i(context, str, (String) null);
    }

    private static CleverTapAPI i(Context context, String str, String str2) {
        if (str == null) {
            try {
                return w(context, str2);
            } catch (Throwable unused) {
            }
        } else {
            String i10 = s.i(context, "instance:" + str, "");
            if (!i10.isEmpty()) {
                CleverTapInstanceConfig d10 = CleverTapInstanceConfig.d(i10);
                p.o("Inflated Instance Config: " + i10);
                if (d10 != null) {
                    return G(context, d10, str2);
                }
                return null;
            }
            try {
                CleverTapAPI v10 = v(context);
                if (v10 == null || !v10.f10054b.e().e().equals(str)) {
                    return null;
                }
                return v10;
            } catch (Throwable th2) {
                p.r("Error creating shared Instance: ", th2.getCause());
                return null;
            }
        }
    }

    private static CleverTapAPI k(Context context, String str) {
        HashMap<String, CleverTapAPI> hashMap = f10049g;
        if (hashMap == null) {
            return h(context, str);
        }
        for (String str2 : hashMap.keySet()) {
            CleverTapAPI cleverTapAPI = f10049g.get(str2);
            boolean z10 = false;
            if (cleverTapAPI != null && ((str == null && cleverTapAPI.f10054b.e().t()) || cleverTapAPI.m().equals(str))) {
                z10 = true;
                continue;
            }
            if (z10) {
                return cleverTapAPI;
            }
        }
        return null;
    }

    private static CleverTapAPI l(Context context, Bundle bundle) {
        return k(context, bundle.getString("wzrk_acct_id"));
    }

    private static ArrayList<CleverTapAPI> o(Context context) {
        ArrayList<CleverTapAPI> arrayList = new ArrayList<>();
        HashMap<String, CleverTapAPI> hashMap = f10049g;
        if (hashMap == null || hashMap.isEmpty()) {
            CleverTapAPI v10 = v(context);
            if (v10 != null) {
                arrayList.add(v10);
            }
        } else {
            arrayList.addAll(f10049g.values());
        }
        return arrayList;
    }

    private CleverTapInstanceConfig q() {
        return this.f10054b.e();
    }

    private p r() {
        return q().n();
    }

    public static int t() {
        return f10047e;
    }

    private static CleverTapInstanceConfig u(Context context) {
        q h10 = q.h(context);
        String c10 = h10.c();
        String e10 = h10.e();
        String d10 = h10.d();
        if (c10 == null || e10 == null) {
            p.j("Account ID or Account token is missing from AndroidManifest.xml, unable to create default instance");
            return null;
        }
        if (d10 == null) {
            p.j("Account Region not specified in the AndroidManifest - using default region");
        }
        return CleverTapInstanceConfig.a(context, c10, e10, d10);
    }

    public static CleverTapAPI v(Context context) {
        return w(context, (String) null);
    }

    public static CleverTapAPI w(Context context, String str) {
        f10050h = BuildConfig.SDK_VERSION_STRING;
        CleverTapInstanceConfig cleverTapInstanceConfig = f10048f;
        if (cleverTapInstanceConfig != null) {
            return G(context, cleverTapInstanceConfig, str);
        }
        CleverTapInstanceConfig u10 = u(context);
        f10048f = u10;
        if (u10 != null) {
            return G(context, u10, str);
        }
        return null;
    }

    public static CleverTapAPI x(Context context, String str) {
        return k(context, str);
    }

    public w D() {
        return this.f10054b.d().n();
    }

    public void K(CTInboxMessage cTInboxMessage) {
        if (this.f10054b.f().e() != null) {
            this.f10054b.f().e().o(cTInboxMessage);
        } else {
            r().f(m(), "Notification Inbox not initialized");
        }
    }

    public void Q(Map<String, Object> map, String str) {
        this.f10054b.j().w(map, str);
    }

    public void S(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList) {
        this.f10054b.b().z(hashMap, arrayList);
    }

    public void T(String str, Map<String, Object> map) {
        this.f10054b.b().B(str, map);
    }

    public synchronized void U(String str, String str2, String str3) {
        this.f10054b.b().F(str, str2, str3);
    }

    public void V(Bundle bundle) {
        this.f10054b.b().G(bundle);
    }

    public void W(Map<String, Object> map) {
        this.f10054b.b().I(map);
    }

    public void X(String str) {
        this.f10054b.b().K(str);
    }

    public void Y(@NonNull com.clevertap.android.sdk.pushnotification.e eVar, Context context, Bundle bundle) {
        CleverTapInstanceConfig e10 = this.f10054b.e();
        try {
            com.clevertap.android.sdk.task.a.a(e10).c().f("CleverTapAPI#renderPushNotification", new f(eVar, bundle, context));
        } catch (Throwable th2) {
            e10.n().g(e10.e(), "Failed to process renderPushNotification()", th2);
        }
    }

    public void a(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle) {
        com.clevertap.android.sdk.task.a.a(this.f10054b.e()).c().f("handleMessageDidShow", new d(cTInboxMessage, bundle));
    }

    public void b(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z10) {
        WeakReference<r> weakReference;
        this.f10054b.b().D(true, cTInboxMessage, bundle);
        if (hashMap == null || hashMap.isEmpty()) {
            p.o("clicked inbox notification.");
            if (z10 && (weakReference = this.f10056d) != null && weakReference.get() != null) {
                this.f10056d.get().a(cTInboxMessage);
                return;
            }
            return;
        }
        p.o("clicked button of an inbox notification.");
        WeakReference<q> weakReference2 = this.f10055c;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.f10055c.get().a(hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void b0(k kVar) {
        this.f10054b = kVar;
    }

    public void e0(String str) {
        if (this.f10054b.g() != null) {
            this.f10054b.g().a0(str);
        }
    }

    public void f(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            this.f10054b.b().d(str);
        } else {
            g(str, new ArrayList(Collections.singletonList(str2)));
        }
    }

    public void g(String str, ArrayList<String> arrayList) {
        this.f10054b.b().u(str, arrayList);
    }

    /* access modifiers changed from: package-private */
    public void j(String str) {
        String e10 = this.f10054b.e().e();
        if (this.f10054b.f() == null) {
            r().t(e10 + ":async_deviceID", "ControllerManager not set yet! Returning from deviceIDCreated()");
            return;
        }
        if (this.f10054b.f().h() == null) {
            r().t(e10 + ":async_deviceID", "Initializing InAppFC after Device ID Created = " + str);
            this.f10054b.f().p(new m(this.f10053a, this.f10054b.e(), str));
        }
        m4.a d10 = this.f10054b.f().d();
        if (d10 != null && TextUtils.isEmpty(d10.j())) {
            r().t(e10 + ":async_deviceID", "Initializing Feature Flags after Device ID Created = " + str);
            d10.p(str);
        }
        CTProductConfigController f10 = this.f10054b.f().f();
        if (f10 != null && TextUtils.isEmpty(f10.j().g())) {
            r().t(e10 + ":async_deviceID", "Initializing Product Config after Device ID Created = " + str);
            f10.w(str);
        }
        r().t(e10 + ":async_deviceID", "Got device id from DeviceInfo, notifying user profile initialized to SyncListener");
        this.f10054b.d().p(str);
        if (this.f10054b.d().i() != null) {
            this.f10054b.d().i().a(str);
        }
    }

    public String m() {
        return this.f10054b.e().e();
    }

    public ArrayList<CTInboxMessage> n() {
        p.a("CleverTapAPI:getAllInboxMessages: called");
        ArrayList<CTInboxMessage> arrayList = new ArrayList<>();
        synchronized (this.f10054b.c().b()) {
            if (this.f10054b.f().e() != null) {
                Iterator<n4.e> it = this.f10054b.f().e().l().iterator();
                while (it.hasNext()) {
                    n4.e next = it.next();
                    p.o("CTMessage Dao - " + next.v().toString());
                    arrayList.add(new CTInboxMessage(next.v()));
                }
                return arrayList;
            }
            r().f(m(), "Notification Inbox not initialized");
            return arrayList;
        }
    }

    public String p() {
        return this.f10054b.g().x();
    }

    public k s() {
        return this.f10054b;
    }

    public int y() {
        synchronized (this.f10054b.c().b()) {
            if (this.f10054b.f().e() != null) {
                int i10 = this.f10054b.f().e().i();
                return i10;
            }
            r().f(m(), "Notification Inbox not initialized");
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004b, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.clevertap.android.sdk.inbox.CTInboxMessage z(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "CleverTapAPI:getInboxMessageForId() called with: messageId = ["
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.clevertap.android.sdk.p.a(r0)
            com.clevertap.android.sdk.k r0 = r4.f10054b
            i4.e r0 = r0.c()
            java.lang.Object r0 = r0.b()
            monitor-enter(r0)
            com.clevertap.android.sdk.k r1 = r4.f10054b     // Catch:{ all -> 0x005b }
            i4.i r1 = r1.f()     // Catch:{ all -> 0x005b }
            n4.d r1 = r1.e()     // Catch:{ all -> 0x005b }
            r2 = 0
            if (r1 == 0) goto L_0x004c
            com.clevertap.android.sdk.k r1 = r4.f10054b     // Catch:{ all -> 0x005b }
            i4.i r1 = r1.f()     // Catch:{ all -> 0x005b }
            n4.d r1 = r1.e()     // Catch:{ all -> 0x005b }
            n4.e r5 = r1.k(r5)     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x004a
            com.clevertap.android.sdk.inbox.CTInboxMessage r2 = new com.clevertap.android.sdk.inbox.CTInboxMessage     // Catch:{ all -> 0x005b }
            org.json.b r5 = r5.v()     // Catch:{ all -> 0x005b }
            r2.<init>((org.json.b) r5)     // Catch:{ all -> 0x005b }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r2
        L_0x004c:
            com.clevertap.android.sdk.p r5 = r4.r()     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r4.m()     // Catch:{ all -> 0x005b }
            java.lang.String r3 = "Notification Inbox not initialized"
            r5.f(r1, r3)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r2
        L_0x005b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.z(java.lang.String):com.clevertap.android.sdk.inbox.CTInboxMessage");
    }
}
