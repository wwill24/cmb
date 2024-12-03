package io.sentry.protocol;

import io.sentry.SentryLevel;
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
public final class f implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final Number f31461a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31462b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f31463c;

    public static final class a implements s0<f> {
        /* renamed from: b */
        public f a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            Number number = null;
            String str = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("unit")) {
                    str = y0Var.H0();
                } else if (!y10.equals("value")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    y0Var.N0(h0Var, concurrentHashMap, y10);
                } else {
                    number = (Number) y0Var.B0();
                }
            }
            y0Var.h();
            if (number != null) {
                f fVar = new f(number, str);
                fVar.a(concurrentHashMap);
                return fVar;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"value\"");
            h0Var.b(SentryLevel.ERROR, "Missing required field \"value\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public f(Number number, String str) {
        this.f31461a = number;
        this.f31462b = str;
    }

    public void a(Map<String, Object> map) {
        this.f31463c = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("value").G(this.f31461a);
        if (this.f31462b != null) {
            a1Var.N("unit").I(this.f31462b);
        }
        Map<String, Object> map = this.f31463c;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31463c.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }
}
