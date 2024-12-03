package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class h implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3311a;

    public /* synthetic */ h(AtomicReference atomicReference) {
        this.f3311a = atomicReference;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3311a.set(aVar);
    }
}
