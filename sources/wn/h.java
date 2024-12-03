package wn;

import java.util.List;
import kotlin.jvm.internal.j;

final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f42493a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42494b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Object> f42495c;

    public h(String str, String str2, List<? extends Object> list) {
        j.g(str, "text");
        j.g(str2, "regexPattern");
        j.g(list, "regexOptions");
        this.f42493a = str;
        this.f42494b = str2;
        this.f42495c = list;
    }

    public final List<Object> a() {
        return this.f42495c;
    }

    public final String b() {
        return this.f42494b;
    }

    public final String c() {
        return this.f42493a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return j.b(this.f42493a, hVar.f42493a) && j.b(this.f42494b, hVar.f42494b) && j.b(this.f42495c, hVar.f42495c);
    }

    public int hashCode() {
        return (((this.f42493a.hashCode() * 31) + this.f42494b.hashCode()) * 31) + this.f42495c.hashCode();
    }

    public String toString() {
        String str = this.f42493a;
        String str2 = this.f42494b;
        List<Object> list = this.f42495c;
        return "MatchArguments(text=" + str + ", regexPattern=" + str2 + ", regexOptions=" + list + ")";
    }
}
