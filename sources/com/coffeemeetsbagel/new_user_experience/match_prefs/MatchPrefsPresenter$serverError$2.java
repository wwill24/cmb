package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.ViewGroup;
import com.coffeemeetsbagel.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MatchPrefsPresenter$serverError$2 extends Lambda implements Function0<String> {
    final /* synthetic */ ViewGroup $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsPresenter$serverError$2(ViewGroup viewGroup) {
        super(0);
        this.$view = viewGroup;
    }

    /* renamed from: a */
    public final String invoke() {
        return this.$view.getResources().getString(R.string.onboarding_save_error);
    }
}
