package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class d0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final d0 f14786c = new d0();

    private d0() {
        super(37, 38);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `profiles` ADD `coffee_club_status` TEXT NOT NULL DEFAULT ''");
        iVar.D("ALTER TABLE `matches` ADD `purchase_attribution` INTEGER DEFAULT NULL");
    }
}
