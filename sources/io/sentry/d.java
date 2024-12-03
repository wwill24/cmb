package io.sentry;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.SentryLevel;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

public final class d implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final Date f31186a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31187b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31188c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Object> f31189d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f31190e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SentryLevel f31191f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Object> f31192g;

    public static final class a implements s0<d> {
        /* renamed from: b */
        public d a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            Date c10 = g.c();
            Map concurrentHashMap = new ConcurrentHashMap();
            String str = null;
            String str2 = null;
            String str3 = null;
            SentryLevel sentryLevel = null;
            ConcurrentHashMap concurrentHashMap2 = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c11 = 65535;
                switch (y10.hashCode()) {
                    case 3076010:
                        if (y10.equals("data")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 3575610:
                        if (y10.equals("type")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 50511102:
                        if (y10.equals("category")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 55126294:
                        if (y10.equals("timestamp")) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 102865796:
                        if (y10.equals(FirebaseAnalytics.Param.LEVEL)) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case 954925063:
                        if (y10.equals("message")) {
                            c11 = 5;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        Map b10 = b.b((Map) y0Var.B0());
                        if (b10 == null) {
                            break;
                        } else {
                            concurrentHashMap = b10;
                            break;
                        }
                    case 1:
                        str2 = y0Var.H0();
                        break;
                    case 2:
                        str3 = y0Var.H0();
                        break;
                    case 3:
                        Date q02 = y0Var.q0(h0Var);
                        if (q02 == null) {
                            break;
                        } else {
                            c10 = q02;
                            break;
                        }
                    case 4:
                        try {
                            sentryLevel = new SentryLevel.a().a(y0Var, h0Var);
                            break;
                        } catch (Exception e10) {
                            h0Var.a(SentryLevel.ERROR, e10, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                    case 5:
                        str = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap2 == null) {
                            concurrentHashMap2 = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap2, y10);
                        break;
                }
            }
            d dVar = new d(c10);
            String unused = dVar.f31187b = str;
            String unused2 = dVar.f31188c = str2;
            Map unused3 = dVar.f31189d = concurrentHashMap;
            String unused4 = dVar.f31190e = str3;
            SentryLevel unused5 = dVar.f31191f = sentryLevel;
            dVar.q(concurrentHashMap2);
            y0Var.h();
            return dVar;
        }
    }

    public d(Date date) {
        this.f31189d = new ConcurrentHashMap();
        this.f31186a = date;
    }

    public static d r(String str, String str2, String str3, String str4, Map<String, Object> map) {
        d dVar = new d();
        dVar.p("user");
        dVar.l("ui." + str);
        if (str2 != null) {
            dVar.m("view.id", str2);
        }
        if (str3 != null) {
            dVar.m("view.class", str3);
        }
        if (str4 != null) {
            dVar.m("view.tag", str4);
        }
        for (Map.Entry next : map.entrySet()) {
            dVar.g().put((String) next.getKey(), next.getValue());
        }
        dVar.n(SentryLevel.INFO);
        return dVar;
    }

    public String f() {
        return this.f31190e;
    }

    @ApiStatus.Internal
    public Map<String, Object> g() {
        return this.f31189d;
    }

    public SentryLevel h() {
        return this.f31191f;
    }

    public String i() {
        return this.f31187b;
    }

    public Date j() {
        return (Date) this.f31186a.clone();
    }

    public String k() {
        return this.f31188c;
    }

    public void l(String str) {
        this.f31190e = str;
    }

    public void m(String str, Object obj) {
        this.f31189d.put(str, obj);
    }

    public void n(SentryLevel sentryLevel) {
        this.f31191f = sentryLevel;
    }

    public void o(String str) {
        this.f31187b = str;
    }

    public void p(String str) {
        this.f31188c = str;
    }

    public void q(Map<String, Object> map) {
        this.f31192g = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("timestamp").O(h0Var, this.f31186a);
        if (this.f31187b != null) {
            a1Var.N("message").I(this.f31187b);
        }
        if (this.f31188c != null) {
            a1Var.N("type").I(this.f31188c);
        }
        a1Var.N("data").O(h0Var, this.f31189d);
        if (this.f31190e != null) {
            a1Var.N("category").I(this.f31190e);
        }
        if (this.f31191f != null) {
            a1Var.N(FirebaseAnalytics.Param.LEVEL).O(h0Var, this.f31191f);
        }
        Map<String, Object> map = this.f31192g;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31192g.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    d(d dVar) {
        this.f31189d = new ConcurrentHashMap();
        this.f31186a = dVar.f31186a;
        this.f31187b = dVar.f31187b;
        this.f31188c = dVar.f31188c;
        this.f31190e = dVar.f31190e;
        Map<String, Object> b10 = b.b(dVar.f31189d);
        if (b10 != null) {
            this.f31189d = b10;
        }
        this.f31192g = b.b(dVar.f31192g);
        this.f31191f = dVar.f31191f;
    }

    public d() {
        this(g.c());
    }
}
