package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w1.b;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f7041d;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f7042e = new Object();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f7043a = new HashMap();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends v1.a<?>>> f7044b = new HashSet();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final Context f7045c;

    a(@NonNull Context context) {
        this.f7045c = context.getApplicationContext();
    }

    @NonNull
    private <T> T d(@NonNull Class<? extends v1.a<?>> cls, @NonNull Set<Class<?>> set) {
        T t10;
        if (b.d()) {
            try {
                b.a(cls.getSimpleName());
            } catch (Throwable th2) {
                b.b();
                throw th2;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f7043a.containsKey(cls)) {
                set.add(cls);
                v1.a aVar = (v1.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends v1.a<?>>> a10 = aVar.a();
                if (!a10.isEmpty()) {
                    for (Class next : a10) {
                        if (!this.f7043a.containsKey(next)) {
                            d(next, set);
                        }
                    }
                }
                t10 = aVar.b(this.f7045c);
                set.remove(cls);
                this.f7043a.put(cls, t10);
            } else {
                t10 = this.f7043a.get(cls);
            }
            b.b();
            return t10;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    @NonNull
    public static a e(@NonNull Context context) {
        if (f7041d == null) {
            synchronized (f7042e) {
                if (f7041d == null) {
                    f7041d = new a(context);
                }
            }
        }
        return f7041d;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            b.a("Startup");
            b(this.f7045c.getPackageManager().getProviderInfo(new ComponentName(this.f7045c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            b.b();
        } catch (PackageManager.NameNotFoundException e10) {
            throw new StartupException((Throwable) e10);
        } catch (Throwable th2) {
            b.b();
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        String string = this.f7045c.getString(v1.b.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String next : bundle.keySet()) {
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (v1.a.class.isAssignableFrom(cls)) {
                            this.f7044b.add(cls);
                        }
                    }
                }
                for (Class<? extends v1.a<?>> d10 : this.f7044b) {
                    d(d10, hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException((Throwable) e10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <T> T c(@NonNull Class<? extends v1.a<?>> cls) {
        T t10;
        synchronized (f7042e) {
            t10 = this.f7043a.get(cls);
            if (t10 == null) {
                t10 = d(cls, new HashSet());
            }
        }
        return t10;
    }

    @NonNull
    public <T> T f(@NonNull Class<? extends v1.a<T>> cls) {
        return c(cls);
    }

    public boolean g(@NonNull Class<? extends v1.a<?>> cls) {
        return this.f7044b.contains(cls);
    }
}
