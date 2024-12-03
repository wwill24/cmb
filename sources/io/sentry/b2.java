package io.sentry;

import io.sentry.util.l;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    private final URL f31142a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f31143b;

    public b2(String str, Map<String, String> map) {
        l.c(str, "url is required");
        l.c(map, "headers is required");
        try {
            this.f31142a = URI.create(str).toURL();
            this.f31143b = map;
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e10);
        }
    }

    public Map<String, String> a() {
        return this.f31143b;
    }

    public URL b() {
        return this.f31142a;
    }
}
