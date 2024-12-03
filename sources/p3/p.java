package p3;

import androidx.annotation.NonNull;
import androidx.core.util.e;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f16959a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16960b;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0187a<?>> f16961a = new HashMap();

        /* renamed from: p3.p$a$a  reason: collision with other inner class name */
        private static class C0187a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f16962a;

            public C0187a(List<n<Model, ?>> list) {
                this.f16962a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f16961a.clear();
        }

        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0187a aVar = this.f16961a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f16962a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f16961a.put(cls, new C0187a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public p(@NonNull e<List<Throwable>> eVar) {
        this(new r(eVar));
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a10) {
        return a10.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> e(@NonNull Class<A> cls) {
        List<n<A, ?>> b10;
        b10 = this.f16960b.b(cls);
        if (b10 == null) {
            b10 = Collections.unmodifiableList(this.f16959a.c(cls));
            this.f16960b.c(cls, b10);
        }
        return b10;
    }

    private <Model, Data> void g(@NonNull List<o<? extends Model, ? extends Data>> list) {
        for (o<? extends Model, ? extends Data> a10 : list) {
            a10.a();
        }
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f16959a.b(cls, cls2, oVar);
        this.f16960b.a();
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        return this.f16959a.g(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> d(@NonNull A a10) {
        List e10 = e(b(a10));
        if (!e10.isEmpty()) {
            int size = e10.size();
            List<n<A, ?>> emptyList = Collections.emptyList();
            boolean z10 = true;
            for (int i10 = 0; i10 < size; i10++) {
                n nVar = (n) e10.get(i10);
                if (nVar.a(a10)) {
                    if (z10) {
                        emptyList = new ArrayList<>(size - i10);
                        z10 = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a10, e10);
        }
        throw new Registry.NoModelLoaderAvailableException(a10);
    }

    public synchronized <Model, Data> void f(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        g(this.f16959a.j(cls, cls2, oVar));
        this.f16960b.a();
    }

    private p(@NonNull r rVar) {
        this.f16960b = new a();
        this.f16959a = rVar;
    }
}
