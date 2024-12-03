package g2;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f¨\u0006\u0013"}, d2 = {"Lg2/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "workSpecId", "I", "()I", "generation", "<init>", "(Ljava/lang/String;I)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f15058a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15059b;

    public m(String str, int i10) {
        j.g(str, "workSpecId");
        this.f15058a = str;
        this.f15059b = i10;
    }

    public final int a() {
        return this.f15059b;
    }

    public final String b() {
        return this.f15058a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return j.b(this.f15058a, mVar.f15058a) && this.f15059b == mVar.f15059b;
    }

    public int hashCode() {
        return (this.f15058a.hashCode() * 31) + Integer.hashCode(this.f15059b);
    }

    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f15058a + ", generation=" + this.f15059b + PropertyUtils.MAPPED_DELIM2;
    }
}
