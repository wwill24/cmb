package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class c1 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3273a;

    public /* synthetic */ c1(AtomicReference atomicReference) {
        this.f3273a = atomicReference;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3273a.set(aVar);
    }
}
