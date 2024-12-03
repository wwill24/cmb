package x1;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;

class j0 extends g0 {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f18417d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f18418e = true;

    j0() {
    }

    @SuppressLint({"NewApi"})
    public void g(@NonNull View view, @NonNull Matrix matrix) {
        if (f18417d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f18417d = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void h(@NonNull View view, @NonNull Matrix matrix) {
        if (f18418e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f18418e = false;
            }
        }
    }
}
