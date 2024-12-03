package androidx.camera.core;

import androidx.camera.core.h1;

public final /* synthetic */ class i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1.j f2345a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2346b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2347c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f2348d;

    public /* synthetic */ i1(h1.j jVar, int i10, String str, Throwable th2) {
        this.f2345a = jVar;
        this.f2346b = i10;
        this.f2347c = str;
        this.f2348d = th2;
    }

    public final void run() {
        this.f2345a.e(this.f2346b, this.f2347c, this.f2348d);
    }
}
