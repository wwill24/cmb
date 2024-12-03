package com.coffeemeetsbagel.new_user_experience.carousel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;

public final class a extends b6.c<i, c> {

    /* renamed from: com.coffeemeetsbagel.new_user_experience.carousel.a$a  reason: collision with other inner class name */
    public interface C0417a extends j<c> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f34933a;

        /* renamed from: b  reason: collision with root package name */
        private final c f34934b;

        public b(ViewGroup viewGroup, c cVar) {
            kotlin.jvm.internal.j.g(viewGroup, "carouselView");
            kotlin.jvm.internal.j.g(cVar, "interactor");
            this.f34933a = viewGroup;
            this.f34934b = cVar;
        }

        public final CarouselPresenter a() {
            return new CarouselPresenter(this.f34933a, this.f34934b);
        }
    }

    public interface c {
        a7.a c();

        na.b j();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final i b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        c cVar = new c();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_onboarding_carousel, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        C0417a a10 = k.a().b(new b(viewGroup2, cVar)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new i(viewGroup2, a10, cVar);
    }
}
