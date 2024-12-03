package s;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f17423a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f17424b;

    public /* synthetic */ e(g gVar, CallbackToFutureAdapter.a aVar) {
        this.f17423a = gVar;
        this.f17424b = aVar;
    }

    public final void run() {
        this.f17423a.m(this.f17424b);
    }
}
