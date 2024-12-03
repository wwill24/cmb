package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.t;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t.b f1986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TotalCaptureResult f1987b;

    public /* synthetic */ u(t.b bVar, TotalCaptureResult totalCaptureResult) {
        this.f1986a = bVar;
        this.f1987b = totalCaptureResult;
    }

    public final void run() {
        this.f1986a.c(this.f1987b);
    }
}
