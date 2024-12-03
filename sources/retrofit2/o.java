package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;
import retrofit2.f;

class o {

    /* renamed from: c  reason: collision with root package name */
    private static final o f42359c = e();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f42360a;

    /* renamed from: b  reason: collision with root package name */
    private final Constructor<MethodHandles.Lookup> f42361b;

    static final class a extends o {

        /* renamed from: retrofit2.o$a$a  reason: collision with other inner class name */
        static final class C0518a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            private final Handler f42362a = new Handler(Looper.getMainLooper());

            C0518a() {
            }

            public void execute(Runnable runnable) {
                this.f42362a.post(runnable);
            }
        }

        a() {
            super(true);
        }

        public Executor b() {
            return new C0518a();
        }

        /* access modifiers changed from: package-private */
        public Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return o.super.g(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    o(boolean z10) {
        this.f42360a = z10;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z10) {
            Class<MethodHandles.Lookup> cls = MethodHandles.Lookup.class;
            try {
                constructor = cls.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f42361b = constructor;
    }

    private static o e() {
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            return new a();
        }
        return new o(true);
    }

    static o f() {
        return f42359c;
    }

    /* access modifiers changed from: package-private */
    public List<? extends c.a> a(Executor executor) {
        g gVar = new g(executor);
        if (!this.f42360a) {
            return Collections.singletonList(gVar);
        }
        return Arrays.asList(new c.a[]{e.f42265a, gVar});
    }

    /* access modifiers changed from: package-private */
    public Executor b() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<? extends f.a> c() {
        return this.f42360a ? Collections.singletonList(m.f42312a) : Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f42360a ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    @IgnoreJRERequirement
    public Object g(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        MethodHandles.Lookup lookup;
        Constructor<MethodHandles.Lookup> constructor = this.f42361b;
        if (constructor != null) {
            lookup = constructor.newInstance(new Object[]{cls, -1});
        } else {
            lookup = MethodHandles.lookup();
        }
        return lookup.unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    /* access modifiers changed from: package-private */
    @IgnoreJRERequirement
    public boolean h(Method method) {
        return this.f42360a && method.isDefault();
    }
}
