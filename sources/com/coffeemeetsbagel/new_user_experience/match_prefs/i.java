package com.coffeemeetsbagel.new_user_experience.match_prefs;

import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import fj.d;
import fj.g;

public final class i implements d<MatchPrefsPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final e.b f35448a;

    public i(e.b bVar) {
        this.f35448a = bVar;
    }

    public static i a(e.b bVar) {
        return new i(bVar);
    }

    public static MatchPrefsPresenter c(e.b bVar) {
        return (MatchPrefsPresenter) g.e(bVar.d());
    }

    /* renamed from: b */
    public MatchPrefsPresenter get() {
        return c(this.f35448a);
    }
}
