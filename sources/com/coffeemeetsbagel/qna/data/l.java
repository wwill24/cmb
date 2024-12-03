package com.coffeemeetsbagel.qna.data;

import java.util.concurrent.Callable;
import za.g;

public final /* synthetic */ class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuestionRepository f36260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f36262c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f36263d;

    public /* synthetic */ l(QuestionRepository questionRepository, String str, g gVar, boolean z10) {
        this.f36260a = questionRepository;
        this.f36261b = str;
        this.f36262c = gVar;
        this.f36263d = z10;
    }

    public final Object call() {
        return QuestionRepository.a0(this.f36260a, this.f36261b, this.f36262c, this.f36263d);
    }
}
