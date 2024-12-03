package ea;

import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f40638a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40639b;

    public b(String str, String str2) {
        j.g(str, "count");
        j.g(str2, "tab");
        this.f40638a = str;
        this.f40639b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.b(this.f40638a, bVar.f40638a) && j.b(this.f40639b, bVar.f40639b);
    }

    public int hashCode() {
        return (this.f40638a.hashCode() * 31) + this.f40639b.hashCode();
    }

    public String toString() {
        String str = this.f40638a;
        String str2 = this.f40639b;
        return "BagelCount(count=" + str + ", tab=" + str2 + ")";
    }
}
