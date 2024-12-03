package com.coffeemeetsbagel.products.my_answers.presentation;

import c6.b;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.g;
import kotlin.Pair;
import kotlin.Unit;
import qj.h;
import ta.a;

public final class h0 {
    public static void a(MyAnswersInteractor myAnswersInteractor, b bVar) {
        myAnswersInteractor.f35826k = bVar;
    }

    public static void b(MyAnswersInteractor myAnswersInteractor, h<Unit> hVar) {
        myAnswersInteractor.f35824h = hVar;
    }

    public static void c(MyAnswersInteractor myAnswersInteractor, DeletePromptAnswerUseCase deletePromptAnswerUseCase) {
        myAnswersInteractor.f35827l = deletePromptAnswerUseCase;
    }

    public static void d(MyAnswersInteractor myAnswersInteractor, h<Pair<QuestionWAnswers, Integer>> hVar) {
        myAnswersInteractor.f35825j = hVar;
    }

    public static void e(MyAnswersInteractor myAnswersInteractor, g gVar) {
        myAnswersInteractor.f35830p = gVar;
    }

    public static void f(MyAnswersInteractor myAnswersInteractor, QuestionRepository questionRepository) {
        myAnswersInteractor.f35829n = questionRepository;
    }

    public static void g(MyAnswersInteractor myAnswersInteractor, a aVar) {
        myAnswersInteractor.f35823g = aVar;
    }

    public static void h(MyAnswersInteractor myAnswersInteractor, UserRepository userRepository) {
        myAnswersInteractor.f35828m = userRepository;
    }
}
