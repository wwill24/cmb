package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class u1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final u1 f14844c = new u1();

    private u1() {
        super(8, 9);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `match_context` (`match_id` TEXT NOT NULL, `icon` TEXT, `title` TEXT, `body` TEXT, PRIMARY KEY(`match_id`))");
        iVar.D("CREATE UNIQUE INDEX `index_match_context_match_id` ON `match_context` (`match_id`)");
    }
}
