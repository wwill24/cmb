package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class n extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final n f14821c = new n();

    private n() {
        super(22, 23);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `user` ADD `hasCoffeeTalkMatches` INTEGER NOT NULL DEFAULT 0");
    }
}
