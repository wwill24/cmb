package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileManager;

public final class d extends b6.c<l, a> {

    public interface a {
        ProfileManager V();

        b6.d<?, ?> a();

        s9.a b();

        a7.a c();

        na.b j();

        hb.c y0();
    }

    public interface b extends j<f> {
        b6.d<?, ?> a();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35620a;

        /* renamed from: b  reason: collision with root package name */
        private final f f35621b;

        public c(ViewGroup viewGroup, f fVar) {
            kotlin.jvm.internal.j.g(viewGroup, "viewGroup");
            kotlin.jvm.internal.j.g(fVar, "interactor");
            this.f35620a = viewGroup;
            this.f35621b = fVar;
        }

        public final RelationshipGoalsPresenter a() {
            return new RelationshipGoalsPresenter(this.f35620a, this.f35621b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final l b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        f fVar = new f();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.onboarding_component_relationship_goals, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        b a10 = b.a().c(new c(viewGroup2, fVar)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(viewGroup2, a10, fVar);
    }
}
