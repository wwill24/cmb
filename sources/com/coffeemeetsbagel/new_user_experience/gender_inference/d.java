package com.coffeemeetsbagel.new_user_experience.gender_inference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.new_user_experience.h;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import d7.g;

public final class d extends b6.c<s, c> {

    public interface a extends j<GenderInferenceInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35042a;

        /* renamed from: b  reason: collision with root package name */
        private final GenderInferenceInteractor f35043b;

        public b(ViewGroup viewGroup, GenderInferenceInteractor genderInferenceInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "view");
            kotlin.jvm.internal.j.g(genderInferenceInteractor, "interactor");
            this.f35042a = viewGroup;
            this.f35043b = genderInferenceInteractor;
        }

        public final GenderInferencePresenter a() {
            return new GenderInferencePresenter(this.f35042a, this.f35043b);
        }
    }

    public interface c {
        ProfileRepository A();

        g E();

        com.coffeemeetsbagel.qna.j R0();

        s9.a b();

        UserRepository e();

        na.b j();

        SaveAnswerUseCase l();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(h.a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final s b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        GenderInferenceInteractor genderInferenceInteractor = new GenderInferenceInteractor();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_gender_inference, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, genderInferenceInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new s(viewGroup2, a10, genderInferenceInteractor);
    }
}
