package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

final class e implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f42780a;

    e(ArrayList arrayList) {
        this.f42780a = arrayList;
    }

    public final Object run() {
        Class<g> cls = g.class;
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property != null) {
            try {
                g cast = cls.cast(Class.forName(property, true, cls.getClassLoader()).newInstance());
                g.e(cast);
                this.f42780a.add(cast);
                return null;
            } catch (Exception e10) {
                throw new Error(e10);
            }
        } else {
            g.e(new f());
            return null;
        }
    }
}
