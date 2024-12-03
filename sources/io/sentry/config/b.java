package io.sentry.config;

import io.sentry.SentryLevel;
import io.sentry.h0;
import io.sentry.util.a;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f31180a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f31181b;

    /* renamed from: c  reason: collision with root package name */
    private final h0 f31182c;

    public b(String str, ClassLoader classLoader, h0 h0Var) {
        this.f31180a = str;
        this.f31181b = a.a(classLoader);
        this.f31182c = h0Var;
    }

    public Properties a() {
        BufferedInputStream bufferedInputStream;
        try {
            InputStream resourceAsStream = this.f31181b.getResourceAsStream(this.f31180a);
            if (resourceAsStream != null) {
                try {
                    bufferedInputStream = new BufferedInputStream(resourceAsStream);
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    resourceAsStream.close();
                    return properties;
                } catch (Throwable th2) {
                    resourceAsStream.close();
                    throw th2;
                }
            } else {
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return null;
            }
            throw th;
        } catch (IOException e10) {
            this.f31182c.a(SentryLevel.ERROR, e10, "Failed to load Sentry configuration from classpath resource: %s", this.f31180a);
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }

    public b(h0 h0Var) {
        this("sentry.properties", b.class.getClassLoader(), h0Var);
    }
}
