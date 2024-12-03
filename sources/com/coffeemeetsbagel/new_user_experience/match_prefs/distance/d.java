package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.j;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;

public final class d extends b6.c<t, c> {

    public interface a extends j<DistanceMatchPreferenceInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final k6.j f35305a;

        public b(k6.j jVar) {
            kotlin.jvm.internal.j.g(jVar, "binding");
            this.f35305a = jVar;
        }

        public final s a() {
            return new s(this.f35305a);
        }
    }

    public interface c {
        s9.a b();

        ProfileManager d();

        UserRepository e();

        l j();

        k k();

        SaveAnswerUseCase l();

        i o();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final t b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor = new DistanceMatchPreferenceInteractor();
        k6.j c10 = k6.j.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().b(new b(c10)).c((c) a()).a();
        ConstraintLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "binding.root");
        kotlin.jvm.internal.j.f(a10, "component");
        return new t(b10, a10, distanceMatchPreferenceInteractor);
    }
}
