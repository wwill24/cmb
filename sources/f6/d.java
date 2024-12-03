package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class d extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final d f14785c = new d();

    private d() {
        super(13, 14);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `options` (`id` TEXT NOT NULL, `question_id` TEXT NOT NULL, `title` TEXT NOT NULL, PRIMARY KEY(`id`))");
    }
}
