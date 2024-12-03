package io.sentry.config;

import io.sentry.SentryLevel;
import io.sentry.h0;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f31184a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f31185b;

    public e(String str, h0 h0Var) {
        this.f31184a = str;
        this.f31185b = h0Var;
    }

    public Properties a() {
        BufferedInputStream bufferedInputStream;
        try {
            File file = new File(this.f31184a);
            if (!file.isFile() || !file.canRead()) {
                return null;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            bufferedInputStream.close();
            return properties;
        } catch (IOException e10) {
            this.f31185b.a(SentryLevel.ERROR, e10, "Failed to load Sentry configuration from file: %s", this.f31184a);
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
