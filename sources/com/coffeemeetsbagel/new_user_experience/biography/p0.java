package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;

public final /* synthetic */ class p0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiographyPresenter f34881a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbRadioGroup f34882b;

    public /* synthetic */ p0(BiographyPresenter biographyPresenter, CmbRadioGroup cmbRadioGroup) {
        this.f34881a = biographyPresenter;
        this.f34882b = cmbRadioGroup;
    }

    public final void onClick(View view) {
        BiographyPresenter.S(this.f34881a, this.f34882b, view);
    }
}
