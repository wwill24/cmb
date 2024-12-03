package com.mparticle.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.mparticle.Configuration;
import com.mparticle.MParticle;
import com.mparticle.MParticleOptions;
import com.mparticle.consent.ConsentState;
import com.mparticle.h;
import com.mparticle.identity.IdentityApi;
import com.mparticle.internal.KitManager;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.PushRegistrationHelper;
import com.mparticle.j;
import com.mparticle.kits.AppsFlyerKit;
import com.mparticle.networking.NetworkOptions;
import com.mparticle.networking.d;
import com.mparticle.p0;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.JSONException;

public class b {
    private static Set<IdentityApi.j> A = new HashSet();

    /* renamed from: w  reason: collision with root package name */
    private static NetworkOptions f22403w;

    /* renamed from: x  reason: collision with root package name */
    static SharedPreferences f22404x;

    /* renamed from: y  reason: collision with root package name */
    private static org.json.a f22405y;

    /* renamed from: z  reason: collision with root package name */
    private static boolean f22406z;

    /* renamed from: a  reason: collision with root package name */
    private Context f22407a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22408b;

    /* renamed from: c  reason: collision with root package name */
    private MParticleOptions.DataplanOptions f22409c;

    /* renamed from: d  reason: collision with root package name */
    private p f22410d;

    /* renamed from: e  reason: collision with root package name */
    private String f22411e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22412f;

    /* renamed from: g  reason: collision with root package name */
    private org.json.b f22413g;

    /* renamed from: h  reason: collision with root package name */
    private int f22414h;

    /* renamed from: i  reason: collision with root package name */
    private int f22415i;

    /* renamed from: j  reason: collision with root package name */
    private int f22416j;

    /* renamed from: k  reason: collision with root package name */
    private int f22417k;

    /* renamed from: l  reason: collision with root package name */
    private long f22418l;

    /* renamed from: m  reason: collision with root package name */
    private org.json.a f22419m;

    /* renamed from: n  reason: collision with root package name */
    private org.json.a f22420n;

    /* renamed from: o  reason: collision with root package name */
    private j f22421o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f22422p;

    /* renamed from: q  reason: collision with root package name */
    private org.json.b f22423q;

    /* renamed from: r  reason: collision with root package name */
    private String f22424r;

    /* renamed from: s  reason: collision with root package name */
    private Integer f22425s;

    /* renamed from: t  reason: collision with root package name */
    private Integer f22426t;

    /* renamed from: u  reason: collision with root package name */
    private List<C0259b> f22427u;

    /* renamed from: v  reason: collision with root package name */
    private List<SideloadedKit> f22428v;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22429a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mparticle.internal.KitManager$KitStatus[] r0 = com.mparticle.internal.KitManager.KitStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22429a = r0
                com.mparticle.internal.KitManager$KitStatus r1 = com.mparticle.internal.KitManager.KitStatus.ACTIVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22429a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mparticle.internal.KitManager$KitStatus r1 = com.mparticle.internal.KitManager.KitStatus.STOPPED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.mparticle.internal.b$b  reason: collision with other inner class name */
    public interface C0259b {
        void a(c cVar, boolean z10);
    }

    public enum c {
        CORE,
        KIT
    }

    private b() {
        this.f22408b = false;
        this.f22411e = "appdefined";
        this.f22414h = -1;
        this.f22415i = -1;
        this.f22416j = -1;
        this.f22417k = -1;
        this.f22418l = DateUtils.MILLIS_IN_HOUR;
        this.f22420n = null;
        this.f22422p = false;
        this.f22427u = new ArrayList();
        this.f22428v = new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y() {
        a(c.KIT, Boolean.TRUE);
    }

    public static b a(Context context) {
        b b10 = MParticle.getInstance() != null ? MParticle.getInstance().Internal().b() : null;
        return b10 == null ? new b(context) : b10;
    }

    private void b0() {
        String m10 = m();
        if (!MPUtility.isEmpty((CharSequence) m10)) {
            try {
                b(new org.json.b(m10));
            } catch (Exception unused) {
            }
        }
    }

    public static p c(Context context, long j10) {
        return p.a(context, j10);
    }

    public static p g(Context context) {
        return p.a(context, b(context));
    }

    private int l() {
        try {
            return this.f22407a.getPackageManager().getPackageInfo(this.f22407a.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("Could not get package name: " + e10);
        }
    }

    public static MParticle.Environment u() {
        SharedPreferences sharedPreferences = f22404x;
        if (sharedPreferences != null) {
            int i10 = sharedPreferences.getInt("mp::environment", MParticle.Environment.Production.getValue());
            for (MParticle.Environment environment : MParticle.Environment.values()) {
                if (environment.getValue() == i10) {
                    return environment;
                }
            }
        }
        return MParticle.Environment.Production;
    }

    public org.json.b A() {
        String string = f22404x.getString("mp::integrationattributes", (String) null);
        if (string == null) {
            return null;
        }
        try {
            return new org.json.b(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public SharedPreferences B() {
        return this.f22407a.getSharedPreferences("mparticle_config.json", 0);
    }

    public org.json.a C() {
        String string = B().getString("kit_config", (String) null);
        if (!MPUtility.isEmpty((CharSequence) string)) {
            try {
                return new org.json.a(string);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean D() {
        if ("appdefined".equals(this.f22411e)) {
            return f22404x.getBoolean("mp::reportUncaughtExceptions", false);
        }
        return "forcecatch".equals(this.f22411e);
    }

    public long E() {
        return c(false);
    }

    public Set<Long> F() {
        return p.c(this.f22407a);
    }

    public NetworkOptions G() {
        if (f22403w == null) {
            f22403w = d.a((NetworkOptions) null);
        }
        return f22403w;
    }

    public boolean H() {
        return f22404x.getBoolean("mp::optout::", false);
    }

    public String I() {
        MPUtility.AdIdInfo adIdInfo = MPUtility.getAdIdInfo(this.f22407a);
        if (adIdInfo == null || adIdInfo.isLimitAdTrackingEnabled) {
            return null;
        }
        return f22404x.getString("mp::previous::android::id", (String) null);
    }

    public synchronized org.json.b J() {
        return this.f22413g;
    }

    public String K() {
        PushRegistrationHelper.PushRegistration M = M();
        if (M != null) {
            return M.instanceId;
        }
        return null;
    }

    public String L() {
        return f22404x.getString("mp::push_reg_id_bckgrnd", (String) null);
    }

    public PushRegistrationHelper.PushRegistration M() {
        return new PushRegistrationHelper.PushRegistration(f22404x.getString("mp::push_reg_id", (String) null), f22404x.getString("mp::push_sender_id", (String) null));
    }

    public String N() {
        PushRegistrationHelper.PushRegistration M = M();
        if (M != null) {
            return M.senderId;
        }
        return null;
    }

    public int O() {
        int i10 = this.f22416j;
        if (i10 > 0) {
            return i10 * 1000;
        }
        return f22404x.getInt("mp::sessionTimeout", 60) * 1000;
    }

    public org.json.a P() {
        return this.f22420n;
    }

    public org.json.a Q() {
        return this.f22419m;
    }

    public long R() {
        if (u().equals(MParticle.Environment.Development)) {
            return 10000;
        }
        int i10 = this.f22417k;
        if (i10 <= 0) {
            i10 = f22404x.getInt("mp::uploadInterval", 600);
        }
        return (long) (i10 * 1000);
    }

    public int S() {
        if (this.f22415i < 0) {
            this.f22415i = (int) (Math.abs(E() >> 8) % 100);
        }
        return this.f22415i;
    }

    public p T() {
        return f(E());
    }

    @NonNull
    public String U() {
        return f22404x.getString("wst", "");
    }

    public boolean V() {
        if (!H() || this.f22412f) {
            return true;
        }
        return false;
    }

    public boolean W() {
        return f22404x.getBoolean("mp::push_enabled", false) && N() != null;
    }

    public boolean X() {
        int i10 = f22404x.getInt("mp::appversion", Integer.MIN_VALUE);
        int l10 = l();
        int i11 = f22404x.getInt("mp::osversion", Integer.MIN_VALUE);
        if (i10 == l10 && i11 == Build.VERSION.SDK_INT) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        if (!f22404x.getBoolean("is_mig_kit_sp", false)) {
            f22404x.edit().putBoolean("is_mig_kit_sp", true).apply();
            String string = f22404x.getString(JsonPacketExtension.ELEMENT, (String) null);
            if (!MPUtility.isEmpty((CharSequence) string)) {
                try {
                    if (string.contains("\"eks\":")) {
                        Logger.info("Migrating kit configuration");
                        a(new org.json.b(string), v(), y(), n());
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    public void a0() {
        b();
        Z();
        b0();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Long n10 = n();
        if (n10 == null) {
            a(Long.valueOf(System.currentTimeMillis()));
            n10 = n();
        }
        Integer num = this.f22426t;
        if (num != null && num.intValue() >= 0) {
            if (this.f22426t.intValue() == 0) {
                c();
            } else if (System.currentTimeMillis() >= n10.longValue() + TimeUnit.SECONDS.toMillis((long) this.f22426t.intValue())) {
                c();
            }
        }
    }

    public void c0() {
        MPUtility.AdIdInfo adIdInfo = MPUtility.getAdIdInfo(this.f22407a);
        if (adIdInfo == null || adIdInfo.isLimitAdTrackingEnabled) {
            f22404x.edit().remove("mp::previous::android::id").apply();
        } else {
            f22404x.edit().putString("mp::previous::android::id", adIdInfo.f22362id).apply();
        }
    }

    public void d(int i10) {
        f22404x.edit().putInt("mp::uploadInterval", i10).apply();
    }

    public void d0() {
        f22404x.edit().putInt("mp::appversion", l()).putInt("mp::osversion", Build.VERSION.SDK_INT).apply();
    }

    public void e(boolean z10) {
        f22404x.edit().putBoolean("mp::reportUncaughtExceptions", z10).apply();
    }

    public p f(long j10) {
        p pVar = this.f22410d;
        if (pVar == null || pVar.m() != j10) {
            this.f22410d = p.a(this.f22407a, j10);
        }
        return this.f22410d;
    }

    public String h() {
        Map<Integer, KitManager.KitStatus> kitStatus = MParticle.getInstance().Internal().c().getKitStatus();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry next : kitStatus.entrySet()) {
            int i10 = a.f22429a[((KitManager.KitStatus) next.getValue()).ordinal()];
            if (i10 == 1 || i10 == 2) {
                arrayList.add((Integer) next.getKey());
            }
        }
        Collections.sort(arrayList);
        if (arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(arrayList.size() * 3);
        for (Integer append : arrayList) {
            sb2.append(append);
            sb2.append(AppsFlyerKit.COMMA);
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

    public int i() {
        return f22404x.getInt("alias_max_window", 90);
    }

    public String j() {
        return f22404x.getString("mp::config::apikey", (String) null);
    }

    public String k() {
        return f22404x.getString("mp::config::apisecret", (String) null);
    }

    /* access modifiers changed from: package-private */
    public String m() {
        return f22404x.getString(JsonPacketExtension.ELEMENT, "");
    }

    /* access modifiers changed from: package-private */
    public Long n() {
        if (f22404x.contains("json_timestamp")) {
            return Long.valueOf(f22404x.getLong("json_timestamp", 0));
        }
        return null;
    }

    public int o() {
        return 30000;
    }

    public int p() {
        return this.f22414h;
    }

    public String q() {
        return this.f22424r;
    }

    public MParticleOptions.DataplanOptions r() {
        return this.f22409c;
    }

    public Integer s() {
        return this.f22425s;
    }

    public String t() {
        String string = f22404x.getString("mp::device-app-stamp", (String) null);
        if (!MPUtility.isEmpty((CharSequence) string)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        f22404x.edit().putString("mp::device-app-stamp", uuid).apply();
        return uuid;
    }

    public String v() {
        return f22404x.getString("mp::etag", (String) null);
    }

    public String w() {
        return f22404x.getString("mp::identity::api::context", (String) null);
    }

    public int x() {
        return f22404x.getInt("mp::connection:timeout:identity", 30) * 1000;
    }

    public String y() {
        return f22404x.getString("mp::ifmodified", (String) null);
    }

    public boolean z() {
        return this.f22422p;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        f22404x.edit().remove(JsonPacketExtension.ELEMENT).remove("json_timestamp").remove("mp::etag").remove("mp::ifmodified").apply();
        B().edit().remove("kit_config").apply();
    }

    public void d() {
        f22404x.edit().remove("mp::push_sender_id").remove("mp::push_reg_id").remove("mp::push_enabled").remove("mp::appversion").remove("mp::osversion").apply();
    }

    public void e() {
        f22404x.edit().remove("mp::push_reg_id_bckgrnd").apply();
    }

    public void g() {
        String N = N();
        if (W() && N != null) {
            MParticle.getInstance().Messaging().enablePushNotifications(N);
        }
    }

    public void a(Context context, long j10) {
        p pVar = this.f22410d;
        if (pVar != null) {
            pVar.b(context, j10);
        }
    }

    public synchronized void f() throws JSONException {
        try {
            String string = B().getString("kit_config", "");
            if (!string.isEmpty()) {
                org.json.a aVar = new org.json.a(string);
                org.json.a a10 = p0.f22631a.a(aVar, this.f22428v);
                B().edit().putString("kit_config", a10.toString()).apply();
                a(c.KIT, Boolean.valueOf(aVar != a10));
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
            throw new RuntimeException(e10);
        }
    }

    public static org.json.a e(Context context) {
        if (f22405y == null) {
            try {
                f22405y = new org.json.a(c(context).getString("pmk", (String) null));
            } catch (Exception unused) {
                f22405y = new org.json.a();
            }
        }
        return f22405y;
    }

    public boolean g(long j10) {
        return p.c(this.f22407a).contains(Long.valueOf(j10));
    }

    public void a(long j10) {
        a(this.f22407a, j10);
    }

    /* access modifiers changed from: package-private */
    public void a(Long l10) {
        f22404x.edit().putLong("json_timestamp", l10.longValue()).apply();
    }

    public static int d(Context context) {
        return c(context).getInt("mp::push::icon", 0);
    }

    public synchronized void b(org.json.b bVar) throws JSONException {
        a(bVar, false);
    }

    private synchronized void b(org.json.a aVar) {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Internal().c().updateKits(aVar).onKitsLoaded(new q(this));
        }
    }

    public void a(org.json.b bVar, String str, String str2, Long l10) throws JSONException {
        if (bVar != null) {
            a(bVar, bVar.has("eks") ? (org.json.a) bVar.remove("eks") : null, str, str2, l10);
        } else {
            a(bVar, (org.json.a) null, str, str2, l10);
        }
    }

    @NonNull
    public org.json.a e(long j10) {
        try {
            org.json.a aVar = new org.json.a(f(j10).q());
            if (!a(aVar)) {
                return aVar;
            }
            b(aVar, j10);
            return aVar;
        } catch (Exception unused) {
            return new org.json.a();
        }
    }

    public static void d(boolean z10) {
        f22406z = z10;
    }

    public void c(int i10) {
        f22404x.edit().putInt("mp::sessionTimeout", i10).apply();
    }

    public Map<MParticle.IdentityType, String> d(long j10) {
        org.json.a e10 = e(j10);
        HashMap hashMap = new HashMap(e10.o());
        for (int i10 = 0; i10 < e10.o(); i10++) {
            try {
                org.json.b j11 = e10.j(i10);
                hashMap.put(MParticle.IdentityType.parseInt(j11.getInt("n")), j11.getString("i"));
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    public b(Context context) {
        this.f22408b = false;
        this.f22411e = "appdefined";
        this.f22414h = -1;
        this.f22415i = -1;
        this.f22416j = -1;
        this.f22417k = -1;
        this.f22418l = DateUtils.MILLIS_IN_HOUR;
        this.f22420n = null;
        this.f22422p = false;
        this.f22427u = new ArrayList();
        this.f22428v = new ArrayList();
        this.f22407a = context;
        f22404x = c(context);
    }

    /* access modifiers changed from: package-private */
    public void a(org.json.b bVar, org.json.a aVar, String str, String str2, Long l10) throws JSONException {
        if (bVar != null) {
            String aVar2 = aVar != null ? aVar.toString() : null;
            Logger.debug("Updating core config to:\n" + bVar);
            Logger.debug("Updating kit config to:\n" + aVar2);
            f22404x.edit().putString(JsonPacketExtension.ELEMENT, bVar.toString()).putLong("json_timestamp", l10 != null ? l10.longValue() : System.currentTimeMillis()).putString("mp::etag", str).putString("mp::ifmodified", str2).apply();
            B().edit().putString("kit_config", p0.f22631a.a(aVar, this.f22428v).toString()).apply();
            return;
        }
        Logger.debug("clearing current configurations");
        c();
    }

    public void c(String str) {
        f22404x.edit().putString("mp::push_sender_id", str).putBoolean("mp::push_enabled", true).apply();
    }

    public void b(boolean z10) {
        if (z10) {
            e(true);
        }
        if (this.f22421o == null) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof j)) {
                j jVar = new j(defaultUncaughtExceptionHandler);
                this.f22421o = jVar;
                Thread.setDefaultUncaughtExceptionHandler(jVar);
            }
        }
    }

    public static Boolean h(Context context) {
        return Boolean.valueOf(c(context).getBoolean("mp::displaypushnotifications", false));
    }

    public void f(boolean z10) {
        f22404x.edit().putBoolean("mp::optout::", z10).apply();
    }

    static SharedPreferences c(Context context) {
        return context.getSharedPreferences("mp_preferences", 0);
    }

    private synchronized void c(org.json.b bVar) {
        this.f22413g = bVar;
    }

    public static int f(Context context) {
        return c(context).getInt("mp::push::title", 0);
    }

    public long c(boolean z10) {
        if (!z10 || !f22406z) {
            return f22404x.getLong("mp::mpid::identity", h.f22319b.longValue());
        }
        return h.f22319b.longValue();
    }

    public void b(String str) {
        f22404x.edit().putString("mp::push_reg_id", str).apply();
    }

    public void b(PushRegistrationHelper.PushRegistration pushRegistration) {
        String K = K();
        if (K == null) {
            K = "";
        }
        f22404x.edit().putString("mp::push_reg_id_bckgrnd", K).apply();
        a(pushRegistration);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.b c(long r8) {
        /*
            r7 = this;
            org.json.b r0 = r7.f22423q
            if (r0 != 0) goto L_0x00b6
            com.mparticle.internal.p r0 = r7.f((long) r8)
            java.lang.String r0 = r0.d()
            boolean r1 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r0)
            if (r1 == 0) goto L_0x0029
            org.json.b r0 = new org.json.b
            r0.<init>()
            r7.f22423q = r0
            com.mparticle.internal.p r8 = r7.f((long) r8)
            org.json.b r9 = r7.f22423q
            java.lang.String r9 = r9.toString()
            r8.b((java.lang.String) r9)
            org.json.b r8 = r7.f22423q
            return r8
        L_0x0029:
            org.json.b r1 = new org.json.b     // Catch:{ JSONException -> 0x0031 }
            r1.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0031 }
            r7.f22423q = r1     // Catch:{ JSONException -> 0x0031 }
            goto L_0x0038
        L_0x0031:
            org.json.b r0 = new org.json.b
            r0.<init>()
            r7.f22423q = r0
        L_0x0038:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r1 = 1
            r2 = 1990(0x7c6, float:2.789E-42)
            r0.set(r1, r2)
            java.util.Date r0 = r0.getTime()
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy"
            r1.<init>(r2)
            org.json.b r2 = r7.f22423q
            java.util.Iterator r2 = r2.keys()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x0058:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r2.next()     // Catch:{  }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{  }
            org.json.b r5 = r7.f22423q     // Catch:{  }
            java.lang.Object r5 = r5.get(r4)     // Catch:{  }
            boolean r5 = r5 instanceof org.json.b     // Catch:{  }
            if (r5 == 0) goto L_0x0058
            org.json.b r5 = r7.f22423q     // Catch:{  }
            java.lang.Object r5 = r5.get(r4)     // Catch:{  }
            org.json.b r5 = (org.json.b) r5     // Catch:{  }
            java.lang.String r6 = "e"
            java.lang.String r5 = r5.getString(r6)     // Catch:{  }
            java.util.Date r5 = r1.parse(r5)     // Catch:{ JSONException -> 0x0058 }
            boolean r5 = r5.before(r0)     // Catch:{ JSONException -> 0x0058 }
            if (r5 == 0) goto L_0x0058
            r3.add(r4)     // Catch:{ JSONException -> 0x0058 }
            goto L_0x0058
        L_0x008a:
            java.util.Iterator r0 = r3.iterator()
        L_0x008e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a0
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            org.json.b r2 = r7.f22423q
            r2.remove(r1)
            goto L_0x008e
        L_0x00a0:
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x00b3
            com.mparticle.internal.p r8 = r7.f((long) r8)
            org.json.b r9 = r7.f22423q
            java.lang.String r9 = r9.toString()
            r8.b((java.lang.String) r9)
        L_0x00b3:
            org.json.b r8 = r7.f22423q
            return r8
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.b.c(long):org.json.b");
    }

    public static int b(Context context, long j10) {
        return c(context, j10).c();
    }

    public b(@NonNull MParticleOptions mParticleOptions) {
        this(mParticleOptions.getContext(), mParticleOptions.getEnvironment(), mParticleOptions.getApiKey(), mParticleOptions.getApiSecret(), mParticleOptions.getDataplanOptions(), mParticleOptions.getDataplanId(), mParticleOptions.getDataplanVersion(), mParticleOptions.getConfigMaxAge(), mParticleOptions.getConfigurationsForTarget(b.class), mParticleOptions.getSideloadedKits());
    }

    public static void b(Context context, boolean z10) {
        p.a(context, z10);
    }

    public b(@NonNull Context context, MParticle.Environment environment, String str, String str2, MParticleOptions.DataplanOptions dataplanOptions, String str3, Integer num, Integer num2, List<Configuration<b>> list, List<SideloadedKit> list2) {
        boolean z10 = false;
        this.f22408b = false;
        this.f22411e = "appdefined";
        this.f22414h = -1;
        this.f22415i = -1;
        this.f22416j = -1;
        this.f22417k = -1;
        this.f22418l = DateUtils.MILLIS_IN_HOUR;
        this.f22420n = null;
        this.f22422p = false;
        this.f22427u = new ArrayList();
        this.f22428v = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.f22407a = applicationContext;
        f22404x = c(applicationContext);
        if (!(str == null && str2 == null)) {
            a(str, str2);
        }
        if (environment != null) {
            a(environment);
        }
        this.f22410d = p.a(this.f22407a, E());
        this.f22408b = dataplanOptions != null ? true : z10;
        this.f22409c = dataplanOptions;
        this.f22425s = num;
        this.f22424r = str3;
        this.f22426t = num2;
        if (list2 != null) {
            this.f22428v = list2;
        } else {
            this.f22428v = new ArrayList();
        }
        if (list != null) {
            for (Configuration<b> apply : list) {
                apply.apply(this);
            }
        }
    }

    public static long b(Context context) {
        return a(context, false);
    }

    public synchronized void a(org.json.b bVar, String str, String str2) throws JSONException {
        if (bVar == null) {
            bVar = new org.json.b();
        }
        org.json.a aVar = bVar.has("eks") ? (org.json.a) bVar.remove("eks") : null;
        a(bVar, aVar, str, str2, Long.valueOf(System.currentTimeMillis()));
        a(bVar, true);
        b(aVar);
    }

    public void b(org.json.a aVar, long j10) {
        f(j10).g(aVar.toString());
    }

    public void b(int i10) {
        if (i10 >= 1) {
            f22404x.edit().putInt("mp::connection:timeout:identity", i10).apply();
        }
    }

    private void b(long j10, long j11) {
        if (!MPUtility.isEmpty((Collection) A)) {
            Iterator it = new ArrayList(A).iterator();
            while (it.hasNext()) {
                IdentityApi.j jVar = (IdentityApi.j) it.next();
                if (jVar != null) {
                    jVar.a(j10, j11);
                }
            }
        }
    }

    private synchronized void a(org.json.b bVar, boolean z10) throws JSONException {
        SharedPreferences.Editor edit = f22404x.edit();
        if (bVar.has("cue")) {
            this.f22411e = bVar.getString("cue");
        }
        if (bVar.has("pmk") && z10) {
            org.json.a jSONArray = bVar.getJSONArray("pmk");
            f22405y = jSONArray;
            edit.putString("pmk", jSONArray.toString());
        }
        this.f22414h = bVar.optInt("rp", -1);
        if (bVar.has("oo")) {
            this.f22412f = bVar.getBoolean("oo");
        } else {
            this.f22412f = false;
        }
        if (bVar.has("cms")) {
            c((org.json.b) new l(bVar, this.f22407a));
        } else {
            c((org.json.b) null);
        }
        this.f22416j = bVar.optInt("stl", -1);
        this.f22417k = bVar.optInt("uitl", -1);
        this.f22419m = null;
        this.f22420n = null;
        if (bVar.has("tri")) {
            try {
                org.json.b jSONObject = bVar.getJSONObject("tri");
                if (jSONObject.has("mm")) {
                    this.f22419m = jSONObject.getJSONArray("mm");
                }
                if (jSONObject.has("evts")) {
                    this.f22420n = jSONObject.getJSONArray("evts");
                }
            } catch (JSONException unused) {
            }
        }
        if (bVar.has("pio")) {
            this.f22418l = bVar.getLong("pio") * 60 * 1000;
        } else {
            this.f22418l = 1800000;
        }
        this.f22422p = bVar.optBoolean("inhd", true);
        if (bVar.has("dpmd")) {
            j.f22487m = bVar.optBoolean("dpmd", false);
        }
        if (bVar.has("wst")) {
            edit.putString("wst", bVar.getString("wst"));
        } else {
            edit.remove("wst");
        }
        if (bVar.has("alias_max_window")) {
            edit.putInt("alias_max_window", bVar.getInt("alias_max_window"));
        } else {
            edit.remove("alias_max_window");
        }
        if (!this.f22408b) {
            this.f22409c = a(bVar);
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                instance.Internal().c().updateDataplan(this.f22409c);
            }
        }
        edit.apply();
        a();
        a(c.CORE, Boolean.valueOf(z10));
    }

    public ConsentState b(long j10) {
        return ConsentState.withConsentState(f(j10).p()).build();
    }

    private void a() {
        if (D()) {
            b(false);
        } else {
            a(false);
        }
    }

    public void a(boolean z10) {
        if (z10) {
            e(false);
        }
        if (this.f22421o != null && (Thread.getDefaultUncaughtExceptionHandler() instanceof j)) {
            Thread.setDefaultUncaughtExceptionHandler(this.f22421o.a());
            this.f22421o = null;
        }
    }

    public void a(String str, String str2) {
        f22404x.edit().putString("mp::config::apikey", str).putString("mp::config::apisecret", str2).apply();
    }

    public void a(MParticle.Environment environment) {
        if (environment != null) {
            f22404x.edit().putInt("mp::environment", environment.getValue()).apply();
        } else {
            f22404x.edit().remove("mp::environment").apply();
        }
    }

    public void a(PushRegistrationHelper.PushRegistration pushRegistration) {
        if (pushRegistration == null || MPUtility.isEmpty((CharSequence) pushRegistration.senderId)) {
            d();
            return;
        }
        c(pushRegistration.senderId);
        b(pushRegistration.instanceId);
    }

    public void a(Boolean bool) {
        f22404x.edit().putBoolean("mp::displaypushnotifications", bool.booleanValue()).apply();
    }

    public void a(long j10, boolean z10) {
        boolean z11;
        long E = E();
        p T = T();
        if (T != null) {
            T.b(Long.valueOf(System.currentTimeMillis()));
            z11 = T.F();
        } else {
            z11 = false;
        }
        p a10 = p.a(this.f22407a, j10);
        a10.a(z10);
        f22404x.edit().putLong("mp::mpid::identity", j10).apply();
        p pVar = this.f22410d;
        if (pVar == null || pVar.m() != j10) {
            this.f22410d = a10;
            a10.a(Long.valueOf(System.currentTimeMillis()));
        }
        if (E != j10 || z11 != z10) {
            b(j10, E);
        }
    }

    public static long a(Context context, boolean z10) {
        if (f22404x == null) {
            f22404x = context.getSharedPreferences("mp_preferences", 0);
        }
        if (!z10 || !f22406z) {
            return f22404x.getLong("mp::mpid::identity", h.f22319b.longValue());
        }
        return h.f22319b.longValue();
    }

    public void a(long j10, long j11) {
        f(j11).a(f(j10));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:36|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (r14.getBoolean(r8) != r6.getBoolean(r8)) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0097, code lost:
        if (r14.getDouble(r8) != r6.getDouble(r8)) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
        r4 = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059 A[SYNTHETIC, Splitter:B:24:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00aa A[SYNTHETIC, Splitter:B:49:0x00aa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.mparticle.c r14) {
        /*
            r13 = this;
            org.json.a r0 = r13.Q()
            org.json.a r1 = r13.P()
            r2 = 0
            r3 = 1
            java.lang.String r4 = r14.a()     // Catch:{ JSONException -> 0x0026 }
            java.lang.String r5 = "ast"
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x0026 }
            if (r4 == 0) goto L_0x0026
            java.lang.String r4 = "t"
            java.lang.Object r4 = r14.get(r4)     // Catch:{ JSONException -> 0x0026 }
            java.lang.String r5 = "app_back"
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x0026 }
            if (r4 == 0) goto L_0x0026
            r4 = r3
            goto L_0x0027
        L_0x0026:
            r4 = r2
        L_0x0027:
            java.lang.String r5 = r14.a()
            java.lang.String r6 = "pm"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0044
            java.lang.String r5 = r14.a()
            java.lang.String r6 = "cm"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0044
            if (r4 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r4 = r2
            goto L_0x0045
        L_0x0044:
            r4 = r3
        L_0x0045:
            if (r4 != 0) goto L_0x00a0
            if (r0 == 0) goto L_0x00a0
            int r5 = r0.o()
            if (r5 <= 0) goto L_0x00a0
            r5 = r2
            r4 = r3
        L_0x0051:
            if (r4 == 0) goto L_0x00a0
            int r6 = r0.o()
            if (r5 >= r6) goto L_0x00a0
            org.json.b r6 = r0.j(r5)     // Catch:{ Exception -> 0x009d }
            java.util.Iterator r7 = r6.keys()     // Catch:{ Exception -> 0x009d }
        L_0x0061:
            if (r4 == 0) goto L_0x009d
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x009d }
            if (r8 == 0) goto L_0x009d
            java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x009d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x009d }
            boolean r4 = r14.has(r8)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x0061
            java.lang.String r9 = r6.getString(r8)     // Catch:{ JSONException -> 0x0082 }
            java.lang.String r10 = r14.getString(r8)     // Catch:{ JSONException -> 0x0082 }
            boolean r4 = r9.equalsIgnoreCase(r10)     // Catch:{ JSONException -> 0x0082 }
            goto L_0x0061
        L_0x0082:
            boolean r9 = r14.getBoolean(r8)     // Catch:{ JSONException -> 0x008d }
            boolean r4 = r6.getBoolean(r8)     // Catch:{ JSONException -> 0x008d }
            if (r9 != r4) goto L_0x009b
            goto L_0x0099
        L_0x008d:
            double r9 = r14.getDouble(r8)     // Catch:{ JSONException -> 0x009b }
            double r11 = r6.getDouble(r8)     // Catch:{ JSONException -> 0x009b }
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x009b
        L_0x0099:
            r4 = r3
            goto L_0x0061
        L_0x009b:
            r4 = r2
            goto L_0x0061
        L_0x009d:
            int r5 = r5 + 1
            goto L_0x0051
        L_0x00a0:
            if (r4 != 0) goto L_0x00b8
            if (r1 == 0) goto L_0x00b8
        L_0x00a4:
            int r0 = r1.o()
            if (r2 >= r0) goto L_0x00b8
            int r0 = r1.getInt(r2)     // Catch:{ JSONException -> 0x00b5 }
            int r5 = r14.e()     // Catch:{ JSONException -> 0x00b5 }
            if (r0 != r5) goto L_0x00b5
            goto L_0x00b9
        L_0x00b5:
            int r2 = r2 + 1
            goto L_0x00a4
        L_0x00b8:
            r3 = r4
        L_0x00b9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.b.a(com.mparticle.c):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036 A[Catch:{ JSONException -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[SYNTHETIC, Splitter:B:15:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ JSONException -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r3 = this;
            if (r5 == 0) goto L_0x002f
            boolean r0 = r5.isEmpty()     // Catch:{ JSONException -> 0x0069 }
            if (r0 != 0) goto L_0x002f
            org.json.b r0 = new org.json.b     // Catch:{ JSONException -> 0x0069 }
            r0.<init>()     // Catch:{ JSONException -> 0x0069 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ JSONException -> 0x0069 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ JSONException -> 0x0069 }
        L_0x0015:
            boolean r1 = r5.hasNext()     // Catch:{ JSONException -> 0x0069 }
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r5.next()     // Catch:{ JSONException -> 0x0069 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ JSONException -> 0x0069 }
            java.lang.Object r2 = r1.getKey()     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0069 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ JSONException -> 0x0069 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x0069 }
            goto L_0x0015
        L_0x002f:
            r0 = 0
        L_0x0030:
            org.json.b r5 = r3.A()     // Catch:{ JSONException -> 0x0069 }
            if (r5 != 0) goto L_0x003b
            org.json.b r5 = new org.json.b     // Catch:{ JSONException -> 0x0069 }
            r5.<init>()     // Catch:{ JSONException -> 0x0069 }
        L_0x003b:
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ JSONException -> 0x0069 }
            r5.put((java.lang.String) r4, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x0069 }
            int r4 = r5.length()     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r0 = "mp::integrationattributes"
            if (r4 <= 0) goto L_0x005c
            android.content.SharedPreferences r4 = f22404x     // Catch:{ JSONException -> 0x0069 }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x0069 }
            android.content.SharedPreferences$Editor r4 = r4.putString(r0, r5)     // Catch:{ JSONException -> 0x0069 }
            r4.apply()     // Catch:{ JSONException -> 0x0069 }
            goto L_0x0069
        L_0x005c:
            android.content.SharedPreferences r4 = f22404x     // Catch:{ JSONException -> 0x0069 }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ JSONException -> 0x0069 }
            android.content.SharedPreferences$Editor r4 = r4.remove(r0)     // Catch:{ JSONException -> 0x0069 }
            r4.apply()     // Catch:{ JSONException -> 0x0069 }
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.b.a(int, java.util.Map):void");
    }

    @NonNull
    public Map<String, String> a(int i10) {
        org.json.b optJSONObject;
        HashMap hashMap = new HashMap();
        org.json.b A2 = A();
        if (!(A2 == null || (optJSONObject = A2.optJSONObject(Integer.toString(i10))) == null)) {
            try {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (optJSONObject.get(next) instanceof String) {
                        hashMap.put(next, optJSONObject.getString(next));
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    private static boolean a(org.json.a aVar) {
        int i10 = 0;
        boolean z10 = false;
        while (i10 < aVar.o()) {
            try {
                org.json.b j10 = aVar.j(i10);
                if (!j10.has("dfs")) {
                    j10.put("dfs", 0);
                    z10 = true;
                }
                if (!j10.has(NetworkProfile.FEMALE)) {
                    j10.put(NetworkProfile.FEMALE, true);
                    z10 = true;
                }
                i10++;
            } catch (JSONException unused) {
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public org.json.a a(org.json.a aVar, long j10) {
        try {
            org.json.a e10 = e(j10);
            if (e10.o() == 0) {
                return null;
            }
            org.json.a aVar2 = new org.json.a(aVar.toString());
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < aVar2.o(); i10++) {
                if (aVar2.j(i10).optBoolean(NetworkProfile.FEMALE)) {
                    hashSet.add(Integer.valueOf(aVar2.j(i10).getInt("n")));
                }
            }
            if (hashSet.size() > 0) {
                for (int i11 = 0; i11 < e10.o(); i11++) {
                    if (hashSet.contains(Integer.valueOf(e10.j(i11).getInt("n")))) {
                        e10.j(i11).put(NetworkProfile.FEMALE, false);
                    }
                }
                return e10;
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    public void a(String str) {
        f22404x.edit().putString("mp::identity::api::context", str).apply();
    }

    public static void a(IdentityApi.j jVar) {
        A.add(jVar);
    }

    public void a(ConsentState consentState, long j10) {
        f(j10).f(consentState != null ? consentState.toString() : null);
    }

    public synchronized void a(NetworkOptions networkOptions) {
        f22403w = networkOptions;
        f22404x.edit().remove("mp::network:options").apply();
    }

    private void a(c cVar, Boolean bool) {
        String[] strArr = new String[1];
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Loading ");
        sb2.append(bool.booleanValue() ? "new " : "cached ");
        sb2.append(cVar.name().toLowerCase(Locale.ROOT));
        sb2.append(" config");
        strArr[0] = sb2.toString();
        Logger.debug(strArr);
        Iterator it = new ArrayList(this.f22427u).iterator();
        while (it.hasNext()) {
            C0259b bVar = (C0259b) it.next();
            if (bVar != null) {
                bVar.a(cVar, bool.booleanValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public MParticleOptions.DataplanOptions a(org.json.b bVar) {
        org.json.b optJSONObject;
        org.json.b optJSONObject2;
        if (bVar == null || (optJSONObject = bVar.optJSONObject("dpr")) == null || (optJSONObject2 = optJSONObject.optJSONObject("dtpn")) == null) {
            return null;
        }
        org.json.b optJSONObject3 = optJSONObject2.optJSONObject("blok");
        org.json.b optJSONObject4 = optJSONObject2.optJSONObject("vers");
        if (optJSONObject3 != null) {
            return MParticleOptions.DataplanOptions.builder().dataplanVersion(optJSONObject4).blockEvents(optJSONObject3.optBoolean("ev", false)).blockEventAttributes(optJSONObject3.optBoolean("ea", false)).blockUserAttributes(optJSONObject3.optBoolean("ua", false)).blockUserIdentities(optJSONObject3.optBoolean("id", false)).build();
        }
        return null;
    }
}
