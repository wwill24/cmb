package com.coffeemeetsbagel.qna.data;

import vj.a;

public final /* synthetic */ class k implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuestionRepository f36257a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36258b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f36259c;

    public /* synthetic */ k(QuestionRepository questionRepository, String str, String str2) {
        this.f36257a = questionRepository;
        this.f36258b = str;
        this.f36259c = str2;
    }

    public final void run() {
        QuestionRepository.w(this.f36257a, this.f36258b, this.f36259c);
    }
}
