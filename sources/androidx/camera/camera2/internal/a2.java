package androidx.camera.camera2.internal;

import androidx.camera.core.f0;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class a2 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g2 f1674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f0 f1675b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f1676c;

    public /* synthetic */ a2(g2 g2Var, f0 f0Var, long j10) {
        this.f1674a = g2Var;
        this.f1675b = f0Var;
        this.f1676c = j10;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f1674a.H(this.f1675b, this.f1676c, aVar);
    }
}
