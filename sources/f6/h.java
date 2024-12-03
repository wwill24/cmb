package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class h extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final h f14803c = new h();

    private h() {
        super(17, 18);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `user` ADD `text` TEXT DEFAULT NULL");
        iVar.D("ALTER TABLE `user` ADD `acceptText` TEXT DEFAULT NULL");
        iVar.D("ALTER TABLE `user` ADD `declineText` TEXT DEFAULT NULL");
        iVar.D("CREATE TABLE IF NOT EXISTS `answers_MERGE_TABLE` (`question_id` TEXT NOT NULL, `option_ids` TEXT, `text_value` TEXT, PRIMARY KEY(`question_id`))");
        iVar.D("INSERT INTO `answers_MERGE_TABLE` (`question_id`,`option_ids`,`text_value`) SELECT `answers`.`question_id`,`answers`.`option_ids`,`answers`.`text_value` FROM `answers`");
        iVar.D("DROP TABLE IF EXISTS `answers`");
        iVar.D("ALTER TABLE `answers_MERGE_TABLE` RENAME TO `answers`");
        w1.f14850a.b().d(iVar, 17, 18);
    }
}
