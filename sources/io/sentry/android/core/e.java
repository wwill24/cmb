package io.sentry.android.core;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f30962a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f30963b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f30964c;

    public /* synthetic */ e(g gVar, Runnable runnable, String str) {
        this.f30962a = gVar;
        this.f30963b = runnable;
        this.f30964c = str;
    }

    public final void run() {
        this.f30962a.j(this.f30963b, this.f30964c);
    }
}
