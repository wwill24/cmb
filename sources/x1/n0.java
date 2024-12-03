package x1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;

class n0 extends l0 {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f18458g = true;

    n0() {
    }

    @SuppressLint({"NewApi"})
    public void f(@NonNull View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i10);
        } else if (f18458g) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f18458g = false;
            }
        }
    }
}
