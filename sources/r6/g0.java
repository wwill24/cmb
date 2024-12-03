package r6;

import android.content.Intent;
import b6.r;
import b6.u;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.discover_feed.list.DiscoverFeedListView;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.subscription_dialog.dialog.e;
import com.coffeemeetsbagel.subscription_dialog.dialog.w;
import com.coffeemeetsbagel.subscription_dialog.dialog.y;
import com.coffeemeetsbagel.util.RequestCode;
import lc.a;
import r6.e;

public class g0 extends u<DiscoverFeedListView, e.a, u> {

    /* renamed from: f  reason: collision with root package name */
    private w f17301f;

    public g0(DiscoverFeedListView discoverFeedListView, e.a aVar, u uVar) {
        super(discoverFeedListView, aVar, uVar);
    }

    public void m(PurchaseSource purchaseSource) {
        PremiumUpsellComponentActivity.f36846j.b(((e.a) e()).a(), purchaseSource);
    }

    public void n(Bagel bagel) {
        ActivityMain a10 = ((e.a) e()).a();
        Intent intent = new Intent(a10, ChatActivity.class);
        intent.putExtra(Extra.BAGEL, bagel);
        a.d(a10, intent, RequestCode.GENERIC);
    }

    public void o(NetworkProfile networkProfile, int i10, boolean z10, boolean z11, Integer num, String str) {
        ActivityMain a10 = ((e.a) e()).a();
        Intent intent = new Intent(a10, BagelProfileComponentActivity.class);
        intent.putExtra("profile", networkProfile);
        intent.putExtra("source", "discover feed");
        intent.putExtra(Extra.SHOULD_SHOW_GIVE_OVERLAY, false);
        intent.putExtra(Extra.GIVE_TAKE_POSITION, i10);
        intent.putExtra(Extra.IS_RISING_GIVE_TAKE, z10);
        intent.putExtra(Extra.HAS_BEEN_ACTED_ON, z11);
        intent.putExtra(Extra.MATCH_TYPE, str);
        if (num != null) {
            intent.putExtra(Extra.VIEW_PAGER_POSITION, num);
        }
        a10.startActivityForResult(intent, RequestCode.PROFILE_DETAIL_VIEW);
    }

    public void p(PurchaseSource purchaseSource, PurchaseType purchaseType, Price price) {
        if (this.f17301f == null) {
            w b10 = new com.coffeemeetsbagel.subscription_dialog.dialog.e((e.a) e()).b(((e.a) e()).a(), (y) null);
            this.f17301f = b10;
            r.a(b10);
        }
        this.f17301f.r(SubscriptionBenefitAttribution.f36723a.a(purchaseSource), purchaseSource, purchaseType, true, price);
    }

    public void q(Price price, Class cls) {
        ActivityMain a10 = ((e.a) e()).a();
        Intent intent = new Intent(a10, cls);
        intent.putExtra(Extra.PURCHASE_TYPE, PurchaseType.DISCOVER_LIKES);
        intent.putExtra(Extra.PRICE, price);
        intent.putExtra(Extra.ITEM_COUNT, 1);
        a.d(a10, intent, RequestCode.BEAN_SHOP);
    }
}
