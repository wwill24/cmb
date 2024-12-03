package ic;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.today_view.main.h;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f40971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f40972b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bagel f40973c;

    public /* synthetic */ o(h hVar, Bagel bagel, Bagel bagel2) {
        this.f40971a = hVar;
        this.f40972b = bagel;
        this.f40973c = bagel2;
    }

    public final void run() {
        this.f40971a.s(this.f40972b, this.f40973c);
    }
}
