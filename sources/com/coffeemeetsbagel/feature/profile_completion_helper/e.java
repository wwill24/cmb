package com.coffeemeetsbagel.feature.profile_completion_helper;

import a6.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.qna.j;

public final class e extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private final GetMyOwnProfileLocalUseCase f13196i;

    /* renamed from: j  reason: collision with root package name */
    private final j f13197j;

    /* renamed from: k  reason: collision with root package name */
    private final a f13198k;

    public e(GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase, j jVar, a aVar) {
        kotlin.jvm.internal.j.g(getMyOwnProfileLocalUseCase, "getMyOwnProfileUseCase");
        kotlin.jvm.internal.j.g(jVar, "getQuestionGroupWQuestions");
        kotlin.jvm.internal.j.g(aVar, "coachmarkManager");
        this.f13196i = getMyOwnProfileLocalUseCase;
        this.f13197j = jVar;
        this.f13198k = aVar;
    }

    public <T extends f0> T b(Class<T> cls, m1.a aVar) {
        kotlin.jvm.internal.j.g(cls, "modelClass");
        kotlin.jvm.internal.j.g(aVar, "extras");
        return new ProfileCompletionHelperViewModel(this.f13196i, this.f13197j, this.f13198k);
    }
}
