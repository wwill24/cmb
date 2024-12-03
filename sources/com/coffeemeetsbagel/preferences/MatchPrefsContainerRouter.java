package com.coffeemeetsbagel.preferences;

import android.view.ViewGroup;
import b6.q;
import com.coffeemeetsbagel.new_user_experience.g;
import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import com.coffeemeetsbagel.new_user_experience.match_prefs.h0;
import com.coffeemeetsbagel.preferences.l;
import gk.f;
import kotlin.jvm.internal.j;

public final class MatchPrefsContainerRouter extends q<l.a, MatchPrefsContainerInteractor> {

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f35788e;

    /* renamed from: f  reason: collision with root package name */
    private final f f35789f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MatchPrefsContainerRouter(ViewGroup viewGroup, l.a aVar, MatchPrefsContainerInteractor matchPrefsContainerInteractor) {
        super(aVar, matchPrefsContainerInteractor);
        j.g(viewGroup, "rootViewGroup");
        j.g(aVar, "component");
        j.g(matchPrefsContainerInteractor, "interactor");
        this.f35788e = viewGroup;
        this.f35789f = b.b(new MatchPrefsContainerRouter$errorAnimation$2(aVar));
    }

    private final g m() {
        return (g) this.f35789f.getValue();
    }

    public final void l() {
        ((l.a) e()).a().onBackPressed();
    }

    public final void n() {
        b6.j e10 = e();
        j.f(e10, "component");
        h0 b10 = new e((e.c) e10, false).b(this.f35788e);
        a(b10);
        this.f35788e.addView((ViewGroup) b10.l());
    }

    public final void o(String str) {
        j.g(str, "message");
        if (!r.w(str)) {
            m().b(str);
        } else {
            m().a();
        }
    }
}
