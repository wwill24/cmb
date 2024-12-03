package array;

import java.util.List;
import kotlin.jvm.internal.j;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<Object> f7660a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7661b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7662c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7663d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7664e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7665f;

    public d(List<? extends Object> list, String str, String str2, String str3, int i10, String str4) {
        j.g(list, "elementsToJoin");
        j.g(str, "separator");
        j.g(str2, "prefix");
        j.g(str3, "postfix");
        j.g(str4, "truncated");
        this.f7660a = list;
        this.f7661b = str;
        this.f7662c = str2;
        this.f7663d = str3;
        this.f7664e = i10;
        this.f7665f = str4;
    }

    public final List<Object> a() {
        return this.f7660a;
    }

    public final int b() {
        return this.f7664e;
    }

    public final String c() {
        return this.f7663d;
    }

    public final String d() {
        return this.f7662c;
    }

    public final String e() {
        return this.f7661b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.b(this.f7660a, dVar.f7660a) && j.b(this.f7661b, dVar.f7661b) && j.b(this.f7662c, dVar.f7662c) && j.b(this.f7663d, dVar.f7663d) && this.f7664e == dVar.f7664e && j.b(this.f7665f, dVar.f7665f);
    }

    public final String f() {
        return this.f7665f;
    }

    public int hashCode() {
        return (((((((((this.f7660a.hashCode() * 31) + this.f7661b.hashCode()) * 31) + this.f7662c.hashCode()) * 31) + this.f7663d.hashCode()) * 31) + Integer.hashCode(this.f7664e)) * 31) + this.f7665f.hashCode();
    }

    public String toString() {
        List<Object> list = this.f7660a;
        String str = this.f7661b;
        String str2 = this.f7662c;
        String str3 = this.f7663d;
        int i10 = this.f7664e;
        String str4 = this.f7665f;
        return "JoinToStringArguments(elementsToJoin=" + list + ", separator=" + str + ", prefix=" + str2 + ", postfix=" + str3 + ", limit=" + i10 + ", truncated=" + str4 + ")";
    }
}
