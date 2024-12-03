package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.y;
import retrofit2.c;

final class g extends c.a {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f42273a;

    class a implements c<Object, b<?>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f42274a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Executor f42275b;

        a(Type type, Executor executor) {
            this.f42274a = type;
            this.f42275b = executor;
        }

        public Type a() {
            return this.f42274a;
        }

        /* renamed from: c */
        public b<Object> b(b<Object> bVar) {
            Executor executor = this.f42275b;
            return executor == null ? bVar : new b(executor, bVar);
        }
    }

    static final class b<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final Executor f42277a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f42278b;

        class a implements d<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f42279a;

            a(d dVar) {
                this.f42279a = dVar;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void c(d dVar, Throwable th2) {
                dVar.onFailure(b.this, th2);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void d(d dVar, r rVar) {
                if (b.this.f42278b.m()) {
                    dVar.onFailure(b.this, new IOException("Canceled"));
                } else {
                    dVar.onResponse(b.this, rVar);
                }
            }

            public void onFailure(b<T> bVar, Throwable th2) {
                b.this.f42277a.execute(new i(this, this.f42279a, th2));
            }

            public void onResponse(b<T> bVar, r<T> rVar) {
                b.this.f42277a.execute(new h(this, this.f42279a, rVar));
            }
        }

        b(Executor executor, b<T> bVar) {
            this.f42277a = executor;
            this.f42278b = bVar;
        }

        public void L(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.f42278b.L(new a(dVar));
        }

        public void cancel() {
            this.f42278b.cancel();
        }

        public r<T> f() throws IOException {
            return this.f42278b.f();
        }

        public y g() {
            return this.f42278b.g();
        }

        public boolean m() {
            return this.f42278b.m();
        }

        public b<T> clone() {
            return new b(this.f42277a, this.f42278b.clone());
        }
    }

    g(Executor executor) {
        this.f42273a = executor;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        Executor executor = null;
        if (c.a.c(type) != b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type g10 = w.g(0, (ParameterizedType) type);
            if (!w.l(annotationArr, u.class)) {
                executor = this.f42273a;
            }
            return new a(g10, executor);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
