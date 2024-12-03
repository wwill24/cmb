package com.coffeemeetsbagel.new_user_experience.notification;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.new_user_experience.OnboardingComponentActivity;
import com.coffeemeetsbagel.new_user_experience.notification.d;
import kotlin.jvm.internal.j;

public final class i extends u<ViewGroup, d.a, f> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(ViewGroup viewGroup, d.a aVar, f fVar) {
        super(viewGroup, aVar, fVar);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(fVar, "interactor");
    }

    public final void m() {
        b6.d<?, ?> a10 = ((d.a) e()).a();
        j.e(a10, "null cannot be cast to non-null type com.coffeemeetsbagel.new_user_experience.OnboardingComponentActivity");
        ((OnboardingComponentActivity) a10).R0();
    }
}
