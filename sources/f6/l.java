package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class l extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final l f14815c = new l();

    private l() {
        super(20, 21);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `pending_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `bagel_id` TEXT NOT NULL, `status` TEXT NOT NULL, `text` TEXT NOT NULL, `type` TEXT NOT NULL)");
    }
}
