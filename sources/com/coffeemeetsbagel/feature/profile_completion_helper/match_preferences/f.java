package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MatchPreferencesFragment f13315a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13317c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13318d;

    public /* synthetic */ f(MatchPreferencesFragment matchPreferencesFragment, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3) {
        this.f13315a = matchPreferencesFragment;
        this.f13316b = cmbTextView;
        this.f13317c = cmbTextView2;
        this.f13318d = cmbTextView3;
    }

    public final void onClick(View view) {
        MatchPreferencesFragment.m1(this.f13315a, this.f13316b, this.f13317c, this.f13318d, view);
    }
}
