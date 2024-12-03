package androidx.camera.core;

import androidx.camera.core.h1;
import java.util.concurrent.Executor;

public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f2937a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h1.o f2938b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f2939c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h1.n f2940d;

    public /* synthetic */ y0(h1 h1Var, h1.o oVar, Executor executor, h1.n nVar) {
        this.f2937a = h1Var;
        this.f2938b = oVar;
        this.f2939c = executor;
        this.f2940d = nVar;
    }

    public final void run() {
        this.f2937a.z0(this.f2938b, this.f2939c, this.f2940d);
    }
}
