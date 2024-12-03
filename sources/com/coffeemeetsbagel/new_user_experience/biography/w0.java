package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;

public final /* synthetic */ class w0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiographyPresenter f34902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelayAutoCompleteTextView f34903b;

    public /* synthetic */ w0(BiographyPresenter biographyPresenter, DelayAutoCompleteTextView delayAutoCompleteTextView) {
        this.f34902a = biographyPresenter;
        this.f34903b = delayAutoCompleteTextView;
    }

    public final void onClick(View view) {
        BiographyPresenter.V(this.f34902a, this.f34903b, view);
    }
}
