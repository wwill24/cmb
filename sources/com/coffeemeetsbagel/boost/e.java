package com.coffeemeetsbagel.boost;

import android.view.View;
import com.coffeemeetsbagel.models.Price;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BoostDialogFragment f11460a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Price f11461b;

    public /* synthetic */ e(BoostDialogFragment boostDialogFragment, Price price) {
        this.f11460a = boostDialogFragment;
        this.f11461b = price;
    }

    public final void onClick(View view) {
        BoostDialogFragment.k1(this.f11460a, this.f11461b, view);
    }
}
