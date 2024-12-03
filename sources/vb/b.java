package vb;

import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f42049a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f42050b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42051c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42052d;

    /* renamed from: e  reason: collision with root package name */
    private final String f42053e;

    /* renamed from: f  reason: collision with root package name */
    private final String f42054f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42055g;

    public b(String str, List<String> list, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(list, "deepLinkTags");
        j.g(str2, "description");
        j.g(str3, "iconUrl");
        j.g(str4, "imageUrl");
        j.g(str5, "title");
        this.f42049a = str;
        this.f42050b = list;
        this.f42051c = str2;
        this.f42052d = str3;
        this.f42053e = str4;
        this.f42054f = str5;
        this.f42055g = str6;
    }

    public final List<String> a() {
        return this.f42050b;
    }

    public final String b() {
        return this.f42051c;
    }

    public final String c() {
        return this.f42052d;
    }

    public final String d() {
        return this.f42053e;
    }

    public final String e() {
        return this.f42049a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.b(this.f42049a, bVar.f42049a) && j.b(this.f42050b, bVar.f42050b) && j.b(this.f42051c, bVar.f42051c) && j.b(this.f42052d, bVar.f42052d) && j.b(this.f42053e, bVar.f42053e) && j.b(this.f42054f, bVar.f42054f) && j.b(this.f42055g, bVar.f42055g);
    }

    public final String f() {
        return this.f42054f;
    }

    public final boolean g(BenefitKeys benefitKeys) {
        j.g(benefitKeys, "benefitKey");
        return j.b(this.f42049a, benefitKeys.b());
    }

    public int hashCode() {
        int hashCode = ((((((((((this.f42049a.hashCode() * 31) + this.f42050b.hashCode()) * 31) + this.f42051c.hashCode()) * 31) + this.f42052d.hashCode()) * 31) + this.f42053e.hashCode()) * 31) + this.f42054f.hashCode()) * 31;
        String str = this.f42055g;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Benefit(key=" + this.f42049a + ", deepLinkTags=" + this.f42050b + ", description=" + this.f42051c + ", iconUrl=" + this.f42052d + ", imageUrl=" + this.f42053e + ", title=" + this.f42054f + ", titleSmallDisplay=" + this.f42055g + PropertyUtils.MAPPED_DELIM2;
    }
}
