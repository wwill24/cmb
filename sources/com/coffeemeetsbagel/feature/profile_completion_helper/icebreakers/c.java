package com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;

public final class c implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f13270b;

    /* renamed from: c  reason: collision with root package name */
    private final j f13271c;

    /* renamed from: d  reason: collision with root package name */
    private final SaveAnswerUseCase f13272d;

    public c(UserRepository userRepository, j jVar, SaveAnswerUseCase saveAnswerUseCase) {
        kotlin.jvm.internal.j.g(userRepository, "userRepository");
        kotlin.jvm.internal.j.g(jVar, "getQuestionUseCase");
        kotlin.jvm.internal.j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13270b = userRepository;
        this.f13271c = jVar;
        this.f13272d = saveAnswerUseCase;
    }

    public <T extends f0> T a(Class<T> cls) {
        kotlin.jvm.internal.j.g(cls, "modelClass");
        return new IcebreakersViewModel(this.f13270b, this.f13271c, this.f13272d);
    }
}
