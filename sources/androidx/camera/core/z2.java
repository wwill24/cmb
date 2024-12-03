package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class z2 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2963a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2964b;

    public /* synthetic */ z2(AtomicReference atomicReference, String str) {
        this.f2963a = atomicReference;
        this.f2964b = str;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f2963a.set(aVar);
    }
}
