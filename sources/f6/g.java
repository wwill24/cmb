package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class g extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final g f14799c = new g();

    private g() {
        super(16, 17);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `user` (`profile_id` TEXT NOT NULL, `emailAddress` TEXT, PRIMARY KEY(`profile_id`))");
    }
}
