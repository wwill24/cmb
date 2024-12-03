package com.coffeemeetsbagel.today_view.today_question;

import a7.a;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.today_view.main.e;

public final class s {
    public static void a(TodayQuestionInteractor todayQuestionInteractor, a aVar) {
        todayQuestionInteractor.f37505j = aVar;
    }

    public static void b(TodayQuestionInteractor todayQuestionInteractor, e.a aVar) {
        todayQuestionInteractor.f37503g = aVar;
    }

    public static void c(TodayQuestionInteractor todayQuestionInteractor, QuestionRepository questionRepository) {
        todayQuestionInteractor.f37502f = questionRepository;
    }

    public static void d(TodayQuestionInteractor todayQuestionInteractor, SaveAnswerUseCase saveAnswerUseCase) {
        todayQuestionInteractor.f37506k = saveAnswerUseCase;
    }

    public static void e(TodayQuestionInteractor todayQuestionInteractor, UserRepository userRepository) {
        todayQuestionInteractor.f37504h = userRepository;
    }
}
