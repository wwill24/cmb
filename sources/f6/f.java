package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class f extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final f f14794c = new f();

    private f() {
        super(15, 16);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `questions` ADD `group` TEXT NOT NULL DEFAULT ''");
        iVar.D("CREATE TABLE IF NOT EXISTS `options_MERGE_TABLE` (`id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `title` TEXT NOT NULL, PRIMARY KEY(`id`))");
        iVar.D("INSERT INTO `options_MERGE_TABLE` (`id`,`question_id`,`title`) SELECT `options`.`id`,`options`.`question_id`,`options`.`title` FROM `options`");
        iVar.D("DROP TABLE IF EXISTS `options`");
        iVar.D("ALTER TABLE `options_MERGE_TABLE` RENAME TO `options`");
    }
}
