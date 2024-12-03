package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.b0;
import okhttp3.z;
import retrofit2.f;
import vn.w;

final class a extends f.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f42258a = true;

    /* renamed from: retrofit2.a$a  reason: collision with other inner class name */
    static final class C0515a implements f<b0, b0> {

        /* renamed from: a  reason: collision with root package name */
        static final C0515a f42259a = new C0515a();

        C0515a() {
        }

        /* renamed from: a */
        public b0 convert(b0 b0Var) throws IOException {
            try {
                return w.a(b0Var);
            } finally {
                b0Var.close();
            }
        }
    }

    static final class b implements f<z, z> {

        /* renamed from: a  reason: collision with root package name */
        static final b f42260a = new b();

        b() {
        }

        /* renamed from: a */
        public z convert(z zVar) {
            return zVar;
        }
    }

    static final class c implements f<b0, b0> {

        /* renamed from: a  reason: collision with root package name */
        static final c f42261a = new c();

        c() {
        }

        /* renamed from: a */
        public b0 convert(b0 b0Var) {
            return b0Var;
        }
    }

    static final class d implements f<Object, String> {

        /* renamed from: a  reason: collision with root package name */
        static final d f42262a = new d();

        d() {
        }

        /* renamed from: a */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    static final class e implements f<b0, Unit> {

        /* renamed from: a  reason: collision with root package name */
        static final e f42263a = new e();

        e() {
        }

        /* renamed from: a */
        public Unit convert(b0 b0Var) {
            b0Var.close();
            return Unit.f32013a;
        }
    }

    static final class f implements f<b0, Void> {

        /* renamed from: a  reason: collision with root package name */
        static final f f42264a = new f();

        f() {
        }

        /* renamed from: a */
        public Void convert(b0 b0Var) {
            b0Var.close();
            return null;
        }
    }

    a() {
    }

    public f<?, z> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        if (z.class.isAssignableFrom(w.h(type))) {
            return b.f42260a;
        }
        return null;
    }

    public f<b0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        if (type == b0.class) {
            if (w.l(annotationArr, w.class)) {
                return c.f42261a;
            }
            return C0515a.f42259a;
        } else if (type == Void.class) {
            return f.f42264a;
        } else {
            if (!this.f42258a || type != Unit.class) {
                return null;
            }
            try {
                return e.f42263a;
            } catch (NoClassDefFoundError unused) {
                this.f42258a = false;
                return null;
            }
        }
    }
}
