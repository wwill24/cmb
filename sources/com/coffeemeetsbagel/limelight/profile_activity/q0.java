package com.coffeemeetsbagel.limelight.profile_activity;

import android.app.Activity;
import androidx.appcompat.app.c;
import b6.d;
import b6.f;
import b6.g;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.limelight.profile_activity.j;
import com.coffeemeetsbagel.limelight.profile_activity.r;

public class q0 extends f<a> {

    public interface a extends g<q0>, j.b, r.c {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?, ?> f34466a;

        public b(d<?, ?> dVar) {
            kotlin.jvm.internal.j.g(dVar, "componentActivity");
            this.f34466a = dVar;
        }

        public final Activity a() {
            return this.f34466a;
        }

        public final c b() {
            return this.f34466a;
        }

        public final d<?, ?> c() {
            return this.f34466a;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C0 */
    public a z0(d<?, ?> dVar) {
        kotlin.jvm.internal.j.g(dVar, "componentActivity");
        a a10 = h.a().c(new b(dVar)).b(Bakery.j()).a();
        kotlin.jvm.internal.j.f(a10, "builder()\n            .l…t())\n            .build()");
        return a10;
    }
}
