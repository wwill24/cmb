package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.t;

public final /* synthetic */ class d2 implements t.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g2 f1715a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f1716b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f1717c;

    public /* synthetic */ d2(g2 g2Var, boolean z10, long j10) {
        this.f1715a = g2Var;
        this.f1716b = z10;
        this.f1717c = j10;
    }

    public final boolean a(TotalCaptureResult totalCaptureResult) {
        return this.f1715a.B(this.f1716b, this.f1717c, totalCaptureResult);
    }
}
