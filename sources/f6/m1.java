package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class m1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final m1 f14820c = new m1();

    private m1() {
        super(69, 70);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `answers` ADD `max_value` REAL DEFAULT NULL");
        iVar.D("ALTER TABLE `answers` ADD `min_value` REAL DEFAULT NULL");
    }
}
