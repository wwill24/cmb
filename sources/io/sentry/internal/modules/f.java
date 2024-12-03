package io.sentry.internal.modules;

import io.sentry.SentryLevel;
import io.sentry.h0;
import io.sentry.util.a;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class f extends d {

    /* renamed from: d  reason: collision with root package name */
    private final ClassLoader f31301d;

    public f(h0 h0Var) {
        this(h0Var, f.class.getClassLoader());
    }

    /* access modifiers changed from: protected */
    public Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream resourceAsStream = this.f31301d.getResourceAsStream("sentry-external-modules.txt");
            if (resourceAsStream != null) {
                return c(resourceAsStream);
            }
            this.f31298a.c(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (SecurityException e10) {
            this.f31298a.b(SentryLevel.INFO, "Access to resources denied.", e10);
            return treeMap;
        }
    }

    f(h0 h0Var, ClassLoader classLoader) {
        super(h0Var);
        this.f31301d = a.a(classLoader);
    }
}
