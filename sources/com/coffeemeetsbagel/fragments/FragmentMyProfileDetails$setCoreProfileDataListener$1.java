package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$setCoreProfileDataListener$1 extends Lambda implements Function1<QuestionWAnswers, Unit> {
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$setCoreProfileDataListener$1(FragmentMyProfileDetails fragmentMyProfileDetails) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
    }

    public final void a(QuestionWAnswers questionWAnswers) {
        j.g(questionWAnswers, "questionWAnswers");
        this.this$0.e5(questionWAnswers);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((QuestionWAnswers) obj);
        return Unit.f32013a;
    }
}
