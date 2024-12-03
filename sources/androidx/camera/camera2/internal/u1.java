package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.j3;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import n.a;
import o.c0;

final class u1 implements j3.b {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f1988a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f1989b = null;

    /* renamed from: c  reason: collision with root package name */
    private CallbackToFutureAdapter.a<Void> f1990c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f1991d = null;

    u1(@NonNull c0 c0Var) {
        this.f1988a = c0Var;
    }

    private Rect g() {
        return (Rect) h.g((Rect) this.f1988a.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    public void a(@NonNull TotalCaptureResult totalCaptureResult) {
        Rect rect;
        if (this.f1990c != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            if (request == null) {
                rect = null;
            } else {
                rect = (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            }
            Rect rect2 = this.f1991d;
            if (rect2 != null && rect2.equals(rect)) {
                this.f1990c.c(null);
                this.f1990c = null;
                this.f1991d = null;
            }
        }
    }

    public float b() {
        return 1.0f;
    }

    public void c(@NonNull a.C0174a aVar) {
        Rect rect = this.f1989b;
        if (rect != null) {
            aVar.e(CaptureRequest.SCALER_CROP_REGION, rect);
        }
    }

    public void d() {
        this.f1991d = null;
        this.f1989b = null;
        CallbackToFutureAdapter.a<Void> aVar = this.f1990c;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            this.f1990c = null;
        }
    }

    public float e() {
        Float f10 = (Float) this.f1988a.a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f10 == null) {
            return 1.0f;
        }
        if (f10.floatValue() < b()) {
            return b();
        }
        return f10.floatValue();
    }

    @NonNull
    public Rect f() {
        Rect rect = this.f1989b;
        return rect != null ? rect : g();
    }
}
