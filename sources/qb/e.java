package qb;

import android.view.View;
import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import kotlin.jvm.internal.j;

public final class e extends lb.e {

    /* renamed from: b  reason: collision with root package name */
    private final View f41802b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f41803c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view, View.OnClickListener onClickListener) {
        super(ShopViewType.SUBSCRIPTION_COMPARISONS);
        j.g(view, "ribView");
        j.g(onClickListener, "clickListener");
        this.f41802b = view;
        this.f41803c = onClickListener;
    }

    public final View b() {
        return this.f41802b;
    }
}
