package com.coffeemeetsbagel.today_view.card.actioncards;

import b6.t;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.card.actioncards.b;
import com.coffeemeetsbagel.today_view.main.e;
import fj.c;
import fj.g;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import qj.h;

public final class b0 {

    private static final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final b.c f37282a;

        /* renamed from: b  reason: collision with root package name */
        private final b.C0463b f37283b;

        /* renamed from: c  reason: collision with root package name */
        private final a f37284c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<PublishSubject<Unit>> f37285d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<ActionCardPresenter> f37286e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<h<Unit>> f37287f;

        /* renamed from: g  reason: collision with root package name */
        private fk.a<a7.a> f37288g;

        /* renamed from: h  reason: collision with root package name */
        private fk.a<a> f37289h;

        /* renamed from: com.coffeemeetsbagel.today_view.card.actioncards.b0$a$a  reason: collision with other inner class name */
        private static final class C0464a implements fk.a<a7.a> {

            /* renamed from: a  reason: collision with root package name */
            private final b.c f37290a;

            C0464a(b.c cVar) {
                this.f37290a = cVar;
            }

            /* renamed from: a */
            public a7.a get() {
                return (a7.a) g.d(this.f37290a.c());
            }
        }

        private a(b.C0463b bVar, b.c cVar) {
            this.f37284c = this;
            this.f37282a = cVar;
            this.f37283b = bVar;
            b(bVar, cVar);
        }

        private void b(b.C0463b bVar, b.c cVar) {
            fk.a<PublishSubject<Unit>> a10 = c.a(g.a(bVar));
            this.f37285d = a10;
            this.f37286e = c.a(c.b(bVar, a10));
            this.f37287f = c.a(f.a(bVar, this.f37285d));
            C0464a aVar = new C0464a(cVar);
            this.f37288g = aVar;
            this.f37289h = c.a(e.b(bVar, aVar));
        }

        private ActionCardInteractor h(ActionCardInteractor actionCardInteractor) {
            t.a(actionCardInteractor, this.f37286e.get());
            w.a(actionCardInteractor, (ActionCardRepository) g.d(this.f37282a.m0()));
            w.c(actionCardInteractor, (a7.a) g.d(this.f37282a.c()));
            w.n(actionCardInteractor, (hb.c) g.d(this.f37282a.H()));
            w.k(actionCardInteractor, (k0) g.d(this.f37282a.j()));
            w.j(actionCardInteractor, (ProfileContract$Manager) g.d(this.f37282a.d()));
            w.d(actionCardInteractor, (b7.c) g.d(this.f37282a.K()));
            w.i(actionCardInteractor, this.f37287f.get());
            w.p(actionCardInteractor, (e.a) g.d(this.f37282a.r()));
            w.e(actionCardInteractor, (j) g.d(this.f37282a.l()));
            w.f(actionCardInteractor, (t7.a) g.d(this.f37282a.Q()));
            w.h(actionCardInteractor, (GetFirstEligibleActionCardUseCase) g.d(this.f37282a.g0()));
            w.q(actionCardInteractor, this.f37289h.get());
            w.o(actionCardInteractor, (bb.a) g.d(this.f37282a.u()));
            w.m(actionCardInteractor, (cb.a) g.d(this.f37282a.f()));
            w.b(actionCardInteractor, d.a(this.f37283b));
            w.l(actionCardInteractor, (SaveProfilesLocalUseCase) g.d(this.f37282a.o0()));
            w.g(actionCardInteractor, (s9.a) g.d(this.f37282a.b()));
            return actionCardInteractor;
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f37282a.a());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37282a.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f37282a.d());
        }

        public UserRepository e() {
            return (UserRepository) g.d(this.f37282a.C());
        }

        /* renamed from: f */
        public void l1(ActionCardInteractor actionCardInteractor) {
            h(actionCardInteractor);
        }

        public e.a g() {
            return (e.a) g.d(this.f37282a.r());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f37282a.k());
        }

        public e.a r() {
            return (e.a) g.d(this.f37282a.r());
        }

        public a6.a x() {
            return (a6.a) g.d(this.f37282a.x());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f37282a.z());
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private b.C0463b f37291a;

        /* renamed from: b  reason: collision with root package name */
        private b.c f37292b;

        private b() {
        }

        public b a(b.C0463b bVar) {
            this.f37291a = (b.C0463b) g.b(bVar);
            return this;
        }

        public b.a b() {
            g.a(this.f37291a, b.C0463b.class);
            g.a(this.f37292b, b.c.class);
            return new a(this.f37291a, this.f37292b);
        }

        public b c(b.c cVar) {
            this.f37292b = (b.c) g.b(cVar);
            return this;
        }
    }

    public static b a() {
        return new b();
    }
}
