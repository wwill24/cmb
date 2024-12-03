package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.l;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public l f31444a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<DebugImage> f31445b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f31446c;

    public static final class a implements s0<c> {
        /* renamed from: b */
        public c a(y0 y0Var, h0 h0Var) throws Exception {
            c cVar = new c();
            y0Var.b();
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("images")) {
                    List unused = cVar.f31445b = y0Var.v0(h0Var, new DebugImage.a());
                } else if (!y10.equals("sdk_info")) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    y0Var.N0(h0Var, hashMap, y10);
                } else {
                    l unused2 = cVar.f31444a = (l) y0Var.E0(h0Var, new l.a());
                }
            }
            y0Var.h();
            cVar.e(hashMap);
            return cVar;
        }
    }

    public List<DebugImage> c() {
        return this.f31445b;
    }

    public void d(List<DebugImage> list) {
        this.f31445b = list != null ? new ArrayList(list) : null;
    }

    public void e(Map<String, Object> map) {
        this.f31446c = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31444a != null) {
            a1Var.N("sdk_info").O(h0Var, this.f31444a);
        }
        if (this.f31445b != null) {
            a1Var.N("images").O(h0Var, this.f31445b);
        }
        Map<String, Object> map = this.f31446c;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31446c.get(next));
            }
        }
        a1Var.h();
    }
}
