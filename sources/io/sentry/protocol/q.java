package io.sentry.protocol;

import com.facebook.internal.ServerProtocol;
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

public final class q implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31522a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31523b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31524c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f31525d;

    public static final class a implements s0<q> {
        /* renamed from: b */
        public q a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            q qVar = new q();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -339173787:
                        if (y10.equals("raw_description")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 3373707:
                        if (y10.equals("name")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 351608024:
                        if (y10.equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                            c10 = 2;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = qVar.f31524c = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = qVar.f31522a = y0Var.H0();
                        break;
                    case 2:
                        String unused3 = qVar.f31523b = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            qVar.g(concurrentHashMap);
            y0Var.h();
            return qVar;
        }
    }

    public q() {
    }

    q(q qVar) {
        this.f31522a = qVar.f31522a;
        this.f31523b = qVar.f31523b;
        this.f31524c = qVar.f31524c;
        this.f31525d = b.b(qVar.f31525d);
    }

    public String d() {
        return this.f31522a;
    }

    public String e() {
        return this.f31523b;
    }

    public void f(String str) {
        this.f31522a = str;
    }

    public void g(Map<String, Object> map) {
        this.f31525d = map;
    }

    public void h(String str) {
        this.f31523b = str;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31522a != null) {
            a1Var.N("name").I(this.f31522a);
        }
        if (this.f31523b != null) {
            a1Var.N(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).I(this.f31523b);
        }
        if (this.f31524c != null) {
            a1Var.N("raw_description").I(this.f31524c);
        }
        Map<String, Object> map = this.f31525d;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31525d.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
