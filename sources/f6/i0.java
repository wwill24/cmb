package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class i0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final i0 f14807c = new i0();

    private i0() {
        super(41, 42);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `profiles_MERGE_TABLE` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `employer` TEXT NOT NULL, `ethnicities` TEXT NOT NULL, `first_name` TEXT NOT NULL, `gender` TEXT NOT NULL, `last_name` TEXT NOT NULL, `occupation` TEXT NOT NULL, `religion` TEXT, `state` TEXT NOT NULL, `school` TEXT, `degree_id` TEXT, `height_cm` INTEGER, `height_feet` INTEGER, `height_inches` INTEGER, `first_icebreaker` TEXT NOT NULL, `second_icebreaker` TEXT NOT NULL, `third_icebreaker` TEXT NOT NULL, `secondary_school` TEXT, `secondary_degree_id` TEXT, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `profiles_MERGE_TABLE` (`id`,`age`,`city`,`country`,`employer`,`ethnicities`,`first_name`,`gender`,`last_name`,`occupation`,`religion`,`state`,`school`,`degree_id`,`height_cm`,`height_feet`,`height_inches`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`,`secondary_school`,`secondary_degree_id`) SELECT `profiles`.`id`,`profiles`.`age`,`profiles`.`city`,`profiles`.`country`,`profiles`.`employer`,`profiles`.`ethnicities`,`profiles`.`first_name`,`profiles`.`gender`,`profiles`.`last_name`,`profiles`.`occupation`,`profiles`.`religion`,`profiles`.`state`,`profiles`.`school`,`profiles`.`degree_id`,`profiles`.`height_cm`,`profiles`.`height_feet`,`profiles`.`height_inches`,`profiles`.`first_icebreaker`,`profiles`.`second_icebreaker`,`profiles`.`third_icebreaker`,`profiles`.`secondary_school`,`profiles`.`secondary_degree_id` FROM `profiles`");
        iVar.D("DROP TABLE IF EXISTS `profiles`");
        iVar.D("ALTER TABLE `profiles_MERGE_TABLE` RENAME TO `profiles`");
    }
}
