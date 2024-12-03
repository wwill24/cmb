package com.coffeemeetsbagel.products.my_answers.presentation;

import b6.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.products.my_answers.presentation.m;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import fj.c;
import fj.g;
import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;
import kotlin.Unit;
import qj.h;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private m.b f35853a;

        /* renamed from: b  reason: collision with root package name */
        private m.c f35854b;

        private a() {
        }

        public m.a a() {
            g.a(this.f35853a, m.b.class);
            g.a(this.f35854b, m.c.class);
            return new b(this.f35853a, this.f35854b);
        }

        public a b(m.b bVar) {
            this.f35853a = (m.b) g.b(bVar);
            return this;
        }

        public a c(m.c cVar) {
            this.f35854b = (m.c) g.b(cVar);
            return this;
        }
    }

    private static final class b implements m.a {

        /* renamed from: a  reason: collision with root package name */
        private final m.c f35855a;

        /* renamed from: b  reason: collision with root package name */
        private final b f35856b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<PublishSubject<Pair<QuestionWAnswers, Integer>>> f35857c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<MyAnswersAdapter> f35858d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<PublishSubject<Unit>> f35859e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<MyAnswersPresenter> f35860f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<a7.a> f35861g;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<ta.a> f35862h;

        /* renamed from: j  reason: collision with root package name */
        private fk.a<h<Unit>> f35863j;

        /* renamed from: k  reason: collision with root package name */
        private fk.a<h<Pair<QuestionWAnswers, Integer>>> f35864k;

        private static final class a implements fk.a<a7.a> {

            /* renamed from: a  reason: collision with root package name */
            private final m.c f35865a;

            a(m.c cVar) {
                this.f35865a = cVar;
            }

            /* renamed from: a */
            public a7.a get() {
                return (a7.a) g.d(this.f35865a.S());
            }
        }

        private b(m.b bVar, m.c cVar) {
            this.f35856b = this;
            this.f35855a = cVar;
            b(bVar, cVar);
        }

        private void b(m.b bVar, m.c cVar) {
            fk.a<PublishSubject<Pair<QuestionWAnswers, Integer>>> a10 = c.a(q.a(bVar));
            this.f35857c = a10;
            this.f35858d = c.a(s.a(bVar, a10));
            fk.a<PublishSubject<Unit>> a11 = c.a(o.b(bVar));
            this.f35859e = a11;
            this.f35860f = c.a(r.a(bVar, this.f35858d, a11));
            a aVar = new a(cVar);
            this.f35861g = aVar;
            this.f35862h = c.a(t.a(bVar, aVar));
            this.f35863j = c.a(n.b(bVar, this.f35859e));
            this.f35864k = c.a(p.a(bVar, this.f35857c));
        }

        private MyAnswersInteractor d(MyAnswersInteractor myAnswersInteractor) {
            t.a(myAnswersInteractor, this.f35860f.get());
            h0.g(myAnswersInteractor, this.f35862h.get());
            h0.b(myAnswersInteractor, this.f35863j.get());
            h0.d(myAnswersInteractor, this.f35864k.get());
            h0.a(myAnswersInteractor, (c6.b) g.d(this.f35855a.a0()));
            h0.c(myAnswersInteractor, (DeletePromptAnswerUseCase) g.d(this.f35855a.o()));
            h0.h(myAnswersInteractor, (UserRepository) g.d(this.f35855a.e()));
            h0.f(myAnswersInteractor, (QuestionRepository) g.d(this.f35855a.k()));
            h0.e(myAnswersInteractor, (com.coffeemeetsbagel.qna.g) g.d(this.f35855a.q()));
            return myAnswersInteractor;
        }

        /* renamed from: c */
        public void l1(MyAnswersInteractor myAnswersInteractor) {
            d(myAnswersInteractor);
        }

        public androidx.appcompat.app.c n() {
            return (androidx.appcompat.app.c) g.d(this.f35855a.n());
        }
    }

    public static a a() {
        return new a();
    }
}
