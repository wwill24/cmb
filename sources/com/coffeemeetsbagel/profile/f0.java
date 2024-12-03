package com.coffeemeetsbagel.profile;

import android.view.View;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;

public final /* synthetic */ class f0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileView f36089a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionGroupType f36090b;

    public /* synthetic */ f0(ProfileView profileView, QuestionGroupType questionGroupType) {
        this.f36089a = profileView;
        this.f36090b = questionGroupType;
    }

    public final void onClick(View view) {
        this.f36089a.I(this.f36090b, view);
    }
}
