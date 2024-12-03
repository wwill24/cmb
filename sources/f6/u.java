package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class u extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final u f14842c = new u();

    private u() {
        super(29, 30);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `answers` ADD `id` TEXT NOT NULL DEFAULT ''");
    }
}
