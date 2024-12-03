package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class x0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final x0 f14853c = new x0();

    private x0() {
        super(55, 56);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `user` ADD `usesMetric` INTEGER NOT NULL DEFAULT 0");
    }
}
