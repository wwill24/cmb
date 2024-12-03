package ob;

import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import kotlin.jvm.internal.j;
import lb.e;

public final class a extends e {

    /* renamed from: b  reason: collision with root package name */
    private String f41322b;

    /* renamed from: c  reason: collision with root package name */
    private String f41323c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, String str2) {
        super(ShopViewType.HEADER);
        j.g(str, "title");
        this.f41322b = str;
        this.f41323c = str2;
    }

    public final String b() {
        return this.f41323c;
    }

    public final String c() {
        return this.f41322b;
    }
}
