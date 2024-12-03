package j6;

import kotlin.jvm.internal.j;
import t1.i;

public final class b {
    public final void a(i iVar, String str) {
        j.g(iVar, "database");
        j.g(str, "tableName");
        iVar.D("DROP TABLE " + str);
    }
}
