package androidx.profileinstaller;

import androidx.profileinstaller.h;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.c f6165a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f6166b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f6167c;

    public /* synthetic */ g(h.c cVar, int i10, Object obj) {
        this.f6165a = cVar;
        this.f6166b = i10;
        this.f6167c = obj;
    }

    public final void run() {
        this.f6165a.a(this.f6166b, this.f6167c);
    }
}
