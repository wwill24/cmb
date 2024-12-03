package com.coffeemeetsbagel.new_user_experience.photos;

import b6.t;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.photos.d;
import fj.g;
import t8.l;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f35554a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f35555b;

        private a() {
        }

        public d.b a() {
            g.a(this.f35554a, d.c.class);
            g.a(this.f35555b, d.a.class);
            return new C0436b(this.f35554a, this.f35555b);
        }

        public a b(d.a aVar) {
            this.f35555b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f35554a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.new_user_experience.photos.b$b  reason: collision with other inner class name */
    private static final class C0436b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f35556a;

        /* renamed from: b  reason: collision with root package name */
        private final d.a f35557b;

        /* renamed from: c  reason: collision with root package name */
        private final C0436b f35558c;

        private C0436b(d.c cVar, d.a aVar) {
            this.f35558c = this;
            this.f35556a = cVar;
            this.f35557b = aVar;
        }

        private PhotoManagerInteractor c(PhotoManagerInteractor photoManagerInteractor) {
            t.a(photoManagerInteractor, e.a(this.f35556a));
            g.b(photoManagerInteractor, (b6.d) g.d(this.f35557b.a()));
            g.d(photoManagerInteractor, (l) g.d(this.f35557b.P0()));
            g.c(photoManagerInteractor, (na.b) g.d(this.f35557b.j()));
            g.e(photoManagerInteractor, (ProfileManager) g.d(this.f35557b.d()));
            g.a(photoManagerInteractor, (a7.a) g.d(this.f35557b.c()));
            return photoManagerInteractor;
        }

        /* renamed from: b */
        public void l1(PhotoManagerInteractor photoManagerInteractor) {
            c(photoManagerInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
