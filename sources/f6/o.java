package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class o extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final o f14824c = new o();

    private o() {
        super(23, 24);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `action_card` (`id` TEXT NOT NULL, `action` TEXT NOT NULL, `action_text` TEXT NOT NULL, `header_text` TEXT NOT NULL, `image_url` TEXT NOT NULL, `message_text` TEXT NOT NULL, PRIMARY KEY(`id`))");
        iVar.D("CREATE TABLE IF NOT EXISTS `questions_MERGE_TABLE` (`id` TEXT NOT NULL, `group` TEXT NOT NULL, `placeholder` TEXT, `type` TEXT NOT NULL, `label` TEXT NOT NULL, `text` TEXT NOT NULL, `max_options` INTEGER, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `questions_MERGE_TABLE` (`id`,`group`,`placeholder`,`type`,`label`,`text`,`max_options`) SELECT `questions`.`id`,`questions`.`group`,`questions`.`placeholder`,`questions`.`type`,`questions`.`label`,`questions`.`text`,NULL FROM `questions`");
        iVar.D("DROP TABLE IF EXISTS `questions`");
        iVar.D("ALTER TABLE `questions_MERGE_TABLE` RENAME TO `questions`");
    }
}
