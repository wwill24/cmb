package com.coffeemeetsbagel.new_user_experience.gender_inference;

import b6.t;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.new_user_experience.gender_inference.d;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f35037a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f35038b;

        private a() {
        }

        public d.a a() {
            g.a(this.f35037a, d.b.class);
            g.a(this.f35038b, d.c.class);
            return new C0420b(this.f35037a, this.f35038b);
        }

        public a b(d.b bVar) {
            this.f35037a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35038b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.gender_inference.b$b  reason: collision with other inner class name */
    private static final class C0420b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f35039a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f35040b;

        /* renamed from: c  reason: collision with root package name */
        private final C0420b f35041c;

        private C0420b(d.b bVar, d.c cVar) {
            this.f35041c = this;
            this.f35039a = bVar;
            this.f35040b = cVar;
        }

        private GenderInferenceInteractor c(GenderInferenceInteractor genderInferenceInteractor) {
            t.a(genderInferenceInteractor, e.a(this.f35039a));
            n.c(genderInferenceInteractor, (na.b) g.d(this.f35040b.j()));
            n.d(genderInferenceInteractor, (ProfileRepository) g.d(this.f35040b.A()));
            n.a(genderInferenceInteractor, (d7.g) g.d(this.f35040b.E()));
            n.e(genderInferenceInteractor, (j) g.d(this.f35040b.R0()));
            n.g(genderInferenceInteractor, (UserRepository) g.d(this.f35040b.e()));
            n.b(genderInferenceInteractor, (s9.a) g.d(this.f35040b.b()));
            n.f(genderInferenceInteractor, (SaveAnswerUseCase) g.d(this.f35040b.l()));
            return genderInferenceInteractor;
        }

        /* renamed from: b */
        public void l1(GenderInferenceInteractor genderInferenceInteractor) {
            c(genderInferenceInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
