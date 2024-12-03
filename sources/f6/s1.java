package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class s1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final s1 f14838c = new s1();

    private s1() {
        super(74, 75);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `prices` (`name` TEXT NOT NULL, `beans` INTEGER NOT NULL, `free_item_count` INTEGER NOT NULL, `image_url` TEXT NOT NULL, `tint_color` TEXT NOT NULL, `is_unlimited` INTEGER NOT NULL, PRIMARY KEY(`name`))");
    }
}
