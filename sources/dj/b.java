package dj;

import java.util.Date;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Date f29550a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f29551b;

    public b(Date date, Date date2) {
        this.f29550a = date;
        this.f29551b = date2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.b(this.f29550a, bVar.f29550a) && j.b(this.f29551b, bVar.f29551b);
    }

    public int hashCode() {
        Date date = this.f29550a;
        int i10 = 0;
        int hashCode = (date == null ? 0 : date.hashCode()) * 31;
        Date date2 = this.f29551b;
        if (date2 != null) {
            i10 = date2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "CollectedGovernmentIdDetails(dateOfBirth=" + this.f29550a + ", expirationDate=" + this.f29551b + PropertyUtils.MAPPED_DELIM2;
    }
}
