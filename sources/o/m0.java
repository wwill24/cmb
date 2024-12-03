package o;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;
import o.d0;
import p.b;
import p.k;

class m0 implements d0.a {

    /* renamed from: a  reason: collision with root package name */
    final CameraDevice f16717a;

    /* renamed from: b  reason: collision with root package name */
    final Object f16718b;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Handler f16719a;

        a(@NonNull Handler handler) {
            this.f16719a = handler;
        }
    }

    m0(@NonNull CameraDevice cameraDevice, Object obj) {
        this.f16717a = (CameraDevice) h.g(cameraDevice);
        this.f16718b = obj;
    }

    private static void b(CameraDevice cameraDevice, @NonNull List<b> list) {
        String id2 = cameraDevice.getId();
        for (b c10 : list) {
            String c11 = c10.c();
            if (c11 != null && !c11.isEmpty()) {
                v1.l("CameraDeviceCompat", "Camera " + id2 + ": Camera doesn't support physicalCameraId " + c11 + ". Ignoring.");
            }
        }
    }

    static void c(CameraDevice cameraDevice, k kVar) {
        h.g(cameraDevice);
        h.g(kVar);
        h.g(kVar.e());
        List<b> c10 = kVar.c();
        if (c10 == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        } else if (kVar.a() != null) {
            b(cameraDevice, c10);
        } else {
            throw new IllegalArgumentException("Invalid executor");
        }
    }

    static List<Surface> d(@NonNull List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (b d10 : list) {
            arrayList.add(d10.d());
        }
        return arrayList;
    }
}
