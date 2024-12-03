package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class m extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final m f14818c = new m();

    private m() {
        super(21, 22);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `questions` ADD `label` TEXT NOT NULL DEFAULT ''");
        iVar.D("ALTER TABLE `questions` ADD `text` TEXT NOT NULL DEFAULT ''");
    }
}
