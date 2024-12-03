package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class e extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final e f14789c = new e();

    private e() {
        super(14, 15);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `answers` (`id` TEXT NOT NULL, `option_ids` TEXT, `question_id` TEXT NOT NULL, `text_value` TEXT, PRIMARY KEY(`id`))");
        iVar.D("ALTER TABLE `options` ADD `answer_id` TEXT NOT NULL DEFAULT ''");
    }
}
