package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class v1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final v1 f14847c = new v1();

    private v1() {
        super(9, 10);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE  INDEX `index_photos_profile_id` ON `photos` (`profile_id`)");
    }
}
