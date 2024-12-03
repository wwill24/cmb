package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class g1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final g1 f14801c = new g1();

    private g1() {
        super(63, 64);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `suggested_limits_MERGE_TABLE` (`id` INTEGER NOT NULL, `remaining_likes` INTEGER, `remaining_views` INTEGER, `num_bagels_required_for_upsell` INTEGER, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `suggested_limits_MERGE_TABLE` (`id`,`num_bagels_required_for_upsell`,`remaining_likes`,`remaining_views`) SELECT `suggested_limits`.`id`,`suggested_limits`.`num_bagels_required_for_upsell`,NULL,NULL FROM `suggested_limits`");
        iVar.D("DROP TABLE IF EXISTS `suggested_limits`");
        iVar.D("ALTER TABLE `suggested_limits_MERGE_TABLE` RENAME TO `suggested_limits`");
    }
}
