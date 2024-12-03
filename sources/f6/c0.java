package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class c0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final c0 f14782c = new c0();

    private c0() {
        super(36, 37);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `capability` (`capability` TEXT NOT NULL, `enabled` INTEGER NOT NULL, PRIMARY KEY(`capability`))");
    }
}
