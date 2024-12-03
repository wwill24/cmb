package io.sentry.protocol;

import com.facebook.internal.ServerProtocol;
import io.sentry.SentryLevel;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class p implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private String f31519a;

    /* renamed from: b  reason: collision with root package name */
    private String f31520b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f31521c;

    public static final class a implements s0<p> {
        /* renamed from: b */
        public p a(y0 y0Var, h0 h0Var) throws Exception {
            y0Var.b();
            String str = null;
            String str2 = null;
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("name")) {
                    str = y0Var.G();
                } else if (!y10.equals(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    y0Var.N0(h0Var, hashMap, y10);
                } else {
                    str2 = y0Var.G();
                }
            }
            y0Var.h();
            if (str == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                h0Var.b(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            } else if (str2 != null) {
                p pVar = new p(str, str2);
                pVar.a(hashMap);
                return pVar;
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                h0Var.b(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
        }
    }

    public p(String str, String str2) {
        this.f31519a = (String) l.c(str, "name is required.");
        this.f31520b = (String) l.c(str2, "version is required.");
    }

    public void a(Map<String, Object> map) {
        this.f31521c = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (!Objects.equals(this.f31519a, pVar.f31519a) || !Objects.equals(this.f31520b, pVar.f31520b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f31519a, this.f31520b});
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("name").I(this.f31519a);
        a1Var.N(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION).I(this.f31520b);
        Map<String, Object> map = this.f31521c;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31521c.get(next));
            }
        }
        a1Var.h();
    }
}
