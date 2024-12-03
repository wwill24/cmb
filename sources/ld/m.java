package ld;

import ed.p;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f41143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f41144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f41145c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f41146d;

    public /* synthetic */ m(o oVar, p pVar, int i10, Runnable runnable) {
        this.f41143a = oVar;
        this.f41144b = pVar;
        this.f41145c = i10;
        this.f41146d = runnable;
    }

    public final void run() {
        this.f41143a.t(this.f41144b, this.f41145c, this.f41146d);
    }
}
