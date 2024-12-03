package io.sentry.protocol;

import com.leanplum.internal.Constants;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31447a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31448b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31449c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f31450d;

    public static final class a implements s0<d> {
        /* renamed from: b */
        public d a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            d dVar = new d();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -934795532:
                        if (y10.equals(Constants.Keys.REGION)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 3053931:
                        if (y10.equals(Constants.Keys.CITY)) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 1481071862:
                        if (y10.equals("country_code")) {
                            c10 = 2;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = dVar.f31449c = y0Var.H0();
                        break;
                    case 1:
                        String unused2 = dVar.f31447a = y0Var.H0();
                        break;
                    case 2:
                        String unused3 = dVar.f31448b = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            dVar.d(concurrentHashMap);
            y0Var.h();
            return dVar;
        }
    }

    public void d(Map<String, Object> map) {
        this.f31450d = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31447a != null) {
            a1Var.N(Constants.Keys.CITY).I(this.f31447a);
        }
        if (this.f31448b != null) {
            a1Var.N("country_code").I(this.f31448b);
        }
        if (this.f31449c != null) {
            a1Var.N(Constants.Keys.REGION).I(this.f31449c);
        }
        Map<String, Object> map = this.f31450d;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31450d.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
