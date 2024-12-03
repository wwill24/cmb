package com.coffeemeetsbagel.instant_like;

import androidx.appcompat.app.c;
import b6.t;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.instant_like.f;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.store.k0;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private f.b f14018a;

        /* renamed from: b  reason: collision with root package name */
        private f.c f14019b;

        private a() {
        }

        public f.a a() {
            g.a(this.f14018a, f.b.class);
            g.a(this.f14019b, f.c.class);
            return new C0148b(this.f14018a, this.f14019b);
        }

        public a b(f.b bVar) {
            this.f14018a = (f.b) g.b(bVar);
            return this;
        }

        public a c(f.c cVar) {
            this.f14019b = (f.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.instant_like.b$b  reason: collision with other inner class name */
    private static final class C0148b implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final f.b f14020a;

        /* renamed from: b  reason: collision with root package name */
        private final f.c f14021b;

        /* renamed from: c  reason: collision with root package name */
        private final C0148b f14022c;

        private C0148b(f.b bVar, f.c cVar) {
            this.f14022c = this;
            this.f14020a = bVar;
            this.f14021b = cVar;
        }

        private com.coffeemeetsbagel.store.alc.a b() {
            return h.a(this.f14020a, (a7.a) g.d(this.f14021b.c()), (FirebaseContract.Analytics) g.d(this.f14021b.a0()));
        }

        private InstantLikeBottomSheetInteractor d(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
            t.a(instantLikeBottomSheetInteractor, g.a(this.f14020a));
            u.f(instantLikeBottomSheetInteractor, (k0) g.d(this.f14021b.j()));
            u.c(instantLikeBottomSheetInteractor, (ProfileContract$Manager) g.d(this.f14021b.d()));
            u.d(instantLikeBottomSheetInteractor, b());
            u.g(instantLikeBottomSheetInteractor, (UpdateBagelLocalUseCase) g.d(this.f14021b.M()));
            u.b(instantLikeBottomSheetInteractor, (j) g.d(this.f14021b.l()));
            u.e(instantLikeBottomSheetInteractor, (com.coffeemeetsbagel.store.alc.b) g.d(this.f14021b.l0()));
            u.a(instantLikeBottomSheetInteractor, (c6.b) g.d(this.f14021b.m0()));
            u.h(instantLikeBottomSheetInteractor, (d) g.d(this.f14021b.T()));
            return instantLikeBottomSheetInteractor;
        }

        public c O0() {
            return (c) g.d(this.f14021b.O0());
        }

        /* renamed from: c */
        public void l1(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
            d(instantLikeBottomSheetInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
