package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class p1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final p1 f14829c = new p1();

    private p1() {
        super(71, 72);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `answers` ADD `is_dealbreaker` INTEGER DEFAULT NULL");
    }
}
