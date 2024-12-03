package f6;

import kotlin.jvm.internal.j;
import p1.b;
import t1.i;

public final class f0 extends b {

    /* renamed from: c  reason: collision with root package name */
    public static final f0 f14795c = new f0();

    private f0() {
        super(39, 40);
    }

    public void a(i iVar) {
        j.g(iVar, "database");
        iVar.D("CREATE TABLE IF NOT EXISTS `stickers` (`name` TEXT NOT NULL, `description` TEXT NOT NULL, `image_url` TEXT NOT NULL, PRIMARY KEY(`image_url`))");
    }
}
