package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;

public final /* synthetic */ class r0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiographyPresenter f34887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbRadioGroup f34888b;

    public /* synthetic */ r0(BiographyPresenter biographyPresenter, CmbRadioGroup cmbRadioGroup) {
        this.f34887a = biographyPresenter;
        this.f34888b = cmbRadioGroup;
    }

    public final void onClick(View view) {
        BiographyPresenter.I(this.f34887a, this.f34888b, view);
    }
}
