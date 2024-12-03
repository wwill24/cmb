package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class h1 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final h1 f14805c = new h1();

    private h1() {
        super(64, 65);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `likes_you_paywall_card` (`profile_id` TEXT NOT NULL, `image_url` TEXT NOT NULL, `purchase_attribution` INTEGER, PRIMARY KEY(`profile_id`))");
    }
}
