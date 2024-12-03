package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.o;
import java.util.ArrayList;
import java.util.List;

final class n1 {
    static CameraCaptureSession.CaptureCallback a(n nVar) {
        if (nVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        b(nVar, arrayList);
        if (arrayList.size() == 1) {
            return (CameraCaptureSession.CaptureCallback) arrayList.get(0);
        }
        return j0.a(arrayList);
    }

    static void b(n nVar, List<CameraCaptureSession.CaptureCallback> list) {
        if (nVar instanceof o) {
            for (n b10 : ((o) nVar).d()) {
                b(b10, list);
            }
        } else if (nVar instanceof m1) {
            list.add(((m1) nVar).e());
        } else {
            list.add(new l1(nVar));
        }
    }
}
