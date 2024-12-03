package retrofit2;

import com.google.firebase.analytics.FirebaseAnalytics;
import gk.g;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u001b\u0010\u000b\u001a\u00020\n*\u00060\bj\u0002`\tH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"", "T", "Lretrofit2/b;", "a", "(Lretrofit2/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "Lretrofit2/r;", "c", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "d", "(Ljava/lang/Exception;Lkotlin/coroutines/c;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
public final class KotlinExtensions {

    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\n\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$a", "Lretrofit2/d;", "Lretrofit2/b;", "call", "Lretrofit2/r;", "response", "", "onResponse", "", "t", "onFailure", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class a implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f42253a;

        a(n nVar) {
            this.f42253a = nVar;
        }

        public void onFailure(b<T> bVar, Throwable th2) {
            j.h(bVar, "call");
            j.h(th2, "t");
            n nVar = this.f42253a;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(g.a(th2)));
        }

        public void onResponse(b<T> bVar, r<T> rVar) {
            j.h(bVar, "call");
            j.h(rVar, "response");
            if (rVar.g()) {
                T a10 = rVar.a();
                if (a10 == null) {
                    Object i10 = bVar.g().i(k.class);
                    if (i10 == null) {
                        j.s();
                    }
                    j.c(i10, "call.request().tag(Invocation::class.java)!!");
                    Method a11 = ((k) i10).a();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Response from ");
                    j.c(a11, FirebaseAnalytics.Param.METHOD);
                    Class<?> declaringClass = a11.getDeclaringClass();
                    j.c(declaringClass, "method.declaringClass");
                    sb2.append(declaringClass.getName());
                    sb2.append('.');
                    sb2.append(a11.getName());
                    sb2.append(" was null but response body type was declared as non-null");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb2.toString());
                    n nVar = this.f42253a;
                    Result.a aVar = Result.f32010a;
                    nVar.resumeWith(Result.b(g.a(kotlinNullPointerException)));
                    return;
                }
                this.f42253a.resumeWith(Result.b(a10));
                return;
            }
            n nVar2 = this.f42253a;
            HttpException httpException = new HttpException(rVar);
            Result.a aVar2 = Result.f32010a;
            nVar2.resumeWith(Result.b(g.a(httpException)));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J(\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$b", "Lretrofit2/d;", "Lretrofit2/b;", "call", "Lretrofit2/r;", "response", "", "onResponse", "", "t", "onFailure", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class b implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f42254a;

        b(n nVar) {
            this.f42254a = nVar;
        }

        public void onFailure(b<T> bVar, Throwable th2) {
            j.h(bVar, "call");
            j.h(th2, "t");
            n nVar = this.f42254a;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(g.a(th2)));
        }

        public void onResponse(b<T> bVar, r<T> rVar) {
            j.h(bVar, "call");
            j.h(rVar, "response");
            if (rVar.g()) {
                this.f42254a.resumeWith(Result.b(rVar.a()));
                return;
            }
            n nVar = this.f42254a;
            HttpException httpException = new HttpException(rVar);
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(g.a(httpException)));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\n\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$c", "Lretrofit2/d;", "Lretrofit2/b;", "call", "Lretrofit2/r;", "response", "", "onResponse", "", "t", "onFailure", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class c implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f42255a;

        c(n nVar) {
            this.f42255a = nVar;
        }

        public void onFailure(b<T> bVar, Throwable th2) {
            j.h(bVar, "call");
            j.h(th2, "t");
            n nVar = this.f42255a;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(g.a(th2)));
        }

        public void onResponse(b<T> bVar, r<T> rVar) {
            j.h(bVar, "call");
            j.h(rVar, "response");
            this.f42255a.resumeWith(Result.b(rVar));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "retrofit2/KotlinExtensions$suspendAndThrow$2$1"}, k = 3, mv = {1, 1, 15})
    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.c f42256a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Exception f42257b;

        d(kotlin.coroutines.c cVar, Exception exc) {
            this.f42256a = cVar;
            this.f42257b = exc;
        }

        public final void run() {
            kotlin.coroutines.c c10 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f42256a);
            Exception exc = this.f42257b;
            Result.a aVar = Result.f32010a;
            c10.resumeWith(Result.b(g.a(exc)));
        }
    }

    public static final <T> Object a(b<T> bVar, kotlin.coroutines.c<? super T> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.o(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(bVar));
        bVar.L(new a(oVar));
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        return v10;
    }

    public static final <T> Object b(b<T> bVar, kotlin.coroutines.c<? super T> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.o(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(bVar));
        bVar.L(new b(oVar));
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        return v10;
    }

    public static final <T> Object c(b<T> bVar, kotlin.coroutines.c<? super r<T>> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.o(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(bVar));
        bVar.L(new c(oVar));
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        return v10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(java.lang.Exception r4, kotlin.coroutines.c<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            gk.g.b(r5)
            goto L_0x005c
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            gk.g.b(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.x0.a()
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            retrofit2.KotlinExtensions$d r3 = new retrofit2.KotlinExtensions$d
            r3.<init>(r0, r4)
            r5.E(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.b.d()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.b.d()
            if (r4 != r5) goto L_0x0059
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x0059:
            if (r4 != r1) goto L_0x005c
            return r1
        L_0x005c:
            kotlin.Unit r4 = kotlin.Unit.f32013a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.d(java.lang.Exception, kotlin.coroutines.c):java.lang.Object");
    }
}
