package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import android.widget.NumberPicker;

public final /* synthetic */ class s0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f34890a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f34891b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BiographyPresenter f34892c;

    public /* synthetic */ s0(NumberPicker numberPicker, NumberPicker numberPicker2, BiographyPresenter biographyPresenter) {
        this.f34890a = numberPicker;
        this.f34891b = numberPicker2;
        this.f34892c = biographyPresenter;
    }

    public final void onClick(View view) {
        BiographyPresenter.L(this.f34890a, this.f34891b, this.f34892c, view);
    }
}
