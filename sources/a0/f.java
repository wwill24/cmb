package a0;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f39a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f40b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f41c;

    public /* synthetic */ f(k kVar, v vVar, CallbackToFutureAdapter.a aVar) {
        this.f39a = kVar;
        this.f40b = vVar;
        this.f41c = aVar;
    }

    public final void run() {
        this.f39a.l(this.f40b, this.f41c);
    }
}
