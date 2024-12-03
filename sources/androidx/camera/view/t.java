package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.a;

public final /* synthetic */ class t implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f3515a;

    public /* synthetic */ t(CallbackToFutureAdapter.a aVar) {
        this.f3515a = aVar;
    }

    public final void accept(Object obj) {
        this.f3515a.c((SurfaceRequest.e) obj);
    }
}
