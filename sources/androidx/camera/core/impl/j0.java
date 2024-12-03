package androidx.camera.core.impl;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f2552a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2553b;

    public /* synthetic */ j0(DeferrableSurface deferrableSurface, String str) {
        this.f2552a = deferrableSurface;
        this.f2553b = str;
    }

    public final void run() {
        this.f2552a.l(this.f2553b);
    }
}
