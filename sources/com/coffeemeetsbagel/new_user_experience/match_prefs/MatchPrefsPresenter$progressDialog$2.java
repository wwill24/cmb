package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.ViewGroup;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import r7.h;

final class MatchPrefsPresenter$progressDialog$2 extends Lambda implements Function0<h> {
    final /* synthetic */ ViewGroup $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchPrefsPresenter$progressDialog$2(ViewGroup viewGroup) {
        super(0);
        this.$view = viewGroup;
    }

    /* renamed from: a */
    public final h invoke() {
        return new h(this.$view.getContext());
    }
}
