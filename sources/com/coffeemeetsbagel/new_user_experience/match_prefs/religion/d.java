package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.j;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;

public final class d extends b6.c<l, a> {

    public interface a {
        c9.a I();

        a7.a c();

        ProfileManager d();

        l j();

        k k();
    }

    public interface b extends j<ReligionMatchPreferenceInteractor> {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ia.b f35471a;

        public c(ia.b bVar) {
            kotlin.jvm.internal.j.g(bVar, "binding");
            this.f35471a = bVar;
        }

        public final k a() {
            return new k(this.f35471a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final l b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        ReligionMatchPreferenceInteractor religionMatchPreferenceInteractor = new ReligionMatchPreferenceInteractor();
        ia.b c10 = ia.b.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        b a10 = b.a().c(new c(c10)).b((a) a()).a();
        ConstraintLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "binding.root");
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(b10, a10, religionMatchPreferenceInteractor);
    }
}
