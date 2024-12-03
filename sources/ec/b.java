package ec;

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
import com.coffeemeetsbagel.today_view.card.actioncards.GetFirstEligibleActionCardUseCase;
import com.coffeemeetsbagel.today_view.main.e;
import ec.d;
import fj.g;
import hb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f40668a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f40669b;

        private a() {
        }

        public d.b a() {
            g.a(this.f40668a, d.c.class);
            g.a(this.f40669b, d.a.class);
            return new C0488b(this.f40668a, this.f40669b);
        }

        public a b(d.a aVar) {
            this.f40669b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f40668a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: ec.b$b  reason: collision with other inner class name */
    private static final class C0488b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f40670a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f40671b;

        /* renamed from: c  reason: collision with root package name */
        private final C0488b f40672c;

        private C0488b(d.c cVar, d.a aVar) {
            this.f40672c = this;
            this.f40670a = cVar;
            this.f40671b = aVar;
        }

        private f h(f fVar) {
            t.a(fVar, e.a(this.f40670a));
            g.a(fVar, (ProfileContract$Manager) g.d(this.f40671b.d()));
            return fVar;
        }

        public UserRepository C() {
            return (UserRepository) g.d(this.f40671b.C());
        }

        public c H() {
            return (c) g.d(this.f40671b.H());
        }

        public b7.c K() {
            return (b7.c) g.d(this.f40671b.K());
        }

        public t7.a Q() {
            return (t7.a) g.d(this.f40671b.Q());
        }

        public ActivityMain a() {
            return (ActivityMain) g.d(this.f40671b.a());
        }

        public s9.a b() {
            return (s9.a) g.d(this.f40671b.b());
        }

        public a7.a c() {
            return (a7.a) g.d(this.f40671b.c());
        }

        public ProfileContract$Manager d() {
            return (ProfileContract$Manager) g.d(this.f40671b.d());
        }

        /* renamed from: e */
        public void l1(f fVar) {
            h(fVar);
        }

        public cb.a f() {
            return (cb.a) g.d(this.f40671b.f());
        }

        public e.a g() {
            return (e.a) g.d(this.f40671b.r());
        }

        public GetFirstEligibleActionCardUseCase g0() {
            return (GetFirstEligibleActionCardUseCase) g.d(this.f40671b.g0());
        }

        public k0 j() {
            return (k0) g.d(this.f40671b.j());
        }

        public QuestionRepository k() {
            return (QuestionRepository) g.d(this.f40671b.k());
        }

        public j l() {
            return (j) g.d(this.f40671b.l());
        }

        public ActionCardRepository m0() {
            return (ActionCardRepository) g.d(this.f40671b.m0());
        }

        public SaveProfilesLocalUseCase o0() {
            return (SaveProfilesLocalUseCase) g.d(this.f40671b.o0());
        }

        public e.a r() {
            return (e.a) g.d(this.f40671b.r());
        }

        public bb.a u() {
            return (bb.a) g.d(this.f40671b.u());
        }

        public a6.a x() {
            return (a6.a) g.d(this.f40671b.x());
        }

        public SaveAnswerUseCase z() {
            return (SaveAnswerUseCase) g.d(this.f40671b.z());
        }
    }

    public static a a() {
        return new a();
    }
}
