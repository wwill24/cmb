package r;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import n.a;
import q.l;
import q.u;

public class i {
    @SuppressLint({"NewApi"})
    public void a(int i10, @NonNull a.C0174a aVar) {
        if (((u) l.a(u.class)) != null) {
            if (i10 == 0) {
                aVar.e(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.TRUE);
            } else if (i10 == 1) {
                aVar.e(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.FALSE);
            }
        }
    }
}
