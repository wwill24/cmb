package f6;

import kotlin.jvm.internal.j;
import p1.b;

public final class i extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final i f14806c = new i();

    private i() {
        super(18, 19);
    }

    public void a(t1.i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `answers_MERGE_TABLE` (`option_id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `text_value` TEXT NOT NULL, PRIMARY KEY(`question_id`, `option_id`, `profile_id`, `text_value`))");
        iVar.D("INSERT INTO `answers_MERGE_TABLE` (`question_id`,`option_id`,`profile_id`,`text_value`) SELECT `answers`.`question_id`,'','',IFNULL(`answers`.`text_value`, '') FROM `answers`");
        iVar.D("DROP TABLE IF EXISTS `answers`");
        iVar.D("ALTER TABLE `answers_MERGE_TABLE` RENAME TO `answers`");
        w1.f14850a.b().e(iVar, 18, 19);
    }
}
