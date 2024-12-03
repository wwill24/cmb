package io.sentry;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.SentryLevel;
import io.sentry.p2;
import io.sentry.protocol.h;
import io.sentry.protocol.n;
import io.sentry.protocol.o;
import io.sentry.protocol.u;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p3 extends p2 implements c1 {
    /* access modifiers changed from: private */
    public SentryLevel B;
    /* access modifiers changed from: private */
    public String C;
    /* access modifiers changed from: private */
    public List<String> D;
    private Map<String, Object> E;
    /* access modifiers changed from: private */
    public Map<String, String> F;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Date f31388t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public h f31389w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public String f31390x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public g4<u> f31391y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public g4<n> f31392z;

    public static final class a implements s0<p3> {
        /* renamed from: b */
        public p3 a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            p3 p3Var = new p3();
            p2.a aVar = new p2.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1375934236:
                        if (y10.equals("fingerprint")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1337936983:
                        if (y10.equals("threads")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1097337456:
                        if (y10.equals("logger")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 55126294:
                        if (y10.equals("timestamp")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 102865796:
                        if (y10.equals(FirebaseAnalytics.Param.LEVEL)) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 954925063:
                        if (y10.equals("message")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 1227433863:
                        if (y10.equals("modules")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 1481625679:
                        if (y10.equals("exception")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 2141246174:
                        if (y10.equals("transaction")) {
                            c10 = 8;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        List list = (List) y0Var.B0();
                        if (list == null) {
                            break;
                        } else {
                            List unused = p3Var.D = list;
                            break;
                        }
                    case 1:
                        y0Var.b();
                        y0Var.y();
                        g4 unused2 = p3Var.f31391y = new g4(y0Var.v0(h0Var, new u.a()));
                        y0Var.h();
                        break;
                    case 2:
                        String unused3 = p3Var.f31390x = y0Var.H0();
                        break;
                    case 3:
                        Date q02 = y0Var.q0(h0Var);
                        if (q02 == null) {
                            break;
                        } else {
                            Date unused4 = p3Var.f31388t = q02;
                            break;
                        }
                    case 4:
                        SentryLevel unused5 = p3Var.B = (SentryLevel) y0Var.E0(h0Var, new SentryLevel.a());
                        break;
                    case 5:
                        h unused6 = p3Var.f31389w = (h) y0Var.E0(h0Var, new h.a());
                        break;
                    case 6:
                        Map unused7 = p3Var.F = b.b((Map) y0Var.B0());
                        break;
                    case 7:
                        y0Var.b();
                        y0Var.y();
                        g4 unused8 = p3Var.f31392z = new g4(y0Var.v0(h0Var, new n.a()));
                        y0Var.h();
                        break;
                    case 8:
                        String unused9 = p3Var.C = y0Var.H0();
                        break;
                    default:
                        if (!aVar.a(p3Var, y10, y0Var, h0Var)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            y0Var.N0(h0Var, concurrentHashMap, y10);
                            break;
                        } else {
                            break;
                        }
                }
            }
            p3Var.B0(concurrentHashMap);
            y0Var.h();
            return p3Var;
        }
    }

    p3(o oVar, Date date) {
        super(oVar);
        this.f31388t = date;
    }

    public void A0(String str) {
        this.C = str;
    }

    public void B0(Map<String, Object> map) {
        this.E = map;
    }

    public List<n> o0() {
        g4<n> g4Var = this.f31392z;
        if (g4Var == null) {
            return null;
        }
        return g4Var.a();
    }

    public List<String> p0() {
        return this.D;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> q0() {
        return this.F;
    }

    public List<u> r0() {
        g4<u> g4Var = this.f31391y;
        if (g4Var != null) {
            return g4Var.a();
        }
        return null;
    }

    public String s0() {
        return this.C;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("timestamp").O(h0Var, this.f31388t);
        if (this.f31389w != null) {
            a1Var.N("message").O(h0Var, this.f31389w);
        }
        if (this.f31390x != null) {
            a1Var.N("logger").I(this.f31390x);
        }
        g4<u> g4Var = this.f31391y;
        if (g4Var != null && !g4Var.a().isEmpty()) {
            a1Var.N("threads");
            a1Var.e();
            a1Var.N("values").O(h0Var, this.f31391y.a());
            a1Var.h();
        }
        g4<n> g4Var2 = this.f31392z;
        if (g4Var2 != null && !g4Var2.a().isEmpty()) {
            a1Var.N("exception");
            a1Var.e();
            a1Var.N("values").O(h0Var, this.f31392z.a());
            a1Var.h();
        }
        if (this.B != null) {
            a1Var.N(FirebaseAnalytics.Param.LEVEL).O(h0Var, this.B);
        }
        if (this.C != null) {
            a1Var.N("transaction").I(this.C);
        }
        if (this.D != null) {
            a1Var.N("fingerprint").O(h0Var, this.D);
        }
        if (this.F != null) {
            a1Var.N("modules").O(h0Var, this.F);
        }
        new p2.b().a(this, a1Var, h0Var);
        Map<String, Object> map = this.E;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.E.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public boolean t0() {
        g4<n> g4Var = this.f31392z;
        if (g4Var == null) {
            return false;
        }
        for (n next : g4Var.a()) {
            if (next.g() != null && next.g().h() != null && !next.g().h().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean u0() {
        g4<n> g4Var = this.f31392z;
        return g4Var != null && !g4Var.a().isEmpty();
    }

    public void v0(List<n> list) {
        this.f31392z = new g4<>(list);
    }

    public void w0(List<String> list) {
        this.D = list != null ? new ArrayList(list) : null;
    }

    public void x0(SentryLevel sentryLevel) {
        this.B = sentryLevel;
    }

    public void y0(Map<String, String> map) {
        this.F = b.c(map);
    }

    public void z0(List<u> list) {
        this.f31391y = new g4<>(list);
    }

    public p3(Throwable th2) {
        this();
        this.f31382k = th2;
    }

    public p3() {
        this(new o(), g.c());
    }
}
