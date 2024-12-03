package g2;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0015"}, d2 = {"Lg2/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "key", "", "b", "Ljava/lang/Long;", "()Ljava/lang/Long;", "value", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "(Ljava/lang/String;Z)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f15043a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f15044b;

    public d(String str, Long l10) {
        j.g(str, SDKConstants.PARAM_KEY);
        this.f15043a = str;
        this.f15044b = l10;
    }

    public final String a() {
        return this.f15043a;
    }

    public final Long b() {
        return this.f15044b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.b(this.f15043a, dVar.f15043a) && j.b(this.f15044b, dVar.f15044b);
    }

    public int hashCode() {
        int hashCode = this.f15043a.hashCode() * 31;
        Long l10 = this.f15044b;
        return hashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.f15043a + ", value=" + this.f15044b + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(String str, boolean z10) {
        this(str, Long.valueOf(z10 ? 1 : 0));
        j.g(str, SDKConstants.PARAM_KEY);
    }
}
