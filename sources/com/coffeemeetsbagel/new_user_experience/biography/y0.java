package com.coffeemeetsbagel.new_user_experience.biography;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.new_user_experience.biography.a;
import kotlin.jvm.internal.j;

public final class y0 extends u<ViewGroup, a.C0415a, BiographyInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y0(ViewGroup viewGroup, a.C0415a aVar, BiographyInteractor biographyInteractor) {
        super(viewGroup, aVar, biographyInteractor);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(biographyInteractor, "interactor");
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return ((BiographyInteractor) f()).e1(true) || super.h();
    }

    public final void m() {
        CmbLinks.Companion.launchTermsAndConditions(((a.C0415a) e()).a());
    }
}
