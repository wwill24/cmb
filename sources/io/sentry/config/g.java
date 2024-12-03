package io.sentry.config;

import io.sentry.o4;
import java.util.ArrayList;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class g {
    public static f a() {
        Properties a10;
        Properties a11;
        o4 o4Var = new o4();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i());
        arrayList.add(new d());
        String property = System.getProperty("sentry.properties.file");
        if (!(property == null || (a11 = new e(property, o4Var).a()) == null)) {
            arrayList.add(new h(a11));
        }
        String str = System.getenv("SENTRY_PROPERTIES_FILE");
        if (!(str == null || (a10 = new e(str, o4Var).a()) == null)) {
            arrayList.add(new h(a10));
        }
        Properties a12 = new b(o4Var).a();
        if (a12 != null) {
            arrayList.add(new h(a12));
        }
        Properties a13 = new e("sentry.properties", o4Var).a();
        if (a13 != null) {
            arrayList.add(new h(a13));
        }
        return new c(arrayList);
    }
}
