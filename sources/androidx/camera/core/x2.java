package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class x2 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2935a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2936b;

    public /* synthetic */ x2(AtomicReference atomicReference, String str) {
        this.f2935a = atomicReference;
        this.f2936b = str;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f2935a.set(aVar);
    }
}
