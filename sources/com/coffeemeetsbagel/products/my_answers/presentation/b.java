package com.coffeemeetsbagel.products.my_answers.presentation;

import androidx.appcompat.app.c;
import com.coffeemeetsbagel.activities.ActivityProfileEdit;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.products.my_answers.presentation.g;
import com.coffeemeetsbagel.qna.DeletePromptAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private g.b f35845a;

        /* renamed from: b  reason: collision with root package name */
        private h f35846b;

        private a() {
        }

        public g.c a() {
            fj.g.a(this.f35845a, g.b.class);
            fj.g.a(this.f35846b, h.class);
            return new C0441b(this.f35845a, this.f35846b);
        }

        public a b(g.b bVar) {
            this.f35845a = (g.b) fj.g.b(bVar);
            return this;
        }

        public a c(h hVar) {
            this.f35846b = (h) fj.g.b(hVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.products.my_answers.presentation.b$b  reason: collision with other inner class name */
    private static final class C0441b implements g.c {

        /* renamed from: a  reason: collision with root package name */
        private final h f35847a;

        /* renamed from: b  reason: collision with root package name */
        private final g.b f35848b;

        /* renamed from: c  reason: collision with root package name */
        private final C0441b f35849c;

        private C0441b(g.b bVar, h hVar) {
            this.f35849c = this;
            this.f35847a = hVar;
            this.f35848b = bVar;
        }

        private g b(g gVar) {
            i.a(gVar, (a7.a) fj.g.d(this.f35847a.S()));
            return gVar;
        }

        public void N(g gVar) {
            b(gVar);
        }

        public a7.a S() {
            return (a7.a) fj.g.d(this.f35847a.S());
        }

        /* renamed from: a */
        public void I(ActivityProfileEdit activityProfileEdit) {
        }

        public c6.b a0() {
            g.b bVar = this.f35848b;
            return j.a(bVar, k.a(bVar));
        }

        public UserRepository e() {
            return (UserRepository) fj.g.d(this.f35847a.C());
        }

        public QuestionRepository k() {
            return (QuestionRepository) fj.g.d(this.f35847a.k());
        }

        public c n() {
            return k.a(this.f35848b);
        }

        public DeletePromptAnswerUseCase o() {
            return (DeletePromptAnswerUseCase) fj.g.d(this.f35847a.o());
        }

        public com.coffeemeetsbagel.qna.g q() {
            return (com.coffeemeetsbagel.qna.g) fj.g.d(this.f35847a.q());
        }
    }

    public static a a() {
        return new a();
    }
}
