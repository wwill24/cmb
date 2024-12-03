package com.coffeemeetsbagel.new_user_experience.gender;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.gender.d;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35000a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35001b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35000a, d.b.class);
            g.a(this.f35001b, d.c.class);
            return new C0419b(this.f35000a, this.f35001b);
        }

        public a b(d.b bVar) {
            this.f35000a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35001b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.gender.b$b  reason: collision with other inner class name */
    private static final class C0419b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35002a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35003b;

        /* renamed from: c  reason: collision with root package name */
        private final C0419b f35004c;

        private C0419b(d.b bVar, d.c cVar) {
            this.f35004c = this;
            this.f35002a = bVar;
            this.f35003b = cVar;
        }

        private GenderInteractor c(GenderInteractor genderInteractor) {
            t.a(genderInteractor, e.a(this.f35002a));
            n.c(genderInteractor, (na.b) g.d(this.f35003b.j()));
            n.a(genderInteractor, (d7.g) g.d(this.f35003b.E()));
            n.e(genderInteractor, (j) g.d(this.f35003b.p()));
            n.f(genderInteractor, (SaveAnswerUseCase) g.d(this.f35003b.t()));
            n.d(genderInteractor, (ProfileManager) g.d(this.f35003b.m()));
            n.g(genderInteractor, (r0) g.d(this.f35003b.v0()));
            n.b(genderInteractor, (s9.a) g.d(this.f35003b.b()));
            return genderInteractor;
        }

        /* renamed from: b */
        public void l1(GenderInteractor genderInteractor) {
            c(genderInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
