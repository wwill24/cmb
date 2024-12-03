package com.coffeemeetsbagel.products.prompts.editor.presentation;

import b6.d;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.products.prompts.editor.presentation.l;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import fj.g;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private l.b f35931a;

        /* renamed from: b  reason: collision with root package name */
        private m f35932b;

        private a() {
        }

        public l.a a() {
            g.a(this.f35931a, l.b.class);
            g.a(this.f35932b, m.class);
            return new b(this.f35931a, this.f35932b);
        }

        public a b(m mVar) {
            this.f35932b = (m) g.b(mVar);
            return this;
        }

        public a c(l.b bVar) {
            this.f35931a = (l.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements l.a {

        /* renamed from: a  reason: collision with root package name */
        private final l.b f35933a;

        /* renamed from: b  reason: collision with root package name */
        private final m f35934b;

        /* renamed from: c  reason: collision with root package name */
        private final b f35935c;

        private b(l.b bVar, m mVar) {
            this.f35935c = this;
            this.f35933a = bVar;
            this.f35934b = mVar;
        }

        public UserRepository C() {
            return (UserRepository) g.d(this.f35934b.C());
        }

        public a7.a S() {
            return (a7.a) g.d(this.f35934b.S());
        }

        public d<?, ?> a() {
            return n.a(this.f35933a);
        }

        /* renamed from: c */
        public void g0(l lVar) {
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f35934b.z());
        }
    }

    public static a a() {
        return new a();
    }
}
