package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class a1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final a1 f14772c = new a1();

    private a1() {
        super(58, 59);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `suggested_limits` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `daily_likes` INTEGER, `daily_views` INTEGER, `num_bagels_required_for_upsell` INTEGER)");
    }
}
