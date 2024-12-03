package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class g0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final g0 f14800c = new g0();

    private g0() {
        super(3, 4);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `profiles_MERGE_TABLE` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `appreciate_in_date` TEXT NOT NULL, `country` TEXT NOT NULL, `employer` TEXT NOT NULL, `ethnicities` TEXT NOT NULL, `first_name` TEXT NOT NULL, `gender` TEXT NOT NULL, `height_cm` INTEGER NOT NULL, `i_am` TEXT NOT NULL, `interested_in` TEXT NOT NULL, `last_name` TEXT NOT NULL, `location` TEXT NOT NULL, `occupation` TEXT NOT NULL, `religion` TEXT, `has_logged_in_recently` INTEGER, `overall_chat_activity` REAL, `chat_initiation_level` REAL, `avg_response_time` REAL, `expiration_date` TEXT, `school` TEXT, `degree_id` TEXT, `first_icebreaker` TEXT NOT NULL, `second_icebreaker` TEXT NOT NULL, `third_icebreaker` TEXT NOT NULL, `secondary_school` TEXT, `secondary_degree_id` TEXT, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `profiles_MERGE_TABLE` (`id`,`age`,`appreciate_in_date`,`country`,`employer`,`first_name`,`gender`,`height_cm`,`i_am`,`interested_in`,`last_name`,`location`,`occupation`,`religion`,`has_logged_in_recently`,`overall_chat_activity`,`chat_initiation_level`,`avg_response_time`,`expiration_date`,`school`,`degree_id`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`,`secondary_school`,`secondary_degree_id`,`ethnicities`) SELECT `profiles`.`id`,`profiles`.`age`,`profiles`.`appreciate_in_date`,`profiles`.`country`,`profiles`.`employer`,`profiles`.`first_name`,`profiles`.`gender`,`profiles`.`height_cm`,`profiles`.`i_am`,`profiles`.`interested_in`,`profiles`.`last_name`,`profiles`.`location`,`profiles`.`occupation`,`profiles`.`religion`,`profiles`.`has_logged_in_recently`,`profiles`.`overall_chat_activity`,`profiles`.`chat_initiation_level`,`profiles`.`avg_response_time`,`profiles`.`expiration_date`,`profiles`.`school`,`profiles`.`degree_id`,`profiles`.`first_icebreaker`,`profiles`.`second_icebreaker`,`profiles`.`third_icebreaker`,`profiles`.`secondary_school`,`profiles`.`secondary_degree_id`,'' FROM `profiles`");
        iVar.D("DROP TABLE IF EXISTS `profiles`");
        iVar.D("ALTER TABLE `profiles_MERGE_TABLE` RENAME TO `profiles`");
    }
}
