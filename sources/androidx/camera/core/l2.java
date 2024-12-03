package androidx.camera.core;

import androidx.camera.core.j2;

public final /* synthetic */ class l2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j2.f f2803a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f2804b;

    public /* synthetic */ l2(j2.f fVar, Exception exc) {
        this.f2803a = fVar;
        this.f2804b = exc;
    }

    public final void run() {
        this.f2803a.a(this.f2804b.getMessage(), this.f2804b.getCause());
    }
}
