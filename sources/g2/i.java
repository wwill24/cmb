package g2;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lg2/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "workSpecId", "b", "I", "()I", "generation", "c", "systemId", "<init>", "(Ljava/lang/String;II)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f15048a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15049b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15050c;

    public i(String str, int i10, int i11) {
        j.g(str, "workSpecId");
        this.f15048a = str;
        this.f15049b = i10;
        this.f15050c = i11;
    }

    public final int a() {
        return this.f15049b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return j.b(this.f15048a, iVar.f15048a) && this.f15049b == iVar.f15049b && this.f15050c == iVar.f15050c;
    }

    public int hashCode() {
        return (((this.f15048a.hashCode() * 31) + Integer.hashCode(this.f15049b)) * 31) + Integer.hashCode(this.f15050c);
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.f15048a + ", generation=" + this.f15049b + ", systemId=" + this.f15050c + PropertyUtils.MAPPED_DELIM2;
    }
}
