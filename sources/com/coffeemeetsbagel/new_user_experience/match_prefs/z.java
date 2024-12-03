package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.View;
import com.coffeemeetsbagel.match_prefs.f;

public final /* synthetic */ class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MatchPrefsPresenter f35485a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f35486b;

    public /* synthetic */ z(MatchPrefsPresenter matchPrefsPresenter, f fVar) {
        this.f35485a = matchPrefsPresenter;
        this.f35486b = fVar;
    }

    public final void onClick(View view) {
        MatchPrefsPresenter.H(this.f35485a, this.f35486b, view);
    }
}
