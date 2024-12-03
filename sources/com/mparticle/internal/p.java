package com.mparticle.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONException;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private long f22574a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f22575b;

    /* renamed from: c  reason: collision with root package name */
    private Context f22576c;

    /* renamed from: d  reason: collision with root package name */
    SharedPreferences f22577d;

    private p(Context context, long j10) {
        this.f22576c = context;
        this.f22574a = j10;
        this.f22575b = c(j10);
        if (a.a(context)) {
            a.a(context, false);
            new a(context).a(this);
        }
        this.f22577d = this.f22576c.getSharedPreferences("mParticlePrefs", 0);
        G();
    }

    private boolean A() {
        return this.f22575b.contains("mp::session::previous_id");
    }

    private boolean B() {
        return this.f22575b.contains("mp::session::previous_start");
    }

    private boolean C() {
        return this.f22575b.contains("mp::totalruns");
    }

    private boolean D() {
        return this.f22575b.contains("mp::user_ids::");
    }

    private void G() {
        SharedPreferences b10 = b(this.f22576c);
        if (!b10.contains("mp::default_seen_time")) {
            b10.edit().putLong("mp::default_seen_time", System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public void d(int i10) {
        this.f22575b.edit().putInt("mp::breadcrumbs::sessioncount", i10).apply();
    }

    private boolean r() {
        return this.f22575b.contains("mp::breadcrumbs::limit");
    }

    private boolean s() {
        return this.f22575b.contains("mp::consent_state::");
    }

    private boolean t() {
        return this.f22575b.contains("mp::cookies");
    }

    private boolean u() {
        return this.f22575b.contains("mp::breadcrumbs::sessioncount");
    }

    private boolean v() {
        return this.f22575b.contains("mp::deleted_user_attrs::");
    }

    private boolean w() {
        return this.f22575b.contains("mp::lastusedate");
    }

    private boolean x() {
        return this.f22575b.contains("mp::launch_since_upgrade");
    }

    private boolean y() {
        return this.f22575b.contains("mp::ltv");
    }

    private boolean z() {
        return this.f22575b.contains("mp::time_in_fg");
    }

    /* access modifiers changed from: package-private */
    public void E() {
        int e10 = e() + 1;
        if (e10 >= 21474836) {
            e10 = 0;
        }
        this.f22575b.edit().putInt("mp::breadcrumbs::sessioncount", e10).apply();
    }

    public boolean F() {
        return this.f22575b.getBoolean("mp::known_user", false);
    }

    /* access modifiers changed from: package-private */
    public boolean b(Context context, long j10) {
        context.deleteSharedPreferences(a(j10));
        return c(context, j10);
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        this.f22575b.edit().putString("mp::deleted_user_attrs::", str).apply();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return a(0);
    }

    /* access modifiers changed from: package-private */
    public void f(long j10) {
        this.f22575b.edit().putLong("mp::lastusedate", j10).apply();
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.f22575b.getString("mp::deleted_user_attrs::", (String) null);
    }

    /* access modifiers changed from: package-private */
    public void h(long j10) {
        this.f22575b.edit().putLong("mp::session::previous_start", j10).apply();
    }

    public long i() {
        if (!this.f22575b.contains("mp::last_seen")) {
            this.f22575b.edit().putLong("mp::last_seen", f().longValue()).apply();
        }
        return this.f22575b.getLong("mp::last_seen", f().longValue());
    }

    /* access modifiers changed from: package-private */
    public long j() {
        return b(0);
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f22575b.getInt("mp::launch_since_upgrade", 0);
    }

    /* access modifiers changed from: package-private */
    public String l() {
        return this.f22575b.getString("mp::ltv", "0");
    }

    /* access modifiers changed from: package-private */
    public long m() {
        return this.f22574a;
    }

    /* access modifiers changed from: package-private */
    public long n() {
        return d(-1);
    }

    /* access modifiers changed from: package-private */
    public String o() {
        return a("");
    }

    /* access modifiers changed from: package-private */
    public String p() {
        return this.f22575b.getString("mp::consent_state::", (String) null);
    }

    /* access modifiers changed from: package-private */
    public String q() {
        return this.f22575b.getString("mp::user_ids::", "");
    }

    /* access modifiers changed from: package-private */
    public int c() {
        SharedPreferences sharedPreferences = this.f22575b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("mp::breadcrumbs::limit", 50);
        }
        return 50;
    }

    /* access modifiers changed from: package-private */
    public long d(long j10) {
        return this.f22575b.getLong("mp::time_in_fg", j10);
    }

    /* access modifiers changed from: package-private */
    public void e(String str) {
        this.f22575b.edit().putString("mp::session::previous_id", str).apply();
    }

    /* access modifiers changed from: package-private */
    public void f(int i10) {
        this.f22575b.edit().putInt("mp::totalruns", i10).apply();
    }

    /* access modifiers changed from: package-private */
    public void g(long j10) {
        this.f22575b.edit().putLong("mp::time_in_fg", j10).apply();
    }

    public long h() {
        if (!this.f22575b.contains("mp::first_seen")) {
            this.f22575b.edit().putLong("mp::first_seen", this.f22577d.getLong("mp::ict", f().longValue())).apply();
        }
        return this.f22575b.getLong("mp::first_seen", f().longValue());
    }

    static p a(Context context, long j10) {
        return new p(context, j10);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f22575b.edit().putString("mp::deleted_user_attrs::", (String) null).apply();
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        this.f22575b.edit().putString("mp::ltv", str).apply();
    }

    /* access modifiers changed from: package-private */
    public long e(long j10) {
        return this.f22575b.getLong("mp::session::previous_start", j10);
    }

    /* access modifiers changed from: package-private */
    public void f(String str) {
        this.f22575b.edit().putString("mp::consent_state::", str).apply();
    }

    /* access modifiers changed from: package-private */
    public void g(String str) {
        this.f22575b.edit().putString("mp::user_ids::", str).apply();
    }

    public static void a(Context context, boolean z10) {
        a.a(context, z10);
    }

    private Long f() {
        return Long.valueOf(b(this.f22576c).getLong("mp::default_seen_time", System.currentTimeMillis()));
    }

    /* access modifiers changed from: package-private */
    public long b(long j10) {
        return this.f22575b.getLong("mp::lastusedate", j10);
    }

    /* access modifiers changed from: package-private */
    public void c(int i10) {
        this.f22575b.edit().putInt("mp::breadcrumbs::limit", i10).apply();
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f22575b.getString("mp::cookies", "");
    }

    /* access modifiers changed from: package-private */
    public void e(int i10) {
        this.f22575b.edit().putInt("mp::launch_since_upgrade", i10).apply();
    }

    private SharedPreferences c(long j10) {
        Set<Long> c10 = c(this.f22576c);
        c10.add(Long.valueOf(j10));
        a(c10);
        return this.f22576c.getSharedPreferences(a(j10), 0);
    }

    /* access modifiers changed from: package-private */
    public int a(int i10) {
        return this.f22575b.getInt("mp::breadcrumbs::sessioncount", i10);
    }

    /* access modifiers changed from: package-private */
    public int b(int i10) {
        return this.f22575b.getInt("mp::totalruns", i10);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f22575b.edit().putLong("mp::time_in_fg", -1).apply();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.f22575b.edit().putString("mp::cookies", str).apply();
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        return this.f22575b.getString("mp::session::previous_id", str);
    }

    public void b(Long l10) {
        this.f22575b.edit().putLong("mp::last_seen", l10.longValue()).apply();
    }

    /* access modifiers changed from: private */
    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("mp_preferences", 0);
    }

    public void a(Long l10) {
        if (!this.f22575b.contains("mp::first_seen")) {
            this.f22575b.edit().putLong("mp::first_seen", l10.longValue()).apply();
        }
    }

    private static boolean c(Context context, long j10) {
        Set<Long> c10 = c(context);
        boolean remove = c10.remove(Long.valueOf(j10));
        a(context, c10);
        return remove;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z10) {
        this.f22575b.edit().putBoolean("mp::known_user", z10).apply();
    }

    private void a(Set<Long> set) {
        a(this.f22576c, set);
    }

    private static void a(Context context, Set<Long> set) {
        org.json.a aVar = new org.json.a();
        for (Long E : set) {
            aVar.E(E);
        }
        b(context).edit().putString("mp::user_config_collection", aVar.toString()).apply();
    }

    static Set<Long> c(Context context) {
        org.json.a aVar = new org.json.a();
        try {
            aVar = new org.json.a(b(context).getString("mp::user_config_collection", new org.json.a().toString()));
        } catch (JSONException unused) {
        }
        TreeSet treeSet = new TreeSet();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            try {
                treeSet.add(Long.valueOf(aVar.m(i10)));
            } catch (JSONException unused2) {
            }
        }
        return treeSet;
    }

    private static String a(long j10) {
        return "mp_preferences:" + j10;
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar) {
        if (pVar.v()) {
            c(pVar.g());
        }
        if (pVar.u()) {
            d(pVar.e());
        }
        if (pVar.r()) {
            c(pVar.c());
        }
        if (pVar.w()) {
            f(pVar.j());
        }
        if (pVar.z()) {
            g(pVar.n());
        }
        if (pVar.A()) {
            e(pVar.o());
        }
        if (pVar.B()) {
            h(pVar.e(0));
        }
        if (pVar.y()) {
            d(pVar.l());
        }
        if (pVar.C()) {
            f(pVar.b(0));
        }
        if (pVar.t()) {
            b(pVar.d());
        }
        if (pVar.x()) {
            e(pVar.k());
        }
        if (pVar.D()) {
            g(pVar.q());
        }
        if (pVar.s()) {
            f(pVar.p());
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences f22578a;

        /* renamed from: b  reason: collision with root package name */
        private SharedPreferences f22579b;

        /* renamed from: c  reason: collision with root package name */
        private String f22580c;

        a(Context context) {
            this.f22578a = context.getSharedPreferences("mParticlePrefs", 0);
            this.f22579b = context.getSharedPreferences("mp_preferences", 0);
            this.f22580c = new b(context).j();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0080 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.mparticle.internal.p r6) {
            /*
                r5 = this;
                java.lang.String r0 = r5.d()     // Catch:{ Exception -> 0x00b2 }
                r6.c((java.lang.String) r0)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r0 = r5.h()     // Catch:{ Exception -> 0x00b2 }
                r6.e((java.lang.String) r0)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r0 = r5.g()     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x0017
                r6.d((java.lang.String) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x0017:
                long r0 = r5.e()     // Catch:{ Exception -> 0x00b2 }
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x0028
                long r0 = r5.e()     // Catch:{ Exception -> 0x00b2 }
                r6.f((long) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x0028:
                int r0 = r5.c()     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x0035
                int r0 = r5.c()     // Catch:{ Exception -> 0x00b2 }
                r6.d((int) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x0035:
                int r0 = r5.a()     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x003e
                r6.c((int) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x003e:
                long r0 = r5.j()     // Catch:{ Exception -> 0x00b2 }
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L_0x0049
                r6.g((long) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x0049:
                long r0 = r5.i()     // Catch:{ Exception -> 0x00b2 }
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 == 0) goto L_0x0054
                r6.h(r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x0054:
                int r0 = r5.k()     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x005d
                r6.f((int) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x005d:
                java.lang.String r0 = r5.b()     // Catch:{ Exception -> 0x00b2 }
                r1 = 0
                if (r0 == 0) goto L_0x0083
                org.json.b r2 = new org.json.b     // Catch:{ Exception -> 0x0080 }
                r2.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r3 = "uid"
                org.json.b r2 = r2.getJSONObject(r3)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r3 = "c"
                java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0080 }
                android.net.UrlQuerySanitizer r3 = new android.net.UrlQuerySanitizer     // Catch:{ Exception -> 0x0080 }
                r3.<init>(r2)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r2 = "g"
                java.lang.String r1 = r3.getValue(r2)     // Catch:{ Exception -> 0x0080 }
            L_0x0080:
                r6.b((java.lang.String) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x0083:
                boolean r0 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r1)     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x0091
                java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x00b2 }
            L_0x0091:
                android.content.SharedPreferences r0 = r5.f22579b     // Catch:{ Exception -> 0x00b2 }
                android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r2 = "mp::device-app-stamp"
                android.content.SharedPreferences$Editor r0 = r0.putString(r2, r1)     // Catch:{ Exception -> 0x00b2 }
                r0.apply()     // Catch:{ Exception -> 0x00b2 }
                int r0 = r5.f()     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x00a9
                r6.e((int) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x00a9:
                java.lang.String r0 = r5.l()     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x00b2
                r6.g((java.lang.String) r0)     // Catch:{ Exception -> 0x00b2 }
            L_0x00b2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.p.a.a(com.mparticle.internal.p):void");
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f22579b.getString("mp::cookies", (String) null);
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.f22578a.getInt("mp::breadcrumbs::sessioncount", 0);
        }

        /* access modifiers changed from: package-private */
        public String d() {
            SharedPreferences sharedPreferences = this.f22578a;
            return sharedPreferences.getString("mp::deleted_user_attrs::" + this.f22580c, (String) null);
        }

        /* access modifiers changed from: package-private */
        public long e() {
            return this.f22578a.getLong("mp::lastusedate", 0);
        }

        /* access modifiers changed from: package-private */
        public int f() {
            return this.f22578a.getInt("mp::launch_since_upgrade", 0);
        }

        /* access modifiers changed from: package-private */
        public String g() {
            return this.f22578a.getString("mp::ltv", (String) null);
        }

        /* access modifiers changed from: package-private */
        public String h() {
            return this.f22578a.getString("mp::session::previous_id", (String) null);
        }

        /* access modifiers changed from: package-private */
        public long i() {
            return this.f22578a.getLong("mp::session::previous_start", 0);
        }

        /* access modifiers changed from: package-private */
        public long j() {
            return this.f22578a.getLong("mp::time_in_fg", 0);
        }

        /* access modifiers changed from: package-private */
        public int k() {
            return this.f22578a.getInt("mp::totalruns", 0);
        }

        /* access modifiers changed from: package-private */
        public String l() {
            SharedPreferences sharedPreferences = this.f22579b;
            return sharedPreferences.getString("mp::user_ids::" + this.f22580c, (String) null);
        }

        static boolean a(Context context) {
            return p.b(context).getBoolean("mp::needs_to_migrate_to_mpid_dependent", false);
        }

        static void a(Context context, boolean z10) {
            p.b(context).edit().putBoolean("mp::needs_to_migrate_to_mpid_dependent", z10).apply();
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f22579b.getInt("mp::breadcrumbs::limit", 0);
        }
    }
}
