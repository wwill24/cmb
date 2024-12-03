package x1;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;

class l0 extends j0 {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f18427f = true;

    l0() {
    }

    @SuppressLint({"NewApi"})
    public void d(@NonNull View view, int i10, int i11, int i12, int i13) {
        if (f18427f) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f18427f = false;
            }
        }
    }
}
