package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class c extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final c f14781c = new c();

    private c() {
        super(12, 13);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `questions` (`id` TEXT NOT NULL, `placeholder` TEXT, `title` TEXT NOT NULL, `type` TEXT NOT NULL, PRIMARY KEY(`id`))");
    }
}
