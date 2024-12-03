package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class e implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3300a;

    public /* synthetic */ e(AtomicReference atomicReference) {
        this.f3300a = atomicReference;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3300a.set(aVar);
    }
}
