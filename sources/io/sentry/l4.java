package io.sentry;

import io.sentry.util.l;
import io.sentry.util.p;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.cli.HelpFormatter;

public final class l4 implements c1 {

    /* renamed from: b  reason: collision with root package name */
    public static final l4 f31327b = new l4(new UUID(0, 0));

    /* renamed from: a  reason: collision with root package name */
    private final String f31328a;

    public static final class a implements s0<l4> {
        /* renamed from: b */
        public l4 a(y0 y0Var, h0 h0Var) throws Exception {
            return new l4(y0Var.G());
        }
    }

    public l4(String str) {
        this.f31328a = (String) l.c(str, "value is required");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l4.class != obj.getClass()) {
            return false;
        }
        return this.f31328a.equals(((l4) obj).f31328a);
    }

    public int hashCode() {
        return this.f31328a.hashCode();
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.I(this.f31328a);
    }

    public String toString() {
        return this.f31328a;
    }

    public l4() {
        this(UUID.randomUUID());
    }

    private l4(UUID uuid) {
        this(p.d(uuid.toString()).replace(HelpFormatter.DEFAULT_OPT_PREFIX, "").substring(0, 16));
    }
}
