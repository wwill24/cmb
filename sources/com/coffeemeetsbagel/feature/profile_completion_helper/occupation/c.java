package com.coffeemeetsbagel.feature.profile_completion_helper.occupation;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import kotlin.jvm.internal.j;

public final class c implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f13340b;

    /* renamed from: c  reason: collision with root package name */
    private final i f13341c;

    /* renamed from: d  reason: collision with root package name */
    private final SaveAnswerUseCase f13342d;

    public c(UserRepository userRepository, i iVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(userRepository, "userRepository");
        j.g(iVar, "getQuestionUseCase");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13340b = userRepository;
        this.f13341c = iVar;
        this.f13342d = saveAnswerUseCase;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        return new OccupationViewModel(this.f13340b, this.f13341c, this.f13342d);
    }
}
