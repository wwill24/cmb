package com.coffeemeetsbagel.limelight.dialog;

import b6.t;
import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.limelight.dialog.d;
import fj.g;
import hb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.b f34377a;

        /* renamed from: b  reason: collision with root package name */
        private d.c f34378b;

        private a() {
        }

        public d.a a() {
            g.a(this.f34377a, d.b.class);
            g.a(this.f34378b, d.c.class);
            return new C0411b(this.f34377a, this.f34378b);
        }

        public a b(d.b bVar) {
            this.f34377a = (d.b) g.b(bVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f34378b = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.limelight.dialog.b$b  reason: collision with other inner class name */
    private static final class C0411b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final d.b f34379a;

        /* renamed from: b  reason: collision with root package name */
        private final d.c f34380b;

        /* renamed from: c  reason: collision with root package name */
        private final C0411b f34381c;

        private C0411b(d.b bVar, d.c cVar) {
            this.f34381c = this;
            this.f34379a = bVar;
            this.f34380b = cVar;
        }

        private LimelightDialogInteractor c(LimelightDialogInteractor limelightDialogInteractor) {
            t.a(limelightDialogInteractor, e.a(this.f34379a));
            h.b(limelightDialogInteractor, (LikesYouMatchRepository) g.d(this.f34380b.C()));
            h.d(limelightDialogInteractor, (c) g.d(this.f34380b.P()));
            h.c(limelightDialogInteractor, (NavStateManager) g.d(this.f34380b.A()));
            h.a(limelightDialogInteractor, (s9.a) g.d(this.f34380b.b()));
            return limelightDialogInteractor;
        }

        /* renamed from: b */
        public void l1(LimelightDialogInteractor limelightDialogInteractor) {
            c(limelightDialogInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
