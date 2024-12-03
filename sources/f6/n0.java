package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class n0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final n0 f14822c = new n0();

    private n0() {
        super(46, 47);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `matches` ADD `match_to_me` TEXT NOT NULL DEFAULT ''");
    }
}
