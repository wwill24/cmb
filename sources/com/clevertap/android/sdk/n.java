package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.db.DBAdapter;
import com.facebook.internal.security.CertificateUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class n {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static long f10654h;

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, Integer> f10655a = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, Object> f10656b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CleverTapInstanceConfig f10657c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f10658d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public DBAdapter f10659e;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f10660f;

    /* renamed from: g  reason: collision with root package name */
    private final String f10661g = "local_events";

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10663b;

        a(Context context, String str) {
            this.f10662a = context;
            this.f10663b = str;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|(5:16|17|(2:19|33)(2:20|(2:22|34)(2:23|35))|32|13)|24|25|26|27|28) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x009d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                com.clevertap.android.sdk.n r0 = com.clevertap.android.sdk.n.this
                com.clevertap.android.sdk.db.DBAdapter r0 = r0.f10659e
                if (r0 != 0) goto L_0x001a
                com.clevertap.android.sdk.n r0 = com.clevertap.android.sdk.n.this
                com.clevertap.android.sdk.db.DBAdapter r1 = new com.clevertap.android.sdk.db.DBAdapter
                android.content.Context r2 = r6.f10662a
                com.clevertap.android.sdk.n r3 = com.clevertap.android.sdk.n.this
                com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r3.f10657c
                r1.<init>((android.content.Context) r2, (com.clevertap.android.sdk.CleverTapInstanceConfig) r3)
                com.clevertap.android.sdk.db.DBAdapter unused = r0.f10659e = r1
            L_0x001a:
                com.clevertap.android.sdk.n r0 = com.clevertap.android.sdk.n.this
                java.util.HashMap r0 = r0.f10656b
                monitor-enter(r0)
                com.clevertap.android.sdk.n r1 = com.clevertap.android.sdk.n.this     // Catch:{ all -> 0x009d }
                com.clevertap.android.sdk.db.DBAdapter r1 = r1.f10659e     // Catch:{ all -> 0x009d }
                java.lang.String r2 = r6.f10663b     // Catch:{ all -> 0x009d }
                org.json.b r1 = r1.B(r2)     // Catch:{ all -> 0x009d }
                if (r1 != 0) goto L_0x0031
                monitor-exit(r0)     // Catch:{ all -> 0x009f }
                return
            L_0x0031:
                java.util.Iterator r2 = r1.keys()     // Catch:{ all -> 0x009d }
            L_0x0035:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x009d }
                if (r3 == 0) goto L_0x0073
                java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x0035 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x0035 }
                java.lang.Object r4 = r1.get(r3)     // Catch:{ JSONException -> 0x0035 }
                boolean r5 = r4 instanceof org.json.b     // Catch:{ JSONException -> 0x0035 }
                if (r5 == 0) goto L_0x0057
                org.json.b r4 = r1.getJSONObject(r3)     // Catch:{ JSONException -> 0x0035 }
                com.clevertap.android.sdk.n r5 = com.clevertap.android.sdk.n.this     // Catch:{ JSONException -> 0x0035 }
                java.util.HashMap r5 = r5.f10656b     // Catch:{ JSONException -> 0x0035 }
                r5.put(r3, r4)     // Catch:{ JSONException -> 0x0035 }
                goto L_0x0035
            L_0x0057:
                boolean r5 = r4 instanceof org.json.a     // Catch:{ JSONException -> 0x0035 }
                if (r5 == 0) goto L_0x0069
                org.json.a r4 = r1.getJSONArray(r3)     // Catch:{ JSONException -> 0x0035 }
                com.clevertap.android.sdk.n r5 = com.clevertap.android.sdk.n.this     // Catch:{ JSONException -> 0x0035 }
                java.util.HashMap r5 = r5.f10656b     // Catch:{ JSONException -> 0x0035 }
                r5.put(r3, r4)     // Catch:{ JSONException -> 0x0035 }
                goto L_0x0035
            L_0x0069:
                com.clevertap.android.sdk.n r5 = com.clevertap.android.sdk.n.this     // Catch:{ JSONException -> 0x0035 }
                java.util.HashMap r5 = r5.f10656b     // Catch:{ JSONException -> 0x0035 }
                r5.put(r3, r4)     // Catch:{ JSONException -> 0x0035 }
                goto L_0x0035
            L_0x0073:
                com.clevertap.android.sdk.n r1 = com.clevertap.android.sdk.n.this     // Catch:{ all -> 0x009d }
                com.clevertap.android.sdk.p r1 = r1.q()     // Catch:{ all -> 0x009d }
                com.clevertap.android.sdk.n r2 = com.clevertap.android.sdk.n.this     // Catch:{ all -> 0x009d }
                java.lang.String r2 = r2.p()     // Catch:{ all -> 0x009d }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009d }
                r3.<init>()     // Catch:{ all -> 0x009d }
                java.lang.String r4 = "Local Data Store - Inflated local profile "
                r3.append(r4)     // Catch:{ all -> 0x009d }
                com.clevertap.android.sdk.n r4 = com.clevertap.android.sdk.n.this     // Catch:{ all -> 0x009d }
                java.util.HashMap r4 = r4.f10656b     // Catch:{ all -> 0x009d }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009d }
                r3.append(r4)     // Catch:{ all -> 0x009d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x009d }
                r1.t(r2, r3)     // Catch:{ all -> 0x009d }
            L_0x009d:
                monitor-exit(r0)     // Catch:{ all -> 0x009f }
                return
            L_0x009f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x009f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.n.a.run():void");
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10665a;

        b(String str) {
            this.f10665a = str;
        }

        public void run() {
            synchronized (n.this.f10656b) {
                long M = n.this.f10659e.M(this.f10665a, new org.json.b((Map<?, ?>) n.this.f10656b));
                p i10 = n.this.q();
                String h10 = n.this.p();
                i10.t(h10, "Persist Local Profile complete with status " + M + " for id " + this.f10665a);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10667a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f10668b;

        c(String str, Runnable runnable) {
            this.f10667a = str;
            this.f10668b = runnable;
        }

        public void run() {
            long unused = n.f10654h = Thread.currentThread().getId();
            try {
                p i10 = n.this.q();
                String h10 = n.this.p();
                i10.t(h10, "Local Data Store Executor service: Starting task - " + this.f10667a);
                this.f10668b.run();
            } catch (Throwable th2) {
                n.this.q().u(n.this.p(), "Executor service: Failed to complete the scheduled task", th2);
            }
        }
    }

    n(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f10658d = context;
        this.f10657c = cleverTapInstanceConfig;
        this.f10660f = Executors.newFixedThreadPool(1);
        y(context);
    }

    @SuppressLint({"CommitPrefEdits"})
    private void A(Context context, org.json.b bVar) {
        String str;
        try {
            String string = bVar.getString("evtName");
            if (string != null) {
                if (!this.f10657c.t()) {
                    str = "local_events:" + this.f10657c.e();
                } else {
                    str = "local_events";
                }
                SharedPreferences h10 = s.h(context, str);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                l4.b n10 = n(string, w(string, o(currentTimeMillis, currentTimeMillis, 0), str));
                String o10 = o(n10.b(), currentTimeMillis, n10.a() + 1);
                SharedPreferences.Editor edit = h10.edit();
                edit.putString(Q(string), o10);
                s.l(edit);
            }
        } catch (Throwable th2) {
            q().u(p(), "Failed to persist event locally", th2);
        }
    }

    private void C() {
        D("LocalDataStore#persistLocalProfileAsync", new b(this.f10657c.e()));
    }

    private void D(String str, Runnable runnable) {
        boolean z10;
        try {
            if (Thread.currentThread().getId() == f10654h) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                runnable.run();
            } else {
                this.f10660f.submit(new c(str, runnable));
            }
        } catch (Throwable th2) {
            q().u(p(), "Failed to submit task to the executor service", th2);
        }
    }

    private boolean E(Object obj) {
        boolean z10;
        boolean z11 = true;
        if (obj == null) {
            return true;
        }
        if (!(obj instanceof String) || ((String) obj).trim().length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!(obj instanceof org.json.a)) {
            return z10;
        }
        if (((org.json.a) obj).o() > 0) {
            z11 = false;
        }
        return z11;
    }

    private Boolean F(Object obj, Object obj2) {
        return Boolean.valueOf(R(obj).equals(R(obj2)));
    }

    private void H(String str, Boolean bool, boolean z10) {
        if (str != null) {
            try {
                b(str);
                if (!bool.booleanValue()) {
                    V(str);
                }
            } catch (Throwable unused) {
            }
            if (z10) {
                C();
            }
        }
    }

    private void I() {
        synchronized (this.f10655a) {
            this.f10655a.clear();
        }
        synchronized (this.f10656b) {
            this.f10656b.clear();
        }
        this.f10659e.I(x());
    }

    private void K(Context context, int i10) {
        s.n(context, Q("local_cache_expires_in"), i10);
    }

    private void M(String str, Object obj, Boolean bool, boolean z10) {
        if (str != null && obj != null) {
            try {
                c(str, obj);
                if (!bool.booleanValue()) {
                    V(str);
                }
            } catch (Throwable unused) {
            }
            if (z10) {
                C();
            }
        }
    }

    private void O(org.json.b bVar, Boolean bool) {
        if (bVar != null) {
            try {
                Iterator<String> keys = bVar.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    M(obj, bVar.get(obj), bool, false);
                }
                C();
            } catch (Throwable th2) {
                q().u(p(), "Failed to set profile fields", th2);
            }
        }
    }

    private Boolean P(String str, int i10) {
        boolean z10;
        if (i10 <= 0) {
            i10 = (int) (System.currentTimeMillis() / 1000);
        }
        Integer u10 = u(str);
        if (u10 == null || u10.intValue() <= i10) {
            z10 = false;
        } else {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    private String Q(String str) {
        return str + CertificateUtil.DELIMITER + this.f10657c.e();
    }

    private String R(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    private org.json.b S(Context context, org.json.b bVar) {
        String str;
        n nVar = this;
        try {
            if (!nVar.f10657c.t()) {
                str = "local_events:" + nVar.f10657c.e();
            } else {
                str = "local_events";
            }
            String str2 = str;
            SharedPreferences h10 = s.h(context, str2);
            Iterator<String> keys = bVar.keys();
            SharedPreferences.Editor edit = h10.edit();
            org.json.b bVar2 = null;
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                l4.b n10 = nVar.n(obj, nVar.w(obj, nVar.o(0, 0, 0), str2));
                org.json.a jSONArray = bVar.getJSONArray(obj);
                if (jSONArray == null || jSONArray.o() < 3) {
                    q().t(p(), "Corrupted upstream event detail");
                } else {
                    try {
                        int i10 = jSONArray.getInt(0);
                        int i11 = jSONArray.getInt(1);
                        int i12 = jSONArray.getInt(2);
                        if (i10 > n10.a()) {
                            edit.putString(nVar.Q(obj), nVar.o(i11, i12, i10));
                            q().t(p(), "Accepted update for event " + obj + " from upstream");
                            if (bVar2 == null) {
                                bVar2 = new org.json.b();
                            }
                            org.json.b bVar3 = new org.json.b();
                            org.json.b bVar4 = new org.json.b();
                            bVar4.put("oldValue", n10.a());
                            bVar4.put("newValue", i10);
                            bVar3.put("count", (Object) bVar4);
                            org.json.b bVar5 = new org.json.b();
                            bVar5.put("oldValue", n10.b());
                            bVar5.put("newValue", jSONArray.getInt(1));
                            bVar3.put("firstTime", (Object) bVar5);
                            org.json.b bVar6 = new org.json.b();
                            bVar6.put("oldValue", n10.c());
                            bVar6.put("newValue", jSONArray.getInt(2));
                            bVar3.put("lastTime", (Object) bVar6);
                            bVar2.put(obj, (Object) bVar3);
                        } else {
                            q().t(p(), "Rejected update for event " + obj + " from upstream");
                        }
                    } catch (Throwable unused) {
                        q().t(p(), "Failed to parse upstream event message: " + jSONArray.toString());
                    }
                }
                nVar = this;
            }
            s.l(edit);
            return bVar2;
        } catch (Throwable th2) {
            q().u(p(), "Couldn't sync events from upstream", th2);
            return null;
        }
    }

    private org.json.b T(org.json.b bVar) {
        org.json.b bVar2 = new org.json.b();
        if (bVar == null || bVar.length() <= 0) {
            return bVar2;
        }
        try {
            org.json.b bVar3 = new org.json.b();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                try {
                    String obj = keys.next().toString();
                    if (P(obj, currentTimeMillis).booleanValue()) {
                        q().t(p(), "Rejecting upstream value for key " + obj + " because our local cache prohibits it");
                    } else {
                        Object v10 = v(obj);
                        Object obj2 = bVar.get(obj);
                        if (E(obj2)) {
                            obj2 = null;
                        }
                        if (!F(obj2, v10).booleanValue()) {
                            if (obj2 != null) {
                                bVar3.put(obj, obj2);
                            } else {
                                H(obj, Boolean.TRUE, true);
                            }
                            org.json.b k10 = k(v10, obj2);
                            if (k10 != null) {
                                bVar2.put(obj, (Object) k10);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    q().u(p(), "Failed to update profile field", th2);
                }
            }
            if (bVar3.length() > 0) {
                O(bVar3, Boolean.TRUE);
            }
            return bVar2;
        } catch (Throwable th3) {
            q().u(p(), "Failed to sync remote profile", th3);
            return null;
        }
    }

    private void V(String str) {
        if (str != null) {
            synchronized (this.f10655a) {
                this.f10655a.put(str, Integer.valueOf(l()));
            }
        }
    }

    private Object a(String str) {
        Object obj;
        if (str == null) {
            return null;
        }
        synchronized (this.f10656b) {
            try {
                obj = this.f10656b.get(str);
            } catch (Throwable th2) {
                q().u(p(), "Failed to retrieve local profile property", th2);
                return null;
            }
        }
        return obj;
    }

    private void b(String str) {
        if (str != null) {
            synchronized (this.f10656b) {
                try {
                    this.f10656b.remove(str);
                } catch (Throwable th2) {
                    p q10 = q();
                    String p10 = p();
                    q10.u(p10, "Failed to remove local profile value for key " + str, th2);
                }
            }
        }
    }

    private void c(String str, Object obj) {
        if (str != null && obj != null) {
            synchronized (this.f10656b) {
                this.f10656b.put(str, obj);
            }
        }
    }

    private org.json.b k(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        org.json.b bVar = new org.json.b();
        if (obj2 == null) {
            try {
                obj2 = -1;
            } catch (Throwable th2) {
                q().u(p(), "Failed to create profile changed values object", th2);
                return null;
            }
        }
        bVar.put("newValue", obj2);
        if (obj != null) {
            bVar.put("oldValue", obj);
        }
        return bVar;
    }

    private int l() {
        return ((int) (System.currentTimeMillis() / 1000)) + t(0);
    }

    private l4.b n(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String[] split = str2.split("\\|");
        return new l4.b(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), str);
    }

    private String o(int i10, int i11, int i12) {
        return i12 + "|" + i10 + "|" + i11;
    }

    /* access modifiers changed from: private */
    public String p() {
        return this.f10657c.e();
    }

    /* access modifiers changed from: private */
    public p q() {
        return this.f10657c.n();
    }

    private int s(String str, int i10) {
        if (!this.f10657c.t()) {
            return s.c(this.f10658d, Q(str), i10);
        }
        int c10 = s.c(this.f10658d, Q(str), -1000);
        if (c10 != -1000) {
            return c10;
        }
        return s.c(this.f10658d, str, i10);
    }

    private int t(int i10) {
        return s("local_cache_expires_in", i10);
    }

    private Integer u(String str) {
        Integer num;
        if (str == null) {
            return 0;
        }
        synchronized (this.f10655a) {
            num = this.f10655a.get(str);
        }
        return num;
    }

    private String w(String str, String str2, String str3) {
        if (!this.f10657c.t()) {
            return s.j(this.f10658d, str3, Q(str), str2);
        }
        String j10 = s.j(this.f10658d, str3, Q(str), str2);
        if (j10 != null) {
            return j10;
        }
        return s.j(this.f10658d, str3, str, str2);
    }

    private String x() {
        return this.f10657c.e();
    }

    private void y(Context context) {
        D("LocalDataStore#inflateLocalProfileAsync", new a(context, this.f10657c.e()));
    }

    private boolean z() {
        return this.f10657c.w();
    }

    public void B(Context context, org.json.b bVar, int i10) {
        if (bVar != null && i10 == 4) {
            try {
                A(context, bVar);
            } catch (Throwable th2) {
                q().u(p(), "Failed to sync with upstream", th2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void G(String str) {
        H(str, Boolean.FALSE, true);
    }

    public void J(org.json.b bVar) {
        try {
            if (!this.f10657c.w()) {
                bVar.put("dsync", false);
                return;
            }
            String string = bVar.getString("type");
            if ("event".equals(string) && "App Launched".equals(bVar.getString("evtName"))) {
                q().t(p(), "Local cache needs to be updated (triggered by App Launched)");
                bVar.put("dsync", true);
            } else if ("profile".equals(string)) {
                bVar.put("dsync", true);
                q().t(p(), "Local cache needs to be updated (profile event)");
            } else {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (s("local_cache_last_update", currentTimeMillis) + t(1200) < currentTimeMillis) {
                    bVar.put("dsync", true);
                    q().t(p(), "Local cache needs to be updated");
                    return;
                }
                bVar.put("dsync", false);
                q().t(p(), "Local cache doesn't need to be updated");
            }
        } catch (Throwable th2) {
            q().u(p(), "Failed to sync with upstream", th2);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(String str, Object obj) {
        M(str, obj, Boolean.FALSE, true);
    }

    /* access modifiers changed from: package-private */
    public void N(org.json.b bVar) {
        O(bVar, Boolean.FALSE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r8 = r6.get(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r8 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U(android.content.Context r11, org.json.b r12) {
        /*
            r10 = this;
            java.lang.String r0 = "expires_in"
            java.lang.String r1 = "evpr"
            java.lang.String r2 = "_custom"
            java.lang.String r3 = "events"
            java.lang.String r4 = "profile"
            boolean r5 = r12.has(r1)     // Catch:{ all -> 0x00e6 }
            if (r5 != 0) goto L_0x0011
            return
        L_0x0011:
            org.json.b r12 = r12.getJSONObject(r1)     // Catch:{ all -> 0x00e6 }
            boolean r1 = r12.has(r4)     // Catch:{ all -> 0x00e6 }
            r5 = 0
            if (r1 == 0) goto L_0x0055
            org.json.b r1 = r12.getJSONObject(r4)     // Catch:{ all -> 0x00e6 }
            boolean r6 = r1.has(r2)     // Catch:{ all -> 0x00e6 }
            if (r6 == 0) goto L_0x0050
            org.json.b r6 = r1.getJSONObject(r2)     // Catch:{ all -> 0x00e6 }
            r1.remove(r2)     // Catch:{ all -> 0x00e6 }
            java.util.Iterator r2 = r6.keys()     // Catch:{ all -> 0x00e6 }
        L_0x0031:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x00e6 }
            if (r7 == 0) goto L_0x0050
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x00e6 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e6 }
            org.json.a r8 = r6.getJSONArray(r7)     // Catch:{ all -> 0x0044 }
            goto L_0x004a
        L_0x0044:
            java.lang.Object r8 = r6.get(r7)     // Catch:{ JSONException -> 0x0049 }
            goto L_0x004a
        L_0x0049:
            r8 = r5
        L_0x004a:
            if (r8 == 0) goto L_0x0031
            r1.put((java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x00e6 }
            goto L_0x0031
        L_0x0050:
            org.json.b r1 = r10.T(r1)     // Catch:{ all -> 0x00e6 }
            goto L_0x0056
        L_0x0055:
            r1 = r5
        L_0x0056:
            boolean r2 = r12.has(r3)     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x0065
            org.json.b r2 = r12.getJSONObject(r3)     // Catch:{ all -> 0x00e6 }
            org.json.b r2 = r10.S(r11, r2)     // Catch:{ all -> 0x00e6 }
            goto L_0x0066
        L_0x0065:
            r2 = r5
        L_0x0066:
            boolean r6 = r12.has(r0)     // Catch:{ all -> 0x00e6 }
            if (r6 == 0) goto L_0x0073
            int r12 = r12.getInt(r0)     // Catch:{ all -> 0x00e6 }
            r10.K(r11, r12)     // Catch:{ all -> 0x00e6 }
        L_0x0073:
            java.lang.String r12 = "local_cache_last_update"
            java.lang.String r12 = r10.Q(r12)     // Catch:{ all -> 0x00e6 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e6 }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            int r0 = (int) r6     // Catch:{ all -> 0x00e6 }
            com.clevertap.android.sdk.s.n(r11, r12, r0)     // Catch:{ all -> 0x00e6 }
            r12 = 1
            r0 = 0
            if (r1 == 0) goto L_0x0090
            int r6 = r1.length()     // Catch:{ all -> 0x00e6 }
            if (r6 <= 0) goto L_0x0090
            r6 = r12
            goto L_0x0091
        L_0x0090:
            r6 = r0
        L_0x0091:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x009e
            int r7 = r2.length()     // Catch:{ all -> 0x00e6 }
            if (r7 <= 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r12 = r0
        L_0x009f:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x00e6 }
            boolean r0 = r6.booleanValue()     // Catch:{ all -> 0x00e6 }
            if (r0 != 0) goto L_0x00af
            boolean r0 = r12.booleanValue()     // Catch:{ all -> 0x00e6 }
            if (r0 == 0) goto L_0x00f4
        L_0x00af:
            org.json.b r0 = new org.json.b     // Catch:{ all -> 0x00e6 }
            r0.<init>()     // Catch:{ all -> 0x00e6 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00e6 }
            if (r6 == 0) goto L_0x00bd
            r0.put((java.lang.String) r4, (java.lang.Object) r1)     // Catch:{ all -> 0x00e6 }
        L_0x00bd:
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x00e6 }
            if (r12 == 0) goto L_0x00c6
            r0.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x00e6 }
        L_0x00c6:
            com.clevertap.android.sdk.CleverTapAPI r11 = com.clevertap.android.sdk.CleverTapAPI.v(r11)     // Catch:{ all -> 0x00d1 }
            if (r11 == 0) goto L_0x00d1
            i4.w r11 = r11.D()     // Catch:{ all -> 0x00d1 }
            r5 = r11
        L_0x00d1:
            if (r5 == 0) goto L_0x00f4
            r5.a(r0)     // Catch:{ all -> 0x00d7 }
            goto L_0x00f4
        L_0x00d7:
            r11 = move-exception
            com.clevertap.android.sdk.p r12 = r10.q()     // Catch:{ all -> 0x00e6 }
            java.lang.String r0 = r10.p()     // Catch:{ all -> 0x00e6 }
            java.lang.String r1 = "Execution of sync listener failed"
            r12.u(r0, r1, r11)     // Catch:{ all -> 0x00e6 }
            goto L_0x00f4
        L_0x00e6:
            r11 = move-exception
            com.clevertap.android.sdk.p r12 = r10.q()
            java.lang.String r0 = r10.p()
            java.lang.String r1 = "Failed to sync with upstream"
            r12.u(r0, r1, r11)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.n.U(android.content.Context, org.json.b):void");
    }

    public void m() {
        I();
    }

    /* access modifiers changed from: package-private */
    public l4.b r(String str) {
        String str2;
        try {
            if (!z()) {
                return null;
            }
            if (!this.f10657c.t()) {
                str2 = "local_events:" + this.f10657c.e();
            } else {
                str2 = "local_events";
            }
            return n(str, w(str, (String) null, str2));
        } catch (Throwable th2) {
            q().u(p(), "Failed to retrieve local event detail", th2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Object v(String str) {
        return a(str);
    }
}
