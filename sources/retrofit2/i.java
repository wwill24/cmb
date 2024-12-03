package retrofit2;

import retrofit2.g;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g.b.a f42284a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f42285b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f42286c;

    public /* synthetic */ i(g.b.a aVar, d dVar, Throwable th2) {
        this.f42284a = aVar;
        this.f42285b = dVar;
        this.f42286c = th2;
    }

    public final void run() {
        this.f42284a.c(this.f42285b, this.f42286c);
    }
}
