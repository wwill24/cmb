package p3;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import i3.e;
import j3.d;
import p3.n;

public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f16989a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f16990a = new a<>();

        public static <T> a<T> b() {
            return f16990a;
        }

        public void a() {
        }

        @NonNull
        public n<Model, Model> c(r rVar) {
            return v.c();
        }
    }

    private static class b<Model> implements d<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f16991a;

        b(Model model) {
            this.f16991a = model;
        }

        @NonNull
        public Class<Model> a() {
            return this.f16991a.getClass();
        }

        public void b() {
        }

        public void cancel() {
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.f(this.f16991a);
        }

        @NonNull
        public DataSource e() {
            return DataSource.LOCAL;
        }
    }

    public static <T> v<T> c() {
        return f16989a;
    }

    public boolean a(@NonNull Model model) {
        return true;
    }

    public n.a<Model> b(@NonNull Model model, int i10, int i11, @NonNull e eVar) {
        return new n.a<>(new e4.d(model), new b(model));
    }
}
