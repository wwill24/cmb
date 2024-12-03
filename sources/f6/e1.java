package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class e1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final e1 f14791c = new e1();

    private e1() {
        super(61, 62);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `subscription_variants_MERGE_TABLE` (`bundle_id` TEXT NOT NULL DEFAULT '', `marketing_type` TEXT, `number_of_units` INTEGER NOT NULL, `unit` TEXT NOT NULL, `savings_comparison_sku` TEXT, `sale_full_price_comparison_sku` TEXT, `sale_sku_type` TEXT, `sale_start_time` INTEGER NOT NULL, `sale_end_time` INTEGER NOT NULL, `sku` TEXT NOT NULL, PRIMARY KEY(`sku`))");
        iVar.D("INSERT INTO `subscription_variants_MERGE_TABLE` (`bundle_id`,`marketing_type`,`number_of_units`,`unit`,`savings_comparison_sku`,`sale_full_price_comparison_sku`,`sale_sku_type`,`sku`,`sale_start_time`,`sale_end_time`) SELECT `subscription_variants`.`bundle_id`,`subscription_variants`.`marketing_type`,`subscription_variants`.`number_of_units`,`subscription_variants`.`unit`,`subscription_variants`.`savings_comparison_sku`,`subscription_variants`.`sale_full_price_comparison_sku`,`subscription_variants`.`sale_sku_type`,`subscription_variants`.`sku`,0,0 FROM `subscription_variants`");
        iVar.D("DROP TABLE IF EXISTS `subscription_variants`");
        iVar.D("ALTER TABLE `subscription_variants_MERGE_TABLE` RENAME TO `subscription_variants`");
    }
}
