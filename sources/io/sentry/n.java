package io.sentry;

import io.sentry.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class n implements t {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Throwable, Object> f31343a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final SentryOptions f31344b;

    public n(SentryOptions sentryOptions) {
        this.f31344b = (SentryOptions) l.c(sentryOptions, "options are required");
    }

    private static List<Throwable> c(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        while (th2.getCause() != null) {
            arrayList.add(th2.getCause());
            th2 = th2.getCause();
        }
        return arrayList;
    }

    private static <T> boolean d(Map<T, Object> map, List<T> list) {
        for (T containsKey : list) {
            if (map.containsKey(containsKey)) {
                return true;
            }
        }
        return false;
    }

    public p3 a(p3 p3Var, w wVar) {
        if (this.f31344b.isEnableDeduplication()) {
            Throwable O = p3Var.O();
            if (O != null) {
                if (this.f31343a.containsKey(O) || d(this.f31343a, c(O))) {
                    this.f31344b.getLogger().c(SentryLevel.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", p3Var.G());
                    return null;
                }
                this.f31343a.put(O, (Object) null);
            }
        } else {
            this.f31344b.getLogger().c(SentryLevel.DEBUG, "Event deduplication is disabled.", new Object[0]);
        }
        return p3Var;
    }
}
