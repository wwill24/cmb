package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.j3;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import n.a;
import o.c0;

final class a implements j3.b {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f1665a;

    /* renamed from: b  reason: collision with root package name */
    private final Range<Float> f1666b;

    /* renamed from: c  reason: collision with root package name */
    private float f1667c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private CallbackToFutureAdapter.a<Void> f1668d;

    /* renamed from: e  reason: collision with root package name */
    private float f1669e = 1.0f;

    a(@NonNull c0 c0Var) {
        this.f1665a = c0Var;
        this.f1666b = (Range) c0Var.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
    }

    public void a(@NonNull TotalCaptureResult totalCaptureResult) {
        Float f10;
        if (this.f1668d != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            if (request == null) {
                f10 = null;
            } else {
                f10 = (Float) request.get(CaptureRequest.CONTROL_ZOOM_RATIO);
            }
            if (f10 != null) {
                if (this.f1669e == f10.floatValue()) {
                    this.f1668d.c(null);
                    this.f1668d = null;
                }
            }
        }
    }

    public float b() {
        return this.f1666b.getLower().floatValue();
    }

    public void c(@NonNull a.C0174a aVar) {
        aVar.e(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.f1667c));
    }

    public void d() {
        this.f1667c = 1.0f;
        CallbackToFutureAdapter.a<Void> aVar = this.f1668d;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            this.f1668d = null;
        }
    }

    public float e() {
        return this.f1666b.getUpper().floatValue();
    }

    @NonNull
    public Rect f() {
        return (Rect) h.g((Rect) this.f1665a.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }
}
