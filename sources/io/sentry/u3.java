package io.sentry;

import io.sentry.protocol.p;
import io.sentry.util.l;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class u3 {

    /* renamed from: c  reason: collision with root package name */
    private static volatile u3 f31711c;

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f31712a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<p> f31713b = new CopyOnWriteArraySet();

    private u3() {
    }

    public static u3 c() {
        if (f31711c == null) {
            synchronized (u3.class) {
                if (f31711c == null) {
                    f31711c = new u3();
                }
            }
        }
        return f31711c;
    }

    public void a(String str) {
        l.c(str, "integration is required.");
        this.f31712a.add(str);
    }

    public void b(String str, String str2) {
        l.c(str, "name is required.");
        l.c(str2, "version is required.");
        this.f31713b.add(new p(str, str2));
    }

    public Set<String> d() {
        return this.f31712a;
    }

    public Set<p> e() {
        return this.f31713b;
    }
}
