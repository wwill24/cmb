package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class c1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final c1 f14783c = new c1();

    private c1() {
        super(5, 6);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE  INDEX `index_dynamic_label_values_profile_id` ON `dynamic_label_values` (`profile_id`)");
        w1.f14850a.b().i(iVar, 5, 6);
    }
}
