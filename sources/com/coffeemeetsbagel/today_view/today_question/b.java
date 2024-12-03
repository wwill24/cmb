package com.coffeemeetsbagel.today_view.today_question;

import b6.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.today_view.today_question.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f37516a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f37517b;

        private a() {
        }

        public d.b a() {
            g.a(this.f37516a, d.c.class);
            g.a(this.f37517b, d.a.class);
            return new C0470b(this.f37516a, this.f37517b);
        }

        public a b(d.a aVar) {
            this.f37517b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f37516a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.today_view.today_question.b$b  reason: collision with other inner class name */
    private static final class C0470b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f37518a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f37519b;

        /* renamed from: c  reason: collision with root package name */
        private final C0470b f37520c;

        private C0470b(d.c cVar, d.a aVar) {
            this.f37520c = this;
            this.f37518a = cVar;
            this.f37519b = aVar;
        }

        private TodayQuestionInteractor c(TodayQuestionInteractor todayQuestionInteractor) {
            t.a(todayQuestionInteractor, e.a(this.f37518a));
            s.c(todayQuestionInteractor, (QuestionRepository) g.d(this.f37519b.k()));
            s.b(todayQuestionInteractor, (e.a) g.d(this.f37519b.r()));
            s.e(todayQuestionInteractor, (UserRepository) g.d(this.f37519b.e()));
            s.a(todayQuestionInteractor, (a7.a) g.d(this.f37519b.c()));
            s.d(todayQuestionInteractor, (SaveAnswerUseCase) g.d(this.f37519b.z()));
            return todayQuestionInteractor;
        }

        /* renamed from: b */
        public void l1(TodayQuestionInteractor todayQuestionInteractor) {
            c(todayQuestionInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
