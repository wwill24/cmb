package com.coffeemeetsbagel.qna.data;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f36250a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionRepository f36251b;

    public /* synthetic */ e(List list, QuestionRepository questionRepository) {
        this.f36250a = list;
        this.f36251b = questionRepository;
    }

    public final Object call() {
        return QuestionRepository.Y(this.f36250a, this.f36251b);
    }
}
