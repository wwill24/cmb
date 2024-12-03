package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.View;
import com.coffeemeetsbagel.match_prefs.f;

public final /* synthetic */ class d0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MatchPrefsPresenter f35285a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f35286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f35287c;

    public /* synthetic */ d0(MatchPrefsPresenter matchPrefsPresenter, f fVar, boolean z10) {
        this.f35285a = matchPrefsPresenter;
        this.f35286b = fVar;
        this.f35287c = z10;
    }

    public final void onClick(View view) {
        MatchPrefsPresenter.C(this.f35285a, this.f35286b, this.f35287c, view);
    }
}
