package za;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f42200a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42201b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42202c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42203d;

    public c(String str, String str2, String str3, String str4) {
        j.g(str, "id");
        j.g(str2, "questionId");
        j.g(str3, "title");
        this.f42200a = str;
        this.f42201b = str2;
        this.f42202c = str3;
        this.f42203d = str4;
    }

    public final String a() {
        return this.f42200a;
    }

    public final String b() {
        return this.f42203d;
    }

    public final String c() {
        return this.f42201b;
    }

    public final String d() {
        return this.f42202c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j.b(this.f42200a, cVar.f42200a) && j.b(this.f42201b, cVar.f42201b) && j.b(this.f42202c, cVar.f42202c) && j.b(this.f42203d, cVar.f42203d);
    }

    public int hashCode() {
        int hashCode = ((((this.f42200a.hashCode() * 31) + this.f42201b.hashCode()) * 31) + this.f42202c.hashCode()) * 31;
        String str = this.f42203d;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "OptionEntity(id=" + this.f42200a + ", questionId=" + this.f42201b + ", title=" + this.f42202c + ", name=" + this.f42203d + PropertyUtils.MAPPED_DELIM2;
    }
}
