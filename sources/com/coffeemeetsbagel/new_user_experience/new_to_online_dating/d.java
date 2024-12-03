package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import d7.g;

public final class d extends b6.c<l, c> {

    public interface a extends j<NewToOnlineDatingInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35528a;

        /* renamed from: b  reason: collision with root package name */
        private final NewToOnlineDatingInteractor f35529b;

        public b(ViewGroup viewGroup, NewToOnlineDatingInteractor newToOnlineDatingInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "viewGroup");
            kotlin.jvm.internal.j.g(newToOnlineDatingInteractor, "interactor");
            this.f35528a = viewGroup;
            this.f35529b = newToOnlineDatingInteractor;
        }

        public final NewToOnlineDatingPresenter a() {
            return new NewToOnlineDatingPresenter(this.f35528a, this.f35529b);
        }
    }

    public interface c {
        ProfileRepository A();

        g E();

        b6.d<?, ?> a();

        a7.a c();

        na.b j();

        hb.c y0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final l b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        NewToOnlineDatingInteractor newToOnlineDatingInteractor = new NewToOnlineDatingInteractor();
        View inflate = LayoutInflater.from(((c) a()).a()).inflate(R.layout.onboarding_component_new_to_online_dating, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, newToOnlineDatingInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(viewGroup2, a10, newToOnlineDatingInteractor);
    }
}
