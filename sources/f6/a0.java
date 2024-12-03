package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class a0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final a0 f14771c = new a0();

    private a0() {
        super(34, 35);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `user` ADD `registeredDate` TEXT NOT NULL DEFAULT ''");
    }
}
