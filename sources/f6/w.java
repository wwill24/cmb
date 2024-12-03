package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class w extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final w f14848c = new w();

    private w() {
        super(30, 31);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `subscription_benefits` (`key` TEXT NOT NULL, `cached_at` INTEGER NOT NULL, `deep_link_tags` TEXT NOT NULL, `description` TEXT NOT NULL, `icon_url` TEXT NOT NULL, `image_url` TEXT NOT NULL, `title` TEXT NOT NULL, `small_title_display` TEXT, PRIMARY KEY(`key`))");
        iVar.D("CREATE TABLE IF NOT EXISTS `active_subscription` (`auto_renew` INTEGER NOT NULL, `benefits` TEXT NOT NULL, `expiry_date` TEXT NOT NULL, `sku` TEXT NOT NULL, `start_date` TEXT NOT NULL, PRIMARY KEY(`sku`))");
        iVar.D("CREATE TABLE IF NOT EXISTS `subscription_variants` (`marketing_type` TEXT, `number_of_units` INTEGER NOT NULL, `unit` TEXT NOT NULL, `savings_comparison_sku` TEXT, `sku` TEXT NOT NULL, PRIMARY KEY(`sku`))");
    }
}
