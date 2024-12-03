package com.coffeemeetsbagel.new_user_experience.introductions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import d7.g;

public final class d extends b6.c<p, c> {

    public interface a extends j<IntroductionsInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35094a;

        /* renamed from: b  reason: collision with root package name */
        private final IntroductionsInteractor f35095b;

        public b(ViewGroup viewGroup, IntroductionsInteractor introductionsInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "introductionsLayout");
            kotlin.jvm.internal.j.g(introductionsInteractor, "interactor");
            this.f35094a = viewGroup;
            this.f35095b = introductionsInteractor;
        }

        public final IntroductionsPresenter a() {
            return new IntroductionsPresenter(this.f35094a, this.f35095b);
        }
    }

    public interface c {
        ProfileRepository A();

        g E();

        a7.a c();

        na.b j();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final p b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        IntroductionsInteractor introductionsInteractor = new IntroductionsInteractor();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_onboarding_introductions, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, introductionsInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new p(viewGroup2, a10, introductionsInteractor);
    }
}
