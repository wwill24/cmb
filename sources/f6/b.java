package f6;

import kotlin.jvm.internal.j;
import t1.i;

public final class b extends p1.b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f14777c = new b();

    private b() {
        super(11, 12);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `matches` ADD `woo_seen_count` INTEGER NOT NULL DEFAULT 0");
    }
}
