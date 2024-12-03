package com.coffeemeetsbagel.deactivate;

import b6.d;
import com.coffeemeetsbagel.deactivate.q;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import fj.g;
import wb.c;

public final class e {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private q.b f12014a;

        /* renamed from: b  reason: collision with root package name */
        private r f12015b;

        private a() {
        }

        public q.a a() {
            g.a(this.f12014a, q.b.class);
            g.a(this.f12015b, r.class);
            return new b(this.f12014a, this.f12015b);
        }

        public a b(r rVar) {
            this.f12015b = (r) g.b(rVar);
            return this;
        }

        public a c(q.b bVar) {
            this.f12014a = (q.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements q.a {

        /* renamed from: a  reason: collision with root package name */
        private final q.b f12016a;

        /* renamed from: b  reason: collision with root package name */
        private final r f12017b;

        /* renamed from: c  reason: collision with root package name */
        private final b f12018c;

        private b(q.b bVar, r rVar) {
            this.f12018c = this;
            this.f12016a = bVar;
            this.f12017b = rVar;
        }

        public a7.a G1() {
            return (a7.a) g.d(this.f12017b.G1());
        }

        public FeatureFlagRepository K0() {
            return (FeatureFlagRepository) g.d(this.f12017b.K0());
        }

        public GetMyOwnProfileLocalUseCase O1() {
            return (GetMyOwnProfileLocalUseCase) g.d(this.f12017b.O1());
        }

        public d<?, ?> a() {
            return s.a(this.f12016a);
        }

        /* renamed from: c */
        public void g0(q qVar) {
        }

        public bb.a i() {
            return (bb.a) g.d(this.f12017b.i());
        }

        public d7.g l1() {
            return (d7.g) g.d(this.f12017b.l1());
        }

        public c n1() {
            return (c) g.d(this.f12017b.n1());
        }

        public ProfileManager s1() {
            return (ProfileManager) g.d(this.f12017b.s1());
        }
    }

    public static a a() {
        return new a();
    }
}
