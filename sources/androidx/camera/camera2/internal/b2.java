package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.t;

public final /* synthetic */ class b2 implements t.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g2 f1687a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1688b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f1689c;

    public /* synthetic */ b2(g2 g2Var, int i10, long j10) {
        this.f1687a = g2Var;
        this.f1688b = i10;
        this.f1689c = j10;
    }

    public final boolean a(TotalCaptureResult totalCaptureResult) {
        return this.f1687a.A(this.f1688b, this.f1689c, totalCaptureResult);
    }
}
