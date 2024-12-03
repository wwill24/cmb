package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.core.view.n0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class t1 {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1447a;

    /* renamed from: b  reason: collision with root package name */
    static final boolean f1448b;

    static {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 27) {
            z10 = true;
        } else {
            z10 = false;
        }
        f1448b = z10;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
            f1447a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                f1447a.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f1447a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception unused) {
            }
        }
    }

    public static boolean b(View view) {
        return n0.B(view) == 1;
    }

    public static void c(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
