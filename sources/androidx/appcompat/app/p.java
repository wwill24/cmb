package androidx.appcompat.app;

import androidx.core.os.j;
import java.util.LinkedHashSet;
import java.util.Locale;

final class p {
    private static j a(j jVar, j jVar2) {
        Locale locale;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i10 = 0; i10 < jVar.f() + jVar2.f(); i10++) {
            if (i10 < jVar.f()) {
                locale = jVar.c(i10);
            } else {
                locale = jVar2.c(i10 - jVar.f());
            }
            if (locale != null) {
                linkedHashSet.add(locale);
            }
        }
        return j.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static j b(j jVar, j jVar2) {
        if (jVar == null || jVar.e()) {
            return j.d();
        }
        return a(jVar, jVar2);
    }
}
