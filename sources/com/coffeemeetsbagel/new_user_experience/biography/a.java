package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import d7.g;

public final class a extends b6.c<y0, c> {

    /* renamed from: com.coffeemeetsbagel.new_user_experience.biography.a$a  reason: collision with other inner class name */
    public interface C0415a extends j<BiographyInteractor> {
        d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f34845a;

        /* renamed from: b  reason: collision with root package name */
        private final BiographyPresenter.a f34846b;

        public b(ViewGroup viewGroup, BiographyPresenter.a aVar) {
            kotlin.jvm.internal.j.g(viewGroup, "rootView");
            kotlin.jvm.internal.j.g(aVar, "listener");
            this.f34845a = viewGroup;
            this.f34846b = aVar;
        }

        public final BiographyPresenter a() {
            return new BiographyPresenter(this.f34845a, this.f34846b);
        }
    }

    public interface c {
        ProfileRepository A();

        g E();

        c9.a I();

        GetSingleSchoolsUseCase N0();

        ProfileManager V();

        m1 W();

        d<?, ?> a();

        s9.a b();

        a7.a c();

        na.b j();

        UserRepository q();

        QuestionRepository r();

        SaveAnswerUseCase s();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final y0 b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        BiographyInteractor biographyInteractor = new BiographyInteractor();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_onboarding_biography, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        C0415a b10 = a1.a().a(new b(viewGroup2, biographyInteractor)).c((c) a()).b();
        kotlin.jvm.internal.j.f(b10, "component");
        return new y0(viewGroup2, b10, biographyInteractor);
    }
}
