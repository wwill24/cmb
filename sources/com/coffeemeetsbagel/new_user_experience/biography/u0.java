package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import android.widget.EditText;

public final /* synthetic */ class u0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiographyPresenter f34897a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f34898b;

    public /* synthetic */ u0(BiographyPresenter biographyPresenter, EditText editText) {
        this.f34897a = biographyPresenter;
        this.f34898b = editText;
    }

    public final void onClick(View view) {
        BiographyPresenter.P(this.f34897a, this.f34898b, view);
    }
}
