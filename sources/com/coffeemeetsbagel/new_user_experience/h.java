package com.coffeemeetsbagel.new_user_experience;

import android.view.ViewGroup;
import b6.c;
import b6.j;
import com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig;
import com.coffeemeetsbagel.new_user_experience.biography.a;
import com.coffeemeetsbagel.new_user_experience.birthday.a;
import com.coffeemeetsbagel.new_user_experience.carousel.a;
import com.coffeemeetsbagel.new_user_experience.email.d;
import com.coffeemeetsbagel.new_user_experience.gender.d;
import com.coffeemeetsbagel.new_user_experience.gender_inference.d;
import com.coffeemeetsbagel.new_user_experience.gender_preference.d;
import com.coffeemeetsbagel.new_user_experience.introductions.d;
import com.coffeemeetsbagel.new_user_experience.light_match.d;
import com.coffeemeetsbagel.new_user_experience.location.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import com.coffeemeetsbagel.new_user_experience.n;
import com.coffeemeetsbagel.new_user_experience.new_to_online_dating.d;
import com.coffeemeetsbagel.new_user_experience.notification.d;
import com.coffeemeetsbagel.new_user_experience.photos.d;
import com.coffeemeetsbagel.new_user_experience.profile_review.d;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.d;
import java.util.List;
import oa.d;

public final class h extends c<v, n.a> {

    public interface a extends j<OnboardingInteractor>, d.c, a.c, d.c, d.c, a.c, d.c, a.c, e.c, d.a, d.c, d.a, d.a, d.a, d.c, d.c, d.c, d.c {
        b6.d<?, ?> a();
    }

    public static final class b {
        public final androidx.appcompat.app.c a(b6.d<?, ?> dVar) {
            kotlin.jvm.internal.j.g(dVar, "componentActivity");
            return dVar;
        }

        public final na.a b(na.c cVar) {
            kotlin.jvm.internal.j.g(cVar, "relayManager");
            return cVar;
        }

        public final na.b c(na.c cVar) {
            kotlin.jvm.internal.j.g(cVar, "relayManager");
            return cVar;
        }

        public final na.c d() {
            return new na.c();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(n.a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final v b(ViewGroup viewGroup, List<? extends OnboardingNavigationConfig.Pages> list) {
        kotlin.jvm.internal.j.g(viewGroup, "viewGroup");
        kotlin.jvm.internal.j.g(list, "pages");
        OnboardingInteractor onboardingInteractor = new OnboardingInteractor();
        a a10 = b.a().b((n.a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new v(viewGroup, a10, onboardingInteractor, list);
    }
}
