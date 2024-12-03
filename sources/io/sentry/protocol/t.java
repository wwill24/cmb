package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.protocol.s;
import io.sentry.s0;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class t implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<s> f31553a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f31554b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Boolean f31555c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f31556d;

    public static final class a implements s0<t> {
        /* renamed from: b */
        public t a(y0 y0Var, h0 h0Var) throws Exception {
            t tVar = new t();
            y0Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1266514778:
                        if (y10.equals("frames")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 78226992:
                        if (y10.equals("registers")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 284874180:
                        if (y10.equals("snapshot")) {
                            c10 = 2;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        List unused = tVar.f31553a = y0Var.v0(h0Var, new s.a());
                        break;
                    case 1:
                        Map unused2 = tVar.f31554b = b.b((Map) y0Var.B0());
                        break;
                    case 2:
                        Boolean unused3 = tVar.f31555c = y0Var.m0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            tVar.e(concurrentHashMap);
            y0Var.h();
            return tVar;
        }
    }

    public t() {
    }

    public t(List<s> list) {
        this.f31553a = list;
    }

    public void d(Boolean bool) {
        this.f31555c = bool;
    }

    public void e(Map<String, Object> map) {
        this.f31556d = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31553a != null) {
            a1Var.N("frames").O(h0Var, this.f31553a);
        }
        if (this.f31554b != null) {
            a1Var.N("registers").O(h0Var, this.f31554b);
        }
        if (this.f31555c != null) {
            a1Var.N("snapshot").F(this.f31555c);
        }
        Map<String, Object> map = this.f31556d;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31556d.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
