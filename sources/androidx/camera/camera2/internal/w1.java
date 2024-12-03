package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.t;
import androidx.camera.core.CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import n.a;
import o.c0;

public class w1 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final t f2011a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final x1 f2012b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Executor f2013c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2014d = false;

    /* renamed from: e  reason: collision with root package name */
    private CallbackToFutureAdapter.a<Integer> f2015e;

    /* renamed from: f  reason: collision with root package name */
    private t.c f2016f;

    w1(@NonNull t tVar, @NonNull c0 c0Var, @NonNull Executor executor) {
        this.f2011a = tVar;
        this.f2012b = new x1(c0Var, 0);
        this.f2013c = executor;
    }

    private void a() {
        CallbackToFutureAdapter.a<Integer> aVar = this.f2015e;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            this.f2015e = null;
        }
        t.c cVar = this.f2016f;
        if (cVar != null) {
            this.f2011a.b0(cVar);
            this.f2016f = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        if (z10 != this.f2014d) {
            this.f2014d = z10;
            if (!z10) {
                this.f2012b.b(0);
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull a.C0174a aVar) {
        aVar.e(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.f2012b.a()));
    }
}
