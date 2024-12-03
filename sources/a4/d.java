package a4;

import androidx.annotation.NonNull;
import androidx.collection.a;
import f4.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<i> f140a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final a<i, List<Class<?>>> f141b = new a<>();

    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f140a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f141b) {
            list = this.f141b.get(andSet);
        }
        this.f140a.set(andSet);
        return list;
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f141b) {
            this.f141b.put(new i(cls, cls2, cls3), list);
        }
    }
}
