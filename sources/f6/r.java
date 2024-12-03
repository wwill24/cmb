package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class r extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final r f14833c = new r();

    private r() {
        super(26, 27);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `pending_messages` ADD `time_sent` TEXT DEFAULT NULL");
    }
}
