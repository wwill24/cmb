package com.coffeemeetsbagel.products.prompts.editor.presentation;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.products.prompts.editor.presentation.g;
import com.coffeemeetsbagel.products.prompts.editor.presentation.l;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import fj.c;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import qj.h;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private g.b f35921a;

        /* renamed from: b  reason: collision with root package name */
        private l.a f35922b;

        private a() {
        }

        public g.a a() {
            fj.g.a(this.f35921a, g.b.class);
            fj.g.a(this.f35922b, l.a.class);
            return new C0442b(this.f35921a, this.f35922b);
        }

        public a b(l.a aVar) {
            this.f35922b = (l.a) fj.g.b(aVar);
            return this;
        }

        public a c(g.b bVar) {
            this.f35921a = (g.b) fj.g.b(bVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.products.prompts.editor.presentation.b$b  reason: collision with other inner class name */
    private static final class C0442b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        private final l.a f35923a;

        /* renamed from: b  reason: collision with root package name */
        private final C0442b f35924b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<PublishSubject<Unit>> f35925c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<PromptEditPresenter> f35926d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<a7.a> f35927e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<xa.a> f35928f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<h<Unit>> f35929g;

        /* renamed from: com.coffeemeetsbagel.products.prompts.editor.presentation.b$b$a */
        private static final class a implements fk.a<a7.a> {

            /* renamed from: a  reason: collision with root package name */
            private final l.a f35930a;

            a(l.a aVar) {
                this.f35930a = aVar;
            }

            /* renamed from: a */
            public a7.a get() {
                return (a7.a) fj.g.d(this.f35930a.S());
            }
        }

        private C0442b(g.b bVar, l.a aVar) {
            this.f35924b = this;
            this.f35923a = aVar;
            b(bVar, aVar);
        }

        private void b(g.b bVar, l.a aVar) {
            fk.a<PublishSubject<Unit>> a10 = c.a(i.b(bVar));
            this.f35925c = a10;
            this.f35926d = c.a(j.a(bVar, a10));
            a aVar2 = new a(aVar);
            this.f35927e = aVar2;
            this.f35928f = c.a(k.a(bVar, aVar2));
            this.f35929g = c.a(h.b(bVar, this.f35925c));
        }

        private PromptEditInteractor d(PromptEditInteractor promptEditInteractor) {
            t.a(promptEditInteractor, this.f35926d.get());
            s.d(promptEditInteractor, (UserRepository) fj.g.d(this.f35923a.C()));
            s.c(promptEditInteractor, this.f35928f.get());
            s.a(promptEditInteractor, this.f35929g.get());
            s.b(promptEditInteractor, (SaveAnswerUseCase) fj.g.d(this.f35923a.z()));
            return promptEditInteractor;
        }

        public d<?, ?> a() {
            return (d) fj.g.d(this.f35923a.a());
        }

        /* renamed from: c */
        public void l1(PromptEditInteractor promptEditInteractor) {
            d(promptEditInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
