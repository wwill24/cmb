package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class d {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f4403a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f4404b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f4405c = f();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f4406d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f4407e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f4408f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f4409g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0033d f4410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f4411b;

        a(C0033d dVar, Object obj) {
            this.f4410a = dVar;
            this.f4411b = obj;
        }

        public void run() {
            this.f4410a.f4416a = this.f4411b;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Application f4412a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0033d f4413b;

        b(Application application, C0033d dVar) {
            this.f4412a = application;
            this.f4413b = dVar;
        }

        public void run() {
            this.f4412a.unregisterActivityLifecycleCallbacks(this.f4413b);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f4414a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f4415b;

        c(Object obj, Object obj2) {
            this.f4414a = obj;
            this.f4415b = obj2;
        }

        public void run() {
            try {
                Method method = d.f4406d;
                if (method != null) {
                    method.invoke(this.f4414a, new Object[]{this.f4415b, Boolean.FALSE, "AppCompat recreation"});
                    return;
                }
                d.f4407e.invoke(this.f4414a, new Object[]{this.f4415b, Boolean.FALSE});
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: androidx.core.app.d$d  reason: collision with other inner class name */
    private static final class C0033d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f4416a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f4417b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4418c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4419d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4420e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4421f = false;

        C0033d(@NonNull Activity activity) {
            this.f4417b = activity;
            this.f4418c = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f4417b == activity) {
                this.f4417b = null;
                this.f4420e = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f4420e && !this.f4421f && !this.f4419d && d.h(this.f4416a, this.f4418c, activity)) {
                this.f4421f = true;
                this.f4416a = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f4417b == activity) {
                this.f4419d = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a10 = a();
        f4403a = a10;
        f4406d = d(a10);
        f4407e = c(a10);
        f4408f = e(a10);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 26 || i10 == 27;
    }

    protected static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f4405c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i10) {
                    f4409g.postAtFrontOfQueue(new c(f4404b.get(activity), obj2));
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static boolean i(@NonNull Activity activity) {
        Object obj;
        Application application;
        C0033d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f4408f == null) {
            return false;
        } else {
            if (f4407e == null && f4406d == null) {
                return false;
            }
            try {
                Object obj2 = f4405c.get(activity);
                if (obj2 == null || (obj = f4404b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new C0033d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f4409g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f4408f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
