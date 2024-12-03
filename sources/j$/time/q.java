package j$.time;

import j$.time.zone.c;
import j$.time.zone.d;
import j$.time.zone.g;
import java.util.Objects;

final class q extends ZoneId {

    /* renamed from: b  reason: collision with root package name */
    private final String f42719b;

    /* renamed from: c  reason: collision with root package name */
    private final transient c f42720c;

    q(String str, c cVar) {
        this.f42719b = str;
        this.f42720c = cVar;
    }

    static q q(String str) {
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i10 == 0) && ((charAt < '0' || charAt > '9' || i10 == 0) && ((charAt != '~' || i10 == 0) && ((charAt != '.' || i10 == 0) && ((charAt != '_' || i10 == 0) && ((charAt != '+' || i10 == 0) && (charAt != '-' || i10 == 0))))))))) {
                    throw new d("Invalid ID for region-based ZoneId, invalid format: " + str);
                }
            }
            try {
                return new q(str, g.b(str, true));
            } catch (d e10) {
                throw e10;
            }
        } else {
            throw new d("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
    }

    public final String n() {
        return this.f42719b;
    }

    public final c o() {
        c cVar = this.f42720c;
        return cVar != null ? cVar : g.b(this.f42719b, false);
    }
}
