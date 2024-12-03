package q6;

import b6.s;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import s9.a;

public class f extends s<k, l> implements g {

    /* renamed from: f  reason: collision with root package name */
    a f17181f;

    /* renamed from: g  reason: collision with root package name */
    k0 f17182g;

    public void H1() {
        if (this.f17181f.a("OnePaidLike.Enabled.Android")) {
            Price price = this.f17182g.getPrice(PurchaseType.PAID_LIKE);
            if (price != null) {
                ((k) this.f7875e).o(price.getFreeItemCount());
            } else {
                ((k) this.f7875e).l();
            }
        }
    }

    public void s0() {
        ((l) B1()).m();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        H1();
    }
}
