package io.sentry.protocol;

import com.facebook.internal.ServerProtocol;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31441a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31442b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f31443c;

    public static final class a implements s0<b> {
        /* renamed from: b */
        public b a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            b bVar = new b();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("name")) {
                    String unused = bVar.f31441a = y0Var.H0();
                } else if (!y10.equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    y0Var.N0(h0Var, concurrentHashMap, y10);
                } else {
                    String unused2 = bVar.f31442b = y0Var.H0();
                }
            }
            bVar.c(concurrentHashMap);
            y0Var.h();
            return bVar;
        }
    }

    public b() {
    }

    b(b bVar) {
        this.f31441a = bVar.f31441a;
        this.f31442b = bVar.f31442b;
        this.f31443c = io.sentry.util.b.b(bVar.f31443c);
    }

    public void c(Map<String, Object> map) {
        this.f31443c = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31441a != null) {
            a1Var.N("name").I(this.f31441a);
        }
        if (this.f31442b != null) {
            a1Var.N(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).I(this.f31442b);
        }
        Map<String, Object> map = this.f31443c;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31443c.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
