package x1;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

class p0 {

    /* renamed from: a  reason: collision with root package name */
    private static Field f18466a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f18467b;

    p0() {
    }

    public void a(@NonNull View view) {
        throw null;
    }

    public float b(@NonNull View view) {
        throw null;
    }

    public void c(@NonNull View view) {
        throw null;
    }

    public void d(@NonNull View view, int i10, int i11, int i12, int i13) {
        throw null;
    }

    public void e(@NonNull View view, float f10) {
        throw null;
    }

    public void f(@NonNull View view, int i10) {
        if (!f18467b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f18466a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f18467b = true;
        }
        Field field = f18466a;
        if (field != null) {
            try {
                f18466a.setInt(view, i10 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void g(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }

    public void h(@NonNull View view, @NonNull Matrix matrix) {
        throw null;
    }
}
