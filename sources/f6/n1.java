package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class n1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final n1 f14823c = new n1();

    private n1() {
        super(6, 7);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `activity_reports` (`profile_id` TEXT NOT NULL, `has_logged_in_recently` INTEGER, `overall_chat_activity` REAL, `chat_initiation_level` REAL, `avg_response_time` REAL, `expiration_date` TEXT NOT NULL, PRIMARY KEY(`profile_id`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        iVar.D("CREATE  INDEX `index_activity_reports_profile_id` ON `activity_reports` (`profile_id`)");
        iVar.D("CREATE TABLE IF NOT EXISTS `profiles_MERGE_TABLE` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `appreciate_in_date` TEXT NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `employer` TEXT NOT NULL, `ethnicities` TEXT NOT NULL, `first_name` TEXT NOT NULL, `gender` TEXT NOT NULL, `i_am` TEXT NOT NULL, `interested_in` TEXT NOT NULL, `last_name` TEXT NOT NULL, `occupation` TEXT NOT NULL, `religion` TEXT, `state` TEXT NOT NULL, `school` TEXT, `degree_id` TEXT, `height_cm` INTEGER, `height_feet` INTEGER, `height_inches` INTEGER, `first_icebreaker` TEXT NOT NULL, `second_icebreaker` TEXT NOT NULL, `third_icebreaker` TEXT NOT NULL, `secondary_school` TEXT, `secondary_degree_id` TEXT, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `profiles_MERGE_TABLE` (`id`,`age`,`appreciate_in_date`,`city`,`country`,`employer`,`ethnicities`,`first_name`,`gender`,`i_am`,`interested_in`,`last_name`,`occupation`,`religion`,`state`,`school`,`degree_id`,`height_cm`,`height_feet`,`height_inches`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`,`secondary_school`,`secondary_degree_id`) SELECT `profiles`.`id`,`profiles`.`age`,`profiles`.`appreciate_in_date`,`profiles`.`city`,`profiles`.`country`,`profiles`.`employer`,`profiles`.`ethnicities`,`profiles`.`first_name`,`profiles`.`gender`,`profiles`.`i_am`,`profiles`.`interested_in`,`profiles`.`last_name`,`profiles`.`occupation`,`profiles`.`religion`,`profiles`.`state`,`profiles`.`school`,`profiles`.`degree_id`,`profiles`.`height_cm`,`profiles`.`height_feet`,`profiles`.`height_inches`,`profiles`.`first_icebreaker`,`profiles`.`second_icebreaker`,`profiles`.`third_icebreaker`,`profiles`.`secondary_school`,`profiles`.`secondary_degree_id` FROM `profiles`");
        iVar.D("DROP TABLE IF EXISTS `profiles`");
        iVar.D("ALTER TABLE `profiles_MERGE_TABLE` RENAME TO `profiles`");
    }
}
