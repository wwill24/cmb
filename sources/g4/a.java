package g4;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final g<Object> f15184a = new C0162a();

    /* renamed from: g4.a$a  reason: collision with other inner class name */
    class C0162a implements g<Object> {
        C0162a() {
        }

        public void a(@NonNull Object obj) {
        }
    }

    class b implements d<List<T>> {
        b() {
        }

        @NonNull
        /* renamed from: a */
        public List<T> create() {
            return new ArrayList();
        }
    }

    class c implements g<List<T>> {
        c() {
        }

        /* renamed from: b */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    public interface d<T> {
        T create();
    }

    private static final class e<T> implements androidx.core.util.e<T> {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f15185a;

        /* renamed from: b  reason: collision with root package name */
        private final g<T> f15186b;

        /* renamed from: c  reason: collision with root package name */
        private final androidx.core.util.e<T> f15187c;

        e(@NonNull androidx.core.util.e<T> eVar, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f15187c = eVar;
            this.f15185a = dVar;
            this.f15186b = gVar;
        }

        public boolean a(@NonNull T t10) {
            if (t10 instanceof f) {
                ((f) t10).d().b(true);
            }
            this.f15186b.a(t10);
            return this.f15187c.a(t10);
        }

        public T acquire() {
            T acquire = this.f15187c.acquire();
            if (acquire == null) {
                acquire = this.f15185a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Created new ");
                    sb2.append(acquire.getClass());
                }
            }
            if (acquire instanceof f) {
                ((f) acquire).d().b(false);
            }
            return acquire;
        }
    }

    public interface f {
        @NonNull
        c d();
    }

    public interface g<T> {
        void a(@NonNull T t10);
    }

    @NonNull
    private static <T extends f> androidx.core.util.e<T> a(@NonNull androidx.core.util.e<T> eVar, @NonNull d<T> dVar) {
        return b(eVar, dVar, c());
    }

    @NonNull
    private static <T> androidx.core.util.e<T> b(@NonNull androidx.core.util.e<T> eVar, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(eVar, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> c() {
        return f15184a;
    }

    @NonNull
    public static <T extends f> androidx.core.util.e<T> d(int i10, @NonNull d<T> dVar) {
        return a(new androidx.core.util.g(i10), dVar);
    }

    @NonNull
    public static <T> androidx.core.util.e<List<T>> e() {
        return f(20);
    }

    @NonNull
    public static <T> androidx.core.util.e<List<T>> f(int i10) {
        return b(new androidx.core.util.g(i10), new b(), new c());
    }
}
