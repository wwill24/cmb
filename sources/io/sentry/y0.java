package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.vendor.gson.stream.a;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class y0 extends a {
    public y0(Reader reader) {
        super(reader);
    }

    public <T> Map<String, T> A0(h0 h0Var, s0<T> s0Var) throws IOException {
        if (J() == JsonToken.NULL) {
            E();
            return null;
        }
        b();
        HashMap hashMap = new HashMap();
        while (true) {
            try {
                hashMap.put(y(), s0Var.a(this, h0Var));
            } catch (Exception e10) {
                h0Var.b(SentryLevel.ERROR, "Failed to deserialize object in map.", e10);
            }
            if (J() != JsonToken.BEGIN_OBJECT && J() != JsonToken.NAME) {
                h();
                return hashMap;
            }
        }
    }

    public Object B0() throws IOException {
        return new x0().c(this);
    }

    public <T> T E0(h0 h0Var, s0<T> s0Var) throws Exception {
        if (J() != JsonToken.NULL) {
            return s0Var.a(this, h0Var);
        }
        E();
        return null;
    }

    public String H0() throws IOException {
        if (J() != JsonToken.NULL) {
            return G();
        }
        E();
        return null;
    }

    public TimeZone I0(h0 h0Var) throws IOException {
        if (J() == JsonToken.NULL) {
            E();
            return null;
        }
        try {
            return DesugarTimeZone.getTimeZone(G());
        } catch (Exception e10) {
            h0Var.b(SentryLevel.ERROR, "Error when deserializing TimeZone", e10);
            return null;
        }
    }

    public void N0(h0 h0Var, Map<String, Object> map, String str) {
        try {
            map.put(str, B0());
        } catch (Exception e10) {
            h0Var.a(SentryLevel.ERROR, e10, "Error deserializing unknown key: %s", str);
        }
    }

    public Boolean m0() throws IOException {
        if (J() != JsonToken.NULL) {
            return Boolean.valueOf(n());
        }
        E();
        return null;
    }

    public Date q0(h0 h0Var) throws IOException {
        if (J() == JsonToken.NULL) {
            E();
            return null;
        }
        String G = G();
        try {
            return g.e(G);
        } catch (Exception e10) {
            h0Var.b(SentryLevel.DEBUG, "Error when deserializing UTC timestamp format, it might be millis timestamp format.", e10);
            try {
                return g.f(G);
            } catch (Exception e11) {
                h0Var.b(SentryLevel.ERROR, "Error when deserializing millis timestamp format.", e11);
                return null;
            }
        }
    }

    public Double r0() throws IOException {
        if (J() != JsonToken.NULL) {
            return Double.valueOf(u());
        }
        E();
        return null;
    }

    public Float s0() throws IOException {
        return Float.valueOf((float) u());
    }

    public Float t0() throws IOException {
        if (J() != JsonToken.NULL) {
            return s0();
        }
        E();
        return null;
    }

    public Integer u0() throws IOException {
        if (J() != JsonToken.NULL) {
            return Integer.valueOf(v());
        }
        E();
        return null;
    }

    public <T> List<T> v0(h0 h0Var, s0<T> s0Var) throws IOException {
        if (J() == JsonToken.NULL) {
            E();
            return null;
        }
        a();
        ArrayList arrayList = new ArrayList();
        do {
            try {
                arrayList.add(s0Var.a(this, h0Var));
            } catch (Exception e10) {
                h0Var.b(SentryLevel.ERROR, "Failed to deserialize object in list.", e10);
            }
        } while (J() == JsonToken.BEGIN_OBJECT);
        g();
        return arrayList;
    }

    public Long x0() throws IOException {
        if (J() != JsonToken.NULL) {
            return Long.valueOf(x());
        }
        E();
        return null;
    }
}
