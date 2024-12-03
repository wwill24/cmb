package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.t;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f implements t.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1738a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f1739b;

    public /* synthetic */ f(long j10, CallbackToFutureAdapter.a aVar) {
        this.f1738a = j10;
        this.f1739b = aVar;
    }

    public final boolean a(TotalCaptureResult totalCaptureResult) {
        return t.Z(this.f1738a, this.f1739b, totalCaptureResult);
    }
}
