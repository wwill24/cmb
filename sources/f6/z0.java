package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class z0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final z0 f14861c = new z0();

    private z0() {
        super(57, 58);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `likes_you_group` ADD `empty_state_title_text` TEXT DEFAULT NULL");
        iVar.D("ALTER TABLE `likes_you_card` ADD `pair_like_comment` TEXT DEFAULT NULL");
    }
}
