package io.sentry.clientreport;

import io.sentry.SentryLevel;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.clientreport.e;
import io.sentry.g;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class b implements c1 {

    /* renamed from: a  reason: collision with root package name */
    private final Date f31167a;

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f31168b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f31169c;

    public static final class a implements s0<b> {
        private Exception c(String str, h0 h0Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            h0Var.b(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* renamed from: b */
        public b a(y0 y0Var, h0 h0Var) throws Exception {
            ArrayList arrayList = new ArrayList();
            y0Var.b();
            Date date = null;
            HashMap hashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                if (y10.equals("discarded_events")) {
                    arrayList.addAll(y0Var.v0(h0Var, new e.a()));
                } else if (!y10.equals("timestamp")) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    y0Var.N0(h0Var, hashMap, y10);
                } else {
                    date = y0Var.q0(h0Var);
                }
            }
            y0Var.h();
            if (date == null) {
                throw c("timestamp", h0Var);
            } else if (!arrayList.isEmpty()) {
                b bVar = new b(date, arrayList);
                bVar.b(hashMap);
                return bVar;
            } else {
                throw c("discarded_events", h0Var);
            }
        }
    }

    public b(Date date, List<e> list) {
        this.f31167a = date;
        this.f31168b = list;
    }

    public List<e> a() {
        return this.f31168b;
    }

    public void b(Map<String, Object> map) {
        this.f31169c = map;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        a1Var.N("timestamp").I(g.g(this.f31167a));
        a1Var.N("discarded_events").O(h0Var, this.f31168b);
        Map<String, Object> map = this.f31169c;
        if (map != null) {
            for (String next : map.keySet()) {
                a1Var.N(next).O(h0Var, this.f31169c.get(next));
            }
        }
        a1Var.h();
    }
}
