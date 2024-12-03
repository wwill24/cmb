package com.coffeemeetsbagel.upsell_banner;

import android.graphics.Rect;
import android.view.TouchDelegate;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class UpsellBannerPresenter$didLoad$1 extends Lambda implements Function1<CmbImageView, Unit> {
    final /* synthetic */ UpsellBannerPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpsellBannerPresenter$didLoad$1(UpsellBannerPresenter upsellBannerPresenter) {
        super(1);
        this.this$0 = upsellBannerPresenter;
    }

    public final void a(CmbImageView cmbImageView) {
        Rect rect = new Rect();
        if (cmbImageView != null) {
            cmbImageView.getHitRect(rect);
        }
        rect.top -= this.this$0.f37555j;
        rect.left -= this.this$0.f37555j;
        rect.bottom += this.this$0.f37555j;
        rect.right += this.this$0.f37555j;
        this.this$0.f37551e.getRoot().setTouchDelegate(new TouchDelegate(rect, cmbImageView));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((CmbImageView) obj);
        return Unit.f32013a;
    }
}
