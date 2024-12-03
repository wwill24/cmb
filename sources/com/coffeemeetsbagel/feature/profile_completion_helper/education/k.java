package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import kotlin.jvm.internal.j;

public final class k implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f13232b;

    /* renamed from: c  reason: collision with root package name */
    private final GetSingleSchoolsUseCase f13233c;

    /* renamed from: d  reason: collision with root package name */
    private final QuestionRepository f13234d;

    /* renamed from: e  reason: collision with root package name */
    private final SaveAnswerUseCase f13235e;

    public k(UserRepository userRepository, GetSingleSchoolsUseCase getSingleSchoolsUseCase, QuestionRepository questionRepository, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(userRepository, "userRepository");
        j.g(getSingleSchoolsUseCase, "getSchoolUseCase");
        j.g(questionRepository, "questionRepository");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13232b = userRepository;
        this.f13233c = getSingleSchoolsUseCase;
        this.f13234d = questionRepository;
        this.f13235e = saveAnswerUseCase;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        return new EducationViewModel(this.f13232b, this.f13233c, this.f13234d, this.f13235e);
    }
}
