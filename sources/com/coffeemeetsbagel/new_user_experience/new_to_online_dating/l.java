package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.new_user_experience.new_to_online_dating.d;
import kotlin.jvm.internal.j;

public final class l extends u<ViewGroup, d.a, NewToOnlineDatingInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ViewGroup viewGroup, d.a aVar, NewToOnlineDatingInteractor newToOnlineDatingInteractor) {
        super(viewGroup, aVar, newToOnlineDatingInteractor);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(newToOnlineDatingInteractor, "interactor");
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        NewToOnlineDatingPage newToOnlineDatingPage;
        NewToOnlineDatingPageView n10 = ((NewToOnlineDatingPresenter) ((NewToOnlineDatingInteractor) f()).G1()).n();
        if (n10 != null) {
            newToOnlineDatingPage = n10.h();
        } else {
            newToOnlineDatingPage = null;
        }
        if (newToOnlineDatingPage == NewToOnlineDatingPage.QUESTION) {
            return super.h();
        }
        ((NewToOnlineDatingInteractor) f()).g(true);
        return true;
    }
}
