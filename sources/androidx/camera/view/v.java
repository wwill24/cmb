package androidx.camera.view;

import android.view.Surface;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class v implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f3518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f3519b;

    public /* synthetic */ v(z zVar, Surface surface) {
        this.f3518a = zVar;
        this.f3519b = surface;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3518a.q(this.f3519b, aVar);
    }
}
