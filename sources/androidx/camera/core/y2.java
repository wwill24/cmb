package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class y2 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2955a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2956b;

    public /* synthetic */ y2(AtomicReference atomicReference, String str) {
        this.f2955a = atomicReference;
        this.f2956b = str;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f2955a.set(aVar);
    }
}
