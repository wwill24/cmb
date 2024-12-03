package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.View;

public final /* synthetic */ class f0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MatchPrefsPresenter f35354a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35355b;

    public /* synthetic */ f0(MatchPrefsPresenter matchPrefsPresenter, String str) {
        this.f35354a = matchPrefsPresenter;
        this.f35355b = str;
    }

    public final void onClick(View view) {
        MatchPrefsPresenter.K(this.f35354a, this.f35355b, view);
    }
}
