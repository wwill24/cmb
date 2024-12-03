package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;
import retrofit2.a;
import retrofit2.c;
import retrofit2.f;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Method, t<?>> f42417a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    final e.a f42418b;

    /* renamed from: c  reason: collision with root package name */
    final t f42419c;

    /* renamed from: d  reason: collision with root package name */
    final List<f.a> f42420d;

    /* renamed from: e  reason: collision with root package name */
    final List<c.a> f42421e;

    /* renamed from: f  reason: collision with root package name */
    final Executor f42422f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f42423g;

    class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final o f42424a = o.f();

        /* renamed from: b  reason: collision with root package name */
        private final Object[] f42425b = new Object[0];

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Class f42426c;

        a(Class cls) {
            this.f42426c = cls;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f42425b;
            }
            if (this.f42424a.h(method)) {
                return this.f42424a.g(method, this.f42426c, obj, objArr);
            }
            return s.this.c(method).a(objArr);
        }
    }

    s(e.a aVar, t tVar, List<f.a> list, List<c.a> list2, Executor executor, boolean z10) {
        this.f42418b = aVar;
        this.f42419c = tVar;
        this.f42420d = list;
        this.f42421e = list2;
        this.f42422f = executor;
        this.f42423g = z10;
    }

    private void j(Class<?> cls) {
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<?> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                    sb2.append(cls2.getName());
                    if (cls2 != cls) {
                        sb2.append(" which is an interface of ");
                        sb2.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb2.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.f42423g) {
                o f10 = o.f();
                for (Method method : cls.getDeclaredMethods()) {
                    if (!f10.h(method) && !Modifier.isStatic(method.getModifiers())) {
                        c(method);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return d((c.a) null, type, annotationArr);
    }

    public <T> T b(Class<T> cls) {
        j(cls);
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    /* access modifiers changed from: package-private */
    public t<?> c(Method method) {
        t<?> tVar;
        t<?> tVar2 = this.f42417a.get(method);
        if (tVar2 != null) {
            return tVar2;
        }
        synchronized (this.f42417a) {
            tVar = this.f42417a.get(method);
            if (tVar == null) {
                tVar = t.b(this, method);
                this.f42417a.put(method, tVar);
            }
        }
        return tVar;
    }

    public c<?, ?> d(c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f42421e.indexOf(aVar) + 1;
        int size = this.f42421e.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            c<?, ?> a10 = this.f42421e.get(i10).a(type, annotationArr, this);
            if (a10 != null) {
                return a10;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f42421e.get(i11).getClass().getName());
            }
            sb2.append(10);
        }
        sb2.append("  Tried:");
        int size2 = this.f42421e.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f42421e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<T, z> e(f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f42420d.indexOf(aVar) + 1;
        int size = this.f42420d.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            f<?, z> c10 = this.f42420d.get(i10).c(type, annotationArr, annotationArr2, this);
            if (c10 != null) {
                return c10;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f42420d.get(i11).getClass().getName());
            }
            sb2.append(10);
        }
        sb2.append("  Tried:");
        int size2 = this.f42420d.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f42420d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<b0, T> f(f.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f42420d.indexOf(aVar) + 1;
        int size = this.f42420d.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            f<b0, ?> d10 = this.f42420d.get(i10).d(type, annotationArr, this);
            if (d10 != null) {
                return d10;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f42420d.get(i11).getClass().getName());
            }
            sb2.append(10);
        }
        sb2.append("  Tried:");
        int size2 = this.f42420d.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f42420d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<T, z> g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e((f.a) null, type, annotationArr, annotationArr2);
    }

    public <T> f<b0, T> h(Type type, Annotation[] annotationArr) {
        return f((f.a) null, type, annotationArr);
    }

    public <T> f<T, String> i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f42420d.size();
        for (int i10 = 0; i10 < size; i10++) {
            f<?, String> e10 = this.f42420d.get(i10).e(type, annotationArr, this);
            if (e10 != null) {
                return e10;
            }
        }
        return a.d.f42262a;
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final o f42428a;

        /* renamed from: b  reason: collision with root package name */
        private e.a f42429b;

        /* renamed from: c  reason: collision with root package name */
        private t f42430c;

        /* renamed from: d  reason: collision with root package name */
        private final List<f.a> f42431d;

        /* renamed from: e  reason: collision with root package name */
        private final List<c.a> f42432e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f42433f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f42434g;

        b(o oVar) {
            this.f42431d = new ArrayList();
            this.f42432e = new ArrayList();
            this.f42428a = oVar;
        }

        public b a(c.a aVar) {
            List<c.a> list = this.f42432e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(f.a aVar) {
            List<f.a> list = this.f42431d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return d(t.h(str));
        }

        public b d(t tVar) {
            Objects.requireNonNull(tVar, "baseUrl == null");
            List<String> n10 = tVar.n();
            if ("".equals(n10.get(n10.size() - 1))) {
                this.f42430c = tVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + tVar);
        }

        public s e() {
            if (this.f42430c != null) {
                e.a aVar = this.f42429b;
                if (aVar == null) {
                    aVar = new x();
                }
                e.a aVar2 = aVar;
                Executor executor = this.f42433f;
                if (executor == null) {
                    executor = this.f42428a.b();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f42432e);
                arrayList.addAll(this.f42428a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f42431d.size() + 1 + this.f42428a.d());
                arrayList2.add(new a());
                arrayList2.addAll(this.f42431d);
                arrayList2.addAll(this.f42428a.c());
                return new s(aVar2, this.f42430c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f42434g);
            }
            throw new IllegalStateException("Base URL required.");
        }

        public b f(e.a aVar) {
            Objects.requireNonNull(aVar, "factory == null");
            this.f42429b = aVar;
            return this;
        }

        public b g(x xVar) {
            Objects.requireNonNull(xVar, "client == null");
            return f(xVar);
        }

        public b() {
            this(o.f());
        }
    }
}
