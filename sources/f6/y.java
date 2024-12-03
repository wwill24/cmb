package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class y extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final y f14856c = new y();

    private y() {
        super(32, 33);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `question_groups` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `maxAllowed` INTEGER, PRIMARY KEY(`id`))");
        iVar.D("CREATE UNIQUE INDEX `index_question_groups_name` ON `question_groups` (`name`)");
    }
}
