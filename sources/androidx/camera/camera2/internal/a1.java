package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.p;
import androidx.camera.core.v1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import s.j;

class a1 {

    static class a {
        static CaptureRequest.Builder a(@NonNull CameraDevice cameraDevice, @NonNull TotalCaptureResult totalCaptureResult) throws CameraAccessException {
            return cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
        }
    }

    private static void a(CaptureRequest.Builder builder, Config config) {
        j d10 = j.a.e(config).d();
        for (Config.a next : d10.e()) {
            CaptureRequest.Key key = (CaptureRequest.Key) next.d();
            try {
                builder.set(key, d10.a(next));
            } catch (IllegalArgumentException unused) {
                v1.c("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    public static CaptureRequest b(@NonNull d0 d0Var, CameraDevice cameraDevice, @NonNull Map<DeferrableSurface, Surface> map) throws CameraAccessException {
        CaptureRequest.Builder builder;
        if (cameraDevice == null) {
            return null;
        }
        List<Surface> d10 = d(d0Var.e(), map);
        if (d10.isEmpty()) {
            return null;
        }
        p c10 = d0Var.c();
        if (d0Var.g() != 5 || c10 == null || !(c10.d() instanceof TotalCaptureResult)) {
            v1.a("Camera2CaptureRequestBuilder", "createCaptureRequest");
            builder = cameraDevice.createCaptureRequest(d0Var.g());
        } else {
            v1.a("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            builder = a.a(cameraDevice, (TotalCaptureResult) c10.d());
        }
        a(builder, d0Var.d());
        Config d11 = d0Var.d();
        Config.a<Integer> aVar = d0.f2485h;
        if (d11.b(aVar)) {
            builder.set(CaptureRequest.JPEG_ORIENTATION, (Integer) d0Var.d().a(aVar));
        }
        Config d12 = d0Var.d();
        Config.a<Integer> aVar2 = d0.f2486i;
        if (d12.b(aVar2)) {
            builder.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) d0Var.d().a(aVar2)).byteValue()));
        }
        for (Surface addTarget : d10) {
            builder.addTarget(addTarget);
        }
        builder.setTag(d0Var.f());
        return builder.build();
    }

    public static CaptureRequest c(@NonNull d0 d0Var, CameraDevice cameraDevice) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(d0Var.g());
        a(createCaptureRequest, d0Var.d());
        return createCaptureRequest.build();
    }

    @NonNull
    private static List<Surface> d(List<DeferrableSurface> list, Map<DeferrableSurface, Surface> map) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : list) {
            Surface surface = map.get(deferrableSurface);
            if (surface != null) {
                arrayList.add(surface);
            } else {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
        }
        return arrayList;
    }
}
