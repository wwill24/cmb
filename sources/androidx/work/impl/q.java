package androidx.work.impl;

import g2.m;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7580a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f7581b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f7582c;

    public /* synthetic */ q(r rVar, m mVar, boolean z10) {
        this.f7580a = rVar;
        this.f7581b = mVar;
        this.f7582c = z10;
    }

    public final void run() {
        this.f7580a.l(this.f7581b, this.f7582c);
    }
}
