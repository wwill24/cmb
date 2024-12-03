package com.coffeemeetsbagel.products.prompts.selection.presentation;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.products.prompts.selection.presentation.h;
import com.coffeemeetsbagel.products.prompts.selection.presentation.n;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.j;
import fj.c;
import fj.g;
import io.reactivex.subjects.PublishSubject;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private h.b f35970a;

        /* renamed from: b  reason: collision with root package name */
        private n.a f35971b;

        private a() {
        }

        public a a(n.a aVar) {
            this.f35971b = (n.a) g.b(aVar);
            return this;
        }

        public h.a b() {
            g.a(this.f35970a, h.b.class);
            g.a(this.f35971b, n.a.class);
            return new C0443b(this.f35970a, this.f35971b);
        }

        public a c(h.b bVar) {
            this.f35970a = (h.b) g.b(bVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.products.prompts.selection.presentation.b$b  reason: collision with other inner class name */
    private static final class C0443b implements h.a {

        /* renamed from: a  reason: collision with root package name */
        private final n.a f35972a;

        /* renamed from: b  reason: collision with root package name */
        private final C0443b f35973b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<PublishSubject<QuestionWAnswers>> f35974c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<PromptSelectionAdapter> f35975d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<PromptSelectionPresenter> f35976e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<qj.h<QuestionWAnswers>> f35977f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<a7.a> f35978g;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<ya.a> f35979h;

        /* renamed from: com.coffeemeetsbagel.products.prompts.selection.presentation.b$b$a */
        private static final class a implements fk.a<a7.a> {

            /* renamed from: a  reason: collision with root package name */
            private final n.a f35980a;

            a(n.a aVar) {
                this.f35980a = aVar;
            }

            /* renamed from: a */
            public a7.a get() {
                return (a7.a) g.d(this.f35980a.S());
            }
        }

        private C0443b(h.b bVar, n.a aVar) {
            this.f35973b = this;
            this.f35972a = aVar;
            b(bVar, aVar);
        }

        private void b(h.b bVar, n.a aVar) {
            fk.a<PublishSubject<QuestionWAnswers>> a10 = c.a(j.a(bVar));
            this.f35974c = a10;
            fk.a<PromptSelectionAdapter> a11 = c.a(k.a(bVar, a10));
            this.f35975d = a11;
            this.f35976e = c.a(l.a(bVar, a11));
            this.f35977f = c.a(i.a(bVar, this.f35974c));
            a aVar2 = new a(aVar);
            this.f35978g = aVar2;
            this.f35979h = c.a(m.a(bVar, aVar2));
        }

        private PromptSelectionInteractor d(PromptSelectionInteractor promptSelectionInteractor) {
            t.a(promptSelectionInteractor, this.f35976e.get());
            x.a(promptSelectionInteractor, this.f35977f.get());
            x.c(promptSelectionInteractor, (j) g.d(this.f35972a.R0()));
            x.b(promptSelectionInteractor, this.f35979h.get());
            x.d(promptSelectionInteractor, (UserRepository) g.d(this.f35972a.C()));
            return promptSelectionInteractor;
        }

        public d<?, ?> a() {
            return (d) g.d(this.f35972a.a());
        }

        /* renamed from: c */
        public void l1(PromptSelectionInteractor promptSelectionInteractor) {
            d(promptSelectionInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
