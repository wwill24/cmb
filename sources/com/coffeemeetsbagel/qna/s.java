package com.coffeemeetsbagel.qna;

import java.util.concurrent.Callable;

public final /* synthetic */ class s implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuestionDaoV2Impl f36306a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36307b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f36308c;

    public /* synthetic */ s(QuestionDaoV2Impl questionDaoV2Impl, String str, int i10) {
        this.f36306a = questionDaoV2Impl;
        this.f36307b = str;
        this.f36308c = i10;
    }

    public final Object call() {
        return QuestionDaoV2Impl.w(this.f36306a, this.f36307b, this.f36308c);
    }
}
