package com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import kotlin.jvm.internal.j;

public final class f implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f13256b;

    /* renamed from: c  reason: collision with root package name */
    private final i f13257c;

    /* renamed from: d  reason: collision with root package name */
    private final SaveAnswerUseCase f13258d;

    public f(UserRepository userRepository, i iVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(userRepository, "userRepository");
        j.g(iVar, "getQuestionUseCase");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13256b = userRepository;
        this.f13257c = iVar;
        this.f13258d = saveAnswerUseCase;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        return new EthnicityViewModel(this.f13256b, this.f13257c, this.f13258d);
    }
}
