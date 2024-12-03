package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class t1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final t1 f14841c = new t1();

    private t1() {
        super(7, 8);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `matches` (`id` TEXT NOT NULL, `action` INTEGER NOT NULL, `end_at` TEXT NOT NULL, `is_blocked` INTEGER NOT NULL, `is_rising` INTEGER NOT NULL, `message` TEXT, `profile_id` TEXT NOT NULL, `show_order` INTEGER NOT NULL, `start_at` TEXT NOT NULL, `type` TEXT NOT NULL, `woo_count` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        iVar.D("CREATE UNIQUE INDEX `index_matches_profile_id_type_action` ON `matches` (`profile_id`, `type`, `action`)");
        iVar.D("CREATE  INDEX `index_matches_type_action` ON `matches` (`type`, `action`)");
    }
}
