package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class k1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final k1 f14814c = new k1();

    private k1() {
        super(67, 68);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `questions` ADD `name` TEXT NOT NULL DEFAULT ''");
    }
}
