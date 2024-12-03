package x3;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f18532a = new ArrayList();

    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Z> f18533a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<R> f18534b;

        /* renamed from: c  reason: collision with root package name */
        final e<Z, R> f18535c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f18533a = cls;
            this.f18534b = cls2;
            this.f18535c = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f18533a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f18534b);
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a next : this.f18532a) {
            if (next.a(cls, cls2)) {
                return next.f18535c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> a10 : this.f18532a) {
            if (a10.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f18532a.add(new a(cls, cls2, eVar));
    }
}
