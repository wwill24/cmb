package o5;

import android.app.Activity;
import androidx.appcompat.app.c;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import o5.a;

public final class g {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a.C0182a f16821a;

        /* renamed from: b  reason: collision with root package name */
        private e f16822b;

        private a() {
        }

        public a a() {
            fj.g.a(this.f16821a, a.C0182a.class);
            fj.g.a(this.f16822b, e.class);
            return new b(this.f16821a, this.f16822b);
        }

        public a b(a.C0182a aVar) {
            this.f16821a = (a.C0182a) fj.g.b(aVar);
            return this;
        }

        public a c(e eVar) {
            this.f16822b = (e) fj.g.b(eVar);
            return this;
        }
    }

    private static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final e f16823a;

        /* renamed from: b  reason: collision with root package name */
        private final a.C0182a f16824b;

        /* renamed from: c  reason: collision with root package name */
        private final b f16825c;

        private b(a.C0182a aVar, e eVar) {
            this.f16825c = this;
            this.f16823a = eVar;
            this.f16824b = aVar;
        }

        private ChatActivity j(ChatActivity chatActivity) {
            com.coffeemeetsbagel.chat.details.a.a(chatActivity, (s9.a) fj.g.d(this.f16823a.b()));
            return chatActivity;
        }

        public void R(d dVar) {
        }

        public s9.a b() {
            return (s9.a) fj.g.d(this.f16823a.b());
        }

        public a7.a c() {
            return (a7.a) fj.g.d(this.f16823a.c());
        }

        /* renamed from: d */
        public void I(ChatActivity chatActivity) {
            j(chatActivity);
        }

        public UserRepository e() {
            return (UserRepository) fj.g.d(this.f16823a.e());
        }

        public cb.a f() {
            return (cb.a) fj.g.d(this.f16823a.f());
        }

        public BuySubscriptionUseCase g() {
            return (BuySubscriptionUseCase) fj.g.d(this.f16823a.g());
        }

        public GetMyOwnProfileLocalUseCase h() {
            return (GetMyOwnProfileLocalUseCase) fj.g.d(this.f16823a.h());
        }

        public Activity i() {
            return b.a(this.f16824b);
        }

        public j l() {
            return (j) fj.g.d(this.f16823a.l());
        }

        public SubscriptionRepository m() {
            return (SubscriptionRepository) fj.g.d(this.f16823a.m());
        }

        public c n() {
            return c.a(this.f16824b);
        }
    }

    public static a a() {
        return new a();
    }
}
