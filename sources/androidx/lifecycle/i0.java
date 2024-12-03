package androidx.lifecycle;

import android.app.Application;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import m1.a;
import org.jivesoftware.smackx.hints.element.StoreHint;

public class i0 {

    /* renamed from: a  reason: collision with root package name */
    private final k0 f6033a;

    /* renamed from: b  reason: collision with root package name */
    private final b f6034b;

    /* renamed from: c  reason: collision with root package name */
    private final m1.a f6035c;

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6041a = a.f6042a;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ a f6042a = new a();

            private a() {
            }
        }

        <T extends f0> T a(Class<T> cls) {
            j.g(cls, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        <T extends f0> T b(Class<T> cls, m1.a aVar) {
            j.g(cls, "modelClass");
            j.g(aVar, "extras");
            return a(cls);
        }
    }

    public static class c implements b {

        /* renamed from: b  reason: collision with root package name */
        public static final a f6043b = new a((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static c f6044c;

        /* renamed from: d  reason: collision with root package name */
        public static final a.b<String> f6045d = a.C0064a.f6046a;

        public static final class a {

            /* renamed from: androidx.lifecycle.i0$c$a$a  reason: collision with other inner class name */
            private static final class C0064a implements a.b<String> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0064a f6046a = new C0064a();

                private C0064a() {
                }
            }

            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final c a() {
                if (c.f6044c == null) {
                    c.f6044c = new c();
                }
                c c10 = c.f6044c;
                j.d(c10);
                return c10;
            }
        }

        public <T extends f0> T a(Class<T> cls) {
            j.g(cls, "modelClass");
            try {
                T newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                j.f(newInstance, "{\n                modelC…wInstance()\n            }");
                return (f0) newInstance;
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (IllegalAccessException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            }
        }
    }

    public static class d {
        public void c(f0 f0Var) {
            j.g(f0Var, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i0(k0 k0Var, b bVar) {
        this(k0Var, bVar, (m1.a) null, 4, (DefaultConstructorMarker) null);
        j.g(k0Var, StoreHint.ELEMENT);
        j.g(bVar, "factory");
    }

    public i0(k0 k0Var, b bVar, m1.a aVar) {
        j.g(k0Var, StoreHint.ELEMENT);
        j.g(bVar, "factory");
        j.g(aVar, "defaultCreationExtras");
        this.f6033a = k0Var;
        this.f6034b = bVar;
        this.f6035c = aVar;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends f0> T b(String str, Class<T> cls) {
        T t10;
        d dVar;
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(cls, "modelClass");
        T b10 = this.f6033a.b(str);
        if (cls.isInstance(b10)) {
            b bVar = this.f6034b;
            if (bVar instanceof d) {
                dVar = (d) bVar;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                j.d(b10);
                dVar.c(b10);
            }
            j.e(b10, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return b10;
        }
        m1.d dVar2 = new m1.d(this.f6035c);
        dVar2.c(c.f6045d, str);
        try {
            t10 = this.f6034b.b(cls, dVar2);
        } catch (AbstractMethodError unused) {
            t10 = this.f6034b.a(cls);
        }
        this.f6033a.d(str, t10);
        return t10;
    }

    public static class a extends c {

        /* renamed from: f  reason: collision with root package name */
        public static final C0062a f6036f = new C0062a((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public static a f6037g;

        /* renamed from: h  reason: collision with root package name */
        public static final a.b<Application> f6038h = C0062a.C0063a.f6040a;

        /* renamed from: e  reason: collision with root package name */
        private final Application f6039e;

        /* renamed from: androidx.lifecycle.i0$a$a  reason: collision with other inner class name */
        public static final class C0062a {

            /* renamed from: androidx.lifecycle.i0$a$a$a  reason: collision with other inner class name */
            private static final class C0063a implements a.b<Application> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0063a f6040a = new C0063a();

                private C0063a() {
                }
            }

            private C0062a() {
            }

            public /* synthetic */ C0062a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(l0 l0Var) {
                j.g(l0Var, "owner");
                if (l0Var instanceof f) {
                    return ((f) l0Var).getDefaultViewModelProviderFactory();
                }
                return c.f6043b.a();
            }

            public final a b(Application application) {
                j.g(application, "application");
                if (a.f6037g == null) {
                    a.f6037g = new a(application);
                }
                a e10 = a.f6037g;
                j.d(e10);
                return e10;
            }
        }

        private a(Application application, int i10) {
            this.f6039e = application;
        }

        private final <T extends f0> T g(Class<T> cls, Application application) {
            if (!a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                T t10 = (f0) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application});
                j.f(t10, "{\n                try {\n…          }\n            }");
                return t10;
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }

        public <T extends f0> T a(Class<T> cls) {
            j.g(cls, "modelClass");
            Application application = this.f6039e;
            if (application != null) {
                return g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public <T extends f0> T b(Class<T> cls, m1.a aVar) {
            j.g(cls, "modelClass");
            j.g(aVar, "extras");
            if (this.f6039e != null) {
                return a(cls);
            }
            Application application = (Application) aVar.a(f6038h);
            if (application != null) {
                return g(cls, application);
            }
            if (!a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public a() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            j.g(application, "application");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(k0 k0Var, b bVar, m1.a aVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(k0Var, bVar, (i10 & 4) != 0 ? a.C0171a.f16279b : aVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i0(l0 l0Var) {
        this(l0Var.getViewModelStore(), a.f6036f.a(l0Var), j0.a(l0Var));
        j.g(l0Var, "owner");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i0(l0 l0Var, b bVar) {
        this(l0Var.getViewModelStore(), bVar, j0.a(l0Var));
        j.g(l0Var, "owner");
        j.g(bVar, "factory");
    }
}
