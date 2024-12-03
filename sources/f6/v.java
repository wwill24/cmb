package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class v extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final v f14845c = new v();

    private v() {
        super(2, 3);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `photos` (`id` TEXT NOT NULL, `caption` TEXT, `position` INTEGER NOT NULL, `profile_id` TEXT NOT NULL, `url` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`profile_id`) REFERENCES `profiles`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
    }
}
