package io.sentry;

import com.facebook.stetho.server.http.HttpStatus;
import com.withpersona.sdk2.inquiry.network.HttpStatusCode;
import java.io.IOException;
import java.util.Locale;

public enum SpanStatus implements c1 {
    OK(200, 299),
    CANCELLED(499),
    INTERNAL_ERROR(500),
    UNKNOWN(500),
    UNKNOWN_ERROR(500),
    INVALID_ARGUMENT(400),
    DEADLINE_EXCEEDED(504),
    NOT_FOUND(404),
    ALREADY_EXISTS(HttpStatusCode.CONFLICT_409),
    PERMISSION_DENIED(403),
    RESOURCE_EXHAUSTED(429),
    FAILED_PRECONDITION(400),
    ABORTED(HttpStatusCode.CONFLICT_409),
    OUT_OF_RANGE(400),
    UNIMPLEMENTED(HttpStatus.HTTP_NOT_IMPLEMENTED),
    UNAVAILABLE(503),
    DATA_LOSS(500),
    UNAUTHENTICATED(401);
    
    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;

    public static final class a implements s0<SpanStatus> {
        /* renamed from: b */
        public SpanStatus a(y0 y0Var, h0 h0Var) throws Exception {
            return SpanStatus.valueOf(y0Var.G().toUpperCase(Locale.ROOT));
        }
    }

    private SpanStatus(int i10) {
        this.minHttpStatusCode = i10;
        this.maxHttpStatusCode = i10;
    }

    public static SpanStatus fromHttpStatusCode(int i10) {
        for (SpanStatus spanStatus : values()) {
            if (spanStatus.matches(i10)) {
                return spanStatus;
            }
        }
        return null;
    }

    private boolean matches(int i10) {
        return i10 >= this.minHttpStatusCode && i10 <= this.maxHttpStatusCode;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.I(name().toLowerCase(Locale.ROOT));
    }

    public static SpanStatus fromHttpStatusCode(Integer num, SpanStatus spanStatus) {
        SpanStatus fromHttpStatusCode = num != null ? fromHttpStatusCode(num.intValue()) : spanStatus;
        return fromHttpStatusCode != null ? fromHttpStatusCode : spanStatus;
    }

    private SpanStatus(int i10, int i11) {
        this.minHttpStatusCode = i10;
        this.maxHttpStatusCode = i11;
    }
}
