package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class m0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final m0 f14819c = new m0();

    private m0() {
        super(45, 46);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `active_subscription` ADD `purchase_token` TEXT NOT NULL DEFAULT ''");
    }
}
