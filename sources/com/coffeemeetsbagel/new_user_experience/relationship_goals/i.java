package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import android.view.View;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalsPresenter;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RelationshipGoalsPageView f35631a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RelationshipGoalsPresenter.a f35632b;

    public /* synthetic */ i(RelationshipGoalsPageView relationshipGoalsPageView, RelationshipGoalsPresenter.a aVar) {
        this.f35631a = relationshipGoalsPageView;
        this.f35632b = aVar;
    }

    public final void onClick(View view) {
        RelationshipGoalsPageView.e(this.f35631a, this.f35632b, view);
    }
}
