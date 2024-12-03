package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class q extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final q f14830c = new q();

    private q() {
        super(25, 26);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `user` ADD `is_eligible_for_free_trial` INTEGER NOT NULL DEFAULT 0");
    }
}
