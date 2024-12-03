package com.coffeemeetsbagel.new_user_experience.gender_inference;

import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import d7.g;
import na.b;
import s9.a;

public final class n {
    public static void a(GenderInferenceInteractor genderInferenceInteractor, g gVar) {
        genderInferenceInteractor.f35021h = gVar;
    }

    public static void b(GenderInferenceInteractor genderInferenceInteractor, a aVar) {
        genderInferenceInteractor.f35024l = aVar;
    }

    public static void c(GenderInferenceInteractor genderInferenceInteractor, b bVar) {
        genderInferenceInteractor.f35019f = bVar;
    }

    public static void d(GenderInferenceInteractor genderInferenceInteractor, ProfileRepository profileRepository) {
        genderInferenceInteractor.f35020g = profileRepository;
    }

    public static void e(GenderInferenceInteractor genderInferenceInteractor, j jVar) {
        genderInferenceInteractor.f35022j = jVar;
    }

    public static void f(GenderInferenceInteractor genderInferenceInteractor, SaveAnswerUseCase saveAnswerUseCase) {
        genderInferenceInteractor.f35025m = saveAnswerUseCase;
    }

    public static void g(GenderInferenceInteractor genderInferenceInteractor, UserRepository userRepository) {
        genderInferenceInteractor.f35023k = userRepository;
    }
}
