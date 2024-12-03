package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public final class h1 {

    private static final class a extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        private final List<CameraDevice.StateCallback> f1785a = new ArrayList();

        a(@NonNull List<CameraDevice.StateCallback> list) {
            for (CameraDevice.StateCallback next : list) {
                if (!(next instanceof b)) {
                    this.f1785a.add(next);
                }
            }
        }

        public void onClosed(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onClosed : this.f1785a) {
                onClosed.onClosed(cameraDevice);
            }
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onDisconnected : this.f1785a) {
                onDisconnected.onDisconnected(cameraDevice);
            }
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i10) {
            for (CameraDevice.StateCallback onError : this.f1785a) {
                onError.onError(cameraDevice, i10);
            }
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onOpened : this.f1785a) {
                onOpened.onOpened(cameraDevice);
            }
        }
    }

    static final class b extends CameraDevice.StateCallback {
        b() {
        }

        public void onClosed(@NonNull CameraDevice cameraDevice) {
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i10) {
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
        }
    }

    @NonNull
    public static CameraDevice.StateCallback a(@NonNull List<CameraDevice.StateCallback> list) {
        if (list.isEmpty()) {
            return b();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new a(list);
    }

    @NonNull
    public static CameraDevice.StateCallback b() {
        return new b();
    }
}
