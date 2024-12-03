package z;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.q;
import androidx.camera.core.l1;
import androidx.camera.core.o1;
import z.b;

public final class d extends a<o1> {
    public d(int i10, @NonNull b.a<o1> aVar) {
        super(i10, aVar);
    }

    private boolean d(@NonNull l1 l1Var) {
        p a10 = q.a(l1Var);
        if ((a10.e() == CameraCaptureMetaData$AfState.LOCKED_FOCUSED || a10.e() == CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) && a10.g() == CameraCaptureMetaData$AeState.CONVERGED && a10.f() == CameraCaptureMetaData$AwbState.CONVERGED) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void b(@NonNull o1 o1Var) {
        if (d(o1Var.z1())) {
            super.b(o1Var);
        } else {
            this.f18782d.a(o1Var);
        }
    }
}
