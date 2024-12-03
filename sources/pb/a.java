package pb;

import android.view.View;
import com.coffeemeetsbagel.models.enums.RewardType;
import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import kotlin.jvm.internal.j;
import lb.e;

public final class a extends e {

    /* renamed from: b  reason: collision with root package name */
    private final RewardType f41786b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f41787c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41788d;

    /* renamed from: e  reason: collision with root package name */
    private final String f41789e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(RewardType rewardType, View.OnClickListener onClickListener, String str, String str2) {
        super(ShopViewType.PURCHASE);
        j.g(rewardType, "rewardType");
        j.g(onClickListener, "clickListener");
        this.f41786b = rewardType;
        this.f41787c = onClickListener;
        this.f41788d = str;
        this.f41789e = str2;
    }

    public final View.OnClickListener b() {
        return this.f41787c;
    }

    public final String c() {
        return this.f41789e;
    }

    public final RewardType d() {
        return this.f41786b;
    }

    public final String e() {
        return this.f41788d;
    }
}
