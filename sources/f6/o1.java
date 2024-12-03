package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class o1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final o1 f14826c = new o1();

    private o1() {
        super(70, 71);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `answers_MERGE_TABLE` (`answer_id` TEXT NOT NULL, `option_id` TEXT NOT NULL, `profile_id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `text_value` TEXT NOT NULL, `integer_value` INTEGER, `float_value` REAL, `max_value` REAL, `min_value` REAL, PRIMARY KEY(`option_id`, `profile_id`, `question_id`))");
        iVar.D("INSERT INTO `answers_MERGE_TABLE` (`option_id`,`profile_id`,`question_id`,`text_value`,`integer_value`,`float_value`,`max_value`,`min_value`,`answer_id`) SELECT `answers`.`option_id`,`answers`.`profile_id`,`answers`.`question_id`,`answers`.`text_value`,`answers`.`integer_value`,`answers`.`float_value`,`answers`.`max_value`,`answers`.`min_value`,'' FROM `answers`");
        iVar.D("DROP TABLE IF EXISTS `answers`");
        iVar.D("ALTER TABLE `answers_MERGE_TABLE` RENAME TO `answers`");
    }
}
