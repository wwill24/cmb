package j$.time;

import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

public abstract class c {
    protected c() {
    }

    public static c c() {
        Map map = ZoneId.f42573a;
        String id2 = TimeZone.getDefault().getID();
        Map map2 = ZoneId.f42573a;
        Objects.requireNonNull(id2, "zoneId");
        Objects.requireNonNull(map2, "aliasMap");
        String str = (String) map2.get(id2);
        if (str != null) {
            id2 = str;
        }
        return new b(ZoneId.of(id2));
    }

    public static c d() {
        return new b(ZoneOffset.UTC);
    }

    public abstract ZoneId a();

    public abstract long b();
}
