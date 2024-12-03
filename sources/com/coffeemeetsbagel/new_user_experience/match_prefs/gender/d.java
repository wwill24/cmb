package com.coffeemeetsbagel.new_user_experience.match_prefs.gender;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.j;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;

public final class d extends b6.c<j, c> {

    public interface a extends j<GenderMatchPreferenceInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ia.c f35371a;

        public b(ia.c cVar) {
            kotlin.jvm.internal.j.g(cVar, "binding");
            this.f35371a = cVar;
        }

        public final i a() {
            return new i(this.f35371a);
        }
    }

    public interface c {
        b6.d<?, ?> a();

        ProfileManager d();

        l j();

        k k();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final j b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        GenderMatchPreferenceInteractor genderMatchPreferenceInteractor = new GenderMatchPreferenceInteractor();
        LayoutInflater from = LayoutInflater.from(((c) a()).a());
        kotlin.jvm.internal.j.f(from, "from(dependency.componentActivity())");
        ia.c c10 = ia.c.c(from, viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().b(new b(c10)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "builder()\n              …\n                .build()");
        ConstraintLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "binding.root");
        return new j(b10, a10, genderMatchPreferenceInteractor);
    }
}
