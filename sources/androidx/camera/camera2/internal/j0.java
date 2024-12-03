package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.c;

public final class j0 {

    private static final class a extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        private final List<CameraCaptureSession.CaptureCallback> f1816a = new ArrayList();

        a(List<CameraCaptureSession.CaptureCallback> list) {
            for (CameraCaptureSession.CaptureCallback next : list) {
                if (!(next instanceof b)) {
                    this.f1816a.add(next);
                }
            }
        }

        public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j10) {
            for (CameraCaptureSession.CaptureCallback a10 : this.f1816a) {
                c.a(a10, cameraCaptureSession, captureRequest, surface, j10);
            }
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            for (CameraCaptureSession.CaptureCallback onCaptureCompleted : this.f1816a) {
                onCaptureCompleted.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            }
        }

        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            for (CameraCaptureSession.CaptureCallback onCaptureFailed : this.f1816a) {
                onCaptureFailed.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            }
        }

        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            for (CameraCaptureSession.CaptureCallback onCaptureProgressed : this.f1816a) {
                onCaptureProgressed.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
            }
        }

        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i10) {
            for (CameraCaptureSession.CaptureCallback onCaptureSequenceAborted : this.f1816a) {
                onCaptureSequenceAborted.onCaptureSequenceAborted(cameraCaptureSession, i10);
            }
        }

        public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i10, long j10) {
            for (CameraCaptureSession.CaptureCallback onCaptureSequenceCompleted : this.f1816a) {
                onCaptureSequenceCompleted.onCaptureSequenceCompleted(cameraCaptureSession, i10, j10);
            }
        }

        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j10, long j11) {
            for (CameraCaptureSession.CaptureCallback onCaptureStarted : this.f1816a) {
                onCaptureStarted.onCaptureStarted(cameraCaptureSession, captureRequest, j10, j11);
            }
        }
    }

    static final class b extends CameraCaptureSession.CaptureCallback {
        b() {
        }

        public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j10) {
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        }

        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
        }

        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        }

        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i10) {
        }

        public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i10, long j10) {
        }

        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j10, long j11) {
        }
    }

    static CameraCaptureSession.CaptureCallback a(List<CameraCaptureSession.CaptureCallback> list) {
        return new a(list);
    }

    @NonNull
    public static CameraCaptureSession.CaptureCallback b(@NonNull CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        return a(Arrays.asList(captureCallbackArr));
    }

    @NonNull
    public static CameraCaptureSession.CaptureCallback c() {
        return new b();
    }
}
