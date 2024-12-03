package io.sentry;

public interface q0 {
    String b() {
        return getClass().getSimpleName().replace("Sentry", "").replace("Integration", "").replace("Interceptor", "");
    }

    void c() {
        u3.c().a(b());
    }
}
