package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class r1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final r1 f14835c = new r1();

    private r1() {
        super(73, 74);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `retry_calls` (`internalTag` TEXT NOT NULL, `payloadObject` TEXT NOT NULL, `lastTimeTried` INTEGER NOT NULL, `timesTriedSoFar` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
    }
}
