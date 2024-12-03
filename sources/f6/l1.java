package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class l1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final l1 f14817c = new l1();

    private l1() {
        super(68, 69);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `answers` ADD `integer_value` INTEGER DEFAULT NULL");
        iVar.D("ALTER TABLE `answers` ADD `float_value` REAL DEFAULT NULL");
    }
}
