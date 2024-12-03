package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.c;

class f1 extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    final Map<CaptureRequest, List<CameraCaptureSession.CaptureCallback>> f1744a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    a f1745b = null;

    interface a {
        void a(@NonNull CameraCaptureSession cameraCaptureSession, int i10, boolean z10);
    }

    f1() {
    }

    private List<CameraCaptureSession.CaptureCallback> b(CaptureRequest captureRequest) {
        List<CameraCaptureSession.CaptureCallback> list = this.f1744a.get(captureRequest);
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public void a(CaptureRequest captureRequest, List<CameraCaptureSession.CaptureCallback> list) {
        List list2 = this.f1744a.get(captureRequest);
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size());
            arrayList.addAll(list);
            arrayList.addAll(list2);
            this.f1744a.put(captureRequest, arrayList);
            return;
        }
        this.f1744a.put(captureRequest, list);
    }

    public void c(@NonNull a aVar) {
        this.f1745b = aVar;
    }

    public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j10) {
        for (CameraCaptureSession.CaptureCallback a10 : b(captureRequest)) {
            c.a(a10, cameraCaptureSession, captureRequest, surface, j10);
        }
    }

    public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        for (CameraCaptureSession.CaptureCallback onCaptureCompleted : b(captureRequest)) {
            onCaptureCompleted.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }
    }

    public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
        for (CameraCaptureSession.CaptureCallback onCaptureFailed : b(captureRequest)) {
            onCaptureFailed.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }
    }

    public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        for (CameraCaptureSession.CaptureCallback onCaptureProgressed : b(captureRequest)) {
            onCaptureProgressed.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }
    }

    public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i10) {
        for (List<CameraCaptureSession.CaptureCallback> it : this.f1744a.values()) {
            for (CameraCaptureSession.CaptureCallback onCaptureSequenceAborted : it) {
                onCaptureSequenceAborted.onCaptureSequenceAborted(cameraCaptureSession, i10);
            }
        }
        a aVar = this.f1745b;
        if (aVar != null) {
            aVar.a(cameraCaptureSession, i10, true);
        }
    }

    public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i10, long j10) {
        for (List<CameraCaptureSession.CaptureCallback> it : this.f1744a.values()) {
            for (CameraCaptureSession.CaptureCallback onCaptureSequenceCompleted : it) {
                onCaptureSequenceCompleted.onCaptureSequenceCompleted(cameraCaptureSession, i10, j10);
            }
        }
        a aVar = this.f1745b;
        if (aVar != null) {
            aVar.a(cameraCaptureSession, i10, false);
        }
    }

    public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j10, long j11) {
        for (CameraCaptureSession.CaptureCallback onCaptureStarted : b(captureRequest)) {
            onCaptureStarted.onCaptureStarted(cameraCaptureSession, captureRequest, j10, j11);
        }
    }
}
