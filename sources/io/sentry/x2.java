package io.sentry;

import io.sentry.p4;
import io.sentry.protocol.m;
import io.sentry.protocol.o;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class x2 implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final o f31795a;

    /* renamed from: b  reason: collision with root package name */
    private final m f31796b;

    /* renamed from: c  reason: collision with root package name */
    private final p4 f31797c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f31798d;

    public static final class a implements s0<x2> {
        /* renamed from: b */
        public x2 a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            o oVar = null;
            m mVar = null;
            p4 p4Var = null;
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case 113722:
                        if (y10.equals("sdk")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 110620997:
                        if (y10.equals("trace")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 278118624:
                        if (y10.equals("event_id")) {
                            c10 = 2;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        mVar = (m) y0Var.E0(h0Var, new m.a());
                        break;
                    case 1:
                        p4Var = (p4) y0Var.E0(h0Var, new p4.b());
                        break;
                    case 2:
                        oVar = (o) y0Var.E0(h0Var, new o.a());
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        y0Var.N0(h0Var, hashMap, y10);
                        break;
                }
            }
            x2 x2Var = new x2(oVar, mVar, p4Var);
            x2Var.d(hashMap);
            y0Var.h();
            return x2Var;
        }
    }

    public x2(o oVar, m mVar) {
        this(oVar, mVar, (p4) null);
    }

    public o a() {
        return this.f31795a;
    }

    public m b() {
        return this.f31796b;
    }

    public p4 c() {
        return this.f31797c;
    }

    public void d(Map<String, Object> map) {
        this.f31798d = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31795a != null) {
            a1Var.N("event_id").O(h0Var, this.f31795a);
        }
        if (this.f31796b != null) {
            a1Var.N("sdk").O(h0Var, this.f31796b);
        }
        if (this.f31797c != null) {
            a1Var.N("trace").O(h0Var, this.f31797c);
        }
        Map<String, Object> map = this.f31798d;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31798d.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public x2(o oVar, m mVar, p4 p4Var) {
        this.f31795a = oVar;
        this.f31796b = mVar;
        this.f31797c = p4Var;
    }

    public x2(o oVar) {
        this(oVar, (m) null);
    }

    public x2() {
        this(new o());
    }
}
