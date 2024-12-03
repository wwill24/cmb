package com.coffeemeetsbagel.match_prefs.dealbreaker;

import a6.a;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import kotlin.jvm.internal.j;

public final class d extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private final a f34580i;

    /* renamed from: j  reason: collision with root package name */
    private final QuestionRepository f34581j;

    /* renamed from: k  reason: collision with root package name */
    private final UserRepository f34582k;

    public d(a aVar, QuestionRepository questionRepository, UserRepository userRepository) {
        j.g(aVar, "coachmarkManager");
        j.g(questionRepository, "questionRepository");
        j.g(userRepository, "userRepository");
        this.f34580i = aVar;
        this.f34581j = questionRepository;
        this.f34582k = userRepository;
    }

    public <T extends f0> T b(Class<T> cls, m1.a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        return new DealbreakerSheetViewModel(this.f34580i, this.f34581j, this.f34582k);
    }
}
