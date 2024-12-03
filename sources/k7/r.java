package k7;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.MessageToSend;
import k7.s;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s.a f15922a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f15923b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f15924c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MessageToSend f15925d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f15926e;

    public /* synthetic */ r(s.a aVar, Bagel bagel, String str, MessageToSend messageToSend, a aVar2) {
        this.f15922a = aVar;
        this.f15923b = bagel;
        this.f15924c = str;
        this.f15925d = messageToSend;
        this.f15926e = aVar2;
    }

    public final void run() {
        this.f15922a.f(this.f15923b, this.f15924c, this.f15925d, this.f15926e);
    }
}
