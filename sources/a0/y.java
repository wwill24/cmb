package a0;

import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f109a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f110b;

    public /* synthetic */ y(z zVar, AtomicReference atomicReference) {
        this.f109a = zVar;
        this.f110b = atomicReference;
    }

    public final void run() {
        this.f109a.i(this.f110b);
    }
}
