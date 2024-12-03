package coil.fetch;

import coil.decode.DataSource;
import coil.decode.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcoil/fetch/l;", "Lcoil/fetch/h;", "", "other", "", "equals", "", "hashCode", "Lcoil/decode/k;", "a", "Lcoil/decode/k;", "c", "()Lcoil/decode/k;", "source", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "mimeType", "Lcoil/decode/DataSource;", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", "dataSource", "<init>", "(Lcoil/decode/k;Ljava/lang/String;Lcoil/decode/DataSource;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class l extends h {

    /* renamed from: a  reason: collision with root package name */
    private final k f8201a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8202b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f8203c;

    public l(k kVar, String str, DataSource dataSource) {
        super((DefaultConstructorMarker) null);
        this.f8201a = kVar;
        this.f8202b = str;
        this.f8203c = dataSource;
    }

    public final DataSource a() {
        return this.f8203c;
    }

    public final String b() {
        return this.f8202b;
    }

    public final k c() {
        return this.f8201a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (!j.b(this.f8201a, lVar.f8201a) || !j.b(this.f8202b, lVar.f8202b) || this.f8203c != lVar.f8203c) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f8201a.hashCode() * 31;
        String str = this.f8202b;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return ((hashCode + i10) * 31) + this.f8203c.hashCode();
    }
}
