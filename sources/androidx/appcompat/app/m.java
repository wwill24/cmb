package androidx.appcompat.app;

import androidx.appcompat.app.n;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n.a f572a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f573b;

    public /* synthetic */ m(n.a aVar, Runnable runnable) {
        this.f572a = aVar;
        this.f573b = runnable;
    }

    public final void run() {
        this.f572a.b(this.f573b);
    }
}
