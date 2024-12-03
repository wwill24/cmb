package x1;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;

class o0 extends n0 {
    o0() {
    }

    public float b(@NonNull View view) {
        return view.getTransitionAlpha();
    }

    public void d(@NonNull View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    public void e(@NonNull View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    public void f(@NonNull View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    public void g(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void h(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
