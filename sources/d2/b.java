package d2;

import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0015"}, d2 = {"Ld2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "isConnected", "b", "d", "isValidated", "c", "isMetered", "isNotRoaming", "<init>", "(ZZZZ)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14397a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14398b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14399c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14400d;

    public b(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f14397a = z10;
        this.f14398b = z11;
        this.f14399c = z12;
        this.f14400d = z13;
    }

    public final boolean a() {
        return this.f14397a;
    }

    public final boolean b() {
        return this.f14399c;
    }

    public final boolean c() {
        return this.f14400d;
    }

    public final boolean d() {
        return this.f14398b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14397a == bVar.f14397a && this.f14398b == bVar.f14398b && this.f14399c == bVar.f14399c && this.f14400d == bVar.f14400d;
    }

    public int hashCode() {
        boolean z10 = this.f14397a;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i10 = (z10 ? 1 : 0) * true;
        boolean z12 = this.f14398b;
        if (z12) {
            z12 = true;
        }
        int i11 = (i10 + (z12 ? 1 : 0)) * 31;
        boolean z13 = this.f14399c;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f14400d;
        if (!z14) {
            z11 = z14;
        }
        return i12 + (z11 ? 1 : 0);
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.f14397a + ", isValidated=" + this.f14398b + ", isMetered=" + this.f14399c + ", isNotRoaming=" + this.f14400d + PropertyUtils.MAPPED_DELIM2;
    }
}
