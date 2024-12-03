package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.function.Consumer;

public final /* synthetic */ class d3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13645a;

    public /* synthetic */ d3(FragmentMyProfileDetails fragmentMyProfileDetails) {
        this.f13645a = fragmentMyProfileDetails;
    }

    public final void accept(Object obj) {
        FragmentMyProfileDetails.i5(this.f13645a, (QuestionWAnswers) obj);
    }
}
