package mb;

import android.view.View;
import com.coffeemeetsbagel.shop.shop.adapter.error.ShopErrorView;
import kotlin.jvm.internal.j;
import lb.e;

public final class b extends lb.b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        j.g(view, "itemView");
    }

    public void V(e eVar) {
        View view = this.f6302a;
        j.e(view, "null cannot be cast to non-null type com.coffeemeetsbagel.shop.shop.adapter.error.ShopErrorView");
        j.e(eVar, "null cannot be cast to non-null type com.coffeemeetsbagel.shop.shop.adapter.error.ShopErrorViewModel");
        ((ShopErrorView) view).b((c) eVar);
    }
}
