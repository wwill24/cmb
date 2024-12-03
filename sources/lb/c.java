package lb;

import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import java.util.function.Predicate;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShopViewType f41095a;

    public /* synthetic */ c(ShopViewType shopViewType) {
        this.f41095a = shopViewType;
    }

    public final boolean test(Object obj) {
        return d.L(this.f41095a, (e) obj);
    }
}
