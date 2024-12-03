package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class s extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final s f14836c = new s();

    private s() {
        super(27, 28);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `options` ADD `name` TEXT DEFAULT NULL");
    }
}
