package t;

import a0.n;
import a0.o;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.o1;
import androidx.camera.core.t2;
import androidx.camera.core.u1;

public class t implements n<o<o1>, o1> {
    @NonNull
    /* renamed from: a */
    public o1 apply(@NonNull o<o1> oVar) throws ImageCaptureException {
        o1 c10 = oVar.c();
        t2 t2Var = new t2(c10, oVar.h(), u1.e(c10.z1().c(), c10.z1().getTimestamp(), oVar.f(), oVar.g()));
        t2Var.p0(oVar.b());
        return t2Var;
    }
}
