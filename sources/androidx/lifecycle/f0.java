package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f6023a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Closeable> f6024b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f6025c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f6025c = true;
        Map<String, Object> map = this.f6023a;
        if (map != null) {
            synchronized (map) {
                for (Object b10 : this.f6023a.values()) {
                    b(b10);
                }
            }
        }
        Set<Closeable> set = this.f6024b;
        if (set != null) {
            synchronized (set) {
                for (Closeable b11 : this.f6024b) {
                    b(b11);
                }
            }
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public <T> T c(String str) {
        T t10;
        Map<String, Object> map = this.f6023a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t10 = this.f6023a.get(str);
        }
        return t10;
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: package-private */
    public <T> T e(String str, T t10) {
        T t11;
        synchronized (this.f6023a) {
            t11 = this.f6023a.get(str);
            if (t11 == null) {
                this.f6023a.put(str, t10);
            }
        }
        if (t11 != null) {
            t10 = t11;
        }
        if (this.f6025c) {
            b(t10);
        }
        return t10;
    }
}
