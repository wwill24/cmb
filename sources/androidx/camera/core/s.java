package androidx.camera.core;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class s implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraX f2885a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f2886b;

    public /* synthetic */ s(CameraX cameraX, Context context) {
        this.f2885a = cameraX;
        this.f2886b = context;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f2885a.n(this.f2886b, aVar);
    }
}
