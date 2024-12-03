package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class d1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final d1 f14787c = new d1();

    private d1() {
        super(60, 61);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `subscription_variants` ADD `sale_full_price_comparison_sku` TEXT DEFAULT NULL");
        iVar.D("ALTER TABLE `subscription_variants` ADD `sale_sku_type` TEXT DEFAULT NULL");
        iVar.D("ALTER TABLE `subscription_variants` ADD `sale_start_time_local` TEXT DEFAULT NULL");
        iVar.D("ALTER TABLE `subscription_variants` ADD `sale_end_time_local` TEXT DEFAULT NULL");
    }
}
