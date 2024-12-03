package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.j;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;

public final class d extends b6.c<l, c> {

    public interface a extends j<EthnicityMatchPreferenceInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ia.b f35344a;

        public b(ia.b bVar) {
            kotlin.jvm.internal.j.g(bVar, "binding");
            this.f35344a = bVar;
        }

        public final k a() {
            return new k(this.f35344a);
        }
    }

    public interface c {
        c9.a I();

        a7.a c();

        ProfileManager d();

        l j();

        k k();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final l b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        EthnicityMatchPreferenceInteractor ethnicityMatchPreferenceInteractor = new EthnicityMatchPreferenceInteractor();
        ia.b c10 = ia.b.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().b(new b(c10)).c((c) a()).a();
        ConstraintLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "binding.root");
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(b10, a10, ethnicityMatchPreferenceInteractor);
    }
}
