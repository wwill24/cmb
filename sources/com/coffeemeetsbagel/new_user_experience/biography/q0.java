package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;

public final /* synthetic */ class q0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiographyPresenter f34884a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbRadioGroup f34885b;

    public /* synthetic */ q0(BiographyPresenter biographyPresenter, CmbRadioGroup cmbRadioGroup) {
        this.f34884a = biographyPresenter;
        this.f34885b = cmbRadioGroup;
    }

    public final void onClick(View view) {
        BiographyPresenter.G(this.f34884a, this.f34885b, view);
    }
}
