package com.coffeemeetsbagel.products.prompts.editor.presentation;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import kotlin.Unit;
import qj.h;
import xa.a;

public final class s {
    public static void a(PromptEditInteractor promptEditInteractor, h<Unit> hVar) {
        promptEditInteractor.f35913h = hVar;
    }

    public static void b(PromptEditInteractor promptEditInteractor, SaveAnswerUseCase saveAnswerUseCase) {
        promptEditInteractor.f35914j = saveAnswerUseCase;
    }

    public static void c(PromptEditInteractor promptEditInteractor, a aVar) {
        promptEditInteractor.f35912g = aVar;
    }

    public static void d(PromptEditInteractor promptEditInteractor, UserRepository userRepository) {
        promptEditInteractor.f35911f = userRepository;
    }
}
