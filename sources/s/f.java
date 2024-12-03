package s;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f17425a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f17426b;

    public /* synthetic */ f(g gVar, CallbackToFutureAdapter.a aVar) {
        this.f17425a = gVar;
        this.f17426b = aVar;
    }

    public final void run() {
        this.f17425a.o(this.f17426b);
    }
}
