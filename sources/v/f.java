package v;

import androidx.annotation.NonNull;
import androidx.camera.core.l3;

public abstract class f implements l3 {
    @NonNull
    public static l3 e(@NonNull l3 l3Var) {
        return new a(l3Var.d(), l3Var.a(), l3Var.c(), l3Var.b());
    }

    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract float d();
}
