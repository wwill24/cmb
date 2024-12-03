package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.config.f;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private String f31684a;

    /* renamed from: b  reason: collision with root package name */
    private String f31685b;

    /* renamed from: c  reason: collision with root package name */
    private String f31686c;

    /* renamed from: d  reason: collision with root package name */
    private String f31687d;

    /* renamed from: e  reason: collision with root package name */
    private String f31688e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f31689f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f31690g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f31691h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f31692i;

    /* renamed from: j  reason: collision with root package name */
    private Double f31693j;

    /* renamed from: k  reason: collision with root package name */
    private Double f31694k;

    /* renamed from: l  reason: collision with root package name */
    private SentryOptions.RequestSize f31695l;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, String> f31696m = new ConcurrentHashMap();

    /* renamed from: n  reason: collision with root package name */
    private SentryOptions.e f31697n;

    /* renamed from: o  reason: collision with root package name */
    private final List<String> f31698o = new CopyOnWriteArrayList();

    /* renamed from: p  reason: collision with root package name */
    private final List<String> f31699p = new CopyOnWriteArrayList();

    /* renamed from: q  reason: collision with root package name */
    private List<String> f31700q = null;

    /* renamed from: r  reason: collision with root package name */
    private final List<String> f31701r = new CopyOnWriteArrayList();

    /* renamed from: s  reason: collision with root package name */
    private String f31702s;

    /* renamed from: t  reason: collision with root package name */
    private Long f31703t;

    /* renamed from: u  reason: collision with root package name */
    private final Set<Class<? extends Throwable>> f31704u = new CopyOnWriteArraySet();

    /* renamed from: v  reason: collision with root package name */
    private Boolean f31705v;

    /* renamed from: w  reason: collision with root package name */
    private Boolean f31706w;

    public static u f(f fVar, h0 h0Var) {
        u uVar = new u();
        uVar.E(fVar.getProperty("dsn"));
        uVar.I(fVar.getProperty("environment"));
        uVar.P(fVar.getProperty("release"));
        uVar.D(fVar.getProperty("dist"));
        uVar.R(fVar.getProperty("servername"));
        uVar.H(fVar.f("uncaught.handler.enabled"));
        uVar.L(fVar.f("uncaught.handler.print-stacktrace"));
        uVar.G(fVar.f("enable-tracing"));
        uVar.T(fVar.c("traces-sample-rate"));
        uVar.M(fVar.c("profiles-sample-rate"));
        uVar.C(fVar.f("debug"));
        uVar.F(fVar.f("enable-deduplication"));
        uVar.Q(fVar.f("send-client-reports"));
        String property = fVar.getProperty("max-request-body-size");
        if (property != null) {
            uVar.K(SentryOptions.RequestSize.valueOf(property.toUpperCase(Locale.ROOT)));
        }
        for (Map.Entry next : fVar.a("tags").entrySet()) {
            uVar.S((String) next.getKey(), (String) next.getValue());
        }
        String property2 = fVar.getProperty("proxy.host");
        String property3 = fVar.getProperty("proxy.user");
        String property4 = fVar.getProperty("proxy.pass");
        String d10 = fVar.d("proxy.port", "80");
        if (property2 != null) {
            uVar.O(new SentryOptions.e(property2, d10, property3, property4));
        }
        for (String d11 : fVar.e("in-app-includes")) {
            uVar.d(d11);
        }
        for (String c10 : fVar.e("in-app-excludes")) {
            uVar.c(c10);
        }
        List<String> list = null;
        if (fVar.getProperty("trace-propagation-targets") != null) {
            list = fVar.e("trace-propagation-targets");
        }
        if (list == null && fVar.getProperty("tracing-origins") != null) {
            list = fVar.e("tracing-origins");
        }
        if (list != null) {
            for (String e10 : list) {
                uVar.e(e10);
            }
        }
        for (String a10 : fVar.e("context-tags")) {
            uVar.a(a10);
        }
        uVar.N(fVar.getProperty("proguard-uuid"));
        uVar.J(fVar.b("idle-timeout"));
        for (String next2 : fVar.e("ignored-exceptions-for-type")) {
            try {
                Class<?> cls = Class.forName(next2);
                if (Throwable.class.isAssignableFrom(cls)) {
                    uVar.b(cls);
                } else {
                    h0Var.c(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", next2, next2);
                }
            } catch (ClassNotFoundException unused) {
                h0Var.c(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", next2, next2);
            }
        }
        return uVar;
    }

    public List<String> A() {
        return this.f31700q;
    }

    public Double B() {
        return this.f31693j;
    }

    public void C(Boolean bool) {
        this.f31690g = bool;
    }

    public void D(String str) {
        this.f31687d = str;
    }

    public void E(String str) {
        this.f31684a = str;
    }

    public void F(Boolean bool) {
        this.f31691h = bool;
    }

    public void G(Boolean bool) {
        this.f31692i = bool;
    }

    public void H(Boolean bool) {
        this.f31689f = bool;
    }

    public void I(String str) {
        this.f31685b = str;
    }

    public void J(Long l10) {
        this.f31703t = l10;
    }

    public void K(SentryOptions.RequestSize requestSize) {
        this.f31695l = requestSize;
    }

    public void L(Boolean bool) {
        this.f31705v = bool;
    }

    public void M(Double d10) {
        this.f31694k = d10;
    }

    public void N(String str) {
        this.f31702s = str;
    }

    public void O(SentryOptions.e eVar) {
        this.f31697n = eVar;
    }

    public void P(String str) {
        this.f31686c = str;
    }

    public void Q(Boolean bool) {
        this.f31706w = bool;
    }

    public void R(String str) {
        this.f31688e = str;
    }

    public void S(String str, String str2) {
        this.f31696m.put(str, str2);
    }

    public void T(Double d10) {
        this.f31693j = d10;
    }

    public void a(String str) {
        this.f31701r.add(str);
    }

    public void b(Class<? extends Throwable> cls) {
        this.f31704u.add(cls);
    }

    public void c(String str) {
        this.f31698o.add(str);
    }

    public void d(String str) {
        this.f31699p.add(str);
    }

    public void e(String str) {
        if (this.f31700q == null) {
            this.f31700q = new CopyOnWriteArrayList();
        }
        if (!str.isEmpty()) {
            this.f31700q.add(str);
        }
    }

    public List<String> g() {
        return this.f31701r;
    }

    public Boolean h() {
        return this.f31690g;
    }

    public String i() {
        return this.f31687d;
    }

    public String j() {
        return this.f31684a;
    }

    public Boolean k() {
        return this.f31691h;
    }

    public Boolean l() {
        return this.f31692i;
    }

    public Boolean m() {
        return this.f31689f;
    }

    public String n() {
        return this.f31685b;
    }

    public Long o() {
        return this.f31703t;
    }

    public Set<Class<? extends Throwable>> p() {
        return this.f31704u;
    }

    public List<String> q() {
        return this.f31698o;
    }

    public List<String> r() {
        return this.f31699p;
    }

    public Boolean s() {
        return this.f31705v;
    }

    public Double t() {
        return this.f31694k;
    }

    public String u() {
        return this.f31702s;
    }

    public SentryOptions.e v() {
        return this.f31697n;
    }

    public String w() {
        return this.f31686c;
    }

    public Boolean x() {
        return this.f31706w;
    }

    public String y() {
        return this.f31688e;
    }

    public Map<String, String> z() {
        return this.f31696m;
    }
}
