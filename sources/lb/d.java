package lb;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import com.coffeemeetsbagel.shop.shop.adapter.error.ShopErrorView;
import com.coffeemeetsbagel.shop.shop.adapter.free.ShopFreeRowView;
import com.coffeemeetsbagel.shop.shop.adapter.header.ShopHeaderRowView;
import com.coffeemeetsbagel.shop.shop.adapter.purchase.ShopPurchaseRowView;
import com.coffeemeetsbagel.shop.shop.adapter.subscription.DynamicPreSubscriptionView;
import com.coffeemeetsbagel.shop.shop.adapter.subscription_durations.ShopNonPurchasedSubscriptionRowView;
import java.util.ArrayList;
import java.util.List;
import qb.e;

public class d extends RecyclerView.Adapter<b> {

    /* renamed from: d  reason: collision with root package name */
    private final List<e> f41096d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final List<b> f41097e = new ArrayList();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41098a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType[] r0 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41098a = r0
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.HEADER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.NON_PURCHASED_SUBSCRIPTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.PURCHASE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.DYNAMIC_PRE_SUBSCRIPTION_BENEFITS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.DYNAMIC_POST_SUBSCRIPTION_BENEFITS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.ERROR_NO_PLAY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.ERROR_NO_SKUS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.SUBSCRIPTION_COMPARISONS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f41098a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.FREE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lb.d.a.<clinit>():void");
        }
    }

    public interface b {
        void c();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean L(ShopViewType shopViewType, e eVar) {
        return eVar.a() == shopViewType;
    }

    public void H() {
        for (e eVar : this.f41096d) {
            if (eVar instanceof rb.a) {
                for (b c10 : this.f41097e) {
                    c10.c();
                }
                return;
            }
        }
    }

    public void I() {
        this.f41097e.clear();
    }

    public int J(e eVar) {
        for (int i10 = 0; i10 < this.f41096d.size(); i10++) {
            if (this.f41096d.get(i10) == eVar) {
                return i10;
            }
        }
        return -1;
    }

    public e K(ShopViewType shopViewType) {
        for (e next : this.f41096d) {
            if (next.a() == shopViewType) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: M */
    public void v(@NonNull b bVar, int i10) {
        bVar.V(this.f41096d.get(i10));
        if (bVar instanceof ShopNonPurchasedSubscriptionRowView.a) {
            this.f41097e.add((ShopNonPurchasedSubscriptionRowView.a) bVar);
        }
    }

    @NonNull
    /* renamed from: N */
    public b x(@NonNull ViewGroup viewGroup, int i10) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (a.f41098a[ShopViewType.a(i10).ordinal()]) {
            case 1:
                return new ShopHeaderRowView.a(from.inflate(R.layout.shop_header_row_dls, viewGroup, false));
            case 2:
                return new ShopNonPurchasedSubscriptionRowView.a(from.inflate(R.layout.shop_non_purchased_subscription_row, viewGroup, false));
            case 3:
                return new ShopPurchaseRowView.a(from.inflate(R.layout.shop_purchase_row_dls, viewGroup, false));
            case 4:
                return new DynamicPreSubscriptionView.a(from.inflate(R.layout.shop_pre_subscription_cta, viewGroup, false));
            case 5:
                return new qb.a((ViewGroup) from.inflate(R.layout.shop_post_subscription_benefits_holder, viewGroup, false));
            case 6:
            case 7:
                return new mb.b((ShopErrorView) from.inflate(R.layout.shop_error, viewGroup, false));
            case 8:
                e K = K(ShopViewType.SUBSCRIPTION_COMPARISONS);
                if (K != null) {
                    return new qb.d(((e) K).b());
                }
                return new ShopFreeRowView.a(from.inflate(R.layout.shop_free_row_dls, viewGroup, false));
            default:
                return new ShopFreeRowView.a(from.inflate(R.layout.shop_free_row_dls, viewGroup, false));
        }
    }

    /* renamed from: O */
    public void C(@NonNull b bVar) {
        super.C(bVar);
        if (bVar instanceof ShopNonPurchasedSubscriptionRowView.a) {
            this.f41097e.remove(bVar);
        }
    }

    public void P(ShopViewType shopViewType) {
        if (this.f41096d.removeIf(new c(shopViewType))) {
            l();
        }
    }

    public void Q(e eVar, int i10) {
        this.f41096d.set(i10, eVar);
        n(i10, eVar);
    }

    public void R(List<e> list) {
        this.f41096d.clear();
        this.f41096d.addAll(list);
        l();
    }

    public int g() {
        return this.f41096d.size();
    }

    public int i(int i10) {
        if (i10 < this.f41096d.size()) {
            return this.f41096d.get(i10).a().ordinal();
        }
        return ShopViewType.f36500k.ordinal();
    }
}
