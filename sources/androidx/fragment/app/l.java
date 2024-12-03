package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.collection.g;
import androidx.fragment.app.Fragment;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final g<ClassLoader, g<String, Class<?>>> f5860a = new g<>();

    static boolean b(@NonNull ClassLoader classLoader, @NonNull String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @NonNull
    private static Class<?> c(@NonNull ClassLoader classLoader, @NonNull String str) throws ClassNotFoundException {
        g<ClassLoader, g<String, Class<?>>> gVar = f5860a;
        g gVar2 = gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new g();
            gVar.put(classLoader, gVar2);
        }
        Class<?> cls = (Class) gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    @NonNull
    public static Class<? extends Fragment> d(@NonNull ClassLoader classLoader, @NonNull String str) {
        try {
            return c(classLoader, str);
        } catch (ClassNotFoundException e10) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e10);
        } catch (ClassCastException e11) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e11);
        }
    }

    @NonNull
    public Fragment a(@NonNull ClassLoader classLoader, @NonNull String str) {
        throw null;
    }
}
