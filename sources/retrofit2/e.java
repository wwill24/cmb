package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;

@IgnoreJRERequirement
final class e extends c.a {

    /* renamed from: a  reason: collision with root package name */
    static final c.a f42265a = new e();

    @IgnoreJRERequirement
    private static final class a<R> implements c<R, CompletableFuture<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final Type f42266a;

        @IgnoreJRERequirement
        /* renamed from: retrofit2.e$a$a  reason: collision with other inner class name */
        private class C0516a implements d<R> {

            /* renamed from: a  reason: collision with root package name */
            private final CompletableFuture<R> f42267a;

            public C0516a(CompletableFuture<R> completableFuture) {
                this.f42267a = completableFuture;
            }

            public void onFailure(b<R> bVar, Throwable th2) {
                this.f42267a.completeExceptionally(th2);
            }

            public void onResponse(b<R> bVar, r<R> rVar) {
                if (rVar.g()) {
                    this.f42267a.complete(rVar.a());
                } else {
                    this.f42267a.completeExceptionally(new HttpException(rVar));
                }
            }
        }

        a(Type type) {
            this.f42266a = type;
        }

        public Type a() {
            return this.f42266a;
        }

        /* renamed from: c */
        public CompletableFuture<R> b(b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.L(new C0516a(bVar2));
            return bVar2;
        }
    }

    @IgnoreJRERequirement
    private static final class b<T> extends CompletableFuture<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b<?> f42269a;

        b(b<?> bVar) {
            this.f42269a = bVar;
        }

        public boolean cancel(boolean z10) {
            if (z10) {
                this.f42269a.cancel();
            }
            return super.cancel(z10);
        }
    }

    @IgnoreJRERequirement
    private static final class c<R> implements c<R, CompletableFuture<r<R>>> {

        /* renamed from: a  reason: collision with root package name */
        private final Type f42270a;

        @IgnoreJRERequirement
        private class a implements d<R> {

            /* renamed from: a  reason: collision with root package name */
            private final CompletableFuture<r<R>> f42271a;

            public a(CompletableFuture<r<R>> completableFuture) {
                this.f42271a = completableFuture;
            }

            public void onFailure(b<R> bVar, Throwable th2) {
                this.f42271a.completeExceptionally(th2);
            }

            public void onResponse(b<R> bVar, r<R> rVar) {
                this.f42271a.complete(rVar);
            }
        }

        c(Type type) {
            this.f42270a = type;
        }

        public Type a() {
            return this.f42270a;
        }

        /* renamed from: c */
        public CompletableFuture<r<R>> b(b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.L(new a(bVar2));
            return bVar2;
        }
    }

    e() {
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.c(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type b10 = c.a.b(0, (ParameterizedType) type);
            if (c.a.c(b10) != r.class) {
                return new a(b10);
            }
            if (b10 instanceof ParameterizedType) {
                return new c(c.a.b(0, (ParameterizedType) b10));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
