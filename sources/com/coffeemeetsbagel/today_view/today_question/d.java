package com.coffeemeetsbagel.today_view.today_question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.today_view.today_question.TodayQuestionPresenter;

public final class d extends b6.c<x, a> {

    public interface a {
        a7.a c();

        UserRepository e();

        QuestionRepository k();

        e.a r();

        SaveAnswerUseCase z();
    }

    public interface b extends j<TodayQuestionInteractor> {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f37521a;

        /* renamed from: b  reason: collision with root package name */
        private final TodayQuestionPresenter.a f37522b;

        public c(ViewGroup viewGroup, TodayQuestionPresenter.a aVar) {
            kotlin.jvm.internal.j.g(viewGroup, "todayQuestionView");
            kotlin.jvm.internal.j.g(aVar, "listener");
            this.f37521a = viewGroup;
            this.f37522b = aVar;
        }

        public final TodayQuestionPresenter a() {
            return new TodayQuestionPresenter(this.f37521a, this.f37522b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final x b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        TodayQuestionInteractor todayQuestionInteractor = new TodayQuestionInteractor();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_today_question, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        b a10 = b.a().c(new c(viewGroup2, todayQuestionInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new x(viewGroup2, a10, todayQuestionInteractor);
    }
}
