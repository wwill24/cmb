package r;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.SessionConfig;
import n.a;
import q.a0;
import q.l;

public class m {
    public static void a(@NonNull SessionConfig.b bVar) {
        if (((a0) l.a(a0.class)) != null) {
            a.C0174a aVar = new a.C0174a();
            aVar.e(CaptureRequest.TONEMAP_MODE, 2);
            bVar.g(aVar.c());
        }
    }
}
