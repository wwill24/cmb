package androidx.camera.lifecycle;

import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class c implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f2980a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraX f2981b;

    public /* synthetic */ c(e eVar, CameraX cameraX) {
        this.f2980a = eVar;
        this.f2981b = cameraX;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f2980a.j(this.f2981b, aVar);
    }
}
