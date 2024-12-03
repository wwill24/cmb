package io.sentry.profilemeasurements;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class b implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f31408a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31409b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public double f31410c;

    public static final class a implements s0<b> {
        /* renamed from: b */
        public b a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            b bVar = new b();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("elapsed_since_start_ns")) {
                    String H0 = y0Var.H0();
                    if (H0 != null) {
                        String unused = bVar.f31409b = H0;
                    }
                } else if (!y10.equals("value")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    y0Var.N0(h0Var, concurrentHashMap, y10);
                } else {
                    Double r02 = y0Var.r0();
                    if (r02 != null) {
                        double unused2 = bVar.f31410c = r02.doubleValue();
                    }
                }
            }
            bVar.c(concurrentHashMap);
            y0Var.h();
            return bVar;
        }
    }

    public b() {
        this(0L, 0);
    }

    public void c(Map<String, Object> map) {
        this.f31408a = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!l.a(this.f31408a, bVar.f31408a) || !this.f31409b.equals(bVar.f31409b) || this.f31410c != bVar.f31410c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return l.b(this.f31408a, this.f31409b, Double.valueOf(this.f31410c));
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("value").O(h0Var, Double.valueOf(this.f31410c));
        a1Var.N("elapsed_since_start_ns").O(h0Var, this.f31409b);
        Map<String, Object> map = this.f31408a;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31408a.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public b(Long l10, Number number) {
        this.f31409b = l10.toString();
        this.f31410c = number.doubleValue();
    }
}
