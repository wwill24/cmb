package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.protocol.z;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class y implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f31583a;

    /* renamed from: b  reason: collision with root package name */
    private final List<z> f31584b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f31585c;

    public static final class a implements s0<y> {
        /* renamed from: b */
        public y a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            String str = null;
            List list = null;
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("rendering_system")) {
                    str = y0Var.H0();
                } else if (!y10.equals("windows")) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    y0Var.N0(h0Var, hashMap, y10);
                } else {
                    list = y0Var.v0(h0Var, new z.a());
                }
            }
            y0Var.h();
            y yVar = new y(str, list);
            yVar.a(hashMap);
            return yVar;
        }
    }

    public y(String str, List<z> list) {
        this.f31583a = str;
        this.f31584b = list;
    }

    public void a(Map<String, Object> map) {
        this.f31585c = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31583a != null) {
            a1Var.N("rendering_system").I(this.f31583a);
        }
        if (this.f31584b != null) {
            a1Var.N("windows").O(h0Var, this.f31584b);
        }
        Map<String, Object> map = this.f31585c;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31585c.get(next));
            }
        }
        a1Var.h();
    }
}
