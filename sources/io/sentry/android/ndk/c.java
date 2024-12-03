package io.sentry.android.ndk;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.d;
import io.sentry.g;
import io.sentry.i0;
import io.sentry.protocol.x;
import io.sentry.util.l;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class c implements i0 {

    /* renamed from: a  reason: collision with root package name */
    private final SentryOptions f31124a;

    /* renamed from: b  reason: collision with root package name */
    private final b f31125b;

    public c(SentryOptions sentryOptions) {
        this(sentryOptions, new NativeScope());
    }

    public void a(String str, String str2) {
        try {
            this.f31125b.a(str, str2);
        } catch (Throwable th2) {
            this.f31124a.getLogger().a(SentryLevel.ERROR, th2, "Scope sync setExtra(%s) has an error.", str);
        }
    }

    public void p(x xVar) {
        if (xVar == null) {
            try {
                this.f31125b.c();
            } catch (Throwable th2) {
                this.f31124a.getLogger().a(SentryLevel.ERROR, th2, "Scope sync setUser has an error.", new Object[0]);
            }
        } else {
            this.f31125b.d(xVar.l(), xVar.k(), xVar.m(), xVar.o());
        }
    }

    public void q(d dVar) {
        String str;
        String str2;
        String g10;
        try {
            str = null;
            if (dVar.h() != null) {
                str2 = dVar.h().name().toLowerCase(Locale.ROOT);
            } else {
                str2 = null;
            }
            g10 = g.g(dVar.j());
            Map<String, Object> g11 = dVar.g();
            if (!g11.isEmpty()) {
                str = this.f31124a.getSerializer().e(g11);
            }
        } catch (Throwable th2) {
            this.f31124a.getLogger().a(SentryLevel.ERROR, th2, "Scope sync addBreadcrumb has an error.", new Object[0]);
            return;
        }
        this.f31125b.b(str2, dVar.i(), dVar.f(), dVar.k(), g10, str);
    }

    c(SentryOptions sentryOptions, b bVar) {
        this.f31124a = (SentryOptions) l.c(sentryOptions, "The SentryOptions object is required.");
        this.f31125b = (b) l.c(bVar, "The NativeScope object is required.");
    }
}
