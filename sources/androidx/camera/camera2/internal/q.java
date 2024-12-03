package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.n;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f1917a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureFailure f1918b;

    public /* synthetic */ q(n nVar, CameraCaptureFailure cameraCaptureFailure) {
        this.f1917a = nVar;
        this.f1918b = cameraCaptureFailure;
    }

    public final void run() {
        this.f1917a.c(this.f1918b);
    }
}
