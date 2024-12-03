package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class w implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final String f31572a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f31573b;

    public static final class a implements s0<w> {
        /* renamed from: b */
        public w a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            String str = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (!y10.equals("source")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    y0Var.N0(h0Var, concurrentHashMap, y10);
                } else {
                    str = y0Var.H0();
                }
            }
            w wVar = new w(str);
            wVar.a(concurrentHashMap);
            y0Var.h();
            return wVar;
        }
    }

    public w(String str) {
        this.f31572a = str;
    }

    public void a(Map<String, Object> map) {
        this.f31573b = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31572a != null) {
            a1Var.N("source").O(h0Var, this.f31572a);
        }
        Map<String, Object> map = this.f31573b;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31573b.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
