package r;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.r1;
import n.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Range<Integer> f17210a;

    public a(@NonNull r1 r1Var) {
        q.a aVar = (q.a) r1Var.b(q.a.class);
        if (aVar == null) {
            this.f17210a = null;
        } else {
            this.f17210a = aVar.c();
        }
    }

    public void a(@NonNull a.C0174a aVar) {
        Range<Integer> range = this.f17210a;
        if (range != null) {
            aVar.e(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
        }
    }
}
