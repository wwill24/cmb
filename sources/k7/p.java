package k7;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f15915a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f15916b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConnectionDetails f15917c;

    public /* synthetic */ p(s sVar, Bagel bagel, ConnectionDetails connectionDetails) {
        this.f15915a = sVar;
        this.f15916b = bagel;
        this.f15917c = connectionDetails;
    }

    public final void run() {
        this.f15915a.I(this.f15916b, this.f15917c);
    }
}
