package tf;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.r;

public class h {
    @NonNull
    static d a(int i10) {
        if (i10 == 0) {
            return new j();
        }
        if (i10 != 1) {
            return b();
        }
        return new e();
    }

    @NonNull
    static d b() {
        return new j();
    }

    @NonNull
    static f c() {
        return new f();
    }

    public static void d(@NonNull View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).a0(f10);
        }
    }

    public static void e(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(@NonNull View view, @NonNull g gVar) {
        if (gVar.S()) {
            gVar.e0(r.f(view));
        }
    }
}
