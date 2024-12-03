package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.models.interfaces.UpgradeContract;
import fj.d;
import fj.g;

public final class e1 implements d<UpgradeContract.Manager> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e1 f11091a = new e1();
    }

    public static e1 a() {
        return a.f11091a;
    }

    public static UpgradeContract.Manager c() {
        return (UpgradeContract.Manager) g.e(c.c0());
    }

    /* renamed from: b */
    public UpgradeContract.Manager get() {
        return c();
    }
}
