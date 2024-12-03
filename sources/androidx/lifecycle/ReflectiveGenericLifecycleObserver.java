package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b;

@Deprecated
class ReflectiveGenericLifecycleObserver implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Object f5964a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f5965b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f5964a = obj;
        this.f5965b = b.f6001c.c(obj.getClass());
    }

    public void e(@NonNull l lVar, @NonNull Lifecycle.Event event) {
        this.f5965b.a(lVar, event, this.f5964a);
    }
}
