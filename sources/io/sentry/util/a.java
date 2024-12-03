package io.sentry.util;

public final class a {
    public static ClassLoader a(ClassLoader classLoader) {
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }
}
