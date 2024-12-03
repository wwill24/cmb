package com.coffeemeetsbagel.products.my_answers.presentation;

import android.view.ViewStub;
import b6.j;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.qna.g;
import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;
import kotlin.Unit;
import qj.h;

public final class m extends b6.c<j0, c> {

    public interface a extends j<MyAnswersInteractor> {
        androidx.appcompat.app.c n();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewStub f35882a;

        /* renamed from: b  reason: collision with root package name */
        private final MyAnswersLocation f35883b;

        public b(ViewStub viewStub, MyAnswersLocation myAnswersLocation) {
            kotlin.jvm.internal.j.g(viewStub, "view");
            kotlin.jvm.internal.j.g(myAnswersLocation, "layoutType");
            this.f35882a = viewStub;
            this.f35883b = myAnswersLocation;
        }

        public final h<Unit> a(PublishSubject<Unit> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "clickInput");
            return publishSubject.v0(BackpressureStrategy.LATEST);
        }

        public final PublishSubject<Unit> b() {
            PublishSubject<Unit> C0 = PublishSubject.C0();
            kotlin.jvm.internal.j.f(C0, "create<Unit>()");
            return C0;
        }

        public final h<Pair<QuestionWAnswers, Integer>> c(PublishSubject<Pair<QuestionWAnswers, Integer>> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "writeStream");
            return publishSubject.v0(BackpressureStrategy.LATEST);
        }

        public final PublishSubject<Pair<QuestionWAnswers, Integer>> d() {
            PublishSubject<Pair<QuestionWAnswers, Integer>> C0 = PublishSubject.C0();
            kotlin.jvm.internal.j.f(C0, "create<Pair<QuestionWAnswers, Int>>()");
            return C0;
        }

        public final MyAnswersPresenter e(MyAnswersAdapter myAnswersAdapter, PublishSubject<Unit> publishSubject) {
            kotlin.jvm.internal.j.g(myAnswersAdapter, "adapter");
            kotlin.jvm.internal.j.g(publishSubject, "clickInput");
            return new MyAnswersPresenter(this.f35882a, myAnswersAdapter, publishSubject, this.f35883b);
        }

        public final MyAnswersAdapter f(PublishSubject<Pair<QuestionWAnswers, Integer>> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "writeStream");
            return new MyAnswersAdapter(publishSubject, this.f35883b);
        }

        public final ta.a g(a7.a aVar) {
            kotlin.jvm.internal.j.g(aVar, "analyticsManager");
            return new ta.a(aVar, this.f35883b);
        }
    }

    public interface c {
        a7.a S();

        c6.b a0();

        UserRepository e();

        QuestionRepository k();

        androidx.appcompat.app.c n();

        DeletePromptAnswerUseCase o();

        g q();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final j0 b(ViewStub viewStub, boolean z10, MyAnswersLocation myAnswersLocation) {
        kotlin.jvm.internal.j.g(viewStub, "viewStub");
        kotlin.jvm.internal.j.g(myAnswersLocation, "layoutType");
        MyAnswersInteractor myAnswersInteractor = new MyAnswersInteractor(z10);
        a a10 = e.a().b(new b(viewStub, myAnswersLocation)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new j0(viewStub, a10, myAnswersInteractor);
    }
}
