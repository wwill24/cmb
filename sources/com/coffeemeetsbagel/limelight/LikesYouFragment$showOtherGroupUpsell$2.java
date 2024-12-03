package com.coffeemeetsbagel.limelight;

import androidx.fragment.app.h;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouFragment$showOtherGroupUpsell$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PurchaseSource $purchaseSource;
    final /* synthetic */ LikesYouFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouFragment$showOtherGroupUpsell$2(LikesYouFragment likesYouFragment, PurchaseSource purchaseSource) {
        super(0);
        this.this$0 = likesYouFragment;
        this.$purchaseSource = purchaseSource;
    }

    public final void invoke() {
        PremiumUpsellComponentActivity.a aVar = PremiumUpsellComponentActivity.f36846j;
        h requireActivity = this.this$0.requireActivity();
        j.f(requireActivity, "requireActivity()");
        aVar.b(requireActivity, this.$purchaseSource);
    }
}
