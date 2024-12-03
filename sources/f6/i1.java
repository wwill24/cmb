package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class i1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final i1 f14808c = new i1();

    private i1() {
        super(65, 66);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `likes_you_group` ADD `paywall_profile_ids` TEXT NOT NULL DEFAULT ''");
    }
}
