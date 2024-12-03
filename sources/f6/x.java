package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class x extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final x f14852c = new x();

    private x() {
        super(31, 32);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `active_subscription` ADD `subscription_state` INTEGER DEFAULT NULL");
    }
}
