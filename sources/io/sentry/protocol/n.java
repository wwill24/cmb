package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.protocol.g;
import io.sentry.protocol.t;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class n implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31510a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31511b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31512c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Long f31513d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public t f31514e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public g f31515f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Object> f31516g;

    public static final class a implements s0<n> {
        /* renamed from: b */
        public n a(y0 y0Var, h0 h0Var) throws Exception {
            n nVar = new n();
            y0Var.b();
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1562235024:
                        if (y10.equals("thread_id")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1068784020:
                        if (y10.equals("module")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 3575610:
                        if (y10.equals("type")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 111972721:
                        if (y10.equals("value")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 1225089881:
                        if (y10.equals("mechanism")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 2055832509:
                        if (y10.equals("stacktrace")) {
                            c10 = 5;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        Long unused = nVar.f31513d = y0Var.x0();
                        break;
                    case 1:
                        String unused2 = nVar.f31512c = y0Var.H0();
                        break;
                    case 2:
                        String unused3 = nVar.f31510a = y0Var.H0();
                        break;
                    case 3:
                        String unused4 = nVar.f31511b = y0Var.H0();
                        break;
                    case 4:
                        g unused5 = nVar.f31515f = (g) y0Var.E0(h0Var, new g.a());
                        break;
                    case 5:
                        t unused6 = nVar.f31514e = (t) y0Var.E0(h0Var, new t.a());
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        y0Var.N0(h0Var, hashMap, y10);
                        break;
                }
            }
            y0Var.h();
            nVar.n(hashMap);
            return nVar;
        }
    }

    public g g() {
        return this.f31515f;
    }

    public Long h() {
        return this.f31513d;
    }

    public void i(g gVar) {
        this.f31515f = gVar;
    }

    public void j(String str) {
        this.f31512c = str;
    }

    public void k(t tVar) {
        this.f31514e = tVar;
    }

    public void l(Long l10) {
        this.f31513d = l10;
    }

    public void m(String str) {
        this.f31510a = str;
    }

    public void n(Map<String, Object> map) {
        this.f31516g = map;
    }

    public void o(String str) {
        this.f31511b = str;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31510a != null) {
            a1Var.N("type").I(this.f31510a);
        }
        if (this.f31511b != null) {
            a1Var.N("value").I(this.f31511b);
        }
        if (this.f31512c != null) {
            a1Var.N("module").I(this.f31512c);
        }
        if (this.f31513d != null) {
            a1Var.N("thread_id").G(this.f31513d);
        }
        if (this.f31514e != null) {
            a1Var.N("stacktrace").O(h0Var, this.f31514e);
        }
        if (this.f31515f != null) {
            a1Var.N("mechanism").O(h0Var, this.f31515f);
        }
        Map<String, Object> map = this.f31516g;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31516g.get(next));
            }
        }
        a1Var.h();
    }
}
