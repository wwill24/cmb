package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.m;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import k6.y;

public final class d extends b6.c<n, c> {

    public interface a extends j<HeightMatchPreferencesImperialInteractor> {
        b6.d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final y f35401a;

        /* renamed from: b  reason: collision with root package name */
        private final m.a f35402b;

        public b(y yVar, m.a aVar) {
            kotlin.jvm.internal.j.g(yVar, "binding");
            kotlin.jvm.internal.j.g(aVar, "listener");
            this.f35401a = yVar;
            this.f35402b = aVar;
        }

        public final m a() {
            return new m(this.f35401a, this.f35402b);
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
        HeightMatchPreferencesImperialInteractor heightMatchPreferencesImperialInteractor = new HeightMatchPreferencesImperialInteractor(questionWAnswers, z10);
        y c10 = y.c(LayoutInflater.from(((c) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().b(new b(c10, heightMatchPreferencesImperialInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new n(c10, a10, heightMatchPreferencesImperialInteractor);
    }
}
