package com.coffeemeetsbagel.new_user_experience.biography;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.biography.a;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import fj.g;

public final class a1 {

    private static final class a implements a.C0415a {

        /* renamed from: a  reason: collision with root package name */
        private final a.b f34848a;

        /* renamed from: b  reason: collision with root package name */
        private final a.c f34849b;

        /* renamed from: c  reason: collision with root package name */
        private final a f34850c;

        private a(a.b bVar, a.c cVar) {
            this.f34850c = this;
            this.f34848a = bVar;
            this.f34849b = cVar;
        }

        private BiographyInteractor c(BiographyInteractor biographyInteractor) {
            t.a(biographyInteractor, b.a(this.f34848a));
            n0.c(biographyInteractor, (s9.a) g.d(this.f34849b.b()));
            n0.h(biographyInteractor, (ProfileRepository) g.d(this.f34849b.A()));
            n0.g(biographyInteractor, (na.b) g.d(this.f34849b.j()));
            n0.b(biographyInteractor, (d7.g) g.d(this.f34849b.E()));
            n0.f(biographyInteractor, (ProfileManager) g.d(this.f34849b.V()));
            n0.a(biographyInteractor, (a7.a) g.d(this.f34849b.c()));
            n0.k(biographyInteractor, (m1) g.d(this.f34849b.W()));
            n0.d(biographyInteractor, (c9.a) g.d(this.f34849b.I()));
            n0.e(biographyInteractor, (GetSingleSchoolsUseCase) g.d(this.f34849b.N0()));
            n0.j(biographyInteractor, (SaveAnswerUseCase) g.d(this.f34849b.s()));
            n0.i(biographyInteractor, (QuestionRepository) g.d(this.f34849b.r()));
            n0.l(biographyInteractor, (UserRepository) g.d(this.f34849b.q()));
            return biographyInteractor;
        }

        public d<?, ?> a() {
            return (d) g.d(this.f34849b.a());
        }

        /* renamed from: b */
        public void l1(BiographyInteractor biographyInteractor) {
            c(biographyInteractor);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private a.b f34851a;

        /* renamed from: b  reason: collision with root package name */
        private a.c f34852b;

        private b() {
        }

        public b a(a.b bVar) {
            this.f34851a = (a.b) g.b(bVar);
            return this;
        }

        public a.C0415a b() {
            g.a(this.f34851a, a.b.class);
            g.a(this.f34852b, a.c.class);
            return new a(this.f34851a, this.f34852b);
        }

        public b c(a.c cVar) {
            this.f34852b = (a.c) g.b(cVar);
            return this;
        }
    }

    public static b a() {
        return new b();
    }
}
