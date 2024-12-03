package retrofit2;

import java.util.Objects;

public class HttpException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final transient r<?> f42252a;
    private final int code;
    private final String message;

    public HttpException(r<?> rVar) {
        super(a(rVar));
        this.code = rVar.b();
        this.message = rVar.h();
        this.f42252a = rVar;
    }

    private static String a(r<?> rVar) {
        Objects.requireNonNull(rVar, "response == null");
        return "HTTP " + rVar.b() + " " + rVar.h();
    }
}
