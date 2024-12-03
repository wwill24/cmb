package x1;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;

class g0 extends p0 {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f18415c = true;

    g0() {
    }

    public void a(@NonNull View view) {
    }

    @SuppressLint({"NewApi"})
    public float b(@NonNull View view) {
        if (f18415c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f18415c = false;
            }
        }
        return view.getAlpha();
    }

    public void c(@NonNull View view) {
    }

    @SuppressLint({"NewApi"})
    public void e(@NonNull View view, float f10) {
        if (f18415c) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f18415c = false;
            }
        }
        view.setAlpha(f10);
    }
}
