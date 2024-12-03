package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MatchPreferencesFragment f13323a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13324b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13325c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f13326d;

    public /* synthetic */ h(MatchPreferencesFragment matchPreferencesFragment, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3) {
        this.f13323a = matchPreferencesFragment;
        this.f13324b = cmbTextView;
        this.f13325c = cmbTextView2;
        this.f13326d = cmbTextView3;
    }

    public final void onClick(View view) {
        MatchPreferencesFragment.o1(this.f13323a, this.f13324b, this.f13325c, this.f13326d, view);
    }
}
