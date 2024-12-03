package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import com.coffeemeetsbagel.new_user_experience.numberPickers.CentimeterHeightPicker;

public final /* synthetic */ class t0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CentimeterHeightPicker f34894a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiographyPresenter f34895b;

    public /* synthetic */ t0(CentimeterHeightPicker centimeterHeightPicker, BiographyPresenter biographyPresenter) {
        this.f34894a = centimeterHeightPicker;
        this.f34895b = biographyPresenter;
    }

    public final void onClick(View view) {
        BiographyPresenter.N(this.f34894a, this.f34895b, view);
    }
}
