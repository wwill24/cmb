package com.coffeemeetsbagel.new_user_experience.gender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import d7.g;

public final class d extends b6.c<s, c> {

    public interface a extends j<GenderInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35005a;

        /* renamed from: b  reason: collision with root package name */
        private final GenderInteractor f35006b;

        public b(ViewGroup viewGroup, GenderInteractor genderInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "view");
            kotlin.jvm.internal.j.g(genderInteractor, "interactor");
            this.f35005a = viewGroup;
            this.f35006b = genderInteractor;
        }

        public final GenderPresenter a() {
            return new GenderPresenter(this.f35005a, this.f35006b);
        }
    }

    public interface c {
        g E();

        s9.a b();

        na.b j();

        ProfileManager m();

        com.coffeemeetsbagel.qna.j p();

        SaveAnswerUseCase t();

        r0 v0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final s b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        GenderInteractor genderInteractor = new GenderInteractor();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_gender, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, genderInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new s(viewGroup2, a10, genderInteractor);
    }
}
