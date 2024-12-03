package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class q1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final q1 f14832c = new q1();

    private q1() {
        super(72, 73);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `answers` ADD `location` TEXT DEFAULT NULL");
        iVar.D("ALTER TABLE `answers` ADD `json_type` TEXT DEFAULT NULL");
    }
}
