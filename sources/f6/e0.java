package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class e0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final e0 f14790c = new e0();

    private e0() {
        super(38, 39);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("DROP INDEX IF EXISTS index_dynamic_label_values_profile_id");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_dynamic_label_values_profile_id` ON `dynamic_label_values` (`profile_id`)");
        iVar.D("CREATE TABLE IF NOT EXISTS `user_MERGE_TABLE` (`profile_id` TEXT NOT NULL, `appsFlyerId` TEXT, `emailAddress` TEXT, `hasCoffeeTalkMatches` INTEGER NOT NULL, `is_eligible_for_free_trial` INTEGER NOT NULL, `registeredDate` TEXT NOT NULL, PRIMARY KEY(`profile_id`))");
        iVar.D("INSERT INTO `user_MERGE_TABLE` (`profile_id`,`appsFlyerId`,`emailAddress`,`hasCoffeeTalkMatches`,`is_eligible_for_free_trial`,`registeredDate`) SELECT `user`.`profile_id`,`user`.`appsFlyerId`,`user`.`emailAddress`,`user`.`hasCoffeeTalkMatches`,`user`.`is_eligible_for_free_trial`,`user`.`registeredDate` FROM `user`");
        iVar.D("DROP TABLE IF EXISTS `user`");
        iVar.D("ALTER TABLE `user_MERGE_TABLE` RENAME TO `user`");
        iVar.D("DROP INDEX IF EXISTS index_photos_profile_id");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_photos_profile_id` ON `photos` (`profile_id`)");
        iVar.D("DROP INDEX IF EXISTS index_activity_reports_profile_id");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_activity_reports_profile_id` ON `activity_reports` (`profile_id`)");
        iVar.D("DROP INDEX IF EXISTS index_matches_profile_id_type_action");
        iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_matches_profile_id_type_action` ON `matches` (`profile_id`, `type`, `action`)");
        iVar.D("DROP INDEX IF EXISTS index_matches_type_action");
        iVar.D("CREATE INDEX IF NOT EXISTS `index_matches_type_action` ON `matches` (`type`, `action`)");
        iVar.D("DROP INDEX IF EXISTS index_match_context_match_id");
        iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_match_context_match_id` ON `match_context` (`match_id`)");
        iVar.D("DROP INDEX IF EXISTS index_question_groups_name");
        iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_question_groups_name` ON `question_groups` (`name`)");
    }
}
