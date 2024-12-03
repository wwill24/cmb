package com.coffeemeetsbagel.fragments;

import android.view.View;
import com.coffeemeetsbagel.models.enums.Units;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f13852a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f13853b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Units f13854c;

    public /* synthetic */ v(i0 i0Var, QuestionWAnswers questionWAnswers, Units units) {
        this.f13852a = i0Var;
        this.f13853b = questionWAnswers;
        this.f13854c = units;
    }

    public final void onClick(View view) {
        this.f13852a.g2(this.f13853b, this.f13854c, view);
    }
}
