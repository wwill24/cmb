package androidx.camera.camera2.internal;

import androidx.camera.core.impl.n;
import java.util.concurrent.Executor;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t f1789a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f1790b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f1791c;

    public /* synthetic */ i(t tVar, Executor executor, n nVar) {
        this.f1789a = tVar;
        this.f1790b = executor;
        this.f1791c = nVar;
    }

    public final void run() {
        this.f1789a.S(this.f1790b, this.f1791c);
    }
}
