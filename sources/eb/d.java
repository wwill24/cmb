package eb;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f40666a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40667b;

    public d(int i10, String str) {
        j.g(str, "name");
        this.f40666a = i10;
        this.f40667b = str;
    }

    public final int a() {
        return this.f40666a;
    }

    public final String b() {
        return this.f40667b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f40666a == dVar.f40666a && j.b(this.f40667b, dVar.f40667b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f40666a) * 31) + this.f40667b.hashCode();
    }

    public String toString() {
        return "SchoolEntity(id=" + this.f40666a + ", name=" + this.f40667b + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i10, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10, str);
    }
}
