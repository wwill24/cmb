package com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.m;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import k6.z;

public final class d extends b6.c<n, c> {

    public interface a extends j<HeightMatchPreferencesMetricInteractor> {
        b6.d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final z f35434a;

        /* renamed from: b  reason: collision with root package name */
        private final m.a f35435b;

        public b(z zVar, m.a aVar) {
            kotlin.jvm.internal.j.g(zVar, "binding");
            kotlin.jvm.internal.j.g(aVar, "listener");
            this.f35434a = zVar;
            this.f35435b = aVar;
        }

        public final m a() {
            return new m(this.f35434a, this.f35435b);
        }
    }

    public interface c {
        b6.d<?, ?> a();

        s9.a b();

        ProfileManager d();

        l j();

        k k();

        SaveAnswerUseCase l();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final n b(ViewGroup viewGroup, QuestionWAnswers questionWAnswers, boolean z10) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        HeightMatchPreferencesMetricInteractor heightMatchPreferencesMetricInteractor = new HeightMatchPreferencesMetricInteractor(questionWAnswers, z10);
        z c10 = z.c(LayoutInflater.from(((c) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().b(new b(c10, heightMatchPreferencesMetricInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new n(c10, a10, heightMatchPreferencesMetricInteractor);
    }
}
