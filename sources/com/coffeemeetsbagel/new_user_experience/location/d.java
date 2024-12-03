package com.coffeemeetsbagel.new_user_experience.location;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;

public final class d extends b6.c<i, c> {

    public interface a extends j<f> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35128a;

        /* renamed from: b  reason: collision with root package name */
        private final f f35129b;

        public b(ViewGroup viewGroup, f fVar) {
            kotlin.jvm.internal.j.g(viewGroup, "LocationView");
            kotlin.jvm.internal.j.g(fVar, "interactor");
            this.f35128a = viewGroup;
            this.f35129b = fVar;
        }

        public final LocationPresenter a() {
            return new LocationPresenter(this.f35128a, this.f35129b);
        }
    }

    public interface c {
        b6.d<?, ?> a();

        na.b j();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final i b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        f fVar = new f();
        View inflate = LayoutInflater.from(((c) a()).a()).inflate(R.layout.component_onboarding_location, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        a a10 = b.a().b(new b(viewGroup2, fVar)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new i(viewGroup2, a10, fVar);
    }
}
