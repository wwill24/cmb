package io.sentry.profilemeasurements;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.profilemeasurements.b;
import io.sentry.s0;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class a implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f31405a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31406b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Collection<b> f31407c;

    /* renamed from: io.sentry.profilemeasurements.a$a  reason: collision with other inner class name */
    public static final class C0360a implements s0<a> {
        /* renamed from: b */
        public a a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            a aVar = new a();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("values")) {
                    List v02 = y0Var.v0(h0Var, new b.a());
                    if (v02 != null) {
                        Collection unused = aVar.f31407c = v02;
                    }
                } else if (!y10.equals("unit")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    y0Var.N0(h0Var, concurrentHashMap, y10);
                } else {
                    String H0 = y0Var.H0();
                    if (H0 != null) {
                        String unused2 = aVar.f31406b = H0;
                    }
                }
            }
            aVar.c(concurrentHashMap);
            y0Var.h();
            return aVar;
        }
    }

    public a() {
        this("unknown", new ArrayList());
    }

    public void c(Map<String, Object> map) {
        this.f31405a = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!l.a(this.f31405a, aVar.f31405a) || !this.f31406b.equals(aVar.f31406b) || !new ArrayList(this.f31407c).equals(new ArrayList(aVar.f31407c))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return l.b(this.f31405a, this.f31406b, this.f31407c);
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("unit").O(h0Var, this.f31406b);
        a1Var.N("values").O(h0Var, this.f31407c);
        Map<String, Object> map = this.f31405a;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31405a.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public a(String str, Collection<b> collection) {
        this.f31406b = str;
        this.f31407c = collection;
    }
}
