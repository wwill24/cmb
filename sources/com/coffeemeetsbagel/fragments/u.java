package com.coffeemeetsbagel.fragments;

import android.view.View;
import com.coffeemeetsbagel.models.enums.Units;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f13838a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f13839b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Units f13840c;

    public /* synthetic */ u(i0 i0Var, QuestionWAnswers questionWAnswers, Units units) {
        this.f13838a = i0Var;
        this.f13839b = questionWAnswers;
        this.f13840c = units;
    }

    public final void onClick(View view) {
        this.f13838a.j2(this.f13839b, this.f13840c, view);
    }
}
