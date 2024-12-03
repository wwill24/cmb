package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class k0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1308a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1309b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f1310c = new Rect();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f1311a;

        /* renamed from: b  reason: collision with root package name */
        private static final Method f1312b;

        /* renamed from: c  reason: collision with root package name */
        private static final Field f1313c;

        /* renamed from: d  reason: collision with root package name */
        private static final Field f1314d;

        /* renamed from: e  reason: collision with root package name */
        private static final Field f1315e;

        /* renamed from: f  reason: collision with root package name */
        private static final Field f1316f;

        /* JADX WARNING: Removed duplicated region for block: B:43:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0058  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x0037, NoSuchFieldException -> 0x0035 }
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch:{ NoSuchMethodException -> 0x0033, ClassNotFoundException -> 0x0031, NoSuchFieldException -> 0x002f }
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002d }
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x0047 }
                r8 = r0
                goto L_0x0049
            L_0x002d:
                r7 = r2
                goto L_0x0047
            L_0x002f:
                r6 = r2
                goto L_0x0046
            L_0x0031:
                r6 = r2
                goto L_0x0046
            L_0x0033:
                r6 = r2
                goto L_0x0046
            L_0x0035:
                r5 = r2
                goto L_0x003d
            L_0x0037:
                r5 = r2
                goto L_0x0041
            L_0x0039:
                r5 = r2
                goto L_0x0045
            L_0x003b:
                r4 = r2
                r5 = r4
            L_0x003d:
                r6 = r5
                goto L_0x0046
            L_0x003f:
                r4 = r2
                r5 = r4
            L_0x0041:
                r6 = r5
                goto L_0x0046
            L_0x0043:
                r4 = r2
                r5 = r4
            L_0x0045:
                r6 = r5
            L_0x0046:
                r7 = r6
            L_0x0047:
                r8 = r1
                r3 = r2
            L_0x0049:
                if (r8 == 0) goto L_0x0058
                f1312b = r4
                f1313c = r5
                f1314d = r6
                f1315e = r7
                f1316f = r3
                f1311a = r0
                goto L_0x0064
            L_0x0058:
                f1312b = r2
                f1313c = r2
                f1314d = r2
                f1315e = r2
                f1316f = r2
                f1311a = r1
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k0.a.<clinit>():void");
        }

        @NonNull
        static Rect a(@NonNull Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f1311a) {
                try {
                    Object invoke = f1312b.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(f1313c.getInt(invoke), f1314d.getInt(invoke), f1315e.getInt(invoke), f1316f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return k0.f1310c;
        }
    }

    static class b {
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(@NonNull Drawable drawable) {
        return true;
    }

    static void b(@NonNull Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29 && i10 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1308a);
        } else {
            drawable.setState(f1309b);
        }
        drawable.setState(state);
    }

    @NonNull
    public static Rect d(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.a(androidx.core.graphics.drawable.a.q(drawable));
        }
        Insets a10 = b.a(drawable);
        return new Rect(a10.left, a10.top, a10.right, a10.bottom);
    }

    public static PorterDuff.Mode e(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
