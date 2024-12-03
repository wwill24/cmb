package ea;

import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f40636a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40637b;

    public a(String str, String str2) {
        j.g(str, "count");
        j.g(str2, "tab");
        this.f40636a = str;
        this.f40637b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f40636a, aVar.f40636a) && j.b(this.f40637b, aVar.f40637b);
    }

    public int hashCode() {
        return (this.f40636a.hashCode() * 31) + this.f40637b.hashCode();
    }

    public String toString() {
        String str = this.f40636a;
        String str2 = this.f40637b;
        return "BadgeCount(count=" + str + ", tab=" + str2 + ")";
    }
}
