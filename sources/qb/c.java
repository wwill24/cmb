package qb;

import android.view.View;
import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import lb.e;

public class c extends e {

    /* renamed from: b  reason: collision with root package name */
    private final View.OnClickListener f41800b;

    /* renamed from: c  reason: collision with root package name */
    private final View f41801c;

    public c(View view, View.OnClickListener onClickListener) {
        super(ShopViewType.DYNAMIC_PRE_SUBSCRIPTION_BENEFITS);
        this.f41801c = view;
        this.f41800b = onClickListener;
    }

    public View b() {
        return this.f41801c;
    }

    public View.OnClickListener c() {
        return this.f41800b;
    }
}
