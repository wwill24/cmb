package retrofit2;

import com.google.firebase.perf.FirebasePerformance;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.e;
import retrofit2.w;

abstract class j<ResponseT, ReturnT> extends t<ReturnT> {

    /* renamed from: a  reason: collision with root package name */
    private final q f42287a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f42288b;

    /* renamed from: c  reason: collision with root package name */
    private final f<b0, ResponseT> f42289c;

    static final class a<ResponseT, ReturnT> extends j<ResponseT, ReturnT> {

        /* renamed from: d  reason: collision with root package name */
        private final c<ResponseT, ReturnT> f42290d;

        a(q qVar, e.a aVar, f<b0, ResponseT> fVar, c<ResponseT, ReturnT> cVar) {
            super(qVar, aVar, fVar);
            this.f42290d = cVar;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [retrofit2.b, retrofit2.b<ResponseT>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ReturnT c(retrofit2.b<ResponseT> r1, java.lang.Object[] r2) {
            /*
                r0 = this;
                retrofit2.c<ResponseT, ReturnT> r2 = r0.f42290d
                java.lang.Object r1 = r2.b(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.j.a.c(retrofit2.b, java.lang.Object[]):java.lang.Object");
        }
    }

    static final class b<ResponseT> extends j<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final c<ResponseT, b<ResponseT>> f42291d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f42292e;

        b(q qVar, e.a aVar, f<b0, ResponseT> fVar, c<ResponseT, b<ResponseT>> cVar, boolean z10) {
            super(qVar, aVar, fVar);
            this.f42291d = cVar;
            this.f42292e = z10;
        }

        /* access modifiers changed from: protected */
        public Object c(b<ResponseT> bVar, Object[] objArr) {
            b bVar2 = (b) this.f42291d.b(bVar);
            kotlin.coroutines.c cVar = objArr[objArr.length - 1];
            try {
                if (this.f42292e) {
                    return KotlinExtensions.b(bVar2, cVar);
                }
                return KotlinExtensions.a(bVar2, cVar);
            } catch (Exception e10) {
                return KotlinExtensions.d(e10, cVar);
            }
        }
    }

    static final class c<ResponseT> extends j<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final c<ResponseT, b<ResponseT>> f42293d;

        c(q qVar, e.a aVar, f<b0, ResponseT> fVar, c<ResponseT, b<ResponseT>> cVar) {
            super(qVar, aVar, fVar);
            this.f42293d = cVar;
        }

        /* access modifiers changed from: protected */
        public Object c(b<ResponseT> bVar, Object[] objArr) {
            b bVar2 = (b) this.f42293d.b(bVar);
            kotlin.coroutines.c cVar = objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(bVar2, cVar);
            } catch (Exception e10) {
                return KotlinExtensions.d(e10, cVar);
            }
        }
    }

    j(q qVar, e.a aVar, f<b0, ResponseT> fVar) {
        this.f42287a = qVar;
        this.f42288b = aVar;
        this.f42289c = fVar;
    }

    private static <ResponseT, ReturnT> c<ResponseT, ReturnT> d(s sVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return sVar.a(type, annotationArr);
        } catch (RuntimeException e10) {
            throw w.n(method, e10, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> f<b0, ResponseT> e(s sVar, Method method, Type type) {
        try {
            return sVar.h(type, method.getAnnotations());
        } catch (RuntimeException e10) {
            throw w.n(method, e10, "Unable to create converter for %s", type);
        }
    }

    static <ResponseT, ReturnT> j<ResponseT, ReturnT> f(s sVar, Method method, q qVar) {
        Type type;
        boolean z10;
        Class<r> cls = r.class;
        boolean z11 = qVar.f42388k;
        Annotation[] annotations = method.getAnnotations();
        if (z11) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type f10 = w.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (w.h(f10) != cls || !(f10 instanceof ParameterizedType)) {
                z10 = false;
            } else {
                f10 = w.g(0, (ParameterizedType) f10);
                z10 = true;
            }
            type = new w.b((Type) null, b.class, f10);
            annotations = v.a(annotations);
        } else {
            type = method.getGenericReturnType();
            z10 = false;
        }
        c d10 = d(sVar, method, type, annotations);
        Type a10 = d10.a();
        if (a10 == a0.class) {
            throw w.m(method, "'" + w.h(a10).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (a10 == cls) {
            throw w.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else if (!qVar.f42380c.equals(FirebasePerformance.HttpMethod.HEAD) || Void.class.equals(a10)) {
            f e10 = e(sVar, method, a10);
            e.a aVar = sVar.f42418b;
            if (!z11) {
                return new a(qVar, aVar, e10, d10);
            }
            if (z10) {
                return new c(qVar, aVar, e10, d10);
            }
            return new b(qVar, aVar, e10, d10, false);
        } else {
            throw w.m(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public final ReturnT a(Object[] objArr) {
        return c(new l(this.f42287a, objArr, this.f42288b, this.f42289c), objArr);
    }

    /* access modifiers changed from: protected */
    public abstract ReturnT c(b<ResponseT> bVar, Object[] objArr);
}
