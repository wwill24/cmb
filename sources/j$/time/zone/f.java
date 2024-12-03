package j$.time.zone;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;

final class f extends g {

    /* renamed from: c  reason: collision with root package name */
    private final Set f42781c;

    f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String add : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(add);
        }
        this.f42781c = Collections.unmodifiableSet(linkedHashSet);
    }

    /* access modifiers changed from: protected */
    public final c c(String str) {
        if (this.f42781c.contains(str)) {
            return new c(TimeZone.getTimeZone(str));
        }
        throw new d("Not a built-in time zone: " + str);
    }

    /* access modifiers changed from: protected */
    public final Set d() {
        return this.f42781c;
    }
}
