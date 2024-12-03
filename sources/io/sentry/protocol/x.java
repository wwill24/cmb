package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.protocol.d;
import io.sentry.s0;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class x implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31574a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31575b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31576c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31577d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f31578e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f31579f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public d f31580g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f31581h;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, Object> f31582j;

    public static final class a implements s0<x> {
        /* renamed from: b */
        public x a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            x xVar = new x();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -265713450:
                        if (y10.equals("username")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 3355:
                        if (y10.equals("id")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 102225:
                        if (y10.equals("geo")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3076010:
                        if (y10.equals("data")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 96619420:
                        if (y10.equals("email")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 106069776:
                        if (y10.equals("other")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 1480014044:
                        if (y10.equals("ip_address")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case 1973722931:
                        if (y10.equals("segment")) {
                            c10 = 8;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = xVar.f31576c = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = xVar.f31575b = y0Var.H0();
                        break;
                    case 2:
                        d unused3 = xVar.f31580g = new d.a().a(y0Var, h0Var);
                        break;
                    case 3:
                        Map unused4 = xVar.f31581h = b.b((Map) y0Var.B0());
                        break;
                    case 4:
                        String unused5 = xVar.f31579f = y0Var.H0();
                        break;
                    case 5:
                        String unused6 = xVar.f31574a = y0Var.H0();
                        break;
                    case 6:
                        if (xVar.f31581h != null && !xVar.f31581h.isEmpty()) {
                            break;
                        } else {
                            Map unused7 = xVar.f31581h = b.b((Map) y0Var.B0());
                            break;
                        }
                    case 7:
                        String unused8 = xVar.f31578e = y0Var.H0();
                        break;
                    case 8:
                        String unused9 = xVar.f31577d = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            xVar.r(concurrentHashMap);
            y0Var.h();
            return xVar;
        }
    }

    public x() {
    }

    public x(x xVar) {
        this.f31574a = xVar.f31574a;
        this.f31576c = xVar.f31576c;
        this.f31575b = xVar.f31575b;
        this.f31578e = xVar.f31578e;
        this.f31577d = xVar.f31577d;
        this.f31579f = xVar.f31579f;
        this.f31580g = xVar.f31580g;
        this.f31581h = b.b(xVar.f31581h);
        this.f31582j = b.b(xVar.f31582j);
    }

    public Map<String, String> j() {
        return this.f31581h;
    }

    public String k() {
        return this.f31574a;
    }

    public String l() {
        return this.f31575b;
    }

    public String m() {
        return this.f31578e;
    }

    public String n() {
        return this.f31577d;
    }

    public String o() {
        return this.f31576c;
    }

    public void p(String str) {
        this.f31575b = str;
    }

    public void q(String str) {
        this.f31578e = str;
    }

    public void r(Map<String, Object> map) {
        this.f31582j = map;
    }

    public void s(String str) {
        this.f31576c = str;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31574a != null) {
            a1Var.N("email").I(this.f31574a);
        }
        if (this.f31575b != null) {
            a1Var.N("id").I(this.f31575b);
        }
        if (this.f31576c != null) {
            a1Var.N("username").I(this.f31576c);
        }
        if (this.f31577d != null) {
            a1Var.N("segment").I(this.f31577d);
        }
        if (this.f31578e != null) {
            a1Var.N("ip_address").I(this.f31578e);
        }
        if (this.f31579f != null) {
            a1Var.N("name").I(this.f31579f);
        }
        if (this.f31580g != null) {
            a1Var.N("geo");
            this.f31580g.serialize(a1Var, h0Var);
        }
        if (this.f31581h != null) {
            a1Var.N("data").O(h0Var, this.f31581h);
        }
        Map<String, Object> map = this.f31582j;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31582j.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
