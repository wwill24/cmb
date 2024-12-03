package com.coffeemeetsbagel.new_user_experience.email;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import d7.g;

public final class d extends b6.c<l, c> {

    public interface a extends j<EmailInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f34970a;

        /* renamed from: b  reason: collision with root package name */
        private final EmailInteractor f34971b;

        public b(ViewGroup viewGroup, EmailInteractor emailInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "emailView");
            kotlin.jvm.internal.j.g(emailInteractor, "interactor");
            this.f34970a = viewGroup;
            this.f34971b = emailInteractor;
        }

        public final EmailPresenter a() {
            return new EmailPresenter(this.f34970a, this.f34971b);
        }
    }

    public interface c {
        ProfileRepository A();

        g E();

        ProfileManager V();

        na.b j();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final l b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        EmailInteractor emailInteractor = new EmailInteractor();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_onboarding_email, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, emailInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(viewGroup2, a10, emailInteractor);
    }
}
