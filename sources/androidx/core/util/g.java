package androidx.core.util;

import androidx.annotation.NonNull;

public class g<T> extends f<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f4739c = new Object();

    public g(int i10) {
        super(i10);
    }

    public boolean a(@NonNull T t10) {
        boolean a10;
        synchronized (this.f4739c) {
            a10 = super.a(t10);
        }
        return a10;
    }

    public T acquire() {
        T acquire;
        synchronized (this.f4739c) {
            acquire = super.acquire();
        }
        return acquire;
    }
}
