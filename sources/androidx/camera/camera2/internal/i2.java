package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.s0;
import n.a;
import r.i;

final class i2 extends k0 {

    /* renamed from: c  reason: collision with root package name */
    static final i2 f1806c = new i2(new i());
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final i f1807b;

    private i2(@NonNull i iVar) {
        this.f1807b = iVar;
    }

    public void a(@NonNull f2<?> f2Var, @NonNull d0.a aVar) {
        super.a(f2Var, aVar);
        if (f2Var instanceof s0) {
            s0 s0Var = (s0) f2Var;
            a.C0174a aVar2 = new a.C0174a();
            if (s0Var.T()) {
                this.f1807b.a(s0Var.L(), aVar2);
            }
            aVar.e(aVar2.c());
            return;
        }
        throw new IllegalArgumentException("config is not ImageCaptureConfig");
    }
}
