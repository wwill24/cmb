package com.coffeemeetsbagel.fragments;

import android.view.View;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class s3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13829a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f13830b;

    public /* synthetic */ s3(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers) {
        this.f13829a = fragmentMyProfileDetails;
        this.f13830b = questionWAnswers;
    }

    public final void onClick(View view) {
        FragmentMyProfileDetails.l5(this.f13829a, this.f13830b, view);
    }
}
