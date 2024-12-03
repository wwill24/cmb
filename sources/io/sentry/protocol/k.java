package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.util.b;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

public final class k implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31495a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f31496b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Integer f31497c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Long f31498d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f31499e;

    public static final class a implements s0<k> {
        /* renamed from: b */
        public k a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            k kVar = new k();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -891699686:
                        if (y10.equals("status_code")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 795307910:
                        if (y10.equals(HeadersExtension.ELEMENT)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 952189583:
                        if (y10.equals("cookies")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 1252988030:
                        if (y10.equals("body_size")) {
                            c10 = 3;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        Integer unused = kVar.f31497c = y0Var.u0();
                        break;
                    case 1:
                        Map map = (Map) y0Var.B0();
                        if (map == null) {
                            break;
                        } else {
                            Map unused2 = kVar.f31496b = b.b(map);
                            break;
                        }
                    case 2:
                        String unused3 = kVar.f31495a = y0Var.H0();
                        break;
                    case 3:
                        Long unused4 = kVar.f31498d = y0Var.x0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            kVar.e(concurrentHashMap);
            y0Var.h();
            return kVar;
        }
    }

    public k() {
    }

    public k(k kVar) {
        this.f31495a = kVar.f31495a;
        this.f31496b = b.b(kVar.f31496b);
        this.f31499e = b.b(kVar.f31499e);
        this.f31497c = kVar.f31497c;
        this.f31498d = kVar.f31498d;
    }

    public void e(Map<String, Object> map) {
        this.f31499e = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31495a != null) {
            a1Var.N("cookies").I(this.f31495a);
        }
        if (this.f31496b != null) {
            a1Var.N(HeadersExtension.ELEMENT).O(h0Var, this.f31496b);
        }
        if (this.f31497c != null) {
            a1Var.N("status_code").O(h0Var, this.f31497c);
        }
        if (this.f31498d != null) {
            a1Var.N("body_size").O(h0Var, this.f31498d);
        }
        Map<String, Object> map = this.f31499e;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31499e.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
