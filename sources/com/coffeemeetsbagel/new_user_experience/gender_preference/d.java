package com.coffeemeetsbagel.new_user_experience.gender_preference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.h;

public final class d extends b6.c<k, c> {

    public interface a extends j<f> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35065a;

        /* renamed from: b  reason: collision with root package name */
        private final f f35066b;

        public b(ViewGroup viewGroup, f fVar) {
            kotlin.jvm.internal.j.g(viewGroup, "view");
            kotlin.jvm.internal.j.g(fVar, "interactor");
            this.f35065a = viewGroup;
            this.f35066b = fVar;
        }

        public final GenderPreferencePresenter a() {
            return new GenderPreferencePresenter(this.f35065a, this.f35066b);
        }
    }

    public interface c {
        na.b j();

        ProfileManager m();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(h.a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final k b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        f fVar = new f();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_gender_preference, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, fVar)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new k(viewGroup2, a10, fVar);
    }
}
