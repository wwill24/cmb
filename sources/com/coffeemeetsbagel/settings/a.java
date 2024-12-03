package com.coffeemeetsbagel.settings;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f36395a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettingsViewModel f36396b;

    public /* synthetic */ a(SettingsActivity settingsActivity, SettingsViewModel settingsViewModel) {
        this.f36395a = settingsActivity;
        this.f36396b = settingsViewModel;
    }

    public final void onClick(View view) {
        SettingsActivity.J0(this.f36395a, this.f36396b, view);
    }
}
