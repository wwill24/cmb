package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.util.p;
import io.sentry.y0;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.cli.HelpFormatter;

public final class o implements c1 {

    /* renamed from: b  reason: collision with root package name */
    public static final o f31517b = new o(new UUID(0, 0));

    /* renamed from: a  reason: collision with root package name */
    private final UUID f31518a;

    public static final class a implements s0<o> {
        /* renamed from: b */
        public o a(y0 y0Var, h0 h0Var) throws Exception {
            return new o(y0Var.G());
        }
    }

    public o() {
        this((UUID) null);
    }

    private UUID a(String str) {
        if (str.length() == 32) {
            str = new StringBuilder(str).insert(8, HelpFormatter.DEFAULT_OPT_PREFIX).insert(13, HelpFormatter.DEFAULT_OPT_PREFIX).insert(18, HelpFormatter.DEFAULT_OPT_PREFIX).insert(23, HelpFormatter.DEFAULT_OPT_PREFIX).toString();
        }
        if (str.length() == 36) {
            return UUID.fromString(str);
        }
        throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: " + str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        if (this.f31518a.compareTo(((o) obj).f31518a) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f31518a.hashCode();
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.I(toString());
    }

    public String toString() {
        return p.d(this.f31518a.toString()).replace(HelpFormatter.DEFAULT_OPT_PREFIX, "");
    }

    public o(UUID uuid) {
        this.f31518a = uuid == null ? UUID.randomUUID() : uuid;
    }

    public o(String str) {
        this.f31518a = a(p.d(str));
    }
}
