package com.coffeemeetsbagel.new_user_experience.profile_review;

import b6.t;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.new_user_experience.profile_review.d;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f35571a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f35572b;

        private a() {
        }

        public d.b a() {
            g.a(this.f35571a, d.c.class);
            g.a(this.f35572b, d.a.class);
            return new C0437b(this.f35571a, this.f35572b);
        }

        public a b(d.a aVar) {
            this.f35572b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35571a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.profile_review.b$b  reason: collision with other inner class name */
    private static final class C0437b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f35573a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f35574b;

        /* renamed from: c  reason: collision with root package name */
        private final C0437b f35575c;

        private C0437b(d.c cVar, d.a aVar) {
            this.f35575c = this;
            this.f35573a = cVar;
            this.f35574b = aVar;
        }

        private ProfileReviewInteractor c(ProfileReviewInteractor profileReviewInteractor) {
            t.a(profileReviewInteractor, e.a(this.f35573a));
            g.b(profileReviewInteractor, (na.b) g.d(this.f35574b.j()));
            g.c(profileReviewInteractor, (ProfileRepository) g.d(this.f35574b.A()));
            g.a(profileReviewInteractor, (d7.g) g.d(this.f35574b.E()));
            return profileReviewInteractor;
        }

        /* renamed from: b */
        public void l1(ProfileReviewInteractor profileReviewInteractor) {
            c(profileReviewInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
