package f6;

import p1.b;
import t1.i;

public final class j extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final j f14809c = new j();

    private j() {
        super(19, 20);
    }

    public void a(i iVar) {
        kotlin.jvm.internal.j.g(iVar, "database");
        iVar.D("ALTER TABLE `user` ADD `appsFlyerId` TEXT DEFAULT NULL");
    }
}
