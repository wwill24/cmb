package com.coffeemeetsbagel.instant_like;

import android.view.View;
import com.coffeemeetsbagel.models.Price;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstantLikeBottomSheetPresenter f14042a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Price f14043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14044c;

    public /* synthetic */ w(InstantLikeBottomSheetPresenter instantLikeBottomSheetPresenter, Price price, String str) {
        this.f14042a = instantLikeBottomSheetPresenter;
        this.f14043b = price;
        this.f14044c = str;
    }

    public final void onClick(View view) {
        InstantLikeBottomSheetPresenter.u(this.f14042a, this.f14043b, this.f14044c, view);
    }
}
