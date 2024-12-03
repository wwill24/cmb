package com.coffeemeetsbagel.feature.profile_completion_helper.religion;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import kotlin.jvm.internal.j;

public final class f implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f13363b;

    /* renamed from: c  reason: collision with root package name */
    private final i f13364c;

    /* renamed from: d  reason: collision with root package name */
    private final SaveAnswerUseCase f13365d;

    public f(UserRepository userRepository, i iVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(userRepository, "userRepository");
        j.g(iVar, "getQuestionUseCase");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13363b = userRepository;
        this.f13364c = iVar;
        this.f13365d = saveAnswerUseCase;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        return new ReligionViewModel(this.f13363b, this.f13364c, this.f13365d);
    }
}
