package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class b0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final b0 f14778c = new b0();

    private b0() {
        super(35, 36);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `matches` ADD `ready_to_meet_congrats_seen` INTEGER DEFAULT NULL");
        iVar.D("ALTER TABLE `matches` ADD `ready_to_meet_pair_has_access` INTEGER DEFAULT NULL");
        iVar.D("ALTER TABLE `matches` ADD `ready_to_meet_pair_ready` INTEGER DEFAULT NULL");
        iVar.D("ALTER TABLE `matches` ADD `ready_to_meet_ready` INTEGER DEFAULT NULL");
    }
}
