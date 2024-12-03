package com.coffeemeetsbagel.new_user_experience.profile_review;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import d7.g;

public final class d extends b6.c<i, a> {

    public interface a {
        ProfileRepository A();

        g E();

        b6.d<?, ?> a();

        na.b j();
    }

    public interface b extends j<ProfileReviewInteractor> {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35576a;

        /* renamed from: b  reason: collision with root package name */
        private final ProfileReviewInteractor f35577b;

        public c(ViewGroup viewGroup, ProfileReviewInteractor profileReviewInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "profileReviewView");
            kotlin.jvm.internal.j.g(profileReviewInteractor, "interactor");
            this.f35576a = viewGroup;
            this.f35577b = profileReviewInteractor;
        }

        public final ProfileReviewPresenter a() {
            return new ProfileReviewPresenter(this.f35576a, this.f35577b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final i b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        ProfileReviewInteractor profileReviewInteractor = new ProfileReviewInteractor();
        View inflate = LayoutInflater.from(((a) a()).a()).inflate(R.layout.component_onboarding_profile_review, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        b a10 = b.a().c(new c(viewGroup2, profileReviewInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new i(viewGroup2, a10, profileReviewInteractor);
    }
}
