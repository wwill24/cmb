package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class p0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final p0 f14828c = new p0();

    private p0() {
        super(48, 49);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `matches_MERGE_TABLE` (`id` TEXT NOT NULL, `action` INTEGER NOT NULL, `end_at` TEXT NOT NULL, `is_blocked` INTEGER NOT NULL, `is_rising` INTEGER NOT NULL, `like_comment` TEXT, `message` TEXT, `profile_id` TEXT NOT NULL, `rising_count` INTEGER NOT NULL, `show_order` INTEGER, `start_at` TEXT NOT NULL, `type` TEXT NOT NULL, `woo_count` INTEGER NOT NULL, `woo_seen_count` INTEGER NOT NULL, `purchase_attribution` INTEGER, `match_to_me` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        iVar.D("INSERT INTO `matches_MERGE_TABLE` (`id`,`action`,`end_at`,`is_blocked`,`is_rising`,`like_comment`,`message`,`profile_id`,`rising_count`,`show_order`,`start_at`,`type`,`woo_count`,`woo_seen_count`,`purchase_attribution`,`match_to_me`) SELECT `matches`.`id`,`matches`.`action`,`matches`.`end_at`,`matches`.`is_blocked`,`matches`.`is_rising`,`matches`.`like_comment`,`matches`.`message`,`matches`.`profile_id`,`matches`.`rising_count`,`matches`.`show_order`,`matches`.`start_at`,`matches`.`type`,`matches`.`woo_count`,`matches`.`woo_seen_count`,`matches`.`purchase_attribution`,`matches`.`match_to_me` FROM `matches`");
        iVar.D("DROP TABLE IF EXISTS `matches`");
        iVar.D("ALTER TABLE `matches_MERGE_TABLE` RENAME TO `matches`");
        iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_matches_profile_id_type_action` ON `matches` (`profile_id`, `type`, `action`)");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_matches_type_action` ON `matches` (`type`, `action`)");
    }
}
