package j$.time.temporal;

import j$.time.a;
import j$.time.e;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.beanutils.PropertyUtils;

public final class u implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    private static final ConcurrentHashMap f42757g = new ConcurrentHashMap(4, 0.75f, 2);

    /* renamed from: h  reason: collision with root package name */
    public static final q f42758h = j.f42735d;

    /* renamed from: a  reason: collision with root package name */
    private final e f42759a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42760b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final transient m f42761c = t.m(this);

    /* renamed from: d  reason: collision with root package name */
    private final transient m f42762d = t.p(this);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final transient m f42763e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final transient m f42764f;

    static {
        new u(e.MONDAY, 4);
        g(e.SUNDAY, 1);
    }

    private u(e eVar, int i10) {
        b bVar = b.NANOS;
        this.f42763e = t.q(this);
        this.f42764f = t.o(this);
        Objects.requireNonNull(eVar, "firstDayOfWeek");
        if (i10 < 1 || i10 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.f42759a = eVar;
        this.f42760b = i10;
    }

    public static u g(e eVar, int i10) {
        String str = eVar.toString() + i10;
        ConcurrentHashMap concurrentHashMap = f42757g;
        u uVar = (u) concurrentHashMap.get(str);
        if (uVar != null) {
            return uVar;
        }
        concurrentHashMap.putIfAbsent(str, new u(eVar, i10));
        return (u) concurrentHashMap.get(str);
    }

    public final m d() {
        return this.f42761c;
    }

    public final e e() {
        return this.f42759a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return hashCode() == obj.hashCode();
        }
        return false;
    }

    public final int f() {
        return this.f42760b;
    }

    public final m h() {
        return this.f42764f;
    }

    public final int hashCode() {
        return (this.f42759a.ordinal() * 7) + this.f42760b;
    }

    public final m i() {
        return this.f42762d;
    }

    public final m j() {
        return this.f42763e;
    }

    public final String toString() {
        StringBuilder a10 = a.a("WeekFields[");
        a10.append(this.f42759a);
        a10.append(',');
        a10.append(this.f42760b);
        a10.append(PropertyUtils.INDEXED_DELIM2);
        return a10.toString();
    }
}
