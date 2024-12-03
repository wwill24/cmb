package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.d;
import kotlin.jvm.internal.j;

public final class l extends u<ViewGroup, d.b, f> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ViewGroup viewGroup, d.b bVar, f fVar) {
        super(viewGroup, bVar, fVar);
        j.g(viewGroup, "view");
        j.g(bVar, "component");
        j.g(fVar, "interactor");
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        RelationshipGoalPage relationshipGoalPage;
        RelationshipGoalsPageView n10 = ((RelationshipGoalsPresenter) ((f) f()).G1()).n();
        if (n10 != null) {
            relationshipGoalPage = n10.g();
        } else {
            relationshipGoalPage = null;
        }
        if (relationshipGoalPage == RelationshipGoalPage.FIRST_QUESTION) {
            return super.h();
        }
        ((f) f()).g(true);
        return true;
    }

    public final void m() {
        CmbLinks.Companion.launchCasualAppsSearch(((d.b) e()).a());
    }

    public final void n() {
        CmbLinks.Companion.launchTinderWebsite(((d.b) e()).a());
    }
}
