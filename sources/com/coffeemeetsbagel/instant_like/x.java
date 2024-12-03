package com.coffeemeetsbagel.instant_like;

import android.view.View;
import com.coffeemeetsbagel.models.Price;

public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstantLikeBottomSheetRouter f14045a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Price f14046b;

    public /* synthetic */ x(InstantLikeBottomSheetRouter instantLikeBottomSheetRouter, Price price) {
        this.f14045a = instantLikeBottomSheetRouter;
        this.f14046b = price;
    }

    public final void onClick(View view) {
        InstantLikeBottomSheetRouter.u(this.f14045a, this.f14046b, view);
    }
}
