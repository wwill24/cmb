package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class j0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final j0 f14810c = new j0();

    private j0() {
        super(42, 43);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `subscription_bundles` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `tier` INTEGER NOT NULL, `intents` TEXT NOT NULL, `benefit_keys` TEXT NOT NULL, `variant_skus` TEXT NOT NULL, PRIMARY KEY(`id`))");
        iVar.D("ALTER TABLE `active_subscription` ADD `bundle_id` TEXT NOT NULL DEFAULT ''");
        iVar.D("ALTER TABLE `active_subscription` ADD `tier` INTEGER NOT NULL DEFAULT 0");
        iVar.D("ALTER TABLE `subscription_variants` ADD `bundle_id` TEXT NOT NULL DEFAULT ''");
    }
}
