package za;

import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f42213a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42214b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f42215c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f42216d;

    /* renamed from: e  reason: collision with root package name */
    private List<f> f42217e = q.j();

    /* renamed from: f  reason: collision with root package name */
    private List<b> f42218f = q.j();

    public g(String str, String str2, Integer num, Integer num2) {
        j.g(str, "id");
        j.g(str2, "name");
        this.f42213a = str;
        this.f42214b = str2;
        this.f42215c = num;
        this.f42216d = num2;
    }

    public final String a() {
        return this.f42213a;
    }

    public final Integer b() {
        return this.f42215c;
    }

    public final Integer c() {
        return this.f42216d;
    }

    public final String d() {
        return this.f42214b;
    }

    public final List<f> e() {
        return this.f42217e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return j.b(this.f42213a, gVar.f42213a) && j.b(this.f42214b, gVar.f42214b) && j.b(this.f42215c, gVar.f42215c) && j.b(this.f42216d, gVar.f42216d);
    }

    public final List<b> f() {
        return this.f42218f;
    }

    public final void g(List<f> list) {
        j.g(list, "<set-?>");
        this.f42217e = list;
    }

    public final void h(List<b> list) {
        j.g(list, "<set-?>");
        this.f42218f = list;
    }

    public int hashCode() {
        int hashCode = ((this.f42213a.hashCode() * 31) + this.f42214b.hashCode()) * 31;
        Integer num = this.f42215c;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f42216d;
        if (num2 != null) {
            i10 = num2.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "QuestionGroupEntity(id=" + this.f42213a + ", name=" + this.f42214b + ", maxAllowed=" + this.f42215c + ", maxSubOptions=" + this.f42216d + PropertyUtils.MAPPED_DELIM2;
    }
}
