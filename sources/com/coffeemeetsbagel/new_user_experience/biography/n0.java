package com.coffeemeetsbagel.new_user_experience.biography;

import a7.a;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import d7.g;
import na.b;

public final class n0 {
    public static void a(BiographyInteractor biographyInteractor, a aVar) {
        biographyInteractor.f34816m = aVar;
    }

    public static void b(BiographyInteractor biographyInteractor, g gVar) {
        biographyInteractor.f34814k = gVar;
    }

    public static void c(BiographyInteractor biographyInteractor, s9.a aVar) {
        biographyInteractor.f34811g = aVar;
    }

    public static void d(BiographyInteractor biographyInteractor, c9.a aVar) {
        biographyInteractor.f34818p = aVar;
    }

    public static void e(BiographyInteractor biographyInteractor, GetSingleSchoolsUseCase getSingleSchoolsUseCase) {
        biographyInteractor.f34819q = getSingleSchoolsUseCase;
    }

    public static void f(BiographyInteractor biographyInteractor, ProfileManager profileManager) {
        biographyInteractor.f34815l = profileManager;
    }

    public static void g(BiographyInteractor biographyInteractor, b bVar) {
        biographyInteractor.f34813j = bVar;
    }

    public static void h(BiographyInteractor biographyInteractor, ProfileRepository profileRepository) {
        biographyInteractor.f34812h = profileRepository;
    }

    public static void i(BiographyInteractor biographyInteractor, QuestionRepository questionRepository) {
        biographyInteractor.f34821w = questionRepository;
    }

    public static void j(BiographyInteractor biographyInteractor, SaveAnswerUseCase saveAnswerUseCase) {
        biographyInteractor.f34820t = saveAnswerUseCase;
    }

    public static void k(BiographyInteractor biographyInteractor, m1 m1Var) {
        biographyInteractor.f34817n = m1Var;
    }

    public static void l(BiographyInteractor biographyInteractor, UserRepository userRepository) {
        biographyInteractor.f34822x = userRepository;
    }
}
