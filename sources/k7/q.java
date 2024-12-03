package k7;

import com.coffeemeetsbagel.models.MessageToSend;
import k7.s;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s.a f15918a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f15919b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MessageToSend f15920c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f15921d;

    public /* synthetic */ q(s.a aVar, a aVar2, MessageToSend messageToSend, Throwable th2) {
        this.f15918a = aVar;
        this.f15919b = aVar2;
        this.f15920c = messageToSend;
        this.f15921d = th2;
    }

    public final void run() {
        this.f15918a.e(this.f15919b, this.f15920c, this.f15921d);
    }
}
