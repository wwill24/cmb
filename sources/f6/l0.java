package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class l0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final l0 f14816c = new l0();

    private l0() {
        super(44, 45);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("ALTER TABLE `question_groups` ADD `max_sub_options` INTEGER DEFAULT NULL");
    }
}
