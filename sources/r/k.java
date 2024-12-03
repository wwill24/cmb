package r;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.r1;
import androidx.camera.core.z1;
import q.b;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final r1 f17222a;

    public k(@NonNull r1 r1Var) {
        this.f17222a = r1Var;
    }

    @NonNull
    public PointF a(@NonNull z1 z1Var, int i10) {
        if (i10 != 1 || !this.f17222a.a(b.class)) {
            return new PointF(z1Var.c(), z1Var.d());
        }
        return new PointF(1.0f - z1Var.c(), z1Var.d());
    }
}
