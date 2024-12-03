package nb;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.coffeemeetsbagel.models.enums.RewardType;
import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lb.e;

public final class a extends e {

    /* renamed from: b  reason: collision with root package name */
    private RewardType f41294b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f41295c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41296d;

    /* renamed from: e  reason: collision with root package name */
    private final Drawable f41297e;

    /* renamed from: f  reason: collision with root package name */
    private final String f41298f;

    /* renamed from: g  reason: collision with root package name */
    private String f41299g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(RewardType rewardType, View.OnClickListener onClickListener, String str, Drawable drawable) {
        this(rewardType, onClickListener, str, drawable, (String) null, 16, (DefaultConstructorMarker) null);
        j.g(rewardType, "rewardType");
        j.g(onClickListener, "clickListener");
        j.g(str, "rewardButtonText");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(RewardType rewardType, View.OnClickListener onClickListener, String str, Drawable drawable, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(rewardType, onClickListener, str, (i10 & 8) != 0 ? null : drawable, (i10 & 16) != 0 ? null : str2);
    }

    public final View.OnClickListener b() {
        return this.f41295c;
    }

    public final Drawable c() {
        return this.f41297e;
    }

    public final String d() {
        return this.f41296d;
    }

    public final String e() {
        return this.f41298f;
    }

    public final String f() {
        return this.f41299g;
    }

    public final RewardType g() {
        return this.f41294b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(RewardType rewardType, View.OnClickListener onClickListener, String str, Drawable drawable, String str2) {
        super(ShopViewType.FREE);
        j.g(rewardType, "rewardType");
        j.g(onClickListener, "clickListener");
        j.g(str, "rewardButtonText");
        this.f41294b = rewardType;
        this.f41295c = onClickListener;
        this.f41296d = str;
        this.f41297e = drawable;
        this.f41298f = str2;
    }
}
