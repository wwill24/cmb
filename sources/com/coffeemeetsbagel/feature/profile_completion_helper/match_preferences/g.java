package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MatchPreferencesFragment f13319a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13320b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13321c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13322d;

    public /* synthetic */ g(MatchPreferencesFragment matchPreferencesFragment, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3) {
        this.f13319a = matchPreferencesFragment;
        this.f13320b = cmbTextView;
        this.f13321c = cmbTextView2;
        this.f13322d = cmbTextView3;
    }

    public final void onClick(View view) {
        MatchPreferencesFragment.n1(this.f13319a, this.f13320b, this.f13321c, this.f13322d, view);
    }
}
