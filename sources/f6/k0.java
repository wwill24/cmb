package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class k0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final k0 f14813c = new k0();

    private k0() {
        super(43, 44);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `resources` (`resource_key` TEXT NOT NULL, `resource_value` TEXT NOT NULL, `resource_list_name` TEXT NOT NULL, PRIMARY KEY(`resource_key`, `resource_list_name`))");
    }
}
