package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class h implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31473a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31474b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<String> f31475c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f31476d;

    public static final class a implements s0<h> {
        /* renamed from: b */
        public h a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            h hVar = new h();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -995427962:
                        if (y10.equals("params")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 954925063:
                        if (y10.equals("message")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 1811591356:
                        if (y10.equals("formatted")) {
                            c10 = 2;
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
                            List unused = hVar.f31475c = list;
                            break;
                        }
                    case 1:
                        String unused2 = hVar.f31474b = y0Var.H0();
                        break;
                    case 2:
                        String unused3 = hVar.f31473a = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            hVar.d(concurrentHashMap);
            y0Var.h();
            return hVar;
        }
    }

    public void d(Map<String, Object> map) {
        this.f31476d = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31473a != null) {
            a1Var.N("formatted").I(this.f31473a);
        }
        if (this.f31474b != null) {
            a1Var.N("message").I(this.f31474b);
        }
        List<String> list = this.f31475c;
        if (list != null && !list.isEmpty()) {
            a1Var.N("params").O(h0Var, this.f31475c);
        }
        Map<String, Object> map = this.f31476d;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31476d.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
