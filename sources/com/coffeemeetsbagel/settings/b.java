package com.coffeemeetsbagel.settings;

import android.view.View;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f36397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettingsViewModel f36398b;

    public /* synthetic */ b(SettingsActivity settingsActivity, SettingsViewModel settingsViewModel) {
        this.f36397a = settingsActivity;
        this.f36398b = settingsViewModel;
    }

    public final void onClick(View view) {
        SettingsActivity.K0(this.f36397a, this.f36398b, view);
    }
}
