package t;

import a0.n;
import a0.o;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.impl.utils.i;
import androidx.camera.core.o1;
import androidx.camera.core.q1;
import androidx.camera.core.s2;
import java.util.Objects;

public class s implements n<o<byte[]>, o<o1>> {
    @NonNull
    /* renamed from: a */
    public o<o1> apply(@NonNull o<byte[]> oVar) throws ImageCaptureException {
        s2 s2Var = new s2(q1.a(oVar.h().getWidth(), oVar.h().getHeight(), 256, 2));
        o1 e10 = ImageProcessingUtil.e(s2Var, oVar.c());
        s2Var.l();
        Objects.requireNonNull(e10);
        i d10 = oVar.d();
        Objects.requireNonNull(d10);
        return o.k(e10, d10, oVar.b(), oVar.f(), oVar.g(), oVar.a());
    }
}
