package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import o.e;

public final class g1 {

    static final class a extends CameraCaptureSession.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        private final List<CameraCaptureSession.StateCallback> f1756a = new ArrayList();

        a(@NonNull List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback next : list) {
                if (!(next instanceof b)) {
                    this.f1756a.add(next);
                }
            }
        }

        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onActive : this.f1756a) {
                onActive.onActive(cameraCaptureSession);
            }
        }

        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback b10 : this.f1756a) {
                e.b(b10, cameraCaptureSession);
            }
        }

        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onClosed : this.f1756a) {
                onClosed.onClosed(cameraCaptureSession);
            }
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onConfigureFailed : this.f1756a) {
                onConfigureFailed.onConfigureFailed(cameraCaptureSession);
            }
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onConfigured : this.f1756a) {
                onConfigured.onConfigured(cameraCaptureSession);
            }
        }

        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onReady : this.f1756a) {
                onReady.onReady(cameraCaptureSession);
            }
        }

        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
            for (CameraCaptureSession.StateCallback a10 : this.f1756a) {
                o.b.a(a10, cameraCaptureSession, surface);
            }
        }
    }

    static final class b extends CameraCaptureSession.StateCallback {
        b() {
        }

        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
        }
    }

    @NonNull
    public static CameraCaptureSession.StateCallback a(@NonNull List<CameraCaptureSession.StateCallback> list) {
        if (list.isEmpty()) {
            return b();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new a(list);
    }

    @NonNull
    public static CameraCaptureSession.StateCallback b() {
        return new b();
    }
}
