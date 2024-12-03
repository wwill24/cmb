package r;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.d0;
import java.util.List;
import n.a;
import q.e0;
import q.l;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17230a;

    public r() {
        boolean z10;
        if (l.a(e0.class) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f17230a = z10;
    }

    @NonNull
    public d0 a(@NonNull d0 d0Var) {
        d0.a aVar = new d0.a();
        aVar.q(d0Var.g());
        for (DeferrableSurface f10 : d0Var.e()) {
            aVar.f(f10);
        }
        aVar.e(d0Var.d());
        a.C0174a aVar2 = new a.C0174a();
        aVar2.e(CaptureRequest.FLASH_MODE, 0);
        aVar.e(aVar2.c());
        return aVar.h();
    }

    public boolean b(@NonNull List<CaptureRequest> list, boolean z10) {
        if (!this.f17230a || !z10) {
            return false;
        }
        for (CaptureRequest captureRequest : list) {
            Integer num = (Integer) captureRequest.get(CaptureRequest.FLASH_MODE);
            if (num != null && num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }
}
