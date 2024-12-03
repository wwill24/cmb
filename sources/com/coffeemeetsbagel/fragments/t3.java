package com.coffeemeetsbagel.fragments;

import android.view.View;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class t3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13835a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Height f13836b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f13837c;

    public /* synthetic */ t3(FragmentMyProfileDetails fragmentMyProfileDetails, Height height, QuestionWAnswers questionWAnswers) {
        this.f13835a = fragmentMyProfileDetails;
        this.f13836b = height;
        this.f13837c = questionWAnswers;
    }

    public final void onClick(View view) {
        FragmentMyProfileDetails.m5(this.f13835a, this.f13836b, this.f13837c, view);
    }
}
