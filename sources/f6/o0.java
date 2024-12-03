package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class o0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final o0 f14825c = new o0();

    private o0() {
        super(47, 48);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `schools` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL)");
        iVar.D("CREATE UNIQUE INDEX IF NOT EXISTS `index_schools_name` ON `schools` (`name`)");
    }
}
