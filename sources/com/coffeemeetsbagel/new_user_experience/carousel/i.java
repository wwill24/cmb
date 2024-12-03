package com.coffeemeetsbagel.new_user_experience.carousel;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.new_user_experience.carousel.a;
import kotlin.jvm.internal.j;

public final class i extends u<ViewGroup, a.C0417a, c> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(ViewGroup viewGroup, a.C0417a aVar, c cVar) {
        super(viewGroup, aVar, cVar);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(cVar, "interactor");
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return ((CarouselPresenter) ((c) f()).G1()).q() || super.h();
    }
}
