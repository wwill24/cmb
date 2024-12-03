package wn;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final String f42497a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42498b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42499c;

    public j(String str, String str2, String str3) {
        kotlin.jvm.internal.j.g(str, "replaceCandidate");
        kotlin.jvm.internal.j.g(str2, "oldString");
        kotlin.jvm.internal.j.g(str3, "newString");
        this.f42497a = str;
        this.f42498b = str2;
        this.f42499c = str3;
    }

    public final String a() {
        return this.f42499c;
    }

    public final String b() {
        return this.f42498b;
    }

    public final String c() {
        return this.f42497a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.j.b(this.f42497a, jVar.f42497a) && kotlin.jvm.internal.j.b(this.f42498b, jVar.f42498b) && kotlin.jvm.internal.j.b(this.f42499c, jVar.f42499c);
    }

    public int hashCode() {
        return (((this.f42497a.hashCode() * 31) + this.f42498b.hashCode()) * 31) + this.f42499c.hashCode();
    }

    public String toString() {
        String str = this.f42497a;
        String str2 = this.f42498b;
        String str3 = this.f42499c;
        return "ReplaceData(replaceCandidate=" + str + ", oldString=" + str2 + ", newString=" + str3 + ")";
    }
}
