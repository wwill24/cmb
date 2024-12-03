package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

class q {

    /* renamed from: a  reason: collision with root package name */
    private static Field f579a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f580b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f581c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f582d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f583e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f584f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f585g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f586h;

    static class a {
        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    static void a(@NonNull Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            b(resources);
        }
    }

    private static void b(@NonNull Resources resources) {
        Object obj;
        if (!f586h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f585g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f586h = true;
        }
        Field field = f585g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
                obj = null;
            }
            if (obj != null) {
                if (!f580b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f579a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    f580b = true;
                }
                Field field2 = f579a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException unused4) {
                    }
                }
                if (obj2 != null) {
                    c(obj2);
                }
            }
        }
    }

    private static void c(@NonNull Object obj) {
        if (!f582d) {
            try {
                f581c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            f582d = true;
        }
        Class<?> cls = f581c;
        if (cls != null) {
            if (!f584f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f583e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused2) {
                }
                f584f = true;
            }
            Field field = f583e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException unused3) {
                }
                if (longSparseArray != null) {
                    a.a(longSparseArray);
                }
            }
        }
    }
}
