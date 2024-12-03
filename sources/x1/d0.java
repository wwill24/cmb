package x1;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.n0;

class d0 {

    /* renamed from: a  reason: collision with root package name */
    private static final p0 f18394a;

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f18395b = new a(Float.class, "translationAlpha");

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Rect> f18396c = new b(Rect.class, "clipBounds");

    class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(d0.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            d0.g(view, f10.floatValue());
        }
    }

    class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return n0.u(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            n0.z0(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f18394a = new o0();
        } else {
            f18394a = new n0();
        }
    }

    static void a(@NonNull View view) {
        f18394a.a(view);
    }

    static c0 b(@NonNull View view) {
        return new b0(view);
    }

    static float c(@NonNull View view) {
        return f18394a.b(view);
    }

    static t0 d(@NonNull View view) {
        return new s0(view);
    }

    static void e(@NonNull View view) {
        f18394a.c(view);
    }

    static void f(@NonNull View view, int i10, int i11, int i12, int i13) {
        f18394a.d(view, i10, i11, i12, i13);
    }

    static void g(@NonNull View view, float f10) {
        f18394a.e(view, f10);
    }

    static void h(@NonNull View view, int i10) {
        f18394a.f(view, i10);
    }

    static void i(@NonNull View view, @NonNull Matrix matrix) {
        f18394a.g(view, matrix);
    }

    static void j(@NonNull View view, @NonNull Matrix matrix) {
        f18394a.h(view, matrix);
    }
}
