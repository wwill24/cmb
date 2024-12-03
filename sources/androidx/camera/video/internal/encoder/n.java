package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class n implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3333a;

    public /* synthetic */ n(AtomicReference atomicReference) {
        this.f3333a = atomicReference;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3333a.set(aVar);
    }
}
