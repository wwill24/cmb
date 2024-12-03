package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class z implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3379a;

    public /* synthetic */ z(AtomicReference atomicReference) {
        this.f3379a = atomicReference;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3379a.set(aVar);
    }
}
