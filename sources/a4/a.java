package a4;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0002a<?>> f133a = new ArrayList();

    /* renamed from: a4.a$a  reason: collision with other inner class name */
    private static final class C0002a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f134a;

        /* renamed from: b  reason: collision with root package name */
        final i3.a<T> f135b;

        C0002a(@NonNull Class<T> cls, @NonNull i3.a<T> aVar) {
            this.f134a = cls;
            this.f135b = aVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(@NonNull Class<?> cls) {
            return this.f134a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull i3.a<T> aVar) {
        this.f133a.add(new C0002a(cls, aVar));
    }

    public synchronized <T> i3.a<T> b(@NonNull Class<T> cls) {
        for (C0002a next : this.f133a) {
            if (next.a(cls)) {
                return next.f135b;
            }
        }
        return null;
    }
}
